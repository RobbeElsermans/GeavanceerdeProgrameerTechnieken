package be.uantwerpen.fi.ei.spaceinvaders.gfx.j2d;
import be.uantwerpen.fi.ei.spaceinvaders.game.entity.enemy.AEnemyEntity;
import be.uantwerpen.fi.ei.spaceinvaders.game.entity.obstacle.AObstacleEntity;
import be.uantwerpen.fi.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fi.ei.spaceinvaders.game.entity.player.APlayerEntity;
import be.uantwerpen.fi.ei.spaceinvaders.game.entity.projectile.AProjectileEntity;

public class FactoryJ2d extends AFactory {

    @Override
    public APlayerEntity getPlayerEntity() {
        return null;
    }

    @Override
    public APlayerEntity getPlayerEntity(int x, int y, int life, int speed) {
        return null;
    }

    @Override
    public AEnemyEntity getEnemyEntity() {
        return null;
    }

    @Override
    public AEnemyEntity getEnemyEntity(int x, int y, int life, int speed) {
        return null;
    }

    @Override
    public AProjectileEntity getProjectileEntity() {
        return null;
    }

    @Override
    public AProjectileEntity getProjectileEntity(int x, int y, int life, int speed) {
        return null;
    }

    @Override
    public AObstacleEntity getObstacleEntity() {
        return null;
    }

    @Override
    public AObstacleEntity getObstacleEntity(int x, int y, int life) {
        return null;
    }
}