package be.uantwerpen.fti.ei.spaceinvaders.game.position;

public interface IDimension {
    /**
     * Geeft de breedte (width) terug van het object.
     *
     * @return de breedte als integer.
     */
    double getWidth();

    /**
     * Geeft de hoogte (height) terug van het object.
     *
     * @return de hoogte als integer.
     */
    double getHeight();

    /**
     * Geeft een IDimension object terug waarin width en height staan.
     *
     * @return Een object met interface IDimension
     */
    IDimension getDimension();
}
