package be.uantwerpen.fti.ei.spaceinvaders.game.entity.position;

public interface IPosition {
    /**
     * Geeft de huidige x-waarden terug.
     *
     * @return De huidige x-waarde als integer.
     */
    double getX();

    /**
     * Geeft de huidige y-waarden terug.
     *
     * @return De huidige y-waarde als integer.
     */
    double getY();

    /**
     * Zet de huidige x-waarde met een gegeven waarde.
     *
     * @param x die de nieuwe waarden voorstelt.
     */
    void setX(double x);

    /**
     * Zet de huidige y-waarde met een gegeven waarde.
     *
     * @param y die de nieuwe waarden voorstelt.
     */
    void setY(double y);

    /**
     * Geeft een IPosition object terug waarin x-waarden en y-waarden staan.
     *
     * @return Een object met interface IPosition.
     */
    IPosition getPosition();
}
