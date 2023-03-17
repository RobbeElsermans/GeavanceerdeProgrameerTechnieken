package be.uantwerpen.fti.ei.spaceinvaders.game;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.enemy.AEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.obstacle.AObstacleEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.player.APlayerEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.projectile.AProjectileEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;

import java.util.ArrayList;
import java.util.List;

public class Game {
    protected AFactory gfxFactory;
    List<APlayerEntity> playerEntitieList = new ArrayList<>();
    List<AEnemyEntity> enemyEntityList = new ArrayList<>();
    List<AProjectileEntity> projectileEntityList = new ArrayList<>();
    List<AObstacleEntity> obstacleEntitieList = new ArrayList<>();
    public Game(AFactory aFactory) {
        this.gfxFactory = aFactory;

        this.Initialize();
    }

    private void Initialize() {
        playerEntitieList.add(this.gfxFactory.getPlayerEntity());
    }

    public void start(){
        //update
        update();
        //visualize entitys
        visualize();
        //render screen
        render();
    }

    private void update(){
        playerEntitieList.forEach(AEntity::update);
    }
    private void visualize(){
        playerEntitieList.forEach(AEntity::visualize);
    }

    private void render(){
        gfxFactory.render();
    }
}
