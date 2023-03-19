package be.uantwerpen.fti.ei.spaceinvaders.game.entity.position;

public interface IPosition {
    int getX();
    int getY();
    void setX(int x);
    void setY(int y);
    IPosition getPosition();
}
