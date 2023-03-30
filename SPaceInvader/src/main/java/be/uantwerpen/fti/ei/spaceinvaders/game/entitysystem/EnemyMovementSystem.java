package be.uantwerpen.fti.ei.spaceinvaders.game.entitysystem;

import be.uantwerpen.fti.ei.spaceinvaders.game.entitycontroller.MovementComponent;

/**
 * gebruikt MovementComponent en Border collision.
 * Als er 1 van de entiteiten een border aanraakt, veranderen we van kant.
 */
public class EnemyMovementSystem {
    public static void move(MovementComponent mc){
        if(mc.getVelocity() == 0){ //botsing dus 1 naar beneden en velocity omdraaien
            if(mc.getX() == 0)
                mc.setVelocity(mc.getDefaultVelocity());
            else{
                mc.setVelocity(-1 * mc.getDefaultVelocity());
            }
            mc.setY((int) (mc.getY() + (mc.getSpeed()* Math.abs(mc.getVelocity()))));
            mc.setX((int) (mc.getX() + (mc.getSpeed()* mc.getVelocity())));
        }
        else {  //Beweeg entiteit
            mc.setX((int) (mc.getX() + (mc.getSpeed()*mc.getVelocity())));
        }
    }
}
