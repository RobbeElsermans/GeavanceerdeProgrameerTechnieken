package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

/**
 * Een Entiteit die overerft van een static entity. Deze AMoveableEntity zal dus kunnen bewegen.
 */
public abstract class AMoveableEntity extends AEntity{
    /**
     * De snelheid waarmee de entiteit zichzelf voortbeweegt. Default is dit 2.
     */
    protected int speed = 2;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public AMoveableEntity() {
        super();
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param x     de x-coördinaat als integer
     * @param y     de y-coördinaat als integer
     * @param speed de snelheid als integer
     */
    public AMoveableEntity(int x, int y, int speed) {
        super(x, y);
        this.setSpeed(speed);
    }

    public abstract void move();

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "AStaticEntity( x: " + getX() + ", y: " + getY() + ", speed: " + getSpeed() + " )";
    }
}
