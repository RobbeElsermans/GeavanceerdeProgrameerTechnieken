package be.uantwerpen.fti.ei.spaceinvaders.game.sound;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

/**
 * Sound systeem dat het geluid aanstuurt d.m.v. de SoundComponent.
 */
public class SoundSystem {

    SoundComponent soundComponent;

    /**
     * Default constructor die interne variabelen initialiseert.
     *
     * @see SoundComponent
     */
    public SoundSystem() {
        this.soundComponent = new SoundComponent();
    }

    /**
     * Overload constructor.
     *
     * @param soundComponent De SoundComponent.
     * @see SoundComponent
     */
    public SoundSystem(SoundComponent soundComponent) {
        this.soundComponent = soundComponent;
    }

    /**
     * Speel muziek 1x af.
     * <p>
     * Het typen bepaald welke track er afgespeeld wordt.
     *
     * @param type Het typen muziek dat afgespeeld moet worden.
     * @see SoundType
     */
    public void playSoundOnce(SoundType type) {
        if (soundExists(type)) {
            setFile(type);

            this.soundComponent.getClipShort().start();
        }
    }

    /**
     * Speel muziek oneindig lang af.
     * <p>
     * Het typen bepaald welke track er afgespeeld wordt. De oneindige loop kan doorbroken worden door methode
     * <code>playSoundLoop(SoundType type)</code>.
     *
     * @param type Het typen muziek dat afgespeeld moet worden.
     * @see SoundType
     */
    public void playSoundLoop(SoundType type) {
        if (soundExists(type)) {
            setFile(type);
            this.soundComponent.getClipLong().loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    /**
     * Stop de oneindige track.
     */
    public void stopSoundLoop() {
        //setFile(type);
        if (this.soundComponent.getClipLong() != null)
            this.soundComponent.getClipLong().stop();
    }

    /**
     * Het opgeslagen bestand a.d.h.v. het typen, opslaan in clip.
     *
     * @param type Het typen sound dat we willen opslaan.
     */
    private void setFile(SoundType type) {
        URL temp = this.soundComponent.getSoundUrl(type);
        if (temp != null) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(temp);
                //System.out.println(audioInputStream.getFormat());
                //Bron: https://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java
                //Bron: https://stackoverflow.com/questions/30036843/clip-sometimes-does-not-play
                Clip tempClip = AudioSystem.getClip();
                tempClip.addLineListener(e -> {
                    if (e.getType() == LineEvent.Type.STOP) {
                        e.getLine().close();
                    }
                });
                if(type != SoundType.BACKGROUND_MUSIC) {
                    this.soundComponent.setClipShort(tempClip);
                    this.soundComponent.getClipShort().open(audioInputStream);
                }
                else{
                    this.soundComponent.setClipLong(tempClip);
                    this.soundComponent.getClipLong().open(audioInputStream);
                }

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                //throw new RuntimeException(e);
                e.printStackTrace();

            }
        }
    }

    /**
     * Checkt of dat het geluid al bestaat of niet.
     * @param type Het typen sound dat we willen bekijken.
     * @return True als het bestaat. Anders false.
     */
    private boolean soundExists(SoundType type) {
        return (this.soundComponent.getSoundUrl(type) != null);
    }

    public SoundComponent getSoundComponent() {
        return soundComponent;
    }
}
