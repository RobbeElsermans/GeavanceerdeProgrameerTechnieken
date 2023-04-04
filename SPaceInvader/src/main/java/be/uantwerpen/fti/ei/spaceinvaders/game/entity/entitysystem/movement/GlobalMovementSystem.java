package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GlobalMovementSystem {
    /**
     * Een globale move methode die overan heen kan bewegen. Is voor debugging belangrijk
     * Deze move methode zal de entiteit kunnen laten bewegen.
     */
    public static void move(MovementComponent mc, IInput input){
        if(input.inputAvailable()) {
            if(input.isLeft()) {
                mc.setVelocity(-Math.abs(mc.getDefaultVelocity()));

                BigDecimal temp = new BigDecimal((mc.getSpeed() * mc.getVelocity()));
                temp = temp.setScale(0, RoundingMode.DOWN);

                mc.setX((int) (mc.getX() + (mc.getSpeed() * temp.intValue() )));
            }
            if(input.isRight()) {
                mc.setVelocity(Math.abs(mc.getDefaultVelocity()));

                BigDecimal temp = new BigDecimal((mc.getSpeed() * mc.getVelocity()));
                temp = temp.setScale(0, RoundingMode.DOWN);

                mc.setX((int) (mc.getX() + (mc.getSpeed() * temp.intValue())));
            }
            if(input.isUp()) {
                mc.setVelocity(-Math.abs(mc.getDefaultVelocity()));

                BigDecimal temp = new BigDecimal((mc.getSpeed() * mc.getVelocity()));
                temp = temp.setScale(0, RoundingMode.DOWN);

                mc.setY((int) (mc.getY() + (mc.getSpeed() * temp.intValue())));
            }
            if(input.isDown()) {
                mc.setVelocity(Math.abs(mc.getDefaultVelocity()));

                BigDecimal temp = new BigDecimal((mc.getSpeed() * mc.getVelocity()));
                temp = temp.setScale(0, RoundingMode.DOWN);

                mc.setY((int) (mc.getY() + (mc.getSpeed() * temp.intValue())));
            }
        }
    }
}
