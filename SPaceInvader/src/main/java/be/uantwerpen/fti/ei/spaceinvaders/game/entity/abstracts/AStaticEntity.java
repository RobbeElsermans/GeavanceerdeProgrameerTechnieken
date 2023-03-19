package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.ILivable;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;

/**
 * Een statische entiteit die de eigenschappen heeft van een entiteit en hierbij een leven heeft.
 */
public abstract class AStaticEntity extends AEntity implements ILivable {
    /**
     * Het leven van een leefbaar entiteit
     */
    private int life;

    /**
     * default constructor die default het leven (life) op 5 zet.
     */
    public AStaticEntity() {
        super();
        this.setLife(5);
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     * @param position  De positie van de entiteit.
     * @param dimension De dimensie van de entiteit.
     * @param life      Het leven van de entiteit.
     */
    public AStaticEntity(IPosition position, IDimension dimension, int life) {
        super(position, dimension);
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
        return "AEntity( x: " + getX() + ", y: " + getY() + ", width: "+getWidth() + ", height: " + getHeight()+ ", life " + this.getLife()+" )";
    }
}
