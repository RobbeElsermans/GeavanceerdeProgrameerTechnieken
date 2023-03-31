package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABulletEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AObstacleEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.APlayerEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

public class FactoryJ2d extends AFactory {

    private GraphicsContext graphicsContext;
    private IInput keyboardInput;
    private String configFile = "";

    /**
     * Initializeer Java2D met gegeven configuratie bestand.
     * @param configFile    Deze bevat de locatie van het configuratiebestand.
     *
     * @description Als het configuratie bestand niet bestaat in het opgegeven pad, zal dit zichzelf genereren met default waarden.
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
        return new Playerj2d(this.graphicsContext);
    }

    @Override
    public APlayerEntity getPlayerEntity(IPosition position, int life, int speed,double velocity) {

        //Schaal a.d.h.v. de game dimentions
        position.setX(position.getX() * this.graphicsContext.getSize());

        if(position.getY() > 0)
            position.setY(position.getY() * this.graphicsContext.getSize()+ 2);
        else
            position.setY(position.getY() * this.graphicsContext.getSize());

        MovementComponent movementComponent = new MovementComponent(position, this.graphicsContext.getGameDimension(),speed,velocity);
        LivableComponent livableComponent = new LivableComponent(life);

        return new Playerj2d(movementComponent, livableComponent,graphicsContext);
    }

    @Override
    public AEnemyEntity getEnemyEntity() {
        return new EnemyJ2d(this.graphicsContext);
    }

    @Override
    public AEnemyEntity getEnemyEntity(IPosition position, int life, int speed,double velocity) {
        //Schaal a.d.h.v. de game dimentions
        position.setX(position.getX() * this.graphicsContext.getSize());

        if(position.getY() > 0)
            position.setY(position.getY() * this.graphicsContext.getSize() + 2);
        else
            position.setY(position.getY() * this.graphicsContext.getSize());

        MovementComponent movementComponent = new MovementComponent(position, this.graphicsContext.getGameDimension(),speed,velocity);
        LivableComponent livableComponent = new LivableComponent(life);

        return new EnemyJ2d(movementComponent, livableComponent, graphicsContext);
    }

    @Override
    public ABulletEntity getBulletEntity() {
        return new BulletJ2d(graphicsContext);
    }

    @Override
    public ABulletEntity getBulletEntity(IPosition position, int life, int speed,double velocity) {


        MovementComponent movementComponent = new MovementComponent(position, this.graphicsContext.getBulletDimention(),speed,velocity);
        LivableComponent livableComponent = new LivableComponent(life);

        return new BulletJ2d(movementComponent, livableComponent, graphicsContext);
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
    public void render() {
        graphicsContext.render();
    }

    @Override
    public IInput getInput() {
        return this.keyboardInput;
    }

    @Override
    public int getScaler() {
        return this.graphicsContext.getSize();
    }
}
