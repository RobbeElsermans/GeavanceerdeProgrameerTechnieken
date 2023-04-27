package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.*;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.*;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.types.CollectableType;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.game.helper.Random;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.Position;
import be.uantwerpen.fti.ei.spaceinvaders.game.sound.ASoundSystem;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity.*;

import java.util.ArrayList;
import java.util.List;

public class FactoryJ2d extends AFactory {

    private GraphicsContext graphicsContext;
    private IInput keyboardInput;
    private final String configFilePath;

    /**
     * Initializeer Java2D met gegeven configuratie bestand.
     *
     * @param configFilePath Deze bevat de locatie van het configuratiebestand.
     * @description Als het configuratie bestand niet bestaat in het opgegeven pad, zal dit zichzelf genereren met default waarden.
     */
    public FactoryJ2d(String configFilePath) {
        this.configFilePath = configFilePath;
    }

    @Override
    public void setupGameDimension(IDimension dimension) {
        super.setupGameDimension(dimension);
        this.graphicsContext = new GraphicsContext(this.gameDimension, this.configFilePath);
        this.keyboardInput = new KeyboardInputController(this.graphicsContext);
    }

    @Override
    public APlayerEntity getPlayerEntity() {
        return new Playerj2d(this.graphicsContext);
    }

    @Override
    public APlayerEntity getPlayerEntity(IPosition position, int life, double speed, double velocity) {

        //Schaal a.d.h.v. de game dimentions
        position.setX(position.getX() * this.graphicsContext.getTileWidth());
        position.setY(position.getY() * this.graphicsContext.getTileHeight());

        MovementComponent movementComponent = new MovementComponent(position, this.graphicsContext.getPlayerDimension(), speed, velocity);
        LivableComponent livableComponent = new LivableComponent(life);

        return new Playerj2d(movementComponent, livableComponent, graphicsContext);
    }

    @Override
    public AEnemyEntity getEnemyEntity() {
        return new EnemyJ2d(this.graphicsContext);
    }

    @Override
    public AEnemyEntity getEnemyEntity(IPosition position, int life, double speed, double velocity) {
        //Schaal a.d.h.v. de game dimentions
        position.setX(position.getX() * this.graphicsContext.getTileWidth());
        position.setY(position.getY() * this.graphicsContext.getTileHeight());

        MovementComponent movementComponent = new MovementComponent(position, this.graphicsContext.getEnemyDimension(), speed, velocity);
        LivableComponent livableComponent = new LivableComponent(life);

        return new EnemyJ2d(movementComponent, livableComponent, graphicsContext);
    }

    @Override
    public ABulletEntity getBulletEntity() {
        return new BulletJ2d(graphicsContext);
    }

    @Override
    public ABulletEntity getBulletEntity(IPosition position, int life, double speed, double velocity) {

        MovementComponent movementComponent = new MovementComponent(position, this.graphicsContext.getBulletDimension(), speed, velocity);
        LivableComponent livableComponent = new LivableComponent(life);

        return new BulletJ2d(movementComponent, livableComponent, graphicsContext);
    }

    @Override
    public AObstacleEntity getObstacleEntity() {
        return new ObstacleJ2d(graphicsContext);
    }

    @Override
    public AObstacleEntity getObstacleEntity(IPosition position, int life) {
        //Schaal a.d.h.v. de game dimentions
        position.setX(position.getX() * this.graphicsContext.getTileWidth());
        position.setY(position.getY() * this.graphicsContext.getTileHeight());

        DimensionComponent dimensionComponent = new DimensionComponent(position, this.graphicsContext.getObstacleDimension());
        LivableComponent livableComponent = new LivableComponent(life);

        return new ObstacleJ2d(dimensionComponent, livableComponent, graphicsContext);
    }

    @Override
    public ABonusEntity getBonusEntity() {
        return new BonusJ2d(graphicsContext);
    }

