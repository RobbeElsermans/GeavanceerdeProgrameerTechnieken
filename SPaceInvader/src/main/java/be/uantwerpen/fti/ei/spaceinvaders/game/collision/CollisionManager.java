package be.uantwerpen.fti.ei.spaceinvaders.game.collision;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;

/**
 * Een collision Manager die de taak krijgt om de collisions uit te voeren en hiermee de entiteit de correcte locatie kan geven.
 */
public class CollisionManager {
    /**
     * Dedicated methoden om een borderCollision te detecteren en hierbij een correcte actie op uit te voeren.
     * @param bc    Een BorderCollision object met een ingestelde gameBorder
     * @param entity
     */
    public static void checkBorderCollision(BorderCollision bc, AEntity entity) {

        if (bc.checkBorderCollision(entity.getPosition(), entity.getDimension()).get(1)) {
            // if left collision.
            entity.setX(0);
            //TODO: Wat als het spel niet in 0 start?
        }
        if (bc.checkBorderCollision(entity.getPosition(), entity.getDimension()).get(3)) {
            // if right collision.
            entity.setX(bc.getGameDimensions().getWidth() - entity.getDimension().getWidth());
        }
        if (bc.checkBorderCollision(entity.getPosition(), entity.getDimension()).get(0)) {
            // if left collision.
            entity.setY(0);
            //TODO: Wat als het spel niet in 0 start?
        }
        if (bc.checkBorderCollision(entity.getPosition(), entity.getDimension()).get(2)) {
            // if right collision.
            entity.setY(bc.getGameDimensions().getHeight() - entity.getDimension().getHeight());
        }
    }
}
