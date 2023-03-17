package be.uantwerpen.fti.ei.spaceinvaders.game.entity.player;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ALivableEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AMoveableEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.ILivable;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ALivableEntity;

public abstract class APlayerEntity extends ALivableEntity {
    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public APlayerEntity(){
        super();
    }
    public APlayerEntity(int x, int y, int life, int speed){
        super(x, y, speed, life);
    }
}
