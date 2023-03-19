package be.uantwerpen.fti.ei.spaceinvaders.game.entity.position;

public class Position implements IPosition{
    private int x, y = 0;

    public Position() {
    }
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
