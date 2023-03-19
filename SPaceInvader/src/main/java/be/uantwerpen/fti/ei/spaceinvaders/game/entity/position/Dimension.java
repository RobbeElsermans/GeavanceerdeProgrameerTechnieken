package be.uantwerpen.fti.ei.spaceinvaders.game.entity.position;

public class Dimension implements IDimension{
    private int width, height = 0;

    public Dimension() {
    }
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
