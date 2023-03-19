package be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller;

import java.util.LinkedList;

public class AInputController implements IInput{
    private LinkedList<InputType> keyInputs;

    public AInputController() {
        this.keyInputs = new LinkedList<>();
    }

    @Override
    public boolean inputAvailable() {
        return keyInputs.size() > 0;
    }

    @Override
    public InputType inputState() {
        return keyInputs.poll();
    }

    public LinkedList<InputType> getKeyInputs() {
        return keyInputs;
    }
    public void addKeyInput(InputType keyInput) {
        this.keyInputs.add(keyInput);
    }
}
