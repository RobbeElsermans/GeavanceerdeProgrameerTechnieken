package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents;

/**
 * Een component dat een collectable bevat.
 */
public class CollectableComponent {
    //Zorgen voor een type etc


    /**
     * Het typen van de collectable.
     */
    private final CollectableType type;
    /**
     * De waarde van de collectable.
     */
    private double value;

    /**
     * Default constructor waarbij er als typen life genomen wordt met waarde 1.
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
     */
    public CollectableComponent(CollectableType type, double value) {
        this.type = type;
        this.value = value;
    }

    public CollectableType getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public double takeValue(){
        double temp = value;
        value = 0;
        return temp;
    }
}
