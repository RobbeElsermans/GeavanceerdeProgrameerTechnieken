package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Position;

/**
 * Een component dat een positie en dimensie bevat.
 */
public class PositionComponent {
    /**
     * De coördinaat van een entiteit. Default is dit (0,0).
     */
    private final IPosition position;

    /**
     * Default constructor die positie en dimensie op default zal plaatsen.
     */
    public PositionComponent() {
        this.position = new Position(0,0);
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     * @param position  De positie van de entiteit.
     */
    public PositionComponent(IPosition position) {
        this.position = position;

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

    @Override
    public String toString() {
        return "PositionComponent{" +
                "position=" + position +
                '}';
    }
}
