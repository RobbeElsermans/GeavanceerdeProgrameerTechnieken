package be.uantwerpen.fti.ei.spaceinvaders.game.entitysystem;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Position;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.ShootComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

public class PlayerMovementSystem{
    /**
     * Een move methode die kan bewerkt worden door onderliggende klasses.
     * Deze move methode zal de entiteit kunnen laten bewegen.
     */
    public static void move(MovementComponent mc, ShootComponent sc, IInput input){
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