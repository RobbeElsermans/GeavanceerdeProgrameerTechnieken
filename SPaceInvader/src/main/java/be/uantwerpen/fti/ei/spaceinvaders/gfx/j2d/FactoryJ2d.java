package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.enemy.AEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.obstacle.AObstacleEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.player.APlayerEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.projectile.AProjectileEntity;

public class FactoryJ2d extends AFactory {

    private GraphicsContext graphicsContext;
    private String configFile = "";

    /**
     * Initializeer Java2D.
     * @param configFile
     */
    public FactoryJ2d(String configFile){
        this.configFile = configFile;
        this.graphicsContext = new GraphicsContext(this.configFile);
    }

    @Override
    public APlayerEntity getPlayerEntity() {
        return new Playerj2d(graphicsContext);
    }

    @Override
    public APlayerEntity getPlayerEntity(int x, int y, int life, int speed) {
        return new Playerj2d(x, y, life, speed, graphicsContext);
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

    @Override
    public void render() {
        graphicsContext.render();
    }
}
