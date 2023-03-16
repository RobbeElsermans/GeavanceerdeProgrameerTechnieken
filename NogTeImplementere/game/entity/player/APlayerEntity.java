package be.uantwerpen.fi.ei.spaceinvaders.game.entity.player;

import be.uantwerpen.fi.ei.spaceinvaders.game.entity.abstracts.ALivableEntity;
import be.uantwerpen.fi.ei.spaceinvaders.game.entity.abstracts.AMoveableEntity;
import be.uantwerpen.fi.ei.spaceinvaders.game.entity.interfaces.ILivable;

public abstract class APlayerEntity extends ALivableEntity implements ILivable {
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
