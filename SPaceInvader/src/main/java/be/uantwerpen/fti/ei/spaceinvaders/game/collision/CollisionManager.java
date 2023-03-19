package be.uantwerpen.fti.ei.spaceinvaders.game.collision;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;

public class CollisionManager {

    public static void checkBorderCollision(BorderCollision bc, AEntity entity, IDimension gameDimentions) {

        if (bc.checkBorderCollision(entity.getPosition(), entity.getDimentions()).get(1)) {
            // if left collision.
            entity.setX(0);
        }
        if (bc.checkBorderCollision(entity.getPosition(), entity.getDimentions()).get(3)) {
            // if right collision.
            entity.setX(gameDimentions.getWidth() - entity.getDimentions().getWidth());
        }
        if (bc.checkBorderCollision(entity.getPosition(), entity.getDimentions()).get(0)) {
            // if left collision.
            entity.setY(0);
        }
        if (bc.checkBorderCollision(entity.getPosition(), entity.getDimentions()).get(2)) {
            // if right collision.
            entity.setY(gameDimentions.getHeight() - entity.getDimentions().getHeight());
        }
    }
}
