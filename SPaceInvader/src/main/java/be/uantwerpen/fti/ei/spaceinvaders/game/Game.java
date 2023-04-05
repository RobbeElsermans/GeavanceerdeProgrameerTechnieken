package be.uantwerpen.fti.ei.spaceinvaders.game;

import be.uantwerpen.fti.ei.spaceinvaders.game.collision.BorderCollision;
import be.uantwerpen.fti.ei.spaceinvaders.game.collision.BorderCollisionSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.collision.BulletCollisionSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.collision.EntityCollision;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.*;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.CollectableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.EntityCleanupSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement.BulletMovementSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement.CollectableMovementSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement.EnemyMovementSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement.GlobalMovementSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting.EnemyShootSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting.FromWhoBulletType;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting.GlobalShootSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting.PlayerShootSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Position;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.game.filecontroller.FileManager;
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

    //TODO: refactor sound.
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
    private final int FPS = 60;

    /**
     * EEN boolean die bijhoud of het spel bezig is.
     * Wanneer men bv. op ESC zou drukken, zal het spel in pauze gaan.
     */
    private boolean isRunning = true;

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

        this.baseInitialize();
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
        this.soundSystem = new SoundSystem();

        //Voeg de geluidjes toe aan de soundcomponent in soundSystem.
        this.soundSystem.getSoundComponent().addSound("/sound/explosion.wav", SoundType.playerDeadSound);
        this.soundSystem.getSoundComponent().addSound("/sound/invaderkilled.wav", SoundType.enemyDeadSound);
        this.soundSystem.getSoundComponent().addSound("/sound/shoot.wav", SoundType.playerShootSound);
        this.soundSystem.getSoundComponent().addSound("/sound/ufo_lowpitch.wav", SoundType.bonusSound);

        // Player & texten blijven bestaan.
        playerEntitieList = new ArrayList<>();
        textLifeList = new ArrayList<>();
        textPointsList = new ArrayList<>();

        // Initialiseer de rest van de entiteiten.
        clearEntityLists();

        //Create player
        playerEntitieList.add(this.gfxFactory.getPlayerEntity(new Position(this.gameWidth / 2, this.gameHeight - 1), 5, 2, 2));
        //playerEntitieList.add(this.gfxFactory.getPlayerEntity(new Position(this.gameWidth / 2 + 10, this.gameHeight-1), 5, 2, 0.3));

        //Create texten a.d.h.v. aantal players.
        for (int i = 0; i < playerEntitieList.size(); i++) {
            this.textLifeList.add(gfxFactory.getTextEntity(new Position(0, i * 2 + 1), "life: ", String.valueOf(this.playerEntitieList.get(i).getLivableComponent().getLife())));
            this.textPointsList.add(gfxFactory.getTextEntity(new Position(0, i * 2 + 2), "points: ", "0"));
        }
    }

    private void clearEntityLists() {
        //playerEntitieList = new ArrayList<>();
        enemyEntityList = new ArrayList<>();
        bonusEntityList = new ArrayList<>();
        obstacleEntitieList = new ArrayList<>();
    }

    private void levelInitialize(int lvlNumber) {
        if (lvlNumber == 1) {
            //Create enemy
            /*
            for (int i = 5; i < this.gameWidth-5; i++) {
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(i, 4 + (i % 3)), 1, 5, 0.5));
            }

             */
            for (int i = 6; i < this.gameWidth - 6; i++) {
                if (i % 2 == 0) {
                    enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(i, 4), 4, 4, 0.5));
                    enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(i, 5), 3, 4, 0.5));
                    enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(i, 6), 2, 4, 0.5));
                    enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(i, 7), 1, 4, 0.5));
                }
            }
            //bonusEntityList.add(gfxFactory.getBonusEntity(new Position(2,1),1,3,0.5, CollectableComponent.collectableType.life,1));

            //Create Obstacles
            obstacleEntitieList.add(gfxFactory.getObstacleEntity(new Position(2, this.gameHeight - 3), 3));
            obstacleEntitieList.add(gfxFactory.getObstacleEntity(new Position(15, this.gameHeight - 4), 3));
            obstacleEntitieList.add(gfxFactory.getObstacleEntity(new Position(23, this.gameHeight - 2), 3));

        } else if (lvlNumber == 2) {
            enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(2, 2), 1, 2, 0.5));
            //enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(2, 3), 3, 10, 0.5));
            //enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(4, 4), 3, 10, 0.5));

            //Create Obstacles
            obstacleEntitieList.add(gfxFactory.getObstacleEntity(new Position(15, this.gameHeight - 2), 3));
        } else {

        }
    }

    /**
     * De start methoden zal het spel starten.
     */
    public void start() {
        //TIJD CONSTANT HOUDEN
        double fpsIntervalNS = ((double) 1000000000 / FPS);
        double nextFpsIntervalNS = System.nanoTime() + fpsIntervalNS;
        double remainingFpsIntervalTime = 0;
        //TIJD CONSTANT HOUDEN

        //Sound test
        //this.soundSystem.playSoundOnce(SoundType.playerShootSound);
        //this.soundSystem.stopSoundLoop();


        int levelNumber = 1;
        while (levelNumber <= 2) {   //maximum 2 levels
            levelInitialize(levelNumber);
            this.isRunning = true;
            while (this.isRunning && levelNumber <= 2) { //maximum 2 levels
                //render screen
                render();
                //update
                update();
                //visualize entitys
                visualize();

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
                //System.out.printf(playerEntitieList.get(0).getStatisticsComponent().toString());
                //System.out.print("\n");
                //System.out.printf(String.valueOf(playerEntitieList.get(0).getMovementComponent().getPosition().getY()));
                //System.out.print("\n");
                //DEBUG
            }
            levelNumber++;
        }
    }

    /**
     * De update methoden zal al de objecten van het spel update.
     */
    private void update() {

        //Heeft een speler shotHits van %5 bereikt? maak dan een bonus van live van 1
        if (playerEntitieList.stream().anyMatch(i -> (i.getStatisticsComponent().getShotsHits() % 5 == 0) && (i.getStatisticsComponent().getShotsHits() > 0))) {
            if (this.bonusEntityList.size() == 0) {
                this.bonusEntityList.add(this.gfxFactory.getBonusEntity(new Position(2, 1), 1, 3, 0.5, CollectableComponent.collectableType.life, 1));
                this.soundSystem.playSoundOnce(SoundType.bonusSound);
            }

        }

        if (enemyEntityList.isEmpty()) {
            System.out.println("WIN!");
            this.isRunning = false;
        }

        if (playerEntitieList.stream().map(APlayerEntity::getLivableComponent).anyMatch(i -> i.getLife() == 0)) {
            soundSystem.playSoundOnce(SoundType.playerDeadSound);
            System.out.println("LOSE!");
            this.isRunning = false;
        }

        //move the players and check for bullets
        playerEntitieList.forEach(player -> {
            GlobalMovementSystem.move(player.getMovementComponent(), gfxFactory.getInput());

            if (playerShootSystem.checkShoot(gfxFactory.getInput())) {
                //Voer het schot uit.
                GlobalShootSystem.fire(player.getMovementComponent(), player.getShootingComponent(), gfxFactory, FromWhoBulletType.player);

                //Voer sound uit
                this.soundSystem.playSoundOnce(SoundType.playerShootSound);

                //STATISTICS
                player.getStatisticsComponent().incrementShotsFired(1); //houd bij hoe vaak een speler geschoten heeft.
                //STATISTICS
            }
        });

        //move the enemy's and check for bullets
        EnemyMovementSystem.move(enemyEntityList.stream().map(AEnemyEntity::getMovementComponent).toList());
        enemyEntityList.forEach(i -> {
            if (enemyShootSystem.checkShoot()) {
                //Voer het schot uit.
                GlobalShootSystem.fire(i.getMovementComponent(), i.getShootingComponent(), gfxFactory, FromWhoBulletType.enemy);
            }
        });

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

        // Als er bonus entiteiten aanwezig zijn, beweeg ze
        bonusEntityList.forEach(i -> CollectableMovementSystem.move(i.getMovementComponent()));


        //Check collisions
        checkCollisions();

        //Check voor wijzigingen in life en points van de spelers.
        for (int i = 0; i < playerEntitieList.size(); i++) {
            textLifeList
                    .get(i)
                    .getInformationComponent()
                    .setInformation(
                            String.valueOf(playerEntitieList.get(i).getLivableComponent().getLife()));
            textPointsList
                    .get(i)
                    .getInformationComponent()
                    .setInformation(
                            String.valueOf(playerEntitieList.get(i).getStatisticsComponent().getShotsHits()));
        }

        //kuis de entiteiten op als er iets mee gebeurd is waardoor ze dood gaan.
        doCleanup();
    }

    /**
     * Deze methoden overloopt al de collisions.
     */
    private void checkCollisions() {
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
                    player.getStatisticsComponent().incrementShotsMissed(1);
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

        //Check for Bonus Border Collsion
        bonusEntityList.forEach(bonus -> BorderCollisionSystem.checkBorderCollisionBonus(borderCollision, bonus.getMovementComponent()));

        //Check entity + entity collision.
        /*for (MovementComponent emc : enemyEntityList.stream().map(AEnemyEntity::getMovementComponent).toList())
            if(EntityCollision.entityCollision(playerEntitieList.get(0).getMovementComponent(), emc)){
                System.out.println("Collision!");
            }
*/
        //Check for bullet to enemy collision
        for (AEnemyEntity enemy : enemyEntityList) {
            for (APlayerEntity player : playerEntitieList) {
                for (ABulletEntity bullet : player.getShootingComponent().getBulletList()) {
                    if (BulletCollisionSystem.bulletEntityCollision(bullet.getMovementComponent(), enemy.getMovementComponent())) {

                        //STATISTICS
                        player.getStatisticsComponent().incrementDamageDone(bullet.getLivableComponent().getLife());
                        player.getStatisticsComponent().incrementShotsHits(1);
                        //STATISTICS

                        GlobalShootSystem.damage(enemy.getLivableComponent(), bullet.getLivableComponent());
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
                        player.getStatisticsComponent().incrementDamageTaken(bullet.getLivableComponent().getLife());
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
                    if (BulletCollisionSystem.bulletEntityCollision(bullet.getMovementComponent(), obstacle.getStaticComponent())) {
                        GlobalShootSystem.damage(obstacle.getLivableComponent(), bullet.getLivableComponent());
                    }
                }
            }
        }

        for (AObstacleEntity obstacle : obstacleEntitieList) {
            for (APlayerEntity player : playerEntitieList) {
                for (ABulletEntity bullet : player.getShootingComponent().getBulletList()) {
                    if (BulletCollisionSystem.bulletEntityCollision(bullet.getMovementComponent(), obstacle.getStaticComponent())) {
                        GlobalShootSystem.damage(obstacle.getLivableComponent(), bullet.getLivableComponent());
                    }
                }
            }
        }

        //Check for bullets from player to bonus
        for (ABonusEntity bonus : bonusEntityList) {
            for (APlayerEntity player : playerEntitieList) {
                for (ABulletEntity bullet : player.getShootingComponent().getBulletList()) {
                    if (BulletCollisionSystem.bulletEntityCollision(bullet.getMovementComponent(), bonus.getMovementComponent())) {
                        GlobalShootSystem.damage(bonus.getLivableComponent(), bullet.getLivableComponent());

                        if (bonus.getCollectableComponent().getType() == CollectableComponent.collectableType.life) {
                            player.getLivableComponent().upLifeByAmount(bonus.getCollectableComponent().getValue());
                        }

                    }
                }
            }
        }

        //Check player to an enemy collision
        for (MovementComponent emc : enemyEntityList.stream().map(AEnemyEntity::getMovementComponent).toList())
            if (EntityCollision.entityIsOnSameLine(playerEntitieList.get(0).getMovementComponent(), emc)) {
                System.out.println("DEAD!");
                this.isRunning = false;
                break;
            }
    }

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
            soundSystem.playSoundOnce(SoundType.enemyDeadSound);
        }

        //Cleanup obstacles
        EntityCleanupSystem.cleanupObstacles(obstacleEntitieList);

        //Cleanup bonuses
        if (EntityCleanupSystem.cleanupBonuses(bonusEntityList)) {
            soundSystem.playSoundOnce(SoundType.enemyDeadSound);
        }
    }

    /**
     * De visualize methode zal elk object afbeelden.
     */
    private void visualize() {
        playerEntitieList.forEach(APlayerEntity::visualize);
        enemyEntityList.forEach(AEnemyEntity::visualize);
        obstacleEntitieList.forEach(AObstacleEntity::visualize);
        bonusEntityList.forEach(ABonusEntity::visualize);
        textLifeList.forEach(ATextEntity::visualize);
        textPointsList.forEach(ATextEntity::visualize);
    }

    /**
     * De rendermethoden gaat het gamevlak renderen zodat alle wijzigingen doorgevoerd worden.
     */
    private void render() {
        gfxFactory.render();
    }
}
