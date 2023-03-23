package be.uantwerpen.fti.ei.spaceinvaders.game.entitycontroller;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

/**
 * Een leefbaar component
 */
public class LivableComponent{
    /**
     * Het leven van een leefbaar entiteit
     */
    private int life;
    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public LivableComponent() {
        super();
        this.setLife(5);
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     * @param life      Het leven van de entiteit.
     */
    public LivableComponent(int life) {
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
}
