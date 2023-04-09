package be.uantwerpen.fti.ei.spaceinvaders.gfx.console;

//Bron: https://stackoverflow.com/questions/4005574/java-key-listener-in-commandline
//Bron: https://github.com/kwhat/jnativehook

import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.AInputController;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

/**
 * @description  Op ubuntu, login als xorg.
 * bron: <a href="https://github.com/go-vgo/robotgo/issues/304">github</a>
 */
public class KeyboardInputController extends AInputController {

    public KeyboardInputController(){
        try {
        			GlobalScreen.registerNativeHook();
        		}
        		catch (NativeHookException ex) {
        			System.err.println("There was a problem registering the native hook.");
        			System.err.println(ex.getMessage());

        			System.exit(1);
        		}

        		GlobalScreen.addNativeKeyListener(new KeyboardAdapter());
    }

    class KeyboardAdapter implements NativeKeyListener {
        public void nativeKeyPressed(NativeKeyEvent e) {
            //System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));



            int keycode = e.getKeyCode();

            if (keycode == NativeKeyEvent.VC_LEFT) {
                setLeft(true);
            }
            if (keycode == NativeKeyEvent.VC_RIGHT) {
                setRight(true);
            }
            if (keycode == NativeKeyEvent.VC_DOWN) {
                setDown(true);
            }
            if (keycode == NativeKeyEvent.VC_UP) {
                setUp(true);
            }
            if (keycode == NativeKeyEvent.VC_SPACE) {
                setShoot(true);
            }
            if (keycode == NativeKeyEvent.VC_VOLUME_UP) {
                setVolUp(true);
            }
            if (keycode == NativeKeyEvent.VC_VOLUME_DOWN) {
                setVolDown(true);
            }
            if (keycode == NativeKeyEvent.VC_ESCAPE) {
                setEsc(true);
            }
            if (keycode == NativeKeyEvent.VC_ENTER) {
                setEnter(true);
            }
            if (keycode == NativeKeyEvent.VC_Q) {
                setQuit(true);
            }


        }

        public void nativeKeyReleased(NativeKeyEvent e) {
            //System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

            int keycode = e.getKeyCode();

            if (keycode == NativeKeyEvent.VC_LEFT) {
                setLeft(false);
            }
            if (keycode == NativeKeyEvent.VC_RIGHT) {
                setRight(false);
            }
            if (keycode == NativeKeyEvent.VC_DOWN) {
                setDown(false);
            }
            if (keycode == NativeKeyEvent.VC_UP) {
                setUp(false);
            }
            if (keycode == NativeKeyEvent.VC_SPACE) {
                setShoot(false);
            }
            if (keycode == NativeKeyEvent.VC_VOLUME_UP) {
                setVolUp(false);
            }
            if (keycode == NativeKeyEvent.VC_VOLUME_DOWN) {
                setVolDown(false);
            }
            if (keycode == NativeKeyEvent.VC_ESCAPE) {
                setEsc(false);
            }
            if (keycode == NativeKeyEvent.VC_ENTER) {
                setEnter(false);
            }
            //Ik heb azerty, maar querty is ook een mogelijkheid.
            if (keycode == NativeKeyEvent.VC_Q || keycode == NativeKeyEvent.VC_A) {
                setQuit(false);
            }
        }
    }
}