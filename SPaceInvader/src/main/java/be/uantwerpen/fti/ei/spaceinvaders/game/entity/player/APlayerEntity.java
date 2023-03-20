package be.uantwerpen.fti.ei.spaceinvaders.game.entity.player;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ALivableEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

/**
 * Een player entiteit dat overerft van livable & movable entiteit.
 */
public abstract class APlayerEntity extends ALivableEntity {
    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     * @param input Een IInput object waarmee de entiteit zichzelf mee kan bewegen.
     */
    public APlayerEntity(IInput input){//Insert de input
        super(input);
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     * @param position  De positie van de entiteit.
     * @param dimension De dimensie van de entiteit.
     * @param speed     De snelheid waarmee de entiteit zich verplaatst.
     * @param life      Het leven van de entiteit.
     * @param input     Een IInput object waarmee de entiteit zichzelf mee kan bewegen.
     */
    public APlayerEntity(IPosition position, IDimension dimension, int life, int speed, IInput input){
        super(position, dimension, speed, life, input);
    }
/*
    @Override
    protected void move(){
        if(getInput().inputAvailable()) {
            switch (getInput().inputState()){
                case LEFT:{
                    setX(getX()-this.getSpeed());
                    break;
                }
                case RIGHT :{
                    setX(getX()+this.getSpeed());
                    break;
                }
                default : {

                }
            }
        }
        //this.setX(getX()+1);
    }
    */

}
