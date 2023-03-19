package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;

public abstract class AStaticEntity extends AEntity{
    private int life = 5;
    public AStaticEntity() {
        super();
    }

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
