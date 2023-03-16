package be.uantwerpen.fi.ei.spaceinvaders.game.factory;

import be.uantwerpen.fi.ei.spaceinvaders.game.entity.enemy.AEnemyEntity;
import be.uantwerpen.fi.ei.spaceinvaders.game.entity.obstacle.AObstacleEntity;
import be.uantwerpen.fi.ei.spaceinvaders.game.entity.player.APlayerEntity;
import be.uantwerpen.fi.ei.spaceinvaders.game.entity.projectile.AProjectileEntity;

public abstract class AFactory {
    public abstract APlayerEntity getPlayerEntity();
    public abstract APlayerEntity getPlayerEntity(int x, int y, int life, int speed);
    public abstract AEnemyEntity getEnemyEntity();
    public abstract AEnemyEntity getEnemyEntity(int x, int y, int life, int speed);
    public abstract AProjectileEntity getProjectileEntity();
    public abstract AProjectileEntity getProjectileEntity(int x, int y, int life, int speed);
    public abstract AObstacleEntity getObstacleEntity();
    public abstract AObstacleEntity getObstacleEntity(int x, int y, int life);
}
