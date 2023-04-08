package be.uantwerpen.fti.ei.spaceinvaders.game.position;

/**
 * Interface die een dimensie bevat in breedte en hoogte.
 */
public interface IDimension {
    /**
     * Geeft de breedte (width) terug.
     *
     * @return de breedte als double.
     */
    double getWidth();

    /**
     * Geeft de hoogte (height) terug.
     *
     * @return de hoogte als double.
     */
    double getHeight();

    /**
     * Geeft een IDimension object terug waarin width en height staan.
     *
     * @return Een object met interface IDimension
     */
    IDimension getDimension();
}
