package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;

import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.AInputController;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardInputController extends AInputController {

    public KeyboardInputController(GraphicsContext gfx) {
        super();
        gfx.getFrame().addKeyListener(new KeyInputAdapter());
    }

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
            if (keycode == KeyEvent.VK_ENTER) {
                setEnter(true);
            }
            if (keycode == KeyEvent.VK_Q || keycode == KeyEvent.VK_A ) {
                setQuit(true);
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
            if (keycode == KeyEvent.VK_ENTER) {
                setEnter(false);
            }
            if (keycode == KeyEvent.VK_Q) {
                setQuit(false);
            }
        }
    }
}
