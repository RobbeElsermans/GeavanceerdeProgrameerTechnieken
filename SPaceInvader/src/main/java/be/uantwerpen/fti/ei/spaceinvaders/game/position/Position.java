package be.uantwerpen.fti.ei.spaceinvaders.game.position;

/**
 * Een positie klassen waarmee we een positie kunnen definiëren voor een entiteit.
 * @see IPosition
 */
public class Position implements IPosition {
    private double x, y;

    /**
     * Default constructor waarbij:
     * <ul>
     *     <li>x -> 0</li>
     *     <li>y -> 0</li>
     * </ul>
     */
    public Position() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Overload constructor die een andere coördinaat kan meegeven.
     *
     * @param x De x-waarde als double.
     * @param y De y-waarde als double.
     */
    public Position(double x, double y) {
        setX(x);
        setY(y);
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public IPosition getPosition() {
        return this;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
