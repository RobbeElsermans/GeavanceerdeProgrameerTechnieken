package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;

public class CollectableMovementSystem {
    public static void move(MovementComponent mc){
        mc.setX((int) (mc.getX()+mc.getSpeed()*mc.getVelocity()));
    }
}
