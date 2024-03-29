package be.uantwerpen.fti.ei.spaceinvaders.game.helper;

/**
 * Help klassen om random getallen te berekenen binnen een bepaald bereik.
 */
public class Random {
    /**
     * Geef een random getal terug tussen [min, max].
     *
     * @param min Van waar de random kan starten.
     * @param max Tot waar de random kan stoppen.
     * @return een integer met de random waarde.
     */
    public static int getRandom(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    /**
     * Geef een random getal terug tussen [0, max].
     *
     * @param max tot waar de random kan stoppen.
     * @return een integer met de random waarde.
     */
    public static int getRandom(int max) {
        return (int) Math.floor(Math.random() * (max + 1));
    }
}
