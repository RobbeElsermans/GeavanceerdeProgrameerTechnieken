package be.uantwerpen.fti.ei.spaceinvaders.game.entitysystem.movement;

import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.MovementComponent;

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
                mc.setX((int) (mc.getX() + (mc.getSpeed() * mc.getVelocity())));
            });
        }
        else{
            //beweeg normaal
            mcl.forEach(mc -> mc.setX((int) (mc.getX() + (mc.getSpeed() * mc.getVelocity()))));
        }
    }
}
