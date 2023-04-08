package be.uantwerpen.fti.ei.spaceinvaders.game.collision;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.DimensionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;

/**
 * Een bullet collision systeem waarbij elke collision van de bullet met een entiteit gecontroleerd wordt.
 *
 * @see EntityCollision
 */
public class BulletCollisionSystem {
    /**
     * Bekijkt bullet botsing met een entiteit.
     *
     * @param mc MovementComponent van de bullet.
     * @param dc DimensionComponent van de entiteit.
     * @return True als de bullet gebotst is met de gegeven entiteit. Anders false.
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