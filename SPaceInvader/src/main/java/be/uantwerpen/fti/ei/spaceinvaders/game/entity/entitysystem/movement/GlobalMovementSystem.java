package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Een GlobalMovementSysteem waarmee we overal heen kunnen gaan.
 */
public class GlobalMovementSystem {

    /**
     * Een globale move methode die overal heen kan bewegen. Is voor debugging belangrijk
     * Deze move methode zal de entiteit kunnen laten bewegen d.m.v. een IInput.
     *
     * @param mc    MovementComponent van de entiteit.
     * @param input De input controller van de entiteit.
     */
    public static void move(MovementComponent mc, IInput input) {
        if (input.inputAvailable()) {
            if (input.isLeft()) {
                mc.setVelocity(-Math.abs(mc.getDefaultVelocity()));

                BigDecimal temp = BigDecimal.valueOf(mc.getSpeed() * mc.getVelocity());
                temp = temp.setScale(0, RoundingMode.DOWN);

                mc.setX((mc.getX() + (mc.getSpeed() * temp.intValue())));
            }
            if (input.isRight()) {
                mc.setVelocity(Math.abs(mc.getDefaultVelocity()));

                BigDecimal temp = BigDecimal.valueOf(mc.getSpeed() * mc.getVelocity());
                temp = temp.setScale(0, RoundingMode.DOWN);

                mc.setX((mc.getX() + (mc.getSpeed() * temp.intValue())));
            }
            if (input.isUp()) {
                mc.setVelocity(-Math.abs(mc.getDefaultVelocity()));

                BigDecimal temp = BigDecimal.valueOf(mc.getSpeed() * mc.getVelocity());
                temp = temp.setScale(0, RoundingMode.DOWN);

                mc.setY((mc.getY() + (mc.getSpeed() * temp.intValue())));
            }
            if (input.isDown()) {
                mc.setVelocity(Math.abs(mc.getDefaultVelocity()));

                BigDecimal temp = BigDecimal.valueOf(mc.getSpeed() * mc.getVelocity());
                temp = temp.setScale(0, RoundingMode.DOWN);

                mc.setY((mc.getY() + (mc.getSpeed() * temp.intValue())));
            }
        }
    }
}
