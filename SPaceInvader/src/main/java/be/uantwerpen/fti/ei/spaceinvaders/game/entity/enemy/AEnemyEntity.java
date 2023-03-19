package be.uantwerpen.fti.ei.spaceinvaders.game.entity.enemy;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ALivableEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

public abstract class AEnemyEntity extends ALivableEntity {
    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public AEnemyEntity(IInput input){
        super(input);
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     * @param x de x-coördinaat als integer
     * @param y de y-coördinaat als integer
     * @param life de levenswaarde als integer
     * @param speed de snelheid als integer
     */
    public AEnemyEntity(IPosition position, IDimension dimension, int life, int speed, IInput input){
        super(position, dimension, life, speed, input);
    }
}
