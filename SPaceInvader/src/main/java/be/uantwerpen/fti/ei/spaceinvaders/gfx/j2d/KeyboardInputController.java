package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;

import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.AInputController;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.InputType;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class KeyboardInputController extends AInputController{

    private GraphicsContext gfx;
    public KeyboardInputController(GraphicsContext gfx){
        super();
        this.gfx = gfx;
        this.gfx.getFrame().addKeyListener(new KeyInputAdapter());
    }

    //TODO: https://stackoverflow.com/questions/15865087/java-2d-game-dev-multiple-key-input
    class KeyInputAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            switch (keycode) {
                case KeyEvent.VK_LEFT -> addKeyInput(InputType.LEFT);
                case KeyEvent.VK_RIGHT -> addKeyInput(InputType.RIGHT);
                case KeyEvent.VK_DOWN -> addKeyInput(InputType.DOWN);
                case KeyEvent.VK_UP -> addKeyInput(InputType.UP);
                case KeyEvent.VK_SPACE -> addKeyInput(InputType.SHOOT);
                case KeyEvent.VK_PLUS -> addKeyInput(InputType.VOLUP);
                case KeyEvent.VK_MINUS -> addKeyInput(InputType.VOLDOWN);
            }
        }
    }
}
