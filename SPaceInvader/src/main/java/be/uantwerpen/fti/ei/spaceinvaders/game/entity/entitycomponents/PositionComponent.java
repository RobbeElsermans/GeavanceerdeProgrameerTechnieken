package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents;

import be.uantwerpen.fti.ei.spaceinvaders.game.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.Position;

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


    public double getX() {
        return position.getX();
    }

    public void setX(double x) {
        this.position.setX(x);
    }

    public double getY() {
        return this.position.getY();
    }

    public void setY(double y) {
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
