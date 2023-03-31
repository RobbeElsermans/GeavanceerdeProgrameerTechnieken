package be.uantwerpen.fti.ei.spaceinvaders.game.entitysystem;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABulletEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Position;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.ShootComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

import java.util.ArrayList;
import java.util.List;

public class PlayerShootSystem {
    static double intervalNs = 500000000; //0.5seconden
    static double nextIntervalNS = System.nanoTime() + intervalNs;
    static double remainingIntervalTime = 0;
    static boolean hasFire = false;
    public static boolean checkShoot(IInput input){
        remainingIntervalTime += nextIntervalNS - System.nanoTime();
        remainingIntervalTime /= 1000;

        if(input.inputAvailable() && input.isShoot() && remainingIntervalTime <=0 && !hasFire){//Als er input aanwezig is & er is geschoten & (de timer is afgelopen of er is nog niet geschoten)
            nextIntervalNS +=intervalNs;
            hasFire = true;
            return true;
        }
        else if(remainingIntervalTime <=0 && hasFire){
            hasFire = false;
            nextIntervalNS +=intervalNs;
        }
        else if(remainingIntervalTime <= 0){
            nextIntervalNS +=intervalNs;
        }

        System.out.println("timer: " + String.valueOf(remainingIntervalTime/1000000) + "\t\t to: " + String.valueOf((nextIntervalNS - System.nanoTime())/1000000));
        //TODO: fix dat er maar 1 bullet geschoten wordt
        // Als er meerdere toets slagen achter elkaar binnen komen, mogen we maar om de 500 ms een toets doorlaten.
        return false;
    }

    public static void doShoot(MovementComponent mc, ShootComponent sc, AFactory af){
        ABulletEntity tempBulletEntity = af.getBulletEntity(new Position(mc.getX()+(mc.getWidth()/2), mc.getY()), 2, 2, -1);
        sc.shoot(tempBulletEntity);
    }

    public static void doCleanup(ShootComponent sc){
        List<Integer> emptyBullets = new ArrayList<>();
        if(!sc.getBullets().isEmpty()){
             sc.getBullets().removeIf( b -> b.getMovementComponent().getVelocity()==0);
        }
    }
}

