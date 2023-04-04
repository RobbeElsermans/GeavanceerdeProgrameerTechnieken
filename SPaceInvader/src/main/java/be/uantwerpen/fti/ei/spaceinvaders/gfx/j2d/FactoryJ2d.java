package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.*;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.StaticComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity.BulletJ2d;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity.EnemyJ2d;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity.Playerj2d;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity.TextJ2d;

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
        //TODO refactor game dimensie zodat het schaalt a.d.h.v. de gfx_config en game_config
        if(position.getY() > 0)
            position.setY(position.getY() * this.graphicsContext.getSize()+ 2);
        else
            position.setY(position.getY() * this.graphicsContext.getSize());

        MovementComponent movementComponent = new MovementComponent(position, this.graphicsContext.getPlayerDimention(),speed,velocity);
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

        MovementComponent movementComponent = new MovementComponent(position, this.graphicsContext.getEnemyDimention(),speed,velocity);
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
    public ATextEntity getTextEntity() {
        return new TextJ2d(graphicsContext);
    }

    @Override
    public ATextEntity getTextEntity(IPosition pos, String preText) {
        //Schaal a.d.h.v. de game dimentions
        pos.setX(pos.getX() * this.graphicsContext.getSize());

        if(pos.getY() > 0)
            pos.setY(pos.getY() * this.graphicsContext.getSize() + 2);
        else
            pos.setY(pos.getY() * this.graphicsContext.getSize());

        StaticComponent staticComponent = new StaticComponent(pos, this.graphicsContext.getTextDimention());

        return new TextJ2d(staticComponent, preText,graphicsContext);
    }

    @Override
    public ATextEntity getTextEntity(IPosition pos, String preText, String text) {
        //Schaal a.d.h.v. de game dimentions
        pos.setX(pos.getX() * this.graphicsContext.getSize());

        if(pos.getY() > 0)
            pos.setY(pos.getY() * this.graphicsContext.getSize() + 2);
        else
            pos.setY(pos.getY() * this.graphicsContext.getSize());

        StaticComponent staticComponent = new StaticComponent(pos, this.graphicsContext.getTextDimention());
        return new TextJ2d(staticComponent, preText,text,graphicsContext);
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
