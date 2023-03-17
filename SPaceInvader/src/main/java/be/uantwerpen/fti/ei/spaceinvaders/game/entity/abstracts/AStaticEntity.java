package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

public abstract class AStaticEntity extends AEntity{
    private int life = 5;
    public AStaticEntity() {
    }

    public AStaticEntity(int x, int y, int life) {
        super(x, y);
        this.setLife(life);
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
