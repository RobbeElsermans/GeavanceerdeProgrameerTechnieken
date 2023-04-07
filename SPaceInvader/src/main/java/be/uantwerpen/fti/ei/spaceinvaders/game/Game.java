package be.uantwerpen.fti.ei.spaceinvaders.game;

import be.uantwerpen.fti.ei.spaceinvaders.game.collision.BorderCollision;
import be.uantwerpen.fti.ei.spaceinvaders.game.collision.BorderCollisionSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.collision.BulletCollisionSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.collision.EntityCollision;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.*;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.EntityCleanupSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.EntityCreationSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.StatisticsSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement.*;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting.EnemyShootSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting.FromWhoBulletType;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting.GlobalShootSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting.PlayerShootSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Position;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.game.filecontroller.FileManager;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;
import be.uantwerpen.fti.ei.spaceinvaders.game.sound.SoundSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.sound.SoundType;

import java.util.ArrayList;
import java.util.List;

/**
 * De overkoepelende klassen waar al de game mechanics in verwerkt zijn.
 */
public class Game {
    /**
     * Gebruikt een GFX-abstract factory om GFX en Game gescheiden te houden.
     */
    protected AFactory gfxFactory;
    /**
     * Een lijst van speler entiteiten.
     */
    List<APlayerEntity> playerEntitieList = new ArrayList<>();
    /**
     * Een lijst van enemy entiteiten.
     */
    List<AEnemyEntity> enemyEntityList = new ArrayList<>();
    /**
     * Een lijst van big enemy entiteiten.
     */
    List<ABigEnemyEntity> bigEnemyEntityList = new ArrayList<>();
    /**
     * Een lijst van bonus entiteiten.
     */
    List<ABonusEntity> bonusEntityList = new ArrayList<>();
    /**
     * Een lijst van obstacle entiteiten.
     */
    List<AObstacleEntity> obstacleEntitieList = new ArrayList<>();

    /**
     * Text over het huidige leven van een speler
     */
    List<ATextEntity> textLifeList = new ArrayList<>();

    /**
     * Text over de huidige punten van een speler
     */
    List<ATextEntity> textPointsList = new ArrayList<>();

    /**
     * Een lijst van schermen.
     */
    List<AScreenEntity> screenEntityList = new ArrayList<>();

    /**
     * Een collision object die we gebruiken om de entiteiten binnenin het spelvlak te houden.
     */
    private BorderCollision borderCollision;

    /**
     * Een speler schiet systeem
     */
    private PlayerShootSystem playerShootSystem;

    /**
     * Een enemy schiet systeem
     */
    private EnemyShootSystem enemyShootSystem;

    private EntityCreationSystem entityCreationSystem;

    private SoundSystem soundSystem;

    /**
     * De variabelen komen mee met de constructor in een file.
     */
    /**
     * De breedte van het spel.
     */
    private int gameWidth;
    /**
     * De hoogte van het spel.
     */
    private int gameHeight;

    /**
     * De genomen FPS (Frames per second).
     */
    private final int FPS = 1;

    /**
     * Een boolean die bijhoud of het spel bezig is.
     * Wanneer men bv. op ESC zou drukken, zal het spel in pauze gaan.
     */
    private boolean isRunning = true;
    private GameStates gameState = GameStates.START_SCREEN;
    private InGameStates inGameState = InGameStates.NO_GAME;
    private InGameStates prevInGameState;

    /**
     * Overload constructor om het spel te initialiseren met de meegegeven parameters.
     *
     * @param aFactory   Een GFX-factory om de zaak te tonen.
     * @param configFile Het configuratiebestand waarin verschillende parameters staan.
     * @implNote Als het configuratie bestand niet bestaat in het opgegeven pad, zal dit zichzelf genereren met default waarden.
     */
    public Game(AFactory aFactory, String configFile) {

        //get the gfxFactory
        this.gfxFactory = aFactory;

        //get the game settings
        this.getSettings(configFile);

        //geeft game dimensions over aan factory
        this.gfxFactory.setupGameDimentions(new Dimension(this.gameWidth, this.gameHeight));
    }

