package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

/**
 * de moeder van de entiteiten
 */
public abstract class AEntity {
    /**
     * De coördinaat van een entiteit. Default is dit (0,0).
     */
    protected int x,y = 0;

    public AEntity() {
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     * @param x de x-coördinaat als integer
     * @param y de y-coördinaat als integer
     */
    public AEntity(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    /**
     * De update methode zal de entiteit updaten a.d.h.v. zijn omgeving.
     */
    public abstract void update();

    /**
     * De visualize methode zal de entiteit weergeven in de gekozen GFX-interface.
     */
    public abstract void visualize();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "AStaticEntity( x: " + getX() + ", y: " + getY() + " )";
    }
}
