package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents;

/**
 * Een component dat een leven bevat.
 */
public class LivableComponent{
    /**
     * Het leven van een leefbare entiteit. Standaard is dit 1.
     */
    private int life;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public LivableComponent() {
        super();
       this.life = 1;
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     * @param life      Het leven van de entiteit.
     */
    public LivableComponent(int life) {
        this.life = life;
    }
    public int getLife(){
        return this.life;
    }
    public void upLife(){
        this.life += 1;
    }
    public void upLifeByAmount(int amount){
        this.life += amount;
    }
    public void downLife(){
        this.life -= 1;
    }
    public void downLifeByAmount(int amount){
        if(this.life - amount < 0)
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
