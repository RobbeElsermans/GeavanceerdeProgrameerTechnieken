package be.uantwerpen.fti.ei.spaceinvaders.game.factory;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.enemy.AEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.obstacle.AObstacleEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.player.APlayerEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.projectile.AProjectileEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

public abstract class AFactory {
    private IDimension gameDimension;
    public AFactory() {
    }
    public void setupGameDimentions(IDimension dimension) {
        this.gameDimension = dimension;
    }
    //Entity abstractions
    public abstract APlayerEntity getPlayerEntity();
    public abstract APlayerEntity getPlayerEntity(IPosition position, int life, int speed);
    public abstract IDimension getPlayerDimentions(APlayerEntity player);
    public abstract AEnemyEntity getEnemyEntity();
    public abstract AEnemyEntity getEnemyEntity(IPosition position, int life, int speed);
    public abstract IDimension getEnemyDimentions(AEnemyEntity enemy);
    public abstract AProjectileEntity getProjectileEntity();
    public abstract AProjectileEntity getProjectileEntity(IPosition position, int life, int speed);
    public abstract IDimension getEnemyDimentions(AProjectileEntity projectile);
    public abstract AObstacleEntity getObstacleEntity();
    public abstract AObstacleEntity getObstacleEntity(IPosition position, int life);
    public abstract IDimension getEnemyDimentions(AObstacleEntity obstacle);
    public abstract void render();

    //Inputs
    public abstract IInput getInput();

    //GameDimension

    public IDimension getGameDimension() {
        return gameDimension;
    }
    public abstract int getDimensionScaler();

}
