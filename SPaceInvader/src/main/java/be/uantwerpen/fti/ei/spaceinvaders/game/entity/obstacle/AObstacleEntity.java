package be.uantwerpen.fti.ei.spaceinvaders.game.entity.obstacle;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AStaticEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.ILivable;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;

/**
 * Een obstacle entiteit dat een statische entiteit is. Deze bevat enkel een positie, dimensie en een leven.
 */
public class AObstacleEntity extends AStaticEntity {

    /**
     * default constructor die default het leven (life) op 5 zet.
     */
    public AObstacleEntity() {
        super();
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     * @param position  De positie van de entiteit.
     * @param dimension De dimensie van de entiteit.
     * @param life      Het leven van de entiteit.
     */
    public AObstacleEntity(IPosition position, IDimension dimension, int life) {
        super(position, dimension, life);
    }


    @Override
    public void update() {

    }

    @Override
    public void visualize() {

    }
}
