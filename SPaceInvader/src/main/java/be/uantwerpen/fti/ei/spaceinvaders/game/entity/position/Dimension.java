package be.uantwerpen.fti.ei.spaceinvaders.game.entity.position;

/**
 * Een dimensie klassen waarmee we een dimensie kunnen definiëren voor een entiteit.
 */
public class Dimension implements IDimension{
    private int width, height;

    /**
     * Default constructor die de default waardes voor width en height zet als 1.
     */
    public Dimension() {
        this.width = 1;
        this.height = 1;
    }

    /**
     * Overload constructor die een andere dimensie kan meegeven.
     * @param width     De breedte als integer.
     * @param height    De hoogte als integer.
     */
    public Dimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public IDimension getDimension() {
        return this;
    }
}
