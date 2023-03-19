package be.uantwerpen.fti.ei.spaceinvaders.game;

import be.uantwerpen.fti.ei.spaceinvaders.game.collision.BorderCollision;
import be.uantwerpen.fti.ei.spaceinvaders.game.collision.CollisionManager;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.enemy.AEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.obstacle.AObstacleEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.player.APlayerEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Position;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.projectile.AProjectileEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.game.filecontroller.FileManager;

import java.util.ArrayList;
import java.util.List;

public class Game {
    protected AFactory gfxFactory;
    List<APlayerEntity> playerEntitieList = new ArrayList<>();
    List<AEnemyEntity> enemyEntityList = new ArrayList<>();
    List<AProjectileEntity> projectileEntityList = new ArrayList<>();
    List<AObstacleEntity> obstacleEntitieList = new ArrayList<>();

    private BorderCollision borderCollision;

    /**
     * De variabelen komen mee met de constructor in een file.
     */
    private int gameWidth;
    private int gameHeight;

    private final int FPS = 60;

    private boolean isRunning = true;
    public Game(AFactory aFactory, String configFile) {


        this.gfxFactory = aFactory;

        //get the game settings
        this.getSettings(configFile);

        //geeft game dimensions over aan factory
        this.gfxFactory.setupGameDimentions(new Dimension(this.gameWidth, this.gameHeight));

        this.Initialize();
    }

    private void getSettings(String configFile) {
        this.gameWidth = FileManager.getSetting("gameWidth", configFile, 20);
        this.gameHeight = FileManager.getSetting("gameHeight", configFile, 20);
    }

    private void Initialize() {
        //Collisions
        this.borderCollision = new BorderCollision(new Dimension(gameWidth * gfxFactory.getDimensionScaler(), gameHeight* gfxFactory.getDimensionScaler()));
        playerEntitieList.add(this.gfxFactory.getPlayerEntity(new Position(this.gameWidth/2,this.gameHeight-2),5,3));
    }

    public void start(){

        double fpsIntervalNS = (1000000000/FPS);
        double nextFpsIntervalNS = System.nanoTime() + fpsIntervalNS;
        double remainingFpsIntervalTime = 0;

        while(this.isRunning) {//omsetten naar timer

            //render screen
            render();
            //update
            update();
            //visualize entitys
            visualize();

            //Wachten zodat totale tijd FPS opleverd.
            try {
                remainingFpsIntervalTime = nextFpsIntervalNS - System.nanoTime();
                remainingFpsIntervalTime /= 1000000;
                if(remainingFpsIntervalTime > 0)
                    Thread.sleep((long) remainingFpsIntervalTime);

                nextFpsIntervalNS += fpsIntervalNS;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void update(){
        playerEntitieList.forEach(AEntity::update);

        //Check collisions with border
        //playerEntitieList.forEach(i -> BorderCollision.checkBorderCollsion(i.getPosition(), i.getDimentions(), gameWidth, gameHeight));
        checkBorderCollisions();
    }

    private void checkBorderCollisions(){
        //CheckPlayerBorderCollision
        IDimension temp = new Dimension(gameWidth * gfxFactory.getDimensionScaler(), gameHeight * gfxFactory.getDimensionScaler());
        playerEntitieList.forEach(i -> CollisionManager.checkBorderCollision(borderCollision,i,temp));
    }

    private void visualize(){
        playerEntitieList.forEach(AEntity::visualize);
    }

    private void render(){
        gfxFactory.render();
    }
}
