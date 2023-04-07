package be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller;

/**
 * Interface die een player input bevat.
 */
public interface IInput {
    /**
     * Als er één van de knoppen is ingedrukt, zal deze methode true geven. Anders false.
     * @return  boolean
     */
    boolean inputAvailable();
    /**
     * Is de knop up ingedrukt geef dan true terug.
     * @return boolean
     */
    boolean isUp();
    /**
     * Is de knop down ingedrukt geef dan true terug.
     * @return boolean
     */
    boolean isDown();
    /**
     * Is de knop left ingedrukt geef dan true terug.
     * @return boolean
     */
    boolean isLeft();
    /**
     * Is de knop right ingedrukt geef dan true terug.
     * @return boolean
     */
    boolean isRight();
    /**
     * Is de knop shoot ingedrukt geef dan true terug.
     * @return boolean
     */
    boolean isShoot();
    /**
     * Is de knop volume up ingedrukt geef dan true terug.
     * @return boolean
     */
    boolean isVolUp();
    /**
     * Is de knop volume down ingedrukt geef dan true terug.
     * @return boolean
     */
    boolean isVolDown();
    /**
     * Is de knop escape ingedrukt geef dan true terug.
     * @return boolean
     */
    boolean isEsc();

    /**
     * Is de knop Enter ingedrukt geef dan true terug.
     * @return boolean
     */
    boolean isEnter();

    /**
     * Is de knop Quit ingedrukt geef dan true terug.
     * @return boolean
     */
    boolean isQuit();

}
