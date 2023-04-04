package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting;

public class EnemyShootSystem extends GlobalShootSystem{
    public boolean checkShoot() {
        //Math.floor(Math.random() *(max - min + 1) + min)
        int randomTime = (int) (Math.random() * 1000);
        if(randomTime == 3)
            return true;
        return false;
    }
}