package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting;

public class EnemyShootSystem extends GlobalShootSystem{
    private int diff;
    public EnemyShootSystem(){
        diff = 1;
    }

    /**
     *
     * @param diff duid de moeilijkheid aan. Hoe hoger, hoe moeilijker.
     */
    public EnemyShootSystem(int diff){
        this.diff = diff;
    }
    public boolean checkShoot() {
        //Math.floor(Math.random() *(max - min + 1) + min)
        int randomTime = (int) (Math.random() * (2000/diff));
        if(randomTime == 3)
            return true;
        return false;
    }
}