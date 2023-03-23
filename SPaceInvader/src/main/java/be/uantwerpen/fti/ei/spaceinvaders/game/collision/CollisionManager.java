package be.uantwerpen.fti.ei.spaceinvaders.game.collision;

import be.uantwerpen.fti.ei.spaceinvaders.game.entitycontroller.MovementComponent;

/**
 * Een collision Manager die de taak krijgt om de collisions uit te voeren en hiermee de entiteit de correcte locatie kan geven.
 */
public class CollisionManager {
    /**
     * Dedicated methoden om een borderCollision te detecteren en hierbij een correcte actie op uit te voeren.
     * @param bc    Een BorderCollision object met een ingestelde gameBorder
     * @param movementComponent
     */
    public static void checkBorderCollision(BorderCollisionSystem bc, MovementComponent movementComponent) {

        if (bc.checkBorderCollision(movementComponent.getPosition(), movementComponent.getDimension()).get(1)) {
            // if left collision.
            movementComponent.setX(0);
            //TODO: Wat als het spel niet in 0 start?
        }
        if (bc.checkBorderCollision(movementComponent.getPosition(), movementComponent.getDimension()).get(3)) {
            // if right collision.
            movementComponent.setX(bc.getGameDimensions().getWidth() - movementComponent.getDimension().getWidth());
        }
        if (bc.checkBorderCollision(movementComponent.getPosition(), movementComponent.getDimension()).get(0)) {
            // if left collision.
            movementComponent.setY(0);
            //TODO: Wat als het spel niet in 0 start?
        }
        if (bc.checkBorderCollision(movementComponent.getPosition(), movementComponent.getDimension()).get(2)) {
            // if right collision.
            movementComponent.setY(bc.getGameDimensions().getHeight() - movementComponent.getDimension().getHeight());
        }
    }
}
