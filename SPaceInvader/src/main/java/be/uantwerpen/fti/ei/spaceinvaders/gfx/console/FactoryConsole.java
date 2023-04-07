package be.uantwerpen.fti.ei.spaceinvaders.gfx.console;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.*;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.CollectableType;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

public class FactoryConsole extends AFactory {

    private final GraphicsContext graphicsContext;

    public FactoryConsole() {
        this.graphicsContext = new GraphicsContext();
    }

    @Override
    public APlayerEntity getPlayerEntity() {
        return null;
    }

    @Override
    public APlayerEntity getPlayerEntity(IPosition position, int life, double speed, double velocity) {
        return null;
    }

    @Override
    public AEnemyEntity getEnemyEntity() {
        return null;
    }

    @Override
    public AEnemyEntity getEnemyEntity(IPosition position, int life, double speed, double velocity) {
        return null;
    }

    @Override
    public ABulletEntity getBulletEntity() {
        return null;
    }

    @Override
    public ABulletEntity getBulletEntity(IPosition position, int life, double speed, double velocity) {
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
    public ABigEnemyEntity getBigEnemyEntity() {
        return null;
    }

    @Override
    public ABigEnemyEntity getBigEnemyEntity(IPosition position, int life, double speed, double velocity) {
        return null;
    }

    @Override
    public ABonusEntity getBonusEntity() {
        return null;
    }

    @Override
    public ABonusEntity getBonusEntity(IPosition position, double speed, double velocity, CollectableType type, double value) {
        return null;
    }

    @Override
    public ABonusEntity getRandomBonusEntity(IPosition position, double speed, double velocity, int randValueRange) {
        return null;
    }

    @Override
    public ATextEntity getTextEntity() {
        return null;
    }

    @Override
    public ATextEntity getTextEntity(IPosition pos, String preText) {
        return null;
    }

    @Override
    public ATextEntity getTextEntity(IPosition pos, String preText, String text) {
        return null;
    }

    @Override
    public AScreenEntity getStartScreen(IPosition pos, String TitleText, String enterText, String excText) {
        return null;
    }

    @Override
    public AScreenEntity getPauseScreen(IPosition pos, String TitleText, String enterText, String excText) {
        return null;
    }

    @Override
    public AScreenEntity getEndScreen(IPosition pos, String TitleText, String enterText, String excText, String preScore, String preHighScore) {
        return null;
    }

    @Override
    public void render() {
        this.graphicsContext.render();
    }

    @Override
    public IInput getInput() {
        return null;
    }

    @Override
    public IDimension getScale() {
        return new Dimension(1,1);
    }
}
