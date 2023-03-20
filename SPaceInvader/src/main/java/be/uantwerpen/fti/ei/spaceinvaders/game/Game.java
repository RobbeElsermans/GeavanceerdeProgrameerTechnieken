package be.uantwerpen.fti.ei.spaceinvaders.game;

import be.uantwerpen.fti.ei.spaceinvaders.game.collision.BorderCollision;
import be.uantwerpen.fti.ei.spaceinvaders.game.collision.CollisionManager;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.enemy.AEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.obstacle.AObstacleEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.player.APlayerEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Position;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.projectile.AProjectileEntity;
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
    List<AProjectileEntity> projectileEntityList = new ArrayList<>();
    /**
     * Een lijst van obstacle entiteiten.
     */
    List<AObstacleEntity> obstacleEntitieList = new ArrayList<>();

    /**
     * Een collision object die we gebruiken om de entiteiten binnenin het spelvlak te houden.
     */
    private BorderCollision borderCollision;

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
     * @param aFactory       Een GFX-factory om de zaak te tonen.
     * @param configFile     Het configuratiebestand waarin verschillende parameters staan.
     *
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
     * @param configFile    De locatie van het configuratiebestand.
     */
    private void getSettings(String configFile) {
        this.gameWidth = FileManager.getSetting("gameWidth", configFile, 20);
        this.gameHeight = FileManager.getSetting("gameHeight", configFile, 20);
    }

    /**
     * We initialiseren hiermee het spel. We laden alle objecten, die nodig zijn om het spel te spelen, in.
     */
    private void Initialize() {
        //Collisions
        this.borderCollision = new BorderCollision(new Dimension(gameWidth * gfxFactory.getDimensionScaler(), gameHeight* gfxFactory.getDimensionScaler()));

        playerEntitieList.add(this.gfxFactory.getPlayerEntity(new Position(this.gameWidth/2,this.gameHeight),5,2));
    }

    /**
     * De start methoden zal het spel starten.
     */
    public void start(){

        //TIJD CONSTANT HOUDEN
        double fpsIntervalNS = (1000000000/FPS);
        double nextFpsIntervalNS = System.nanoTime() + fpsIntervalNS;
        double remainingFpsIntervalTime = 0;
        //TIJD CONSTANT HOUDEN

        while(this.isRunning) {
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
                if(remainingFpsIntervalTime > 0)
                    Thread.sleep((long) remainingFpsIntervalTime); //Wachten zodat totale tijd FPS behaald wordt.

                nextFpsIntervalNS += fpsIntervalNS;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //TIJD CONSTANT HOUDEN
        }
    }

    /**
     * De update methoden zal al de objecten van het spel update.
     */
    private void update(){
        playerEntitieList.forEach(AEntity::update);

        //Check collisions with border
        //playerEntitieList.forEach(i -> BorderCollision.checkBorderCollsion(i.getPosition(), i.getDimentions(), gameWidth, gameHeight));
        checkCollisions();
    }

    /**
     * Deze methoden overloopt al de collisions.
     */
    private void checkCollisions(){
        //CheckPlayerBorderCollision
        playerEntitieList.forEach(i -> CollisionManager.checkBorderCollision(borderCollision,i));

        //Check Enemy Border Collision
    }

    /**
     * De visualize methode zal elk object afbeelden.
     */
    private void visualize(){
        playerEntitieList.forEach(AEntity::visualize);
    }

    /**
     * De render methoden gaat het gamevlak renderen zodat alle wijzigingen doorgevoerd worden.
     */
    private void render(){
        gfxFactory.render();
    }
}
