package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.enemy.AEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.obstacle.AObstacleEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.player.APlayerEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.projectile.AProjectileEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

public class FactoryJ2d extends AFactory {

    private GraphicsContext graphicsContext;
    private IInput keyboardInput;
    private String configFile = "";

    /**
     * Initializeer Java2D.
     * @param configFile
     */
    public FactoryJ2d(IDimension gameDimension,String configFile){
        super(gameDimension);
        this.configFile = configFile;
        this.graphicsContext = new GraphicsContext(this.getGameDimension(),this.configFile);
        this.keyboardInput = new KeyboardInputController(this.graphicsContext);
    }

    @Override
    public APlayerEntity getPlayerEntity() {
        return new Playerj2d(this.keyboardInput, this.graphicsContext);
    }

    @Override
    public APlayerEntity getPlayerEntity(IPosition position, IDimension dimension, int life, int speed) {
        return new Playerj2d(position, dimension, life, speed,this.keyboardInput, graphicsContext);
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
        graphicsContext.render();
    }

    @Override
    public IInput getInput() {
        return new KeyboardInputController(graphicsContext);
    }

    @Override
    public int getDimensionScaler() {
        return this.graphicsContext.getSize();
    }
}
