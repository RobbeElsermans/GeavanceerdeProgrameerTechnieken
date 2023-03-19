package be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces;

public interface ILivable {
    int getLife();
    void upLife();
    void upLife(int amount);
    void downLife();
    void downLife(int amount);

}
