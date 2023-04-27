package be.uantwerpen.fti.ei.spaceinvaders.game.collision;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Hulp enum om te bepalen welke border collision er bekeken moet worden.
 * @see BorderCollision BorderCollision
 */
public enum Edge {
    /**
     * TOP stelt TOP-COLLISION voor (index 0).
     */
    TOP(0),
    /**
     * LEFT stelt LEFT-COLLISION voor (index 1).
     */
    LEFT(1),
    /**
     * BOTTOM stelt BOTTOM-COLLISION voor (index 2).
     */
    BOTTOM(2),
    /**
     * RIGHT stelt RIGHT-COLLISION voor (index 3).
     */
    RIGHT(3);

    private final int value;

    Edge(int value) {
        this.value = value;
    }

    /**
     * Verkrijg de integer value van een enum.
     *
     * @return De integer value van de enum.
     */
    public int getValue() {
        return value;
    }
}
