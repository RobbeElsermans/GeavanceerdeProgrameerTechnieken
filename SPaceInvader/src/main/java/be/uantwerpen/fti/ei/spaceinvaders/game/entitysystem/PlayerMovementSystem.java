package be.uantwerpen.fti.ei.spaceinvaders.game.entitysystem;

import be.uantwerpen.fti.ei.spaceinvaders.game.entitycontroller.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

public class PlayerMovementSystem extends GlobalMovementSystem {
    /**
     * Een move methode die kan bewerkt worden door onderliggende klasses.
     * Deze move methode zal de entiteit kunnen laten bewegen.
     */
    public static void move(MovementComponent mc, IInput input){
        if(input.inputAvailable()) {
            if(input.isLeft()) {
                mc.setVelocity(-Math.abs(mc.getDefaultVelocity()));
                mc.setX((int) (mc.getX() + (mc.getSpeed() * mc.getVelocity())));
                //System.out.println(mc.getVelocity());
            }
            if(input.isRight()) {
                mc.setVelocity(Math.abs(mc.getDefaultVelocity()));
                mc.setX((int) (mc.getX() + (mc.getSpeed() * mc.getVelocity())));
                //System.out.println(mc.getVelocity());
            }
        }
    }
}