package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.helper.RoundEvenly;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Een MovementSysteem dedicated voor een player.
 * <p>
 * Om op eigen kracht te kunnen bewegen, hebben we een input nodig van de gebruiker.
 * Deze kan gevormd worden door AInputController wat een IInput is.
 *
 * @see be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.AInputController AInputController
 * @see IInput
 */
public class PlayerMovementSystem {

    /**
     * Deze move methode zal de entiteit kunnen laten bewegen d.m.v. een IInput.
     *
     * @param mc    MovementComponent van de entiteit.
     * @param input De input controller van de entiteit.
     * @see IInput
     * @see MovementComponent
     * @see RoundEvenly#toInteger(double)
     */
    public static void move(MovementComponent mc, IInput input) {
        if (input.inputAvailable()) {
            if (input.isLeft()) {
                mc.setVelocity(Math.abs(mc.getDefaultVelocity()));
                mc.setX(mc.getX() - RoundEvenly.toInteger(mc.getSpeed() * mc.getVelocity()));
            }
            if (input.isRight()) {
                mc.setVelocity(Math.abs(mc.getDefaultVelocity()));
                mc.setX(mc.getX() + RoundEvenly.toInteger(mc.getSpeed() * mc.getVelocity()));
            }
        }
    }
}