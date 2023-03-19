package be.uantwerpen.fti.ei.spaceinvaders.gfx.console;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.enemy.AEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.obstacle.AObstacleEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.player.APlayerEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.projectile.AProjectileEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

public class FactoryConsole extends AFactory {

    public FactoryConsole(IDimension gameDimension) {
        super(gameDimension);
    }

    @Override
    public APlayerEntity getPlayerEntity() {
        return null;
    }

    @Override
    public APlayerEntity getPlayerEntity(IPosition position, IDimension dimension, int life, int speed) {
        return null;
    }

    @Override
    public AEnemyEntity getEnemyEntity() {
        return null;
    }

    @Override
    public AEnemyEntity getEnemyEntity(IPosition position, IDimension dimension, int life, int speed) {
        return null;
    }

    @Override
    public AProjectileEntity getProjectileEntity() {
        return null;
    }

    @Override
    public AProjectileEntity getProjectileEntity(IPosition position, IDimension dimension, int life, int speed) {
        return null;
    }

    @Override
    public AObstacleEntity getObstacleEntity() {
        return null;
    }

    @Override
    public AObstacleEntity getObstacleEntity(IPosition position, IDimension dimension, int life) {
        return null;
    }

    @Override
    public void render() {

    }

    @Override
    public IInput getInput() {
        return null;
    }

    @Override
    public int getDimensionScaler() {
        return 0;
    }
}
