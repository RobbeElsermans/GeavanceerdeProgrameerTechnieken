package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Een component dat een leven bevat.
 * <p>
 * Deze component kan gebruikt worden wanneer iets een eindigende state heeft die zichzelf kan verhogen of verlagen.
 */
public class LivableComponent {
    /**
     * Het leven van een leefbare entiteit. Standaard is dit 1.
     */
    private int life;

    /**
     * Default constructor waarbij:
     * <ul>
     *     <li>life  -> 1</li>
     * </ul>
     */
    public LivableComponent() {
        this.life = 1;
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param life Het leven van de entiteit.
     */
    public LivableComponent(int life) {
        this.life = life;
    }

    public int getLife() {
        return this.life;
    }

    /**
     * We vermeerderen het leven met 1.
     */
    public void upLife() {
        this.life += 1;
    }

    /**
     * We sommeren amount met het huidige leven.
     */
    public void upLifeByAmount(int amount) {
        this.life += amount;
    }

    /**
     * We verminderen het leven met 1.
     */
    public void downLife() {
        this.life -= 1;
    }

    /**
     * We trekken amount af van het huidige leven.
     * <p>
     * Het leven kan niet onder 0 zakken en zal altijd 0 zijn wanneer men hier onder gaat.
     */
    public void downLifeByAmount(int amount) {
        if (this.life - amount < 0)
            this.life = 0;
        else
            this.life -= amount;
    }

    @Override
    public String toString() {
        return "LivableComponent{" +
                "life=" + life +
                '}';
    }
}
