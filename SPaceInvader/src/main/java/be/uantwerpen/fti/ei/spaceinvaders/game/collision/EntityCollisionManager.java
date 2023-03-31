package be.uantwerpen.fti.ei.spaceinvaders.game.collision;

import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.MovementComponent;

public class EntityCollisionManager {
    public static boolean bulletEntityCollision(MovementComponent mc1, MovementComponent mc2){
        if(EntityCollisionSystem.entityCollision(mc1, mc2)){
            mc1.setVelocity(0);
            return true;
        }
        return false;
    }
}
