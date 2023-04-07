package be.uantwerpen.fti.ei.spaceinvaders.game.sound;

import javax.sound.sampled.*;
import java.net.URL;
import java.util.EnumMap;

/**
 * Een component die geluiden bevat.
 */
public class SoundComponent {
    /**
     * Hierin kunnen we het geluid laten afspelen.
     */
    private Clip clip;
    /**
     * Een Map met key, value pairs waar de key het typen geluid voorstelt en de value de locatie van het bestand.
     */
    //Bron: https://stackoverflow.com/questions/12669497/using-enum-as-key-for-map
    private final ThreadLocal<EnumMap<SoundType, URL>> sounds = new ThreadLocal<>();

    public SoundComponent() {
        this.sounds.set(new EnumMap<>(SoundType.class));
    }

    /**
     * Een geluid toevoegen aan de lijst.
     * @param filePath  De locatie van het bestand
     * @param type      Het typen geluid.
     *
     * @implNote Er kan maar 1 identiek typen bestaan in de database.
     */
    public void addSound(String filePath, SoundType type) {
        URL temp = getClass().getResource(filePath);
        sounds.get().put(type, temp);
    }

    public Clip getClip() {
        return this.clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }

    public EnumMap<SoundType, URL> getSounds() {
        return sounds.get();
    }

    public URL getSoundUrl(SoundType type) {
        return sounds.get().get(type);
    }
}
