package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;

public class BulletMovementSystem {
    public static void move(MovementComponent mc){
            mc.setY((int) (mc.getY()+mc.getSpeed()* mc.getVelocity()));
    }
}