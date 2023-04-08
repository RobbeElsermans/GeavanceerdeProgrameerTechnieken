package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.helper.RoundEvenly;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Een MovementSysteem dedicated voor een bigEnemy.
 */
public class BigEnemyMovementSystem {

    /**
     * Beweegt de entiteit a.d.h.v. een MovementComponent.
     *
     * @param mc MovementComponent van de bigEnemy entiteit die bewogen moet worden.
     * @see MovementComponent
     * @see RoundEvenly#toInteger(double)
     */
    public static void move(MovementComponent mc) {
        mc.setX(mc.getX() + RoundEvenly.toInteger(mc.getSpeed()*mc.getVelocity()));
    }
}