    /**
     * De start methoden zal het spel starten.
     */
    public void start() {
        screenInitialize();
        soundInitialize();
        while (isRunning) {
            //TIJD CONSTANT HOUDEN
            double fpsIntervalNS = ((double) 1000000000 / FPS);
            double nextFpsIntervalNS = System.nanoTime() + fpsIntervalNS;
            double remainingFpsIntervalTime = 0;
            //TIJD CONSTANT HOUDEN

            //render screen
            render();

            switch (gameState) {
                case START_SCREEN, PAUSED -> {
                    //Create startscreen van aFactory.
                    visualizeScreen();
                    //Kijk of dat de input ENTER is.
                    //Als ENTER, dan verder naar IN_GAME
                }
                case IN_GAME -> {
                    //Do game mechanics.
                    //Verschillende levels mogelijk.

                    //Als level veranderd is, upgraden
                    if (prevInGameState == null) {
                        this.baseInitialize();
                    }

                    if (prevInGameState != inGameState) {
                        levelInitialize(inGameState);
                    }

                    prevInGameState = inGameState;

                    //update
                    update();
                    //visualize entities
                    visualize();
                }
                //Pause screen en game mag niet verder gaan.
                case END_GAME -> {

                    //De values doorspelen naar endscherm.
                    if (playerEntitieList.get(0).getStatisticsComponent().getScore() > FileManager.getSettingInteger("high_score", "src/main/resources/highScore.txt", 0) && (inGameState == InGameStates.BOSS_LEVEL && playerEntitieList.get(0).getLivableComponent().getLife() > 0)) {
                        FileManager.propOverwrite("high_score", "src/main/resources/highScore.txt", String.valueOf(playerEntitieList.get(0).getStatisticsComponent().getScore()));
                    }

                    screenEntityList.get(2).getTextEntityList().get(1).getInformationComponent().setInformation(String.valueOf(playerEntitieList.get(0).getStatisticsComponent().getScore()));
                    screenEntityList.get(2).getTextEntityList().get(2).getInformationComponent().setInformation(String.valueOf(FileManager.getSettingInteger("high_score", "src/main/resources/highScore.txt", 0)));

                    visualizeScreen();
                    //Create endgame met highscore en mogelijkheid om opnieuw of af te sluiten.
                    //isRunning = false;
                }
            }

            checkGameInput(gfxFactory.getInput());

            //TIJD CONSTANT HOUDEN
            try {
                remainingFpsIntervalTime = nextFpsIntervalNS - System.nanoTime();
                remainingFpsIntervalTime /= 1000000;
                if (remainingFpsIntervalTime > 0)
                    Thread.sleep((long) remainingFpsIntervalTime); //Wachten zodat totale tijd FPS behaald wordt.

                nextFpsIntervalNS += fpsIntervalNS;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //TIJD CONSTANT HOUDEN

            //DEBUG
            //if(!playerEntitieList.isEmpty())
            //    System.out.println(playerEntitieList.get(0).getMovementComponent().getSpeed());
            //DEBUG
        }
    }

    /**
     * De rendermethoden gaat het gamevlak renderen zodat alle wijzigingen doorgevoerd worden.
     */
    private void render() {
        gfxFactory.render();
    }

    /**
     * De update methoden zal al de objecten van het spel update.
     */
    private void update() {
        updateInGameStates();   // Updates in game states en game states.

        updateBullets();            // Updates kogels.
        updateBonus();              // Updates bonus creatie.
        updateBigEnemy();           // Updates big enemy creatie.

        updateMovements();          // Update movements van entiteiten.

        checkBorderCollisions();        // Checkt de entiteiten dat ze niet buiten de grenzen gaan en reageer gepast wanneer wel.
        checkBulletCollision();         // Checkt wanneer dat kogels ergens inslaan en reageer gepast.
        checkEnemyToPlayerCollision();  // Checkt wanneer een enemy tegen de player aanbotst en reageer gepast.
        checkBonusToPlayerCollision();  // Checkt wanneer een bonus tegen een player en reageer gepast.

        updateText();   //Updates teksten met spelers statistics.

        doCleanup();    //Kuis de entiteiten op als er iets mee gebeurd is waardoor ze dood gaan.
    }

    /**
     * De visualize methode zal elk object afbeelden.
     */
    private void visualize() {
        playerEntitieList.forEach(APlayerEntity::visualize);
        enemyEntityList.forEach(AEnemyEntity::visualize);
        obstacleEntitieList.forEach(AObstacleEntity::visualize);
        bigEnemyEntityList.forEach(ABigEnemyEntity::visualize);
        bonusEntityList.forEach(ABonusEntity::visualize);
        textLifeList.forEach(ATextEntity::visualize);
        textPointsList.forEach(ATextEntity::visualize);
    }

    /**
     * De visualize methode van de schermen zal elk object afbeelden.
     */
    private void visualizeScreen() {
        switch (gameState) {

            case START_SCREEN -> {
                screenEntityList.get(0).visualize();
            }
            case PAUSED -> {
                screenEntityList.get(1).visualize();
            }
            case END_GAME -> {
                screenEntityList.get(2).visualize();
            }
            default -> throw new IllegalStateException("Unexpected value: " + gameState);
        }

    }

    /**
     * Een methode die al de parameters ophaalt van het meegegeven bestand.
     *
     * @param configFile De locatie van het configuratiebestand.
     */
    private void getSettings(String configFile) {
        this.gameWidth = FileManager.getSettingInteger("gameWidth", configFile, 30);
        this.gameHeight = FileManager.getSettingInteger("gameHeight", configFile, 20);
    }

    /**
     * We initialiseren hiermee het spel. We laden alle objecten, die nodig zijn om het spel te spelen, in.
     */
    private void baseInitialize() {
        // Systemen initialiseren
        this.borderCollision = new BorderCollision(new Dimension(gameWidth * gfxFactory.getScale().getWidth(), gameHeight * gfxFactory.getScale().getHeight()));

        this.playerShootSystem = new PlayerShootSystem();
        this.enemyShootSystem = new EnemyShootSystem(1);

        this.entityCreationSystem = new EntityCreationSystem();

        // Player & texten blijven bestaan.
        playerEntitieList = new ArrayList<>();
        textLifeList = new ArrayList<>();
        textPointsList = new ArrayList<>();

        // Initialiseer de rest van de entiteiten.
        clearEntityLists();

        //Create player
        playerEntitieList.add(this.gfxFactory.getPlayerEntity(new Position(this.gameWidth / 2, this.gameHeight - 2), 3, 1.5, 1));
        //playerEntitieList.add(this.gfxFactory.getPlayerEntity(new Position(this.gameWidth / 2 + 10, this.gameHeight-1), 5, 2, 0.3));

        //Create texten a.d.h.v. aantal players.
        for (int i = 0; i < playerEntitieList.size(); i++) {
            this.textLifeList.add(gfxFactory.getTextEntity(new Position(0, i * 2 + 1), "life: ", String.valueOf(this.playerEntitieList.get(i).getLivableComponent().getLife())));
            this.textPointsList.add(gfxFactory.getTextEntity(new Position(0, i * 2 + 2), "points: ", "0"));
        }
    }

    private void soundInitialize() {
        this.soundSystem = new SoundSystem();

        //Voeg de geluidjes toe aan de soundcomponent in soundSystem.
        this.soundSystem.getSoundComponent().addSound("/sound/explosion.wav", SoundType.PLAYER_DEAD_SOUND);
        this.soundSystem.getSoundComponent().addSound("/sound/invaderkilled.wav", SoundType.ENEMY_DEAD_SOUND);
        this.soundSystem.getSoundComponent().addSound("/sound/shoot.wav", SoundType.PLAYER_SHOOT_SOUND);
        this.soundSystem.getSoundComponent().addSound("/sound/ufo_lowpitch.wav", SoundType.BIG_ENEMY_SOUND);
        this.soundSystem.getSoundComponent().addSound("/sound/ufo_highpitch.wav", SoundType.BONUS_SOUND);
    }

    private void screenInitialize() {
        //Create de schermen
        screenEntityList.add(gfxFactory.getStartScreen(
                new Position(gameWidth/2-5, gameHeight/2-5),
                "Start",
                "Enter om te starten",
                "ESC om af te sluiten"));

        screenEntityList.add(gfxFactory.getPauseScreen(
                new Position(gameWidth/2-5, gameHeight/2-5),
                "Pause",
                "Enter om verder te spelen",
                "Q/A om te stoppen"));

        screenEntityList.add(gfxFactory.getEndScreen(
                new Position(gameWidth/2-5, gameHeight/2-5),
                "End",
                "Enter om opnieuw te starten",
                "Q/A om te stoppen",
                "speler score: ",
                "highscore: "));
    }

    /**
     * Initialiseer een level a.d.h.v. de inGameState.
     *
     * @param level
     */
    private void levelInitialize(InGameStates level) {
        //Clear all entities
        clearEntityLists();

        switch (level) {

            case LEVEL_1 -> {
                //Create enemy
                for (int i = 6; i < this.gameWidth - 6; i++) {
                    if (i % 2 == 0) {
                        enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(i, 2), 4, 4, 0.5));
                        enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(i, 3), 3, 4, 0.5));
                        enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(i, 4), 2, 4, 0.5));
                        enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(i, 5), 1, 4, 0.5));
                    }
                }
                //bonusEntityList.add(gfxFactory.getBonusEntity(new Position(2,1),1,3,0.5, CollectableComponent.collectableType.life,1));

                //Create Obstacles
                obstacleEntitieList.add(gfxFactory.getObstacleEntity(new Position(1, this.gameHeight - 3), 5));
                obstacleEntitieList.add(gfxFactory.getObstacleEntity(new Position((this.gameWidth-1)/2.0, this.gameHeight - 4), 5));
                obstacleEntitieList.add(gfxFactory.getObstacleEntity(new Position(this.gameWidth-4, this.gameHeight - 3), 5));
            }
            case LEVEL_2 -> {
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(2, 2), 1, 2, 0.5));
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(2, 3), 3, 10, 0.5));
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(4, 4), 3, 10, 0.5));

                //Create Obstacles
                obstacleEntitieList.add(gfxFactory.getObstacleEntity(new Position(15, this.gameHeight - 2), 3));
            }
            case BOSS_LEVEL -> {
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(2, 2), 1, 2, 0.5));
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(2, 3), 3, 3, 0.5));
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(4, 4), 3, 4, 0.5));
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(4, 4), 3, 5, 0.5));
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(4, 4), 3, 6, 0.5));
            }
        }
    }

    /**
     * Bekijkt de inputs die de game states kunnen beïnvloeden
     *
     * @param input De input van de gebruiker
     */
    private void checkGameInput(IInput input) {
        if (input.inputAvailable()) {

            //Als we in het startscherm staan en er wordt enter gedrukt.
            if (gameState == GameStates.START_SCREEN && input.isEnter()) {
                gameState = GameStates.IN_GAME;     //Start game loop.
                inGameState = InGameStates.LEVEL_1; //Start spel in level 1
            }

            //Als we in het startscherm staan en er wordt esc gedrukt.
            if (gameState == GameStates.START_SCREEN && input.isEsc()) {
                System.exit(0);
            }

            //Als er gespeeld wordt en esc wordt ingedrukt.
            if (gameState == GameStates.IN_GAME && input.isEsc()) {
                gameState = GameStates.PAUSED;  //Pause het spel.
            }

            //Als we in pausescherm staan en er wordt op enter gedrukt.
            if (gameState == GameStates.PAUSED && input.isEnter()) {
                gameState = GameStates.IN_GAME;  //resume het spel
            }
            //Als we in pausescherm staan en er wordt op enter gedrukt.
            if (gameState == GameStates.PAUSED && input.isQuit()) {
                System.exit(0);
            }

            //Als we in endScherm staan en er wordt op enter gedrukt.
            if (gameState == GameStates.END_GAME && input.isEnter()) {
                gameState = GameStates.IN_GAME;  //opnieuw

                //Basic initialize zodat alles zichzelf reset.
                inGameState = InGameStates.LEVEL_1;
                prevInGameState = null;
            }

            //Als we in endScherm staan en er wordt op quit gedrukt.
            if (gameState == GameStates.END_GAME && input.isQuit()) {
                System.exit(0);
            }
        }
    }

    /**
     * Checkt wanneer een enemy tegen de player aanbotst en reageer gepast.
     */
    private void checkEnemyToPlayerCollision() {
        //Check player to an enemy collision
        for (MovementComponent emc : enemyEntityList.stream().map(AEnemyEntity::getMovementComponent).toList())
            if (EntityCollision.entityIsOnSameLine(playerEntitieList.get(0).getMovementComponent(), emc)) {
                System.out.println("DEAD!");
                gameState = GameStates.END_GAME;
                break;
            }
    }

    /**
     * Checkt wanneer een bonus tegen de speler botst
     */
    private void checkBonusToPlayerCollision() {
        //Check player to an enemy collision
        for (ABonusEntity bonus : bonusEntityList)
            for (APlayerEntity player : playerEntitieList) {
                if (EntityCollision.entityCollision(player.getMovementComponent(), bonus.getMovementComponent())) {
                    //Bonus toevoegen
                    //TODO
                    switch (bonus.getCollectableComponent().getType()) {
                        case LIFE -> {
                            player.getLivableComponent().upLifeByAmount((int) bonus.getCollectableComponent().takeValue());
                        }
                        case MOVE_SPEED -> {
                            double temp = (player.getMovementComponent().getSpeed() + bonus.getCollectableComponent().takeValue());
                            if(temp >= 6)
                                player.getMovementComponent().setSpeed(6);
                            else
                                player.getMovementComponent().setSpeed(Math.max(temp, 1));  //speed mag niet kleiner zijn dan 1.
                        }
                    }
                }
            }
    }

    /**
     * Checkt wanneer dat kogels ergens inslaan en reageer gepast.
     */
    private void checkBulletCollision() {

        //Check for bullet to enemy collision
        //Probleem dat wanneer 1 bullet, 2 enemy's raakt.
        // Statistics kunnen hier niet goed mee om dus moeten we opvangen in onderstaande code.
        for (AEnemyEntity enemy : enemyEntityList) {
            for (APlayerEntity player : playerEntitieList) {
                for (ABulletEntity bullet : player.getShootingComponent().getBulletList()) {
                    if (BulletCollisionSystem.bulletEntityCollision(bullet.getMovementComponent(), enemy.getMovementComponent())) {

                        //STATISTICS
                        //Als de bullet al gebruikt is, niet bijwerken in statistics.
                        if (bullet.getLivableComponent().getLife() > 0) {
                            StatisticsSystem.incrementDamageDone(player.getStatisticsComponent(), bullet.getLivableComponent());
                            StatisticsSystem.incrementShotHit(player.getStatisticsComponent());
                        }
                        //STATISTICS

                        GlobalShootSystem.damage(enemy.getLivableComponent(), bullet.getLivableComponent());
                        break;
                    }
                }
            }
        }

        //Check for bullet to player collision
        for (APlayerEntity player : playerEntitieList) {
            for (AEnemyEntity enemy : enemyEntityList) {
                for (ABulletEntity bullet : enemy.getShootingComponent().getBulletList()) {
                    if (BulletCollisionSystem.bulletEntityCollision(bullet.getMovementComponent(), player.getMovementComponent())) {

                        //STATISTICS
                        StatisticsSystem.incrementDamageTaken(player.getStatisticsComponent(), bullet.getLivableComponent());
                        //STATISTICS

                        GlobalShootSystem.damage(player.getLivableComponent(), bullet.getLivableComponent());
                    }
                }
            }
        }

        //Check for bullet to obstacle from enemy and player
        for (AObstacleEntity obstacle : obstacleEntitieList) {
            for (AEnemyEntity enemy : enemyEntityList) {
                for (ABulletEntity bullet : enemy.getShootingComponent().getBulletList()) {
                    if (BulletCollisionSystem.bulletEntityCollision(bullet.getMovementComponent(), obstacle.getDimensionComponent())) {
                        GlobalShootSystem.damage(obstacle.getLivableComponent(), bullet.getLivableComponent());
                    }
                }
            }
        }

        for (AObstacleEntity obstacle : obstacleEntitieList) {
            for (APlayerEntity player : playerEntitieList) {
                for (ABulletEntity bullet : player.getShootingComponent().getBulletList()) {
                    if (BulletCollisionSystem.bulletEntityCollision(bullet.getMovementComponent(), obstacle.getDimensionComponent())) {
                        GlobalShootSystem.damage(obstacle.getLivableComponent(), bullet.getLivableComponent());

                        //STATISTICS
                        StatisticsSystem.incrementShotMiss(player.getStatisticsComponent());
                        //STATISTICS
                    }
                }
            }
        }

        //Check for bullets from player to BigEnemy
        for (ABigEnemyEntity bigEnemy : bigEnemyEntityList) {
            for (APlayerEntity player : playerEntitieList) {
                for (ABulletEntity bullet : player.getShootingComponent().getBulletList()) {
                    if (BulletCollisionSystem.bulletEntityCollision(bullet.getMovementComponent(), bigEnemy.getMovementComponent())) {

                        //STATISTICS
                        if (bullet.getLivableComponent().getLife() > 0) {
                            StatisticsSystem.incrementShotHit(player.getStatisticsComponent());
                            StatisticsSystem.incrementDamageDone(player.getStatisticsComponent(), bigEnemy.getLivableComponent());
                        }
                        //STATISTICS

                        GlobalShootSystem.damage(bigEnemy.getLivableComponent(), bullet.getLivableComponent());
                    }
                }
            }
        }
/*
        //Check for bullets from player to bonus
        for (ABigEnemyEntity bonus : bonusEntityList) {
            for (APlayerEntity player : playerEntitieList) {
                for (ABulletEntity bullet : player.getShootingComponent().getBulletList()) {
                    if (BulletCollisionSystem.bulletEntityCollision(bullet.getMovementComponent(), bonus.getMovementComponent())) {

                        //STATISTICS
                        if(bullet.getLivableComponent().getLife()>0)
                            StatisticsSystem.incrementShotHit(player.getStatisticsComponent());
                        //STATISTICS

                        GlobalShootSystem.damage(bonus.getLivableComponent(), bullet.getLivableComponent());

                        //Breng de bonus over
                        if (bonus.getCollectableComponent().getType() == CollectableComponent.collectableType.life) {
                            player.getLivableComponent().upLifeByAmount(bonus.getCollectableComponent().getValue());
                        }
                    }
                }
            }
        }

 */
    }

    /**
     * Checkt de entiteiten dat ze niet buiten de grenzen gaan en reageer gepast wanneer wel.
     */
    private void checkBorderCollisions() {
        //checkBorderCollisionPlayer
        playerEntitieList.forEach(i -> {
            BorderCollisionSystem.checkBorderCollisionPlayer(borderCollision, i.getMovementComponent());
        });

        //Check bullet collision player with game ends
        for (APlayerEntity player : playerEntitieList) {
            for (ABulletEntity b : player.getShootingComponent().getBulletList()) {

                //STATISTICS
                double tempVelocityBullets = b.getMovementComponent().getVelocity();
                //STATISTICS

                BorderCollisionSystem.checkBorderCollisionBullet(borderCollision, b.getMovementComponent());

                //STATISTICS
                if (tempVelocityBullets != b.getMovementComponent().getVelocity()) {  //Als er een bullet stopt met bewegen dus ergens tegen botst
                    StatisticsSystem.incrementShotMiss(player.getStatisticsComponent());
                }
                //STATISTICS
            }
        }

        //Check bullet collision enemy with game ends
        for (AEnemyEntity enemy : enemyEntityList) {
            for (ABulletEntity b : enemy.getShootingComponent().getBulletList()) {
                BorderCollisionSystem.checkBorderCollisionBullet(borderCollision, b.getMovementComponent());
            }
        }

        //Check Enemy Border Collision
        //enemyEntityList.forEach(i -> CollisionManager.checkBorderCollision(borderCollisionSystem,i.getMovementComponent()));
        BorderCollisionSystem.checkBorderCollisionEnemy(borderCollision, enemyEntityList.stream().map(AEnemyEntity::getMovementComponent).toList());

        //Check for BigEnemy Border Collsion
        bigEnemyEntityList.forEach(bonus -> BorderCollisionSystem.checkBorderCollisionBigEnemy(borderCollision, bonus.getMovementComponent()));

        //Check for Bonus Border Collsion
        bonusEntityList.forEach(bonus -> BorderCollisionSystem.checkBorderCollisionBonus(borderCollision, bonus.getMovementComponent()));

    }

    private void clearEntityLists() {
        //playerEntitieList = new ArrayList<>();
        enemyEntityList = new ArrayList<>();
        bigEnemyEntityList = new ArrayList<>();
        obstacleEntitieList = new ArrayList<>();
        bonusEntityList = new ArrayList<>();
    }

    /**
     * Updates teksten met spelers statistics.
     */
    private void updateText() {
        //Check voor wijzigingen in life en points van de spelers.
        for (int i = 0; i < playerEntitieList.size(); i++) {
            textLifeList
                    .get(i)
                    .getInformationComponent()
                    .setInformation(
                            String.valueOf(playerEntitieList.get(i).getLivableComponent().getLife()));

            //Bereken de score
            StatisticsSystem.calculateScore(playerEntitieList.get(i).getStatisticsComponent());

            textPointsList
                    .get(i)
                    .getInformationComponent()
                    .setInformation(
                            String.valueOf(playerEntitieList.get(i).getStatisticsComponent().getScore()));
        }
    }

    /**
     * Updates in game states en game states.
     */
    private void updateInGameStates() {
        //Al de enemies zijn dood en elke speler heeft nog genoeg leven
        if (enemyEntityList.isEmpty() && playerEntitieList.stream().noneMatch(i -> i.getLivableComponent().getLife() == 0)) {
            System.out.println("WIN!");
            switch (inGameState) {

                case LEVEL_1 -> {
                    inGameState = InGameStates.LEVEL_2;
                }
                case LEVEL_2 -> {
                    inGameState = InGameStates.BOSS_LEVEL;
                }
                case BOSS_LEVEL -> {
                    gameState = GameStates.END_GAME;
                }
            }
        }

        //De speler zijn leven is 0.
        if (playerEntitieList.stream().map(APlayerEntity::getLivableComponent).anyMatch(i -> i.getLife() == 0)) {
            soundSystem.playSoundOnce(SoundType.PLAYER_DEAD_SOUND);
            System.out.println("LOSE!");
            gameState = GameStates.END_GAME;
        }
    }

    /**
     * Updates bonus creatie.
     */
    private void updateBonus() {
        if(this.entityCreationSystem.bonusCreation(bonusEntityList, playerEntitieList.stream().map(APlayerEntity::getStatisticsComponent).toList(), gfxFactory, new Dimension(gameWidth, gameHeight)))
            soundSystem.playSoundOnce(SoundType.BONUS_SOUND);
    }

    /**
     * Updates bigEnemy creatie.
     */
    private void updateBigEnemy() {
        //Heeft een speler shotHits van %20 bereikt? maak dan een big Enemy van life van 1
        if(this.entityCreationSystem.bigEnemyCreation(bigEnemyEntityList, playerEntitieList.stream().map(APlayerEntity::getStatisticsComponent).toList(), gfxFactory, new Dimension(gameWidth, gameHeight)))
            this.soundSystem.playSoundOnce(SoundType.BIG_ENEMY_SOUND);
    }

    /**
     * Updates kogel movement.
     */
    private void updateBullets() {
        // Check for player bullets
        playerEntitieList.forEach(player -> {
            //De speler kan maar 1 schot uitvoeren.
            if (playerShootSystem.checkShoot(gfxFactory.getInput()) && player.getShootingComponent().getBulletList().isEmpty()) {
                //Voer het schot uit.
                GlobalShootSystem.fire(player.getMovementComponent(), player.getShootingComponent(), gfxFactory, FromWhoBulletType.PLAYER);

                //Voer sound uit
                this.soundSystem.playSoundOnce(SoundType.PLAYER_SHOOT_SOUND);

                //STATISTICS
                //houd bij hoe vaak een speler geschoten heeft.
                StatisticsSystem.incrementShotFired(player.getStatisticsComponent());
                //STATISTICS
            }
        });

        // Check for enemy bullets
        enemyEntityList.forEach(i -> {
            if (enemyShootSystem.checkShoot()) {
                //Voer het schot uit.
                GlobalShootSystem.fire(i.getMovementComponent(), i.getShootingComponent(), gfxFactory, FromWhoBulletType.ENEMY);
            }
        });
    }

    private void updateMovements(){
        playerEntitieList.stream().map(APlayerEntity::getMovementComponent).forEach(mc -> PlayerMovementSystem.move(mc, gfxFactory.getInput()));
        EnemyMovementSystem.move(enemyEntityList.stream().map(AEnemyEntity::getMovementComponent).toList());
        bonusEntityList.stream().map(ABonusEntity::getMovementComponent).forEach(BonusMovementSystem::move);
        bigEnemyEntityList.stream().map(ABigEnemyEntity::getMovementComponent).forEach(BigEnemyMovementSystem::move);

        //Als er bullets aanwezig zijn van een speler, beweeg ze
        playerEntitieList.forEach(player -> {
            if (!player.getShootingComponent().getBulletList().isEmpty()) {
                player.getShootingComponent().getBulletList().forEach(b -> BulletMovementSystem.move(b.getMovementComponent()));
            }
        });

        //Als er bullets aanwezig zijn van een enemy, beweeg ze
        enemyEntityList.forEach(enemy -> {
            if (!enemy.getShootingComponent().getBulletList().isEmpty()) {
                enemy.getShootingComponent().getBulletList().forEach(b -> BulletMovementSystem.move(b.getMovementComponent()));
            }
        });
    }

    /**
     * Kuis de entiteiten op als er iets mee gebeurd is waardoor ze dood gaan of stil staan.
     */
    void doCleanup() {
        //Cleanup bullets van een speler
        playerEntitieList.forEach(player -> {
            EntityCleanupSystem.cleanupBullets(player.getShootingComponent().getBulletList());
        });

        //Cleanup bullets van een enemy
        enemyEntityList.forEach(enemy -> {
            EntityCleanupSystem.cleanupBullets(enemy.getShootingComponent().getBulletList());
        });

        //Cleanup enemy's
        if (EntityCleanupSystem.cleanupEnemys(enemyEntityList)) {
            soundSystem.playSoundOnce(SoundType.ENEMY_DEAD_SOUND);
        }

        //Cleanup obstacles
        EntityCleanupSystem.cleanupObstacles(obstacleEntitieList);

        //Cleanup BigEnemy
        if (EntityCleanupSystem.cleanupBigEnemy(bigEnemyEntityList)) {
            soundSystem.playSoundOnce(SoundType.ENEMY_DEAD_SOUND);
        }

        //Cleanup bonuses
        EntityCleanupSystem.cleanupBonuses(bonusEntityList);
    }
}
