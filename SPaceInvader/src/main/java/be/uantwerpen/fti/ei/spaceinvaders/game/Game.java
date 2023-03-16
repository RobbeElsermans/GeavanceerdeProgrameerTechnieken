package be.uantwerpen.fi.ei.spaceinvaders.game;

import be.uantwerpen.fi.ei.spaceinvaders.game.entity.enemy.AEnemyEntity;
import be.uantwerpen.fi.ei.spaceinvaders.game.entity.obstacle.AObstacleEntity;
import be.uantwerpen.fi.ei.spaceinvaders.game.entity.player.APlayerEntity;
import be.uantwerpen.fi.ei.spaceinvaders.game.entity.projectile.AProjectileEntity;
import be.uantwerpen.fi.ei.spaceinvaders.game.factory.AFactory;

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
        enemyEntityList.add(this.gfxFactory.getEnemyEntity());

    }


}
