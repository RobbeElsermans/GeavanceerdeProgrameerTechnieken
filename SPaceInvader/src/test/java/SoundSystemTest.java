import be.uantwerpen.fti.ei.spaceinvaders.game.sound.SoundSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.sound.SoundType;
import org.junit.jupiter.api.Test;

public class SoundSystemTest {
    @Test
    public void testClipHang() {
        SoundSystem soundSystem = new SoundSystem();

        //Voeg de geluidjes toe aan de soundcomponent in soundSystem.
        soundSystem.getSoundComponent().addSound("/sound/explosion.wav", SoundType.PLAYER_DEAD_SOUND);
        soundSystem.getSoundComponent().addSound("/sound/invaderkilled.wav", SoundType.ENEMY_DEAD_SOUND);
        soundSystem.getSoundComponent().addSound("/sound/shoot.wav", SoundType.PLAYER_SHOOT_SOUND);
        soundSystem.getSoundComponent().addSound("/sound/ufo_lowpitch.wav", SoundType.BIG_ENEMY_SOUND);
        for(int i = 0; i < 1000; i++) {
            try {
                soundSystem.playSoundOnce(SoundType.PLAYER_DEAD_SOUND);
                //soundSystem.stopSoundLoop();
                Thread.sleep(100); //Wachten zodat totale tijd FPS behaald wordt.

            } catch (Exception e) {
                break;
                //throw new RuntimeException(e);
            }
        }
    }
}
