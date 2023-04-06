package be.uantwerpen.fti.ei.spaceinvaders.game.collision;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;

/**
 * Een collision klasse waarmee we kunnen detecteren dat 2 entiteiten elkaar aanraken of niet.
 */
public class EntityCollision {

    /**
     * Een algemene entiteit collision functie die kijkt of dat entiteit 1, entiteit 2 aanraakt lans eender welke kant.
     *
     * @param mc1 MovementComponent van entiteit 1.
     * @param mc2 MovementComponent van entiteit 2.
     * @return true als entiteit 1, entiteit 2 aanraakt. Anders false.
     * @implNote De volgorde van wie dat entiteit 1 en 2 voorstelt, maakt niet uit.
     */
    public static boolean entityCollision(MovementComponent mc1, MovementComponent mc2) {
        /**
         * Als entiteit 1, entiteit 2 aanraakt langs links boven.
         */
        if ((mc1.getX() <= mc2.getX() && mc1.getX() + mc1.getWidth() >= mc2.getX()) &&
                (mc1.getY() <= mc2.getY() && mc1.getY() + mc1.getHeight() >= mc2.getY())) {
            return true;
        }

        /**
         * Als entiteit 2, entiteit 1 aanraakt langs rechts onder.
         */
        if ((mc2.getX() <= mc1.getX() && mc2.getX() + mc2.getWidth() >= mc1.getX()) &&
                (mc2.getY() <= mc1.getY() && mc2.getY() + mc2.getHeight() >= mc1.getY())) {
            return true;
        }

        /**
         * Als entiteit 1, entiteit 2 aanraakt langs links onder.
         */
        if ((mc1.getX() + mc1.getWidth() >= mc2.getX() && mc1.getX() + mc1.getWidth() <= mc2.getX() + mc2.getWidth()) &&
                (mc1.getY() <= mc2.getY() + mc2.getHeight() && mc1.getY() >= mc2.getY())) {
            return true;
        }

        /**
         * Als entiteit 2, entiteit 1 aanraakt langs rechts onder.
         */

        if ((mc2.getX() + mc2.getWidth() >= mc1.getX() && mc2.getX() + mc2.getWidth() <= mc1.getX() + mc1.getWidth()) &&
                (mc2.getY() <= mc1.getY() + mc1.getHeight() && mc2.getY() >= mc1.getY())) {
            return true;
        }


        return false;
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