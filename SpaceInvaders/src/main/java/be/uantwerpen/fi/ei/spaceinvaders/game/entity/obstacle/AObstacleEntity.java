package be.uantwerpen.fi.ei.spaceinvaders.game.entity.obstacle;

import be.uantwerpen.fi.ei.spaceinvaders.game.entity.abstracts.AEntity;
import be.uantwerpen.fi.ei.spaceinvaders.game.entity.interfaces.ILivable;

public abstract class AObstacleEntity extends AEntity implements ILivable {
    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public AObstacleEntity(){
        super();
    }
    public AObstacleEntity(int x, int y, int life){
        super(x, y);
    }

    @Override
    public void update() {

    }

    @Override
    public void visualize() {

    }
}
