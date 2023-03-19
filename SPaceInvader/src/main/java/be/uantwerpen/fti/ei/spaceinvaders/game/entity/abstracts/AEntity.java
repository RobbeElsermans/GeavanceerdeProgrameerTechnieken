package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Position;

/**
 * de moeder van de entiteiten
 */
public abstract class AEntity{
    /**
     * De coördinaat van een entiteit. Default is dit (0,0).
     */
    private IPosition position;
    private IDimension dimentions;

    public AEntity() {
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     * @param position
     * @param dimension
     */
    public AEntity(IPosition position, IDimension dimension) {
        this.position = position;
        this.dimentions = dimension;
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
        return position.getX();
    }

    public void setX(int x) {
        this.position.setX(x);
    }

    public int getY() {
        return this.position.getY();
    }

    public void setY(int y) {
        this.position.setY(y);
    }

    public IPosition getPosition() {
        return this.position;
    }

    public int getWidth() {
        return this.dimentions.getWidth();
    }

    public int getHeight(){
        return this.dimentions.getHeight();
    }
    public IDimension getDimension()
    {
        return this.dimentions.getDimension();
    }

    @Override
    public String toString() {
        return "AStaticEntity( x: " + getX() + ", y: " + getY() + " )";
    }
}
