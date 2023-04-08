package be.uantwerpen.fti.ei.spaceinvaders.game.sound;

import javax.sound.sampled.*;
import java.net.URL;
import java.util.EnumMap;

/**
 * Een component die geluiden bevat.
 * <p>
 * De geluiden zijn onderverdeeld door SoundType.
 *
 * @see SoundType
 * @see SoundSystem
 */
public class SoundComponent {
    /*
     * Hierin kunnen we het tijdelijke geluidjes in laten afspelen.
     */
    private Clip clipShort;
    /*
     * Hierin kunnen we het loop geluidjes in laten afspelen.
     */
    private Clip clipLong;
    /*
     * Een Map met key, value pairs waar de key het typen geluid voorstelt en de value de locatie van het bestand.
     */
    //Bron: https://stackoverflow.com/questions/12669497/using-enum-as-key-for-map
    private final ThreadLocal<EnumMap<SoundType, URL>> sounds = new ThreadLocal<>();

    /**
     * Default constructor die interne variabelen initialiseert.
     */
    public SoundComponent() {
        this.sounds.set(new EnumMap<>(SoundType.class));
    }

    /**
     * Een geluid toevoegen aan de lijst.
     * <p>
     * Er kan maar 1 identiek typen bestaan in de database.
     *
     * @param filePath  De locatie van het geluidsbestand + de naam van het bestand.
     * @param type      Het typen geluid gedefinieerd in SoundType.
     * @see SoundType
     */
    public void addSound(String filePath, SoundType type) {
        URL temp = getClass().getResource(filePath);
        sounds.get().put(type, temp);
    }

    public Clip getClipShort() {
        return this.clipShort;
    }

    public void setClipShort(Clip clip) {
        this.clipShort = clip;
    }
    public Clip getClipLong() {
        return this.clipLong;
    }

    public void setClipLong(Clip clip) {
        this.clipLong = clip;
    }

    public EnumMap<SoundType, URL> getSounds() {
        return sounds.get();
    }

    public URL getSoundUrl(SoundType type) {
        return sounds.get().get(type);
    }
}
