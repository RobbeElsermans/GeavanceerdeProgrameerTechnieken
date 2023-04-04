package be.uantwerpen.fti.ei.spaceinvaders.game.factory;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.*;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

/**
 * Een GFX abstract factory zodat de Game kan werken met eender welke GFX-library. De GFX-library moet overerven en methodes implementeren van de abstract factory.
 */
public abstract class AFactory {

    //TODO: Zorg ervoor dat de IInput meegegeven wordt bij de factory zodat de GFX-factory niet verantwoordelijk is voor de input die gegeven moet worden. Doe dit voor elke get...Entity die een IInput nodig hebben

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
     * @param dimension
     */
    public void setupGameDimentions(IDimension dimension) {
        this.gameDimension = dimension;
    }
    //Entity abstractions

    /**
     * Geeft een APlayerEntity object terug met default waarden.
     * @return APlayerEntity object
     */
    public abstract APlayerEntity getPlayerEntity();

    /**
     * Geeft een APlayerEntity object terug met volgende parameters.
     * @param position  Een positie van de entiteit als IPosition.
     * @param life      Het leven van de entiteit als integer.
     * @param speed     De snelheid waarmee de entiteit zich verplaatst als integer.
     * @param velocity  De versnelling waarmee de entiteit zich verplaatst als integer.
     * @return          AEnemyEntity object
     *
     * @implNote De dimensies van een entiteit worden gedefinieerd in het configuratiebestand van de GFX-library.
     */
    public abstract APlayerEntity getPlayerEntity(IPosition position, int life, int speed, double velocity);

    /**
     * Geeft een AEnemyEntity object terug met default waarden.
     * @return AEnemyEntity object
     */
    public abstract AEnemyEntity getEnemyEntity();

    /**
     * Geeft een AEnemyEntity object terug met volgende parameters.
     * @param position  Een positie van de entiteit als IPosition.
     * @param life      Het leven van de entiteit als integer.
     * @param speed     De snelheid waarmee de entiteit zich verplaatst als integer.
     * @param velocity  De versnelling waarmee de entiteit zich verplaatst als integer.
     * @return          AEnemyEntity object
     *
     * @implNote De dimensies van een entiteit worden gedefinieerd in het configuratiebestand van de GFX-library.
     */
    public abstract AEnemyEntity getEnemyEntity(IPosition position, int life, int speed, double velocity);

    /**
     * Geeft een ABulletEntity object terug met default waarden.
     * @return ABulletEntity object
     */
    public abstract ABulletEntity getBulletEntity();

    /**
     * Geeft een ABulletEntity object terug met volgende parameters.
     * @param position  Een positie van de entiteit als IPosition.
     * @param life      Het leven van de entiteit als integer.
     * @param speed     De snelheid waarmee de entiteit zich verplaatst als integer.
     * @param velocity  De versnelling waarmee de entiteit zich verplaatst als integer.
     * @return          ABulletEntity object
     *
     * @implNote De dimensies van een entiteit worden gedefinieerd in het configuratiebestand van de GFX-library.
     */
    public abstract ABulletEntity getBulletEntity(IPosition position, int life, int speed, double velocity);
    /**
     * Geeft een AObstacleEntity object terug met default waarden.
     * @return AObstacleEntity object
     */
    public abstract AObstacleEntity getObstacleEntity();
    /**
     * Geeft een AObstacleEntity object terug met volgende parameters.
     * @param position  Een positie van de entiteit als IPosition.
     * @param life      Het leven van de entiteit als integer.
     * @return          AObstacleEntity object
     * @implNote  De dimensies van een entiteit worden gedefinieerd in het configuratiebestand van de GFX-library.
     */
    public abstract AObstacleEntity getObstacleEntity(IPosition position, int life);

    public abstract ATextEntity getTextEntity();
    public abstract ATextEntity getTextEntity(IPosition pos, String preText);
    public abstract ATextEntity getTextEntity(IPosition pos, String preText, String text);


    /**
     * De gekozen GFX renderen.
     */
    public abstract void render();


    //TODO: Als bovenstaande todo uitgevoerd is, moet dit weg.
    /**
     * De player input controller terug geven
     * @return
     */
    //Inputs
    public abstract IInput getInput();

    public IDimension getGameDimension() {
        return gameDimension;
    }
    public abstract int getScaler();

}
