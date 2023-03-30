package be.uantwerpen.fti.ei.spaceinvaders.game.entitysystem;

import be.uantwerpen.fti.ei.spaceinvaders.game.collision.CollisionManager;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycontroller.MovementComponent;

import java.util.List;

/**
 * gebruikt MovementComponent en Border collision.
 * Als er 1 van de entiteiten een border aanraakt, veranderen we van kant.
 */
public class EnemyMovementSystem {
    public static void move(List<MovementComponent> mcl){
        if(mcl.stream().anyMatch(i -> i.getVelocity() == 0)){   //Als er een collision is opgetreden.
            System.out.println("Collide");
            //verkrijg vorige state van entiteit dat 0 had
            double prevState = mcl.stream().filter(i -> i.getVelocity() == 0).toList().get(0).getPrevVelocity();
            //verander de velocity states
            mcl.forEach(mc -> {
                //verander de velocity states
                mc.setVelocity(-1 * prevState);
                //beweeg naar beneden en naar links/rechts
                mc.setY((int) (mc.getY() + (mc.getSpeed()* Math.abs(mc.getVelocity()))));
                mc.setX((int) (mc.getX() + (mc.getSpeed() * mc.getVelocity())));
            });
        }
        else{
            //beweeg normaal
            mcl.forEach(mc -> mc.setX((int) (mc.getX() + (mc.getSpeed() * mc.getVelocity()))));
        }

        /*
        if (mc.getVelocity() == 0) { //botsing dus 1 naar beneden en velocity omdraaien
                if (mc.getX() == 0)
                    mc.setVelocity(mc.getDefaultVelocity());
                else {
                    mc.setVelocity(-1 * mc.getDefaultVelocity());
                }
                //mc.setY((int) (mc.getY() + (mc.getSpeed()* Math.abs(mc.getVelocity()))));
                //mc.setX((int) (mc.getX() + (mc.getSpeed()* mc.getVelocity())));
            } else {  //Beweeg entiteit
                mc.setX((int) (mc.getX() + (mc.getSpeed() * mc.getVelocity())));
            }
         */
    }
}
