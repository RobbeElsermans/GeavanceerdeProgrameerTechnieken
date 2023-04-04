package be.uantwerpen.fti.ei.spaceinvaders.game.entitysystem.shooting;

import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

public class EnemyShootSystem extends GlobalShootSystem{
    public boolean checkShoot() {
        //Math.floor(Math.random() *(max - min + 1) + min)
        int randomTime = (int) (Math.random() * 500);
        if(randomTime == 3)
            return true;
        return false;
    }
}