    @Override
    public ABonusEntity getBonusEntity(IPosition position, double speed, double velocity, CollectableType type, double value) {
        //Schaal a.d.h.v. de game dimentions
        position.setX(position.getX() * this.graphicsContext.getTileWidth());
        position.setY(position.getY() * this.graphicsContext.getTileHeight());

        MovementComponent movementComponent = new MovementComponent(position, this.graphicsContext.getBonusDimension(), speed, velocity);
        CollectableComponent collectableComponent = new CollectableComponent(type, value);

        return new BonusJ2d(movementComponent, collectableComponent, graphicsContext);
    }

    @Override
    public ABonusEntity getRandomBonusEntity(IPosition position, double speed, double velocity, int randValueRange) {
        //Schaal a.d.h.v. de game dimentions
        position.setX(position.getX() * this.graphicsContext.getTileWidth());
        position.setY(position.getY() * this.graphicsContext.getTileHeight());

        MovementComponent movementComponent = new MovementComponent(position, this.graphicsContext.getBonusDimension(), speed, velocity);
        CollectableComponent collectableComponent = new CollectableComponent();

        //Selecteer typen at random a.d.h.v. de totale lengte van de enum
        int temp = Random.getRandom(CollectableType.values().length - 1);
        if (temp == 0) {
            collectableComponent = new CollectableComponent(CollectableType.LIFE, (Random.getRandom(randValueRange)));
        } else if (temp == 1) {
            collectableComponent = new CollectableComponent(CollectableType.BULLET_SPEED, (Random.getRandom(randValueRange)));
        }
        return new BonusJ2d(movementComponent, collectableComponent, graphicsContext);
    }

    @Override
    public ABigEnemyEntity getBigEnemyEntity() {
        return new BigEnemyJ2D(graphicsContext);
    }


    @Override
    public ABigEnemyEntity getBigEnemyEntity(IPosition position, int life, double speed, double velocity) {
        //Schaal a.d.h.v. de game dimentions
        position.setX(position.getX() * this.graphicsContext.getTileWidth());
        position.setY(position.getY() * this.graphicsContext.getTileHeight());

        MovementComponent movementComponent = new MovementComponent(position, this.graphicsContext.getBigEnemyDimension(), speed, velocity);
        LivableComponent livableComponent = new LivableComponent(life);

        return new BigEnemyJ2D(movementComponent, livableComponent, graphicsContext);
    }

    @Override
    public ATextEntity getTextEntity() {
        return new TextJ2d(graphicsContext);
    }

    @Override
    public ATextEntity getTextEntity(IPosition pos, String preText) {
        //Schaal a.d.h.v. de game dimentions
        pos.setX(pos.getX() * this.graphicsContext.getTileWidth());
        pos.setY(pos.getY() * this.graphicsContext.getTileHeight());

        PositionComponent positionComponent = new PositionComponent(pos);

        return new TextJ2d(positionComponent, preText, graphicsContext);
    }

    @Override
    public ATextEntity getTextEntity(IPosition pos, String preText, String text) {
        //Schaal a.d.h.v. de game dimentions
        pos.setX(pos.getX() * this.graphicsContext.getTileWidth());
        pos.setY(pos.getY() * this.graphicsContext.getTileHeight());

        PositionComponent positionComponent = new PositionComponent(pos);
        return new TextJ2d(positionComponent, preText, text, graphicsContext);
    }

    @Override
    public void render() {
        graphicsContext.render();
    }

    @Override
    public AScreenEntity getStartScreen(IPosition pos, String titleText, String enterText, String excText) {
        //Maak de positie relatief in het scherm vlak.
        PositionComponent positionHeading = new PositionComponent(new Position((pos.getX() + 2) * this.graphicsContext.getTileWidth(), (pos.getY()) * this.graphicsContext.getTileHeight()));
        PositionComponent positionEnterText = new PositionComponent(new Position((pos.getX() + 3) * this.graphicsContext.getTileWidth(), (pos.getY() + 1) * this.graphicsContext.getTileHeight()));
        PositionComponent positionEscText = new PositionComponent(new Position((pos.getX() + 3) * this.graphicsContext.getTileWidth(), (pos.getY() + 2) * this.graphicsContext.getTileHeight()));

        PositionComponent positionScreen = new PositionComponent(new Position(pos.getX() * this.graphicsContext.getTileWidth(), pos.getY() * this.graphicsContext.getTileHeight()));

        List<ATextEntity> textEntities = new ArrayList<>();
        textEntities.add(new TextJ2d(positionHeading, titleText, graphicsContext));
        textEntities.add(new TextJ2d(positionEnterText, enterText, graphicsContext));
        textEntities.add(new TextJ2d(positionEscText, excText, graphicsContext));

        return new StartScreenJ2d(positionScreen, textEntities);
    }

