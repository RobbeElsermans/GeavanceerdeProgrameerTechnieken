package be.uantwerpen.fti.ei.spaceinvaders.game.entity.position;

/**
 * Een positie klassen waarmee we een positie kunnen definiëren voor een entiteit.
 *
 * @implNote De coördinaten dat hier ingegeven worden,
 * zijn gekoppeld aan gameWidth en gameHeight die in het bestand game_config.txt staan.
 */
public class Position implements IPosition {
    private int x, y;

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
    public Position(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public IPosition getPosition() {
        return this;
    }
}
