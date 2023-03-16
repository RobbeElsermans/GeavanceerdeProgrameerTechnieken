package be.uantwerpen.fi.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fi.ei.spaceinvaders.game.entity.interfaces.ILivable;

public abstract class ALivableEntity extends AMoveableEntity{
    private int life = 5;
    public ALivableEntity() {
    }

    public ALivableEntity(int x, int y, int speed, int life) {
        super(x, y, speed);
        this.setLife(life);
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
