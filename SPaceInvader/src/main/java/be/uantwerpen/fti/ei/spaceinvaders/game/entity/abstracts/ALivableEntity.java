package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.ILivable;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

/**
 * Een leefbare entiteit dat de eigenschappen heeft van een entiteit en van een beweegbare entiteit.
 */
public abstract class ALivableEntity  extends AMoveableEntity implements ILivable {
    /**
     * Het leven van een leefbaar entiteit
     */
    private int life;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     * @param input Een IInput object waarmee de entiteit zichzelf mee kan bewegen.
     */
    public ALivableEntity(IInput input) {
        super(input);
        this.setLife(5);
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     * @param position  De positie van de entiteit.
     * @param dimension De dimensie van de entiteit.
     * @param speed     De snelheid waarmee de entiteit zich verplaatst.
     * @param life      Het leven van de entiteit.
     * @param input     Een IInput object waarmee de entiteit zichzelf mee kan bewegen.
     */
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
    public void upLifeByAmount(int amount){
        this.life += amount;
    }
    public void downLife(){
        this.life -= 1;
    }
    public void downLifeByAmount(int amount){
        if(this.life - amount < 0)
            this.life = 0;
        else
            this.life -= amount;
    }

    @Override
    public String toString() {
        return "AEntity( x: " + getX() + ", y: " + getY() + ", width: "+getWidth() + ", height: " + getHeight()+ ", speed "+ this.getSpeed()+ ", life " + this.getLife()+" )";
    }
}
