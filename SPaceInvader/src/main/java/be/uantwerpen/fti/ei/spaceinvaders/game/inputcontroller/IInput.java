package be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller;

public interface IInput {
    boolean inputAvailable();

    InputType inputState();
}
