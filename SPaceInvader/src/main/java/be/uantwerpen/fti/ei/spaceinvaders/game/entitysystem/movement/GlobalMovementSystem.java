package be.uantwerpen.fti.ei.spaceinvaders.game.entitysystem.movement;

import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

public class GlobalMovementSystem {
    /**
     * Een globale move methode die overan heen kan bewegen. Is voor debugging belangrijk
     * Deze move methode zal de entiteit kunnen laten bewegen.
     */
    public static void move(MovementComponent mc, IInput input){
        if(input.inputAvailable()) {
            if(input.isLeft()) {
                mc.setVelocity(-Math.abs(mc.getDefaultVelocity()));
                mc.setX((int) (mc.getX() + (mc.getSpeed() * mc.getVelocity())));
            }
            if(input.isRight()) {
                mc.setVelocity(Math.abs(mc.getDefaultVelocity()));
                mc.setX((int) (mc.getX() + (mc.getSpeed() * mc.getVelocity())));
            }
            if(input.isUp()) {
                mc.setVelocity(-Math.abs(mc.getDefaultVelocity()));
                mc.setY((int) (mc.getY() + (mc.getSpeed() * mc.getVelocity())));
            }
            if(input.isDown()) {
                mc.setVelocity(Math.abs(mc.getDefaultVelocity()));
                mc.setY((int) (mc.getY() + (mc.getSpeed() * mc.getVelocity())));
            }
        }
    }
}
