package be.uantwerpen.fti.ei.spaceinvaders.game.entitysystem;

import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.MovementComponent;

public class BulletMovementSystem {
    public static void move(MovementComponent mc){
            mc.setY((int) (mc.getY()+mc.getSpeed()* mc.getVelocity()));
    }
}