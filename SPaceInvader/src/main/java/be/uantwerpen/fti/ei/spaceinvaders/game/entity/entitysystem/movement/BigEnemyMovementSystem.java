package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;

/**
 * Een MovementSysteem dedicated voor een collectable (Bonus).
 */
public class BigEnemyMovementSystem {
    /**
     * Beweegt de entiteit.
     *
     * @param mc MovementComponent van de entiteit
     */
    public static void move(MovementComponent mc) {
        mc.setX((int) (mc.getX() + mc.getSpeed() * mc.getVelocity()));
    }
}