    @Override
    public AScreenEntity getPauseScreen(IPosition pos, String titleText, String enterText, String excText) {
        //Maak de positie relatief in het scherm vlak.
        PositionComponent positionHeading = new PositionComponent(new Position((pos.getX() + 2) * this.graphicsContext.getTileWidth(), (pos.getY()) * this.graphicsContext.getTileHeight()));
        PositionComponent positionEnterText = new PositionComponent(new Position((pos.getX() + 3) * this.graphicsContext.getTileWidth(), (pos.getY() + 1) * this.graphicsContext.getTileHeight()));
        PositionComponent positionEscText = new PositionComponent(new Position((pos.getX() + 3) * this.graphicsContext.getTileWidth(), (pos.getY() + 2) * this.graphicsContext.getTileHeight()));

        PositionComponent positionScreen = new PositionComponent(new Position(pos.getX() * this.graphicsContext.getTileWidth(), pos.getY() * this.graphicsContext.getTileHeight()));

        List<ATextEntity> textEntities = new ArrayList<>();
        textEntities.add(new TextJ2d(positionHeading, titleText, graphicsContext));
        textEntities.add(new TextJ2d(positionEnterText, enterText, graphicsContext));
        textEntities.add(new TextJ2d(positionEscText, excText, graphicsContext));

        return new PauseScreenJ2d(positionScreen, textEntities, graphicsContext);
    }

    @Override
    public AScreenEntity getEndScreen(IPosition pos, String titleText, String enterText, String excText, String preScore, String preHighScore) {
        //Maak de positie relatief in het scherm vlak.
        PositionComponent positionHeading = new PositionComponent(new Position((pos.getX() + 2) * this.graphicsContext.getTileWidth(), (pos.getY()) * this.graphicsContext.getTileHeight()));
        PositionComponent positionPreScoreText = new PositionComponent(new Position((pos.getX() + 3) * this.graphicsContext.getTileWidth(), (pos.getY() + 1) * this.graphicsContext.getTileHeight()));
        PositionComponent positionPreHighScoreText = new PositionComponent(new Position((pos.getX() + 3) * this.graphicsContext.getTileWidth(), (pos.getY() + 2) * this.graphicsContext.getTileHeight()));
        PositionComponent positionEnterText = new PositionComponent(new Position((pos.getX() + 3) * this.graphicsContext.getTileWidth(), (pos.getY() + 4) * this.graphicsContext.getTileHeight()));
        PositionComponent positionEscText = new PositionComponent(new Position((pos.getX() + 3) * this.graphicsContext.getTileWidth(), (pos.getY() + 5) * this.graphicsContext.getTileHeight()));

        PositionComponent positionScreen = new PositionComponent(new Position(pos.getX() * this.graphicsContext.getTileWidth(), pos.getY() * this.graphicsContext.getTileHeight()));

        List<ATextEntity> textEntities = new ArrayList<>();
        textEntities.add(new TextJ2d(positionHeading, titleText, graphicsContext));
        textEntities.add(new TextJ2d(positionPreScoreText, preScore, graphicsContext));
        textEntities.add(new TextJ2d(positionPreHighScoreText, preHighScore, graphicsContext));
        textEntities.add(new TextJ2d(positionEnterText, enterText, graphicsContext));
        textEntities.add(new TextJ2d(positionEscText, excText, graphicsContext));

        return new EndScreenJ2d(positionScreen, textEntities);
    }

    @Override
    public IInput getInput() {
        return this.keyboardInput;
    }

    @Override
    public ASoundSystem getSoundSystem() {
        return new SoundContext("");
    }

    @Override
    public IDimension getScale() {
        return new Dimension(graphicsContext.getTileWidth(), graphicsContext.getTileHeight());
    }
}
