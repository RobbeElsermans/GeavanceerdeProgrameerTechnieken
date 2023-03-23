package be.uantwerpen.fti.ei.spaceinvaders.game.entitysystem;

import be.uantwerpen.fti.ei.spaceinvaders.game.entitycontroller.MovementComponent;

public class PlayerMovementSystem {
    /**
     * Een move methode die kan bewerkt worden door onderliggende klasses.
     * Deze move methode zal de entiteit kunnen laten bewegen.
     */
    public static void move(MovementComponent movementComponent){
        if(movementComponent.getInput().inputAvailable()) {
            if(movementComponent.getInput().isLeft())
                movementComponent.setX(movementComponent.getX()-movementComponent.getSpeed());
            if(movementComponent.getInput().isRight())
                movementComponent.setX(movementComponent.getX()+movementComponent.getSpeed());
        }
    }
}