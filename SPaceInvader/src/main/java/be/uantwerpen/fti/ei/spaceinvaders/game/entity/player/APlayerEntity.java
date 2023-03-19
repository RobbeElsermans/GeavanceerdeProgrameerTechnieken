package be.uantwerpen.fti.ei.spaceinvaders.game.entity.player;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ALivableEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

public abstract class APlayerEntity extends ALivableEntity {
    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */

    public APlayerEntity(IInput input){//Insert de input
        super(input);
    }

    public APlayerEntity(IPosition position, IDimension dimension, int life, int speed, IInput input){
        super(position, dimension, speed, life, input);
    }
}
