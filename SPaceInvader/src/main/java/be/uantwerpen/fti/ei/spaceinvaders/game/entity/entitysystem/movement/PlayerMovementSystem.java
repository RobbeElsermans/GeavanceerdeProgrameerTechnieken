package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

public class PlayerMovementSystem{
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