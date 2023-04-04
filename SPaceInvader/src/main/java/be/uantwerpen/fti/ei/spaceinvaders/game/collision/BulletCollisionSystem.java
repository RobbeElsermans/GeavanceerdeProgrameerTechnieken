package be.uantwerpen.fti.ei.spaceinvaders.game.collision;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.StaticComponent;

public class BulletCollisionSystem {
    public static boolean bulletEntityCollision(MovementComponent mc1, MovementComponent mc2){
        if(EntityCollisionSystem.entityCollision(mc1, mc2)){
            mc1.setVelocity(0);
            return true;
        }
        return false;
    }

    public static boolean bulletEntityCollision(MovementComponent mc, StaticComponent sc){
        //Converteer static naar movable
        //TODO: wegwerken door betere conversie of meer structuur in componenten te brengen.
        MovementComponent temp = new MovementComponent(sc.getPosition(), sc.getDimension(),0,0);

        if(EntityCollisionSystem.entityCollision(mc, temp)){
            mc.setVelocity(0);
            return true;
        }
        return false;
    }
}
