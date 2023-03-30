package be.uantwerpen.fti.ei.spaceinvaders.game.entitysystem;

import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.MovementComponent;

public class BulletMovementSystem {
    public static void move(MovementComponent mc, LivableComponent lc){
        if(lc.getLife() >0){   //Als de entiteit leeft, beweeg dan
            mc.setY(2);
        }
    }
}
