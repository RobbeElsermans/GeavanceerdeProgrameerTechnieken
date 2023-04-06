package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Een MovementSysteem dedicated voor een player.
 */
public class PlayerMovementSystem {

    /**
     * Deze move methode zal de entiteit kunnen laten bewegen d.m.v. een IInput.
     *
     * @param mc    MovementComponent van de entiteit.
     * @param input De input controller van de entiteit.
     */
    public static void move(MovementComponent mc, IInput input) {
        if (input.inputAvailable()) {
            if (input.isLeft()) {
                mc.setVelocity(-Math.abs(mc.getDefaultVelocity()));

                BigDecimal temp = new BigDecimal((mc.getSpeed() * mc.getVelocity()));
                temp = temp.setScale(0, RoundingMode.DOWN);

                mc.setX((int) (mc.getX() + (mc.getSpeed() * temp.intValue())));
                //System.out.println(mc.getVelocity());
            }
            if (input.isRight()) {
                mc.setVelocity(Math.abs(mc.getDefaultVelocity()));

                BigDecimal temp = new BigDecimal((mc.getSpeed() * mc.getVelocity()));
                temp = temp.setScale(0, RoundingMode.DOWN);

                mc.setX((int) (mc.getX() + (mc.getSpeed() * temp.intValue())));
                //System.out.println(mc.getVelocity());
            }
        }
    }
}