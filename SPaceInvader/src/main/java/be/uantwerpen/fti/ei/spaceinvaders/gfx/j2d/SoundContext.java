package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;

import be.uantwerpen.fti.ei.spaceinvaders.game.filecontroller.FileManager;
import be.uantwerpen.fti.ei.spaceinvaders.game.sound.ASoundSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.sound.SoundType;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.EnumMap;

public class SoundContext extends ASoundSystem {
    /*
     * Hierin kunnen we het tijdelijke geluidjes in laten afspelen.
     */
    private Clip clipShort;
    private Clip clipLoop;
    /*
     * Een Map met key, value pairs waar de key het soort geluid voorstelt en de value de locatie van het bestand.
     */
    //Bron: https://stackoverflow.com/questions/12669497/using-enum-as-key-for-map
    private final EnumMap<SoundType, URL> sounds = new EnumMap<>(SoundType.class);

    /**
     * De overload constructor die de geluiden buffert
     * @param configFile De locatie van het gfx_config bestand. Hierin worden de locaties van de geluiden bewaard.
     */
    public SoundContext(String configFile) {
        //Haal de muziek locaties uit het gfx_config bestand
        addSound(FileManager.getSettingString("sound_player_dead", configFile, "/sound/explosion.wav"), SoundType.PLAYER_DEAD_SOUND);
        addSound(FileManager.getSettingString("sound_enemy_dead", configFile, "/sound/invaderkilled.wav"), SoundType.ENEMY_DEAD_SOUND);
        addSound(FileManager.getSettingString("sound_player_shoot", configFile, "/sound/shoot.wav"), SoundType.PLAYER_SHOOT_SOUND);
        addSound(FileManager.getSettingString("sound_enemy_shoot", configFile, "/sound/shoot.wav"), SoundType.ENEMY_SHOOT_SOUND);
        addSound(FileManager.getSettingString("sound_big_enemy_sound", configFile, "/sound/ufo_lowpitch.wav"), SoundType.BIG_ENEMY_SOUND);
        addSound(FileManager.getSettingString("sound_bonus_sound", configFile, "/sound/ufo_highpitch.wav"), SoundType.BONUS_SOUND);
        addSound(FileManager.getSettingString("sound_background_music", configFile, "/sound/spaceinvaders.wav"), SoundType.BACKGROUND_MUSIC);
    }

    /**
     * Een geluid toevoegen aan de lijst.
     * <p>
     * Er kan maar 1 identiek typen bestaan in de database.
     *
     * @param filePath De locatie van het geluidsbestand + de naam van het bestand.
     * @param type     Het soort geluid gedefinieerd in SoundType.
     * @see SoundType
     */
    private void addSound(String filePath, SoundType type) {
        URL temp = getClass().getResource(filePath);
        sounds.put(type, temp);
    }

    private URL getSoundUrl(SoundType type) {
        return sounds.get(type);
    }

    /**
     * Het opgeslagen bestand a.d.h.v. het typen, opslaan in clip.
     *
     * @param type Het typen sound dat we willen opslaan.
     */
    private void setFile(SoundType type) {
        URL temp = getSoundUrl(type);
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
                if (type == SoundType.BACKGROUND_MUSIC) {
                    clipLoop = tempClip;
                    clipLoop.open(audioInputStream);
                } else {
                    clipShort = tempClip;
                    clipShort.open(audioInputStream);
                }

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                //throw new RuntimeException(e);
                e.printStackTrace();
            }
        }
    }

    /**
     * Checkt of dat het geluid al bestaat of niet.
     *
     * @param type Het typen sound dat we willen bekijken.
     * @return True als het bestaat. Anders false.
     */
    private boolean soundExists(SoundType type) {
        return (getSoundUrl(type) != null);
    }

    @Override
    public void playShortSound(SoundType soundType) {
        if (soundExists(soundType)) {
            Thread t = new Thread(() -> {
                try {
                    this.setFile(soundType);
                } finally {
                    this.clipShort.loop(0);
                }
            });
            t.start();
        }
    }

    @Override
    public void playBackgroundMusic(SoundType soundType) {
        //reset de vorige loop sound
        stopBackgroundMusic(soundType);

        if (soundExists(soundType)) {
            setFile(soundType);
            clipLoop.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    @Override
    public void stopBackgroundMusic(SoundType soundType) {
        if (clipLoop != null)
            clipLoop.stop();
    }
}
