package be.uantwerpen.fti.ei.spaceinvaders.game.collision;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.DimensionComponent;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Een globale collision klasse waarmee we kunnen detecteren dat 2 entiteiten elkaar aanraken of niet.
 *
 * @see DimensionComponent
 */
public class EntityCollision {

    /**
     * Een algemene entiteit collision functie die kijkt of dat entiteit 1, entiteit 2 aanraakt lans eender welke kant.
     * <p>
     * De volgorde van wie dat entiteit 1 en 2 voorstelt, maakt niet uit. Er zal altijd true gegeven worden als er een collision is tussen beide.
     *
     * @param dc1 DimensionComponent van entiteit 1.
     * @param dc2 DimensionComponent van entiteit 2.
     * @return true als entiteit 1/2, entiteit 2/1 aanraakt. Anders false.
     */
    public static boolean entityCollision(DimensionComponent dc1, DimensionComponent dc2) {
        /*
         * Als entiteit 1, entiteit 2 aanraakt langs links boven.
         */
        if ((dc1.getX() <= dc2.getX() && dc1.getX() + dc1.getWidth() >= dc2.getX()) &&
                (dc1.getY() <= dc2.getY() && dc1.getY() + dc1.getHeight() >= dc2.getY())) {
            return true;
        }

        /*
         * Als entiteit 2, entiteit 1 aanraakt langs rechts onder.
         */
        if ((dc2.getX() <= dc1.getX() && dc2.getX() + dc2.getWidth() >= dc1.getX()) &&
                (dc2.getY() <= dc1.getY() && dc2.getY() + dc2.getHeight() >= dc1.getY())) {
            return true;
        }

        /*
         * Als entiteit 1, entiteit 2 aanraakt langs links onder.
         */
        if ((dc1.getX() + dc1.getWidth() >= dc2.getX() && dc1.getX() + dc1.getWidth() <= dc2.getX() + dc2.getWidth()) &&
                (dc1.getY() <= dc2.getY() + dc2.getHeight() && dc1.getY() >= dc2.getY())) {
            return true;
        }

        /*
         * Als entiteit 2, entiteit 1 aanraakt langs rechts onder.
         */
        return (dc2.getX() + dc2.getWidth() >= dc1.getX() && dc2.getX() + dc2.getWidth() <= dc1.getX() + dc1.getWidth()) &&
                (dc2.getY() <= dc1.getY() + dc1.getHeight() && dc2.getY() >= dc1.getY());
    }

    /**
     * Check of dat entiteit 1 op dezelfde lijn is met een entiteit 2 of niet.
     * <p>
     * Entiteit 2 komt langs boven en entiteit 1 staan altijd onder entiteit 2. De volgorde van wie dat entiteit 1 en 2 voorstelt, is van belang.
     *
     * @param dc1 MovementComponent van entiteit 1.
     * @param dc2 MovementComponent van entiteit 2.
     * @return True als entiteit 2, langs boven, op dezelfde hoogte komt als entiteit 1. Anders false.
     */
    public static boolean entityIsOnSameLine(DimensionComponent dc1, DimensionComponent dc2) {
        return dc2.getY() + dc2.getHeight() >= dc1.getY();
    }
}