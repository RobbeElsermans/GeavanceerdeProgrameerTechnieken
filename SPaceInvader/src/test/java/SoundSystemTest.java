import be.uantwerpen.fti.ei.spaceinvaders.game.filecontroller.FileManager;
import be.uantwerpen.fti.ei.spaceinvaders.game.sound.SoundSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.sound.SoundType;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.LineUnavailableException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SoundSystemTest {
    @Test
    public void testClipHang() {
        SoundSystem soundSystem = new SoundSystem();

        //Voeg de geluidjes toe aan de soundcomponent in soundSystem.
        soundSystem.getSoundComponent().addSound("/sound/explosion.wav", SoundType.playerDeadSound);
        soundSystem.getSoundComponent().addSound("/sound/invaderkilled.wav", SoundType.enemyDeadSound);
        soundSystem.getSoundComponent().addSound("/sound/shoot.wav", SoundType.playerShootSound);
        soundSystem.getSoundComponent().addSound("/sound/ufo_lowpitch.wav", SoundType.bonusSound);
        for(int i = 0; i < 1000; i++) {
            try {
                soundSystem.playSoundOnce(SoundType.playerDeadSound);
                //soundSystem.stopSoundLoop();
                Thread.sleep(100); //Wachten zodat totale tijd FPS behaald wordt.

            } catch (Exception e) {
                break;
                //throw new RuntimeException(e);
            }
        }
    }
}
