package be.uantwerpen.fti.ei.spaceinvaders.game.collision;

import be.uantwerpen.fti.ei.spaceinvaders.game.entitycontroller.MovementComponent;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Een collision Manager die de taak krijgt om de collisions uit te voeren en hiermee de entiteit de correcte locatie kan geven.
 */
public class CollisionManager {
    /**
     * Dedicated methoden om een borderCollision te detecteren en hierbij een correcte actie op uit te voeren.
     * @param bc    Een BorderCollision object met een ingestelde gameBorder.
     * @param mc    Een Movement component die de data van movement bijhoud.
     */
    public static void checkBorderCollision(BorderCollisionSystem bc, MovementComponent mc) {

        if (bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(1)) {
            // if left collision.
            mc.setX(0);
            mc.setVelocity(0);
            //TODO: Wat als het spel niet in 0 start?
        }
        if (bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(3)) {
            // if right collision.
            mc.setX((int) (bc.getGameDimensions().getWidth() - (mc.getDimension().getWidth() + (mc.getSpeed()))));
            mc.setVelocity(0);
        }
        if (bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(0)) {
            // if top collision.
            mc.setY(0);
            mc.setVelocity(0);
            //TODO: Wat als het spel niet in 0 start?
        }
        if (bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(2)) {
            // if bottom collision.
            mc.setY((int) (bc.getGameDimensions().getHeight() - (mc.getDimension().getHeight()+ (mc.getSpeed()))));
            mc.setVelocity(0);
        }
    }


    public static void checkBorderCollisionEnemy(BorderCollisionSystem bc, List<MovementComponent> mcl) {
        boolean hasCollideLeft = false;
        boolean hasCollideRight = false;
        boolean hasCollideBottom = false;
        for (MovementComponent mc : mcl) {
            if (bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(1)) {
                // if left collision.
                mc.setX(0);
                hasCollideLeft = true;
                break;
                //TODO: Wat als het spel niet in 0 start?
            }
            if (bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(3)) {
                // if right collision.
                //mc.setX(bc.getGameDimensions().getWidth() - (mc.getDimension().getWidth() + (mc.getSpeed())));
                hasCollideRight = true;
                break;
            }
            if (bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(2)) {
                // if bottom collision.
                mc.setY(bc.getGameDimensions().getHeight() - (mc.getDimension().getHeight() + (mc.getSpeed())));
                hasCollideBottom = true;
                break;
            }
        }

        if(hasCollideLeft || hasCollideBottom || hasCollideRight){
            mcl.forEach(i -> i.setVelocity(0));
        }

        if(hasCollideRight){
            //fix alle entiteiten want deze zijn te ver bewogen.
            //mc.setX(bc.getGameDimensions().getWidth() - (mc.getDimension().getWidth() + (mc.getSpeed())));
            mcl.forEach(mc -> mc.setX((int) ((mc.getX()) - mc.getSpeed()*Math.abs(mc.getDefaultVelocity()))));
        }
    }
}
