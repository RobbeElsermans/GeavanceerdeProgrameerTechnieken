package be.uantwerpen.fti.ei.spaceinvaders.game.position;

/**
 * Een positie klassen waarmee we een positie kunnen definiëren voor een entiteit.
 *
 * @implNote De coördinaten dat hier ingegeven worden,
 * zijn gekoppeld aan gameWidth en gameHeight die in het bestand game_config.txt staan.
 */
public class Position implements IPosition {
    private double x, y;

    /**
     * Default constructor die de default waardes voor x en y zet op 0.
     */
    public Position() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Overload constructor die een andere coördinaat kan meegeven.
     *
     * @param x De x-waarde als integer.
     * @param y De y-waarde als integer.
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
