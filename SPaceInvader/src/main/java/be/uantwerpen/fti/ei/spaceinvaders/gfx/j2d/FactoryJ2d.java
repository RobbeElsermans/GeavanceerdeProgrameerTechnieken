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
    public FactoryJ2d(String configFile){
        this.configFile = configFile;
    }

    @Override
    public void setupGameDimentions(IDimension dimension){
        super.setupGameDimentions(dimension);
        this.graphicsContext = new GraphicsContext(this.getGameDimension(),this.configFile);
        this.keyboardInput = new KeyboardInputController(this.graphicsContext);
    }

    @Override
    public APlayerEntity getPlayerEntity() {
        return new Playerj2d(this.keyboardInput, this.graphicsContext);
    }

    @Override
    public APlayerEntity getPlayerEntity(IPosition position, int life, int speed) {

        //Schaal a.d.h.v. de game dimentions
        position.setX(position.getX() * this.getDimensionScaler() - 2);
        position.setX(position.getX() * this.getDimensionScaler() -2);

        if(position.getY() > 0)
            position.setY(position.getY() * this.getDimensionScaler() + 2);
        else
            position.setY(position.getY() * this.getDimensionScaler());

        return new Playerj2d(position, life, speed,this.keyboardInput, graphicsContext);
    }

    @Override
    public IDimension getPlayerDimentions(APlayerEntity player) {
        return null;
    }

    @Override
    public AEnemyEntity getEnemyEntity() {
        return null;
    }

    @Override
    public AEnemyEntity getEnemyEntity(IPosition position, int life, int speed) {
        return null;
    }

    @Override
    public IDimension getEnemyDimentions(AEnemyEntity enemy) {
        return null;
    }

    @Override
    public AProjectileEntity getProjectileEntity() {
        return null;
    }

    @Override
    public AProjectileEntity getProjectileEntity(IPosition position, int life, int speed) {
        return null;
    }

    @Override
    public IDimension getEnemyDimentions(AProjectileEntity projectile) {
        return null;
    }

    @Override
    public AObstacleEntity getObstacleEntity() {
        return null;
    }

    @Override
    public AObstacleEntity getObstacleEntity(IPosition position, int life) {
        return null;
    }

    @Override
    public IDimension getEnemyDimentions(AObstacleEntity obstacle) {
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
