package be.uantwerpen.fti.ei.spaceinvaders.game.entity.obstacle;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.ILivable;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;

public abstract class AObstacleEntity extends AEntity{
    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public AObstacleEntity(){
        super();
    }
    public AObstacleEntity(IPosition position, IDimension dimension, int life){
        super(position, dimension);
    }

    @Override
    public void update() {

    }

    @Override
    public void visualize() {

    }
}
