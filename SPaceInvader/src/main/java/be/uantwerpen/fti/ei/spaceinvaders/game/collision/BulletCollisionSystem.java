package be.uantwerpen.fti.ei.spaceinvaders.game.collision;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.DimensionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;

/**
 * Een bullet collision systeem waarbij elke collision van de bullet met een entiteit gechecked wordt en de juiste actie uitgevoerd.
 */
public class BulletCollisionSystem {
    /**
     * Bekijkt bullet met een Movable Entiteit.
     *
     * @param mc1 MovementComponent van de bullet.
     * @param mc2 MovementComponent van de entiteit.
     * @return true als de bullet collided is met de gegeven entiteit. Anders false.
     */
    public static boolean bulletEntityCollision(MovementComponent mc1, MovementComponent mc2) {
        if (EntityCollision.entityCollision(mc1, mc2)) {
            mc1.setVelocity(0);
            return true;
        }
        return false;
    }

    /**
     * Bekijkt bullet met een Statische Entiteit.
     *
     * @param mc MovementComponent van de bullet.
     * @param dc DimentionComponent van de entiteit.
     * @return true als de bullet collided is met de gegeven statische entiteit. Anders false.
     */
    public static boolean bulletEntityCollision(MovementComponent mc, DimensionComponent dc) {
        //MovementComponent is een DimensionComponent.
        if (EntityCollision.entityCollision(mc, dc)) {
            mc.setVelocity(0);
            return true;
        }
        return false;
    }
}
