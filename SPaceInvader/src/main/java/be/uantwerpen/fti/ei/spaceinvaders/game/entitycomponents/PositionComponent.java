package be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Position;

public class PositionComponent {
    /**
     * De coördinaat van een entiteit. Default is dit (0,0).
     */
    private final IPosition position;

    /**
     * De dimensie van een entiteit. Default is dit (1,1).
     */
    private IDimension dimentions;

    /**
     * default constructor die positie en dimensie op default zal plaatsen.
     */
    public PositionComponent() {
        this.position = new Position(0,0);
        this.dimentions = new Dimension(1,1);
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     * @param position  De positie van de entiteit.
     * @param dimension De dimensie van de entiteit.
     */
    public PositionComponent(IPosition position, IDimension dimension) {
        this.position = position;
        this.dimentions = dimension;
    }


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
    public void setDimension(IDimension dimension)
    {
        this.dimentions = dimension;
    }
}
