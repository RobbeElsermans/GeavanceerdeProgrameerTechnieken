package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents;

import be.uantwerpen.fti.ei.spaceinvaders.game.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IPosition;

public class DimensionComponent extends PositionComponent{
    /**
     * De dimensie van een entiteit. Default is dit (1,1).
     */
    private IDimension dimentions;
    public DimensionComponent() {
        super();
        this.dimentions = new Dimension(1,1);
    }
    public DimensionComponent(IDimension dimentions) {
        super();
        this.dimentions = dimentions;
    }

    public DimensionComponent(IPosition position, IDimension dimentions) {
        super(position);
        this.dimentions = dimentions;
    }

    public int getWidth() {
        return (int) this.dimentions.getWidth();
    }

    public int getHeight(){
        return (int) this.dimentions.getHeight();
    }
    public IDimension getDimension()
    {
        return this.dimentions.getDimension();
    }
    public void setDimension(IDimension dimension)
    {
        this.dimentions = dimension;
    }

    @Override
    public String toString() {
        return "DimensionComponent{" +
                "dimentions=" + dimentions +
                '}';
    }
}
