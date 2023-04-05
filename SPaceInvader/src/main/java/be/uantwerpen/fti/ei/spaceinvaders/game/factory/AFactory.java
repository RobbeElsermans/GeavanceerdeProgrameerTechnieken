package be.uantwerpen.fti.ei.spaceinvaders.game.factory;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.*;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.CollectableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

/**
 * Een GFX abstract factory zodat de Game kan werken met eender welke GFX-library.
 * De GFX-library moet overerven en methodes implementeren van de abstract factory.
 */
public abstract class AFactory {

    /**
     * Variabelen die de speldimensies bijhoud.
     */
    private IDimension gameDimension;

    /**
     * Default constructor die niets doet dan enkel het object aanmaken.
     */
    public AFactory() {
    }

    /**
     * De game dimensies doorspelen naar de abstract factory.
     *
     * @param dimension
     */
    public void setupGameDimentions(IDimension dimension) {
        this.gameDimension = dimension;
    }
    //Entity abstractions

    /**
     * Geeft een APlayerEntity object terug met default waarden.
     *
     * @return APlayerEntity object
     */
    public abstract APlayerEntity getPlayerEntity();

    /**
     * Geeft een APlayerEntity object terug met volgende parameters.
     *
     * @param position Een positie van de entiteit als IPosition.
     * @param life     Het leven van de entiteit als integer.
     * @param speed    De snelheid waarmee de entiteit zich verplaatst als integer.
     * @param velocity De versnelling waarmee de entiteit zich verplaatst als integer.
     * @return APlayerEntity object
     * @implNote De dimensies van een entiteit worden gedefinieerd in het configuratiebestand van de GFX-library.
     */
    public abstract APlayerEntity getPlayerEntity(IPosition position, int life, int speed, double velocity);

    /**
     * Geeft een AEnemyEntity object terug met default waarden.
     *
     * @return AEnemyEntity object
     */
    public abstract AEnemyEntity getEnemyEntity();

    /**
     * Geeft een AEnemyEntity object terug met volgende parameters.
     *
     * @param position Een positie van de entiteit als IPosition.
     * @param life     Het leven van de entiteit als integer.
     * @param speed    De snelheid waarmee de entiteit zich verplaatst als integer.
     * @param velocity De versnelling waarmee de entiteit zich verplaatst als integer.
     * @return AEnemyEntity object
     * @implNote De dimensies van een entiteit worden gedefinieerd in het configuratiebestand van de GFX-library. Dit wordt geschaald.
     */
    public abstract AEnemyEntity getEnemyEntity(IPosition position, int life, int speed, double velocity);

    /**
     * Geeft een ABulletEntity object terug met default waarden.
     *
     * @return ABulletEntity object
     */
    public abstract ABulletEntity getBulletEntity();

    /**
     * Geeft een ABulletEntity object terug met volgende parameters.
     *
     * @param position Een positie van de entiteit als IPosition.
     * @param life     Het leven van de entiteit als integer.
     * @param speed    De snelheid waarmee de entiteit zich verplaatst als integer.
     * @param velocity De versnelling waarmee de entiteit zich verplaatst als integer.
     * @return ABulletEntity object
     * @implNote De dimensies van een entiteit worden gedefinieerd in het configuratiebestand van de GFX-library. Dit wordt geschaald.
     */
    public abstract ABulletEntity getBulletEntity(IPosition position, int life, int speed, double velocity);

    /**
     * Geeft een AObstacleEntity object terug met default waarden.
     *
     * @return AObstacleEntity object
     */
    public abstract AObstacleEntity getObstacleEntity();

    /**
     * Geeft een AObstacleEntity object terug met volgende parameters.
     *
     * @param position Een positie van de entiteit als IPosition.
     * @param life     Het leven van de entiteit als integer.
     * @return AObstacleEntity object
     * @implNote De dimensies van een entiteit worden gedefinieerd in het configuratiebestand van de GFX-library. Dit wordt geschaald.
     */
    public abstract AObstacleEntity getObstacleEntity(IPosition position, int life);

    /**
     * Geeft een ABonusEntity object terug met default waarden.
     *
     * @return ABonusEntity object
     */
    public abstract ABonusEntity getBonusEntity();

    /**
     * Geeft een ABonusEntity object terug met volgende parameters.
     *
     * @param position Een positie van de entiteit als IPosition.
     * @param life     Het leven van de entiteit als integer.
     * @param speed    De snelheid waarmee de entiteit zich verplaatst als integer.
     * @param velocity De versnelling waarmee de entiteit zich verplaatst als integer.
     * @param type     het type collectable.
     * @param value    De waarde van de collectable.
     * @return ABonusEntity object.
     * @implNote De dimensies van een entiteit worden gedefinieerd in het configuratiebestand van de GFX-library. Dit wordt geschaald.
     */
    public abstract ABonusEntity getBonusEntity(IPosition position, int life, int speed, double velocity, CollectableComponent.collectableType type, int value);

    /**
     * Geeft een ATextEntity object terug met default waarden.
     *
     * @return ATextEntity object
     */
    public abstract ATextEntity getTextEntity();

    /**
     * Geeft een ATextEntity object terug met volgende parameters.
     *
     * @param pos     Een positie van de entiteit als IPosition.
     * @param preText Een preText dat voor de informatie text komt.
     * @return ATextEntity object.
     */
    public abstract ATextEntity getTextEntity(IPosition pos, String preText);

    /**
     * Geeft een ATextEntity object terug met volgende parameters.
     *
     * @param pos     Een positie van de entiteit als IPosition.
     * @param preText Een preText dat voor de informatie text komt.
     * @param text    De effectieve informatie.
     * @return ATextEntity object.
     */
    public abstract ATextEntity getTextEntity(IPosition pos, String preText, String text);

    /**
     * De gekozen GFX renderen.
     */
    public abstract void render();

    /**
     * De player input controller terug geven
     *
     * @return IInput
     */
    public abstract IInput getInput();

    /**
     * De game dimensie van de gekozen gfx.
     *
     * @return IDimension
     */
    public IDimension getGameDimension() {
        return gameDimension;
    }

    /**
     * De scale van de gfx om alles op het scherm te laten passen.
     *
     * @return IDimension met schaal langs width en height.
     */
    public abstract IDimension getScale();

}
