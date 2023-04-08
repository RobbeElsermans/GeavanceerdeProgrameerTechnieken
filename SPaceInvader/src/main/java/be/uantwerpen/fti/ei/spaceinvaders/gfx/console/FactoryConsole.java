package be.uantwerpen.fti.ei.spaceinvaders.gfx.console;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.*;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.*;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.types.CollectableType;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.Position;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.console.entity.*;

import java.util.ArrayList;
import java.util.List;

public class FactoryConsole extends AFactory {

    private final IInput keyboardInput;
    private GraphicsContext graphicsContext;

    public FactoryConsole() {
        this.keyboardInput = new KeyboardInputController();
    }

    @Override
    public void setupGameDimension(IDimension dimension) {
        super.setupGameDimension(dimension);
        this.graphicsContext = new GraphicsContext(dimension);
    }

    @Override
    public APlayerEntity getPlayerEntity() {
        return new PlayerC(graphicsContext);
    }

    @Override
    public APlayerEntity getPlayerEntity(IPosition position, int life, double speed, double velocity) {
        MovementComponent movementComponent = new MovementComponent(position, new Dimension(), speed, velocity);
        LivableComponent livableComponent = new LivableComponent(life);

        return new PlayerC(movementComponent, livableComponent, graphicsContext);
    }

    @Override
    public AEnemyEntity getEnemyEntity() {
        return new EnemyC(graphicsContext);
    }

    @Override
    public AEnemyEntity getEnemyEntity(IPosition position, int life, double speed, double velocity) {
        MovementComponent movementComponent = new MovementComponent(position, new Dimension(), speed, velocity);
        LivableComponent livableComponent = new LivableComponent(life);

        return new EnemyC(movementComponent, livableComponent, graphicsContext);
    }

    @Override
    public ABulletEntity getBulletEntity() {
        return new BulletC(graphicsContext);
    }

    @Override
    public ABulletEntity getBulletEntity(IPosition position, int life, double speed, double velocity) {
        MovementComponent movementComponent = new MovementComponent(position, new Dimension(), speed, velocity);
        LivableComponent livableComponent = new LivableComponent(life);

        return new BulletC(movementComponent, livableComponent, graphicsContext);
    }

    @Override
    public AObstacleEntity getObstacleEntity() {
        return new ObstacleC(graphicsContext);
    }

    @Override
    public AObstacleEntity getObstacleEntity(IPosition position, int life) {
        DimensionComponent dimensionComponent = new DimensionComponent(position, new Dimension(2,1));
        LivableComponent livableComponent = new LivableComponent(life);

        return new ObstacleC(dimensionComponent, livableComponent, graphicsContext);
    }

    @Override
    public ABigEnemyEntity getBigEnemyEntity() {
        return new BigEnemyC(graphicsContext);
    }

    @Override
    public ABigEnemyEntity getBigEnemyEntity(IPosition position, int life, double speed, double velocity) {
        MovementComponent movementComponent = new MovementComponent(position, new Dimension(), speed, velocity);
        LivableComponent livableComponent = new LivableComponent(life);

        return new BigEnemyC(movementComponent, livableComponent, graphicsContext);
    }

    @Override
    public ABonusEntity getBonusEntity() {
        return new BonusC(graphicsContext);
    }

    @Override
    public ABonusEntity getBonusEntity(IPosition position, double speed, double velocity, CollectableType type, double value) {
        MovementComponent movementComponent = new MovementComponent(position, new Dimension(), speed, velocity);
        CollectableComponent collectableComponent = new CollectableComponent(type, value);

        return new BonusC(movementComponent, collectableComponent, graphicsContext);
    }

    @Override
    public ABonusEntity getRandomBonusEntity(IPosition position, double speed, double velocity, int randValueRange) {
        return null;
    }

    @Override
    public ATextEntity getTextEntity() {
        return new TextC(graphicsContext);
    }

    @Override
    public ATextEntity getTextEntity(IPosition pos, String preText) {
        PositionComponent positionComponent = new PositionComponent(pos);

        return new TextC(positionComponent, preText, graphicsContext);
    }

    @Override
    public ATextEntity getTextEntity(IPosition pos, String preText, String text) {
        PositionComponent positionComponent = new PositionComponent(pos);

        return new TextC(positionComponent, preText, text, graphicsContext);
    }

    @Override
    public AScreenEntity getStartScreen(IPosition pos, String titleText, String enterText, String excText) {
        //Maak de positie relatief in het scherm vlak.
        PositionComponent positionHeading = new PositionComponent(new Position(pos.getX() + 2, pos.getY()));
        PositionComponent positionEnterText = new PositionComponent(new Position(pos.getX() + 3, pos.getY() + 1));
        PositionComponent positionEscText = new PositionComponent(new Position(pos.getX() + 3, pos.getY() + 2));

        PositionComponent positionScreen = new PositionComponent(new Position(pos.getX(), pos.getY()));

        List<ATextEntity> textEntities = new ArrayList<>();
        textEntities.add(new TextC(positionHeading, titleText, graphicsContext));
        textEntities.add(new TextC(positionEnterText, enterText, graphicsContext));
        textEntities.add(new TextC(positionEscText, excText, graphicsContext));

        return new StartScreenC(positionScreen, textEntities);
    }

    @Override
    public AScreenEntity getPauseScreen(IPosition pos, String titleText, String enterText, String excText) {
        //Maak de positie relatief in het scherm vlak.
        PositionComponent positionHeading = new PositionComponent(new Position(pos.getX() + 2, pos.getY()));
        PositionComponent positionEnterText = new PositionComponent(new Position(pos.getX() + 3, pos.getY() + 1));
        PositionComponent positionEscText = new PositionComponent(new Position(pos.getX() + 3, pos.getY() + 2));

        PositionComponent positionScreen = new PositionComponent(new Position(pos.getX(), pos.getY()));

        List<ATextEntity> textEntities = new ArrayList<>();
        textEntities.add(new TextC(positionHeading, titleText, graphicsContext));
        textEntities.add(new TextC(positionEnterText, enterText, graphicsContext));
        textEntities.add(new TextC(positionEscText, excText, graphicsContext));

        return new PauseScreenC(positionScreen, textEntities);
    }

    @Override
    public AScreenEntity getEndScreen(IPosition pos, String titleText, String enterText, String excText, String preScore, String preHighScore) {
        //Maak de positie relatief in het scherm vlak.
        PositionComponent positionHeading = new PositionComponent(new Position(pos.getX() + 2, pos.getY()));
        PositionComponent positionEnterText = new PositionComponent(new Position(pos.getX() + 3, pos.getY() + 1));
        PositionComponent positionEscText = new PositionComponent(new Position(pos.getX() + 3, pos.getY() + 2));

        PositionComponent positionScreen = new PositionComponent(new Position(pos.getX(), pos.getY()));

        List<ATextEntity> textEntities = new ArrayList<>();
        textEntities.add(new TextC(positionHeading, titleText, graphicsContext));
        textEntities.add(new TextC(positionEnterText, enterText, graphicsContext));
        textEntities.add(new TextC(positionEscText, excText, graphicsContext));

        return new EndScreenC(positionScreen, textEntities);
    }

    @Override
    public void render() {
        this.graphicsContext.render();
    }

    @Override
    public IInput getInput() {
        return this.keyboardInput;
    }

    @Override
    public IDimension getScale() {
        return new Dimension(1, 1);
    }
}
