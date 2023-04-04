package be.uantwerpen.fti.ei.spaceinvaders.game;

import be.uantwerpen.fti.ei.spaceinvaders.game.collision.BorderCollisionSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.collision.BorderCollisionManager;
import be.uantwerpen.fti.ei.spaceinvaders.game.collision.EntityCollisionManager;
import be.uantwerpen.fti.ei.spaceinvaders.game.collision.EntityCollisionSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.*;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Position;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.EntityCleanupSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement.BulletMovementSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement.EnemyMovementSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement.PlayerMovementSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting.EnemyShootSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting.FromWhoBulletType;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting.GlobalShootSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting.PlayerShootSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.game.filecontroller.FileManager;

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
     * Een lijst van projectile entiteiten.
     */
    List<ABulletEntity> projectileEntityList = new ArrayList<>();
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
    private BorderCollisionSystem borderCollisionSystem;

    /**
     * Een speler schiet systeem
     */
    private PlayerShootSystem playerShootSystem;

    /**
     * Een enemy schiet systeem
     */
    private EnemyShootSystem enemyShootSystem;

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

        this.Initialize();
    }

    /**
     * Een methode die al de parameters ophaalt van het meegegeven bestand.
     *
     * @param configFile De locatie van het configuratiebestand.
     */
    private void getSettings(String configFile) {
        this.gameWidth = FileManager.getSettingInteger("gameWidth", configFile, 20);
        this.gameHeight = FileManager.getSettingInteger("gameHeight", configFile, 20);
    }

    /**
     * We initialiseren hiermee het spel. We laden alle objecten, die nodig zijn om het spel te spelen, in.
     */
    private void Initialize() {
        //Collisions
        this.borderCollisionSystem = new BorderCollisionSystem(new Dimension(gameWidth * gfxFactory.getScaler().getWidth(), gameHeight * gfxFactory.getScaler().getHeight()));
        this.playerShootSystem = new PlayerShootSystem();
        this.enemyShootSystem = new EnemyShootSystem();

        //Create player
        playerEntitieList.add(this.gfxFactory.getPlayerEntity(new Position(this.gameWidth / 2, this.gameHeight-1), 5, 2, 2));
        //playerEntitieList.add(this.gfxFactory.getPlayerEntity(new Position(this.gameWidth/2 +10,this.gameHeight),5,2));

        //Create texten a.d.h.v. aantal players
        for (int i = 0; i < playerEntitieList.size(); i++) {
            this.textLifeList.add(gfxFactory.getTextEntity(new Position(0, i+1), "life: ", String.valueOf(this.playerEntitieList.get(i).getLivableComponent().getLife())));
            this.textPointsList.add(gfxFactory.getTextEntity(new Position(0, i+2), "points: ", "0"));
        }

        //Create enemy
        for (int i = 5; i < this.gameWidth - 5; i++) {
            enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(i, 1 + (i % 2)), 1, 3, 0.5));
        }
    }

    /**
     * De start methoden zal het spel starten.
     */
    public void start() {
        //TIJD CONSTANT HOUDEN
        double fpsIntervalNS = (1000000000 / FPS);
        double nextFpsIntervalNS = System.nanoTime() + fpsIntervalNS;
        double remainingFpsIntervalTime = 0;
        //TIJD CONSTANT HOUDEN

        while (this.isRunning) {
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
            System.out.printf(String.valueOf(playerEntitieList.get(0).getMovementComponent().getPosition().getY()));
            System.out.print("\n");
            //DEBUG
        }
    }

    /**
     * De update methoden zal al de objecten van het spel update.
     */
    private void update() {

        if (enemyEntityList.isEmpty()) {
            System.out.println("WIN!");
            this.isRunning = false;
        }

        if (playerEntitieList.stream().map(APlayerEntity::getLivableComponent).anyMatch(i -> i.getLife() == 0)) {
            System.out.println("LOSE!");
            this.isRunning = false;
        }



        //move the players and check for bullets
        playerEntitieList.forEach(player -> {
            PlayerMovementSystem.move(player.getMovementComponent(), gfxFactory.getInput());

            if (playerShootSystem.checkShoot(gfxFactory.getInput())) {
                //Voer het schot uit.
                GlobalShootSystem.fire(player.getMovementComponent(), player.getBulletList(), gfxFactory, FromWhoBulletType.player);
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
                GlobalShootSystem.fire(i.getMovementComponent(), i.getBulletList(), gfxFactory, FromWhoBulletType.enemy);
            }
        });

        //Als er bullets aanwezig zijn van een speler, beweeg ze
        playerEntitieList.forEach(player -> {
            if (!player.getBulletList().isEmpty()) {
                player.getBulletList().forEach(b -> BulletMovementSystem.move(b.getMovementComponent()));
            }
        });

        //Als er bullets aanwezig zijn van een enemy, beweeg ze
        enemyEntityList.forEach(enemy -> {
            if (!enemy.getBulletList().isEmpty()) {
                enemy.getBulletList().forEach(b -> BulletMovementSystem.move(b.getMovementComponent()));
            }
        });


        //Check collisions
        checkCollisions();

        //Check voor wijzigingen in life en points van de spelers.
        for (int i=0; i < playerEntitieList.size(); i++){
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
            BorderCollisionManager.checkBorderCollisionPlayer(borderCollisionSystem, i.getMovementComponent());
        });

        //Check bullet collision player with game ends
        for (APlayerEntity player : playerEntitieList) {
            for (ABulletEntity b : player.getBulletList()) {
                //STATISTICS
                double tempVelocityBullets = b.getMovementComponent().getVelocity();
                //STATISTICS

                BorderCollisionManager.checkBorderCollisionBullet(borderCollisionSystem, b.getMovementComponent());

                //STATISTICS
                if (tempVelocityBullets != b.getMovementComponent().getVelocity()) {  //Als er een bullet stopt met bewegen dus ergens tegen botst
                    player.getStatisticsComponent().incrementShotsMissed(1);
                }
                //STATISTICS
            }
        }

        //Check bullet collision enemy with game ends
        for (AEnemyEntity enemy : enemyEntityList) {
            for (ABulletEntity b : enemy.getBulletList()) {
                BorderCollisionManager.checkBorderCollisionBullet(borderCollisionSystem, b.getMovementComponent());
            }
        }

        //Check Enemy Border Collision
        //enemyEntityList.forEach(i -> CollisionManager.checkBorderCollision(borderCollisionSystem,i.getMovementComponent()));
        BorderCollisionManager.checkBorderCollisionEnemy(borderCollisionSystem, enemyEntityList.stream().map(AEnemyEntity::getMovementComponent).toList());

        //Check entity + entity collision.
        /*for (MovementComponent emc : enemyEntityList.stream().map(AEnemyEntity::getMovementComponent).toList())
            if(EntityCollision.entityCollision(playerEntitieList.get(0).getMovementComponent(), emc)){
                System.out.println("Collision!");
            }
*/
        //Check for bullet to enemy collision
        for (AEnemyEntity enemy : enemyEntityList) {
            for (APlayerEntity player : playerEntitieList) {
                for (ABulletEntity bullet : player.getBulletList()) {
                    if (EntityCollisionManager.bulletEntityCollision(bullet.getMovementComponent(), enemy.getMovementComponent())) {
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
                for (ABulletEntity bullet : enemy.getBulletList()) {
                    if (EntityCollisionManager.bulletEntityCollision(bullet.getMovementComponent(), player.getMovementComponent())) {
                        //STATISTICS
                        player.getStatisticsComponent().incrementDamageTaken(bullet.getLivableComponent().getLife());
                        //STATISTICS

                        GlobalShootSystem.damage(player.getLivableComponent(), bullet.getLivableComponent());
                    }
                }
            }
        }

        //Check player to an enemy collision
        for (MovementComponent emc : enemyEntityList.stream().map(AEnemyEntity::getMovementComponent).toList())
            if (EntityCollisionSystem.entityIsOnSameLine(playerEntitieList.get(0).getMovementComponent(), emc)) {
                System.out.println("DEAD!");
                this.isRunning = false;
                break;
            }
    }

    void doCleanup() {
        //Cleanup bullets van een speler
        playerEntitieList.forEach(player -> {
            EntityCleanupSystem.cleanupBullets(player.getBulletList());
        });

        //Cleanup bullets van een enemy
        enemyEntityList.forEach(enemy -> {
            EntityCleanupSystem.cleanupBullets(enemy.getBulletList());
        });

        //Cleanup enemy's
        EntityCleanupSystem.cleanupEnemys(enemyEntityList);
    }

    /**
     * De visualize methode zal elk object afbeelden.
     */
    private void visualize() {
        playerEntitieList.forEach(APlayerEntity::visualize);
        enemyEntityList.forEach(AEnemyEntity::visualize);
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
