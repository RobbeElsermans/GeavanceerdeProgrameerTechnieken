package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement;

import be.uantwerpen.fti.ei.spaceinvaders.game.collision.BorderCollision;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.helper.RoundEvenly;

import java.util.List;

/**
 * Een MovementSysteem dedicated voor een Enemy.
 */
public class EnemyMovementSystem {
    /**
     * Beweegt de entiteit a.d.h.v. een MovementComponent.
     * <p>
     * Er wordt een lijst van MovementComponents meegegeven omdat de movement van enemy in cluster gebeurd.
     * Ze bewegen namelijk allemaal samen.
     *
     * @param mcl Een lijst van MovementComponents van de enemy entiteiten.
     * @see be.uantwerpen.fti.ei.spaceinvaders.game.collision.BorderCollisionSystem#checkBorderCollisionEnemy(BorderCollision, List) checkBorderCollisionEnemy(BorderCollision, List)
     * @see MovementComponent
     * @see RoundEvenly#toInteger(double)
     */
    public static void move(List<MovementComponent> mcl) {
        if (mcl.stream().anyMatch(i -> i.getVelocity() == 0)) {   //Als er een collision is opgetreden.
            //System.out.println("Collide");
            //verkrijg vorige state van entiteit dat 0 had
            double prevState = mcl.stream().filter(i -> i.getVelocity() == 0).toList().get(0).getPrevVelocity();
            //verander de velocity states van alle enemy's.
            mcl.forEach(mc -> {
                //verander de velocity states
                mc.setVelocity(-1 * prevState);
                //beweeg naar beneden met de entiteit zijn hoogte en naar links/ rechts.
                mc.setY((int) (mc.getY() + mc.getHeight()));
            });
        }

        mcl.forEach(mc -> mc.setX(mc.getX() + RoundEvenly.toInteger(mc.getSpeed() * mc.getVelocity())));
    }
}
