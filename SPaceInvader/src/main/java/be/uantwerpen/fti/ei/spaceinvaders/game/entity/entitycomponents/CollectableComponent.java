package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.types.CollectableType;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Een component dat collectable data bevat.
 * <p>
 * Deze component kan gebruikt worden wanneer we iets willen collecten. Zo kan een collectable enkele types aannemen.
 * Samenhangend met dit typen, is er ook een waarde aan vast gekoppeld.
 *
 * @see CollectableType
 */
public class CollectableComponent {
    /*
     * Het typen van de collectable.
     */
    private final CollectableType type;
    /*
     * De waarde van de collectable.
     */
    private double value;

    /**
     * Default constructor waarbij:
     * <ul>
     *     <li>type  -> LIFE</li>
     *     <li>value -> 1</li>
     * </ul>
     *
     * @see CollectableType
     */
    public CollectableComponent() {
        this.type = CollectableType.LIFE;
        this.value = 1;
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param type  Een specifiek type van collectableType.
     * @param value Een value die bij het typen hoort. Kan zowel negatief als positief zijn.
     * @see CollectableType
     */
    public CollectableComponent(CollectableType type, double value) {
        this.type = type;
        this.value = value;
    }

    /**
     *
     * @return Geeft het geselecteerde typen terug.
     */
    public CollectableType getType() {
        return type;
    }

    /**
     *
     * @return De value van de collectable
     */
    public double getValue() {
        return value;
    }

    /**
     * Geeft de waarde terug en zal hiermee de value gelijk stellen aan 0. Hierdoor weet een systeem dat de collectable genomen is.
     * @return De value van de collectable
     */
    public double takeValue() {
        double temp = value;
        value = 0;
        return temp;
    }
}
