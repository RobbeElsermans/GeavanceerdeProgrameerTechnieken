package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

/**
 * gebruikt MovementComponent en Border collision.
 * Als er 1 van de entiteiten een border aanraakt, veranderen we van kant.
 */
public class EnemyMovementSystem {
    public static void move(List<MovementComponent> mcl){
        if(mcl.stream().anyMatch(i -> i.getVelocity() == 0)){   //Als er een collision is opgetreden.
            //System.out.println("Collide");
            //verkrijg vorige state van entiteit dat 0 had
            double prevState = mcl.stream().filter(i -> i.getVelocity() == 0).toList().get(0).getPrevVelocity();
            //verander de velocity states
            mcl.forEach(mc -> {
                //verander de velocity states
                mc.setVelocity(-1 * prevState);
                //beweeg naar beneden en naar links/rechts
                mc.setY( (mc.getY() + (mc.getSpeed())));

            });
        }

        /**
         * Probleem dat -1.5 -> -1 en 1.5 -> 2.
         * Oplossing: Roundingmode Down
         * https://docs.oracle.com/javase/7/docs/api/java/math/RoundingMode.html
         */


        mcl.forEach(mc -> {
            BigDecimal temp = new BigDecimal((mc.getSpeed() * mc.getVelocity()));
            temp = temp.setScale(0,RoundingMode.DOWN);

            mc.setX(mc.getX() + (temp.intValue()));
        });
    }
}
