package be.uantwerpen.fti.ei.spaceinvaders.game.collision;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.DimensionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;

/**
 * Een collision klasse waarmee we kunnen detecteren dat 2 entiteiten elkaar aanraken of niet.
 */
public class EntityCollision {

    /**
     * Een algemene entiteit collision functie die kijkt of dat entiteit 1, entiteit 2 aanraakt lans eender welke kant.
     *
     * @param dc1 MovementComponent van entiteit 1.
     * @param dc2 MovementComponent van entiteit 2.
     * @return true als entiteit 1, entiteit 2 aanraakt. Anders false.
     * @implNote De volgorde van wie dat entiteit 1 en 2 voorstelt, maakt niet uit.
     */
    public static boolean entityCollision(DimensionComponent dc1, DimensionComponent dc2) {
        /**
         * Als entiteit 1, entiteit 2 aanraakt langs links boven.
         */
        if ((dc1.getX() <= dc2.getX() && dc1.getX() + dc1.getWidth() >= dc2.getX()) &&
                (dc1.getY() <= dc2.getY() && dc1.getY() + dc1.getHeight() >= dc2.getY())) {
            return true;
        }

        /**
         * Als entiteit 2, entiteit 1 aanraakt langs rechts onder.
         */
        if ((dc2.getX() <= dc1.getX() && dc2.getX() + dc2.getWidth() >= dc1.getX()) &&
                (dc2.getY() <= dc1.getY() && dc2.getY() + dc2.getHeight() >= dc1.getY())) {
            return true;
        }

        /**
         * Als entiteit 1, entiteit 2 aanraakt langs links onder.
         */
        if ((dc1.getX() + dc1.getWidth() >= dc2.getX() && dc1.getX() + dc1.getWidth() <= dc2.getX() + dc2.getWidth()) &&
                (dc1.getY() <= dc2.getY() + dc2.getHeight() && dc1.getY() >= dc2.getY())) {
            return true;
        }

        /**
         * Als entiteit 2, entiteit 1 aanraakt langs rechts onder.
         */

        return (dc2.getX() + dc2.getWidth() >= dc1.getX() && dc2.getX() + dc2.getWidth() <= dc1.getX() + dc1.getWidth()) &&
                (dc2.getY() <= dc1.getY() + dc1.getHeight() && dc2.getY() >= dc1.getY());
    }

    /**
     * Check of dat een entiteit op dezelfde lijn is met een andere entiteit of niet.
     * Entiteit 2 komt langs boven en entiteit 1 staan altijd onder entiteit 2.
     *
     * @param mc1 MovementComponent van entiteit 1.
     * @param mc2 MovementComponent van entiteit 2.
     * @return true als entiteit 2 langs boven, op dezelfde hoogte komt als entiteit 1. Anders false.
     * @implNote De volgorde van wie dat entiteit 1 en 2 voorstelt, is van belang.
     */
    public static boolean entityIsOnSameLine(MovementComponent mc1, MovementComponent mc2) {
        return mc2.getY() + mc2.getHeight() >= mc1.getY();
    }
}