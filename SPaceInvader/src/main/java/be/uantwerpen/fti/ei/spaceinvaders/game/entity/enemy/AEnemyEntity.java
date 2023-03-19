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
     * @param position  IPosition die de coördinaat bepaald van de speler
     * @param dimension IDimention die de dimentie bepaald van de speler
     * @param life
     * @param speed
     * @param input
     */
    public AEnemyEntity(IPosition position, IDimension dimension, int life, int speed, IInput input){
        super(position, dimension, life, speed, input);
    }
}
