package be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller;

public interface IInput {
    boolean inputAvailable();
    boolean isUp();
    boolean isDown();
    boolean isLeft();
    boolean isRight();
    boolean isShoot();
    boolean isVolUp();
    boolean isVolDown();
    boolean isEsc();

}
