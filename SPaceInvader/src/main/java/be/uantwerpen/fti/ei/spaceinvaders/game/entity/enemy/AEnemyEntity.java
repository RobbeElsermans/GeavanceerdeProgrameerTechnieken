package be.uantwerpen.fti.ei.spaceinvaders.game.entity.enemy;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ALivableEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

public abstract class AEnemyEntity extends ALivableEntity {
    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     * @param input Een IInput object waarmee de entiteit zichzelf mee kan bewegen.
     */
    public AEnemyEntity(IInput input){
        super(input);
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     * @param position  De positie van de entiteit.
     * @param dimension De dimensie van de entiteit.
     * @param life      Het leven van de entiteit.
     * @param speed     De snelheid waarmee de entiteit zich verplaatst.
     * @param input     Een IInput object waarmee de entiteit zichzelf mee kan bewegen.
     */
    public AEnemyEntity(IPosition position, IDimension dimension, int life, int speed, IInput input){
        super(position, dimension, life, speed, input);
    }
}
