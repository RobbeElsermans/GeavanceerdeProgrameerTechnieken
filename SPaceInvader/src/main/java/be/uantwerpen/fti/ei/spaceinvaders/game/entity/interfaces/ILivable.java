package be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces;

public interface ILivable {
    int getLife();
    void upLife();
    void upLifeByAmount(int amount);
    void downLife();
    void downLifeByAmount(int amount);
}
