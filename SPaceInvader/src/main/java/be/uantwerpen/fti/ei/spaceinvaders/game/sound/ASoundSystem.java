package be.uantwerpen.fti.ei.spaceinvaders.game.sound;

/**
 * Een sound systeem die verschillende soorten geluidjes kan afspelen
 * <p>
 * Deze klasse wordt overgeërft in de graphics package en wordt daar ook geïmplementeerd.
 */
public abstract class ASoundSystem {
    /**
     * Speel een geluid één keer af.
     *
     * @param soundType Het typen geluid. Moet in de implementatie opgeslagen en verwerkt worden.
     */
    public abstract void playShortSound(SoundType soundType);

    /**
     * Speel een geluid oneindig keer af.
     *
     * @param soundType Het typen geluid. Moet in de implementatie opgeslagen en verwerkt worden.
     */
    public abstract void playBackgroundMusic(SoundType soundType);

    /**
     * Speel een geluid oneindig keer af.
     *
     * @param soundType Het typen geluid. Moet in de implementatie opgeslagen en verwerkt worden.
     */
    public abstract void stopBackgroundMusic(SoundType soundType);
}
