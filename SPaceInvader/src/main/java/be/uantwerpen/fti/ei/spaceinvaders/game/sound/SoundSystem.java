package be.uantwerpen.fti.ei.spaceinvaders.game.sound;

import be.uantwerpen.fti.ei.spaceinvaders.game.sound.SoundComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.sound.SoundType;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

/**
 * Sound systeem dat het geluid aanstuurt.
 */
public class SoundSystem {

    SoundComponent soundComponent;

    public SoundSystem() {
        this.soundComponent = new SoundComponent();
    }

    public SoundSystem(SoundComponent soundComponent) {
        this.soundComponent = soundComponent;
    }

    /**
     * Speel muziek 1x, a.d.h.v. het typen, af.
     *
     * @param type Het typen muziek dat afgespeeld moet worden.
     */
    public void playSoundOnce(SoundType type) {
        if(soundExists(type)) {
            setFile(type);

            this.soundComponent.getClip().start();
        }
    }

    /**
     * Speel muziek, a.d.h.v. het typen,  af in een oneindige loop.
     *
     * @param type Het typen muziek dat afgespeeld moet worden.
     */
    public void playSoundLoop(SoundType type) {
        if(soundExists(type)) {
            setFile(type);
            this.soundComponent.getClip().loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    /**
     * Stop het huidig spelende muziekje.
     */
    public void stopSoundLoop() {
        //setFile(type);
        if(this.soundComponent.getClip() != null)
            this.soundComponent.getClip().stop();
    }

    /**
     * Het opgeslagen bestand a.d.h.v. het typen, opslaan in clip.
     *
     * @param type
     */
    private void setFile(SoundType type) {
        URL temp = this.soundComponent.getSoundUrl(type);
        if(temp != null) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(temp);
                //System.out.println(audioInputStream.getFormat());
                //Bron: https://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java
                //Bron: https://stackoverflow.com/questions/30036843/clip-sometimes-does-not-play
                Clip tempClip = AudioSystem.getClip();
                tempClip.addLineListener(e -> {
                    if(e.getType() == LineEvent.Type.STOP){
                        e.getLine().close();
                    }
                });
                this.soundComponent.setClip(tempClip);
                this.soundComponent.getClip().open(audioInputStream);

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                //throw new RuntimeException(e);
                e.printStackTrace();

            }
        }
    }

    private boolean soundExists(SoundType type){
        return (this.soundComponent.getSoundUrl(type) != null);
    }

    public SoundComponent getSoundComponent() {
        return soundComponent;
    }
}
