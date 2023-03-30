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
            // if left collision.
            mc.setY(0);
            mc.setVelocity(0);
            //TODO: Wat als het spel niet in 0 start?
        }
        if (bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(2)) {
            // if right collision.
            mc.setY((int) (bc.getGameDimensions().getHeight() - (mc.getDimension().getHeight()+ (mc.getSpeed()))));
            mc.setVelocity(0);
        }
    }

    /**
     * Bekijkt ofdat een enemy tegen de kant zit.
     * Als een enemy links ergens tegen komt, zal er +1 terug gestuurd worden.
     * Als er een enemy rechts ergens tegen komt, zal er -1 terug gegeven worden.
     * Als er geen collision is, wordt er 0 terug gegeven.
     * @param bc
     * @param movementComponent
     * @return  Als een enemy links ergens tegen komt, zal er +1 terug gestuurd worden.
     *          Als er een enemy rechts ergens tegen komt, zal er -1 terug gegeven worden.
     *          Als er geen collision is, wordt er 0 terug gegeven.
     */
    //TODO: zorg ervoor dat in de EnemyMovementSystem nu de -1, 0, 1 worden verwerkt. zodat de enemy 1x naar onder gaat en naar de andere kant gaat.
    public static int checkBorderCollisionEnemy(BorderCollisionSystem bc, List<MovementComponent> movementComponent) {
        AtomicInteger temp = new AtomicInteger();
        movementComponent.forEach(mc -> {
            if(bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(1)){
                //if left collision
                temp.set(1);
            }
            if(bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(2)){
                //if left collision
                temp.set(-1);
            }
        });

        return temp.get();
    }
}
