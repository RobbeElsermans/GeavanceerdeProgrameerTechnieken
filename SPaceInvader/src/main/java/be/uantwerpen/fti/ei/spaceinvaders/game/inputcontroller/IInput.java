package be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller;

/**
 * Interface die een player input bevat.
 */
public interface IInput {

    //TODO: IInput meer onderverdelen in bv. IProjectileInput, ICharacterInput

    /**
     * Als er één van de knoppen is ingedrukt, zal deze methode true geven. Anders false.
     * @return  boolean
     */
    boolean inputAvailable();
    /**
     * is de knop up ingedrukt geef dan true terug.
     * @return boolean
     */
    boolean isUp();
    /**
     * is de knop down ingedrukt geef dan true terug.
     * @return boolean
     */
    boolean isDown();
    /**
     * is de knop left ingedrukt geef dan true terug.
     * @return boolean
     */
    boolean isLeft();
    /**
     * is de knop right ingedrukt geef dan true terug.
     * @return boolean
     */
    boolean isRight();
    /**
     * is de knop shoot ingedrukt geef dan true terug.
     * @return boolean
     */
    boolean isShoot();
    /**
     * is de knop volume up ingedrukt geef dan true terug.
     * @return boolean
     */
    boolean isVolUp();
    /**
     * is de knop volume down ingedrukt geef dan true terug.
     * @return boolean
     */
    boolean isVolDown();
    /**
     * is de knop escape ingedrukt geef dan true terug.
     * @return boolean
     */
    boolean isEsc();

}
