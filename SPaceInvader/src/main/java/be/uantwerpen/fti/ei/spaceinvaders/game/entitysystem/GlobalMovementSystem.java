package be.uantwerpen.fti.ei.spaceinvaders.game.entitysystem;

import be.uantwerpen.fti.ei.spaceinvaders.game.entitycontroller.MovementComponent;

public class GlobalMovementSystem {
    /**
     * Een globale move methode die overan heen kan bewegen. Is voor debugging belangrijk
     * Deze move methode zal de entiteit kunnen laten bewegen.
     */
    public static void move(MovementComponent mc){
        if(mc.getInput().inputAvailable()) {
            if(mc.getInput().isLeft()) {
                mc.setVelocity(-Math.abs(mc.getDefaultVelocity()));
                mc.setX((int) (mc.getX() + (mc.getSpeed() * mc.getVelocity())));
            }
            if(mc.getInput().isRight()) {
                mc.setVelocity(Math.abs(mc.getDefaultVelocity()));
                mc.setX((int) (mc.getX() + (mc.getSpeed() * mc.getVelocity())));
            }
            if(mc.getInput().isUp()) {
                mc.setVelocity(-Math.abs(mc.getDefaultVelocity()));
                mc.setY((int) (mc.getY() + (mc.getSpeed() * mc.getVelocity())));
            }
            if(mc.getInput().isDown()) {
                mc.setVelocity(Math.abs(mc.getDefaultVelocity()));
                mc.setY((int) (mc.getY() + (mc.getSpeed() * mc.getVelocity())));
            }
        }
    }
}
