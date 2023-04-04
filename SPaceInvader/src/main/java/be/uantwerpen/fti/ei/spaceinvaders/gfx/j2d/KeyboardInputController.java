package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;

import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.AInputController;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.InputType;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class KeyboardInputController extends AInputController {
    private final GraphicsContext gfx;

    public KeyboardInputController(GraphicsContext gfx) {
        super();
        this.gfx = gfx;
        this.gfx.getFrame().addKeyListener(new KeyInputAdapter());
    }

    //TODO: https://stackoverflow.com/questions/15865087/java-2d-game-dev-multiple-key-input
    class KeyInputAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();

            if (keycode == KeyEvent.VK_LEFT) {
                setLeft(true);
            }
            if (keycode == KeyEvent.VK_RIGHT) {
                setRight(true);
            }
            if (keycode == KeyEvent.VK_DOWN) {
                setDown(true);
            }
            if (keycode == KeyEvent.VK_UP) {
                setUp(true);
            }
            if (keycode == KeyEvent.VK_SPACE) {
                setShoot(true);
            }
            if (keycode == KeyEvent.VK_PLUS) {
                setVolup(true);
            }
            if (keycode == KeyEvent.VK_MINUS) {
                setVoldown(true);
            }
            if (keycode == KeyEvent.VK_ESCAPE) {
                setEsc(true);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keycode = e.getKeyCode();

            if (keycode == KeyEvent.VK_LEFT) {
                setLeft(false);
            }
            if (keycode == KeyEvent.VK_RIGHT) {
                setRight(false);
            }
            if (keycode == KeyEvent.VK_DOWN) {
                setDown(false);
            }
            if (keycode == KeyEvent.VK_UP) {
                setUp(false);
            }
            if (keycode == KeyEvent.VK_SPACE) {
                setShoot(false);
            }
            if (keycode == KeyEvent.VK_PLUS) {
                setVolup(false);
            }
            if (keycode == KeyEvent.VK_MINUS) {
                setVoldown(false);
            }
            if (keycode == KeyEvent.VK_ESCAPE) {
                setEsc(false);
            }
        }
    }
}
