package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents;

public class CollectableComponent {
    //Zorgen voor een type etc
    public enum collectableType{
        life,
        reloadSpeed,
        moveSpeed
    }

    private collectableType type;
    private int value;

    /**
     * Default constructor waarbij er als typen life genomen wordt met waarde 1.
     */
    public CollectableComponent(){
        this.type = collectableType.life;
        this.value = 1;
    }

    public CollectableComponent(collectableType type, int value){
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
