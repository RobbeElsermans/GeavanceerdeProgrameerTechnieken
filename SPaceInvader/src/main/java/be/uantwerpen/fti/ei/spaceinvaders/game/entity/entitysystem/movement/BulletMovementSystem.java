package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.helper.RoundEvenly;

/**
 * Een MovementSysteem dedicated voor een bullet.
 */
public class BulletMovementSystem {
    /**
     * Beweegt de entiteit a.d.h.v. een MovementComponent.
     *
     * @param mc MovementComponent van de bullet entiteit die bewogen moet worden.
     * @see MovementComponent
     * @see RoundEvenly#toInteger(double)
     */
    public static void move(MovementComponent mc) {
        mc.setY(mc.getY() + RoundEvenly.toInteger(mc.getSpeed() * mc.getVelocity()));
    }
}