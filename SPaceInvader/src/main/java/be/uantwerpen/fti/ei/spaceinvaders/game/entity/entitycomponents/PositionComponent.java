package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents;

import be.uantwerpen.fti.ei.spaceinvaders.game.position.IPosition;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Een component dat een positie bevat.
 */
public class PositionComponent {
    private final IPosition position;

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param position De positie van de entiteit.
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
