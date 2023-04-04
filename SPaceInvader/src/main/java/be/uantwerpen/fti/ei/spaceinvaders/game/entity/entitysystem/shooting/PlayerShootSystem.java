package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting;

import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;


public class PlayerShootSystem extends GlobalShootSystem {
    double intervalNs;
    double nextIntervalNS;
    double remainingIntervalTime;
    boolean hasFire;

    public PlayerShootSystem(){
        this.intervalNs = 500000000;
        this.nextIntervalNS = System.nanoTime() + intervalNs;
        this.remainingIntervalTime = 0;
        this.hasFire = false;
    }

    /**
     * Zal kijken of dat er geschoten moet worden of niet.
     * @param input
     */
    public boolean checkShoot(IInput input){
        remainingIntervalTime += nextIntervalNS - System.nanoTime();
        remainingIntervalTime /= 1000;

        if(input.inputAvailable() && input.isShoot() && remainingIntervalTime <=0 && !hasFire){//Als er input aanwezig is & er is geschoten & (de timer is afgelopen of er is nog niet geschoten)
            nextIntervalNS +=intervalNs;
            hasFire = true;
            //System.out.println("if1: timer: " + String.valueOf(remainingIntervalTime/1000000) + "\t\t to: " + String.valueOf((nextIntervalNS - System.nanoTime())/1000000) + "\t\t hasFire: "+ hasFire);
            return true;
        }
        else if(input.inputAvailable() && !input.isShoot() && remainingIntervalTime <=0 && hasFire){
            hasFire = false;
            nextIntervalNS +=intervalNs;
            //System.out.println("if2: timer: " + String.valueOf(remainingIntervalTime/1000000) + "\t\t to: " + String.valueOf((nextIntervalNS - System.nanoTime())/1000000) + "\t\t hasFire: "+ hasFire);
        }
        else if(remainingIntervalTime <= 0){
            hasFire = false;
            nextIntervalNS +=intervalNs;
            //System.out.println("if3: timer: " + String.valueOf(remainingIntervalTime/1000000) + "\t\t to: " + String.valueOf((nextIntervalNS - System.nanoTime())/1000000) + "\t\t hasFire: "+ hasFire);
        }
        return false;
    }
}

