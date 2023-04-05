package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents;

/**
 * Een component dat een collectable bevat.
 */
public class CollectableComponent {
    //Zorgen voor een type etc

    /**
     * Het typen collectable.
     */
    public enum collectableType {
        life,   //Life collectable
        reloadSpeed,    //De snelheid van herladen
        moveSpeed   //De bewegingssnelheid
    }

    /**
     * Het typen van de collectable.
     */
    private collectableType type;
    /**
     * De waarde van de collectable.
     */
    private int value;

    /**
     * Default constructor waarbij er als typen life genomen wordt met waarde 1.
     */
    public CollectableComponent() {
        this.type = collectableType.life;
        this.value = 1;
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param type  Een specifiek type van collectableType.
     * @param value Een value die bij het typen hoort. Kan zowel negatief als positief zijn.
     */
    public CollectableComponent(collectableType type, int value) {
        this.type = type;
        this.value = value;
    }

    public collectableType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
