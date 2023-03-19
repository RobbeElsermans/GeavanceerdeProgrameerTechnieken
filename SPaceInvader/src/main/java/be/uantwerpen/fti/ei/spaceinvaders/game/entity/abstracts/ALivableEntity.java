package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.ILivable;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

public abstract class ALivableEntity  extends AMoveableEntity implements ILivable {
    /**
     * Het leven van een leefbaar entiteit
     */
    private int life = 5;
    public ALivableEntity(IInput input) {
        super(input);
    }

    public ALivableEntity(IPosition position, IDimension dimension, int speed, int life, IInput input) {
        super(position, dimension, speed, input);
        this.setLife(life);
    }

    private void setLife(int life) {
        this.life = life;
    }

    public int getLife(){
        return this.life;
    }
    public void upLife(){
        this.life += 1;
    }
    public void upLife(int amount){
        this.life += amount;
    }
    public void downLife(){
        this.life -= 1;
    }
    public void downLife(int amount){
        if(this.life - amount < 0)
            this.life = 0;
        else
            this.life -= amount;
    }
}
