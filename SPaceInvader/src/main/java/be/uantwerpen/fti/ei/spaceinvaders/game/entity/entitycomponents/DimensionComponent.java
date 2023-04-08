package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.types.CollectableType;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IPosition;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Een component dat een dimensie bevat in de vorm van IDimension. Het erft over van PositionComponent dus het heeft ook een positie.
 * <p>
 * Dit component kan gebruikt worden om iets een positie met een dimensie te geven.
 * @see IDimension
 * @see IPosition
 * @see PositionComponent
 */
public class DimensionComponent extends PositionComponent{
    /**
     * De dimensie van een entiteit. Default is dit (1,1).
     */
    private IDimension dimentions;

    /**
     * Default constructor waarbij:
     * <ul>
     *     <li>dimentions  -> [1,1]</li>
     * </ul>
     * @see PositionComponent#PositionComponent()  PositionComponent
     * @see Dimension#Dimension()  Dimension
     */
    public DimensionComponent() {
        super();
        this.dimentions = new Dimension();
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
