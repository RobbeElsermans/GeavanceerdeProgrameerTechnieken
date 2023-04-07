package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting;

import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

/**
 * Dedicated ShootSysteem voor een player entiteit.
 */
public class PlayerShootSystem extends GlobalShootSystem {
    //Wat parameters zodat een player niet constant kan vuren maar in een tijdsinterval.
    /**
     * Het interval in nanoseconden waarop men wacht. Default is dit 500 ms (500000000 ns).
     */
    double intervalNs;
    /**
     * Het volgende interval.
     */
    double nextIntervalNS;
    /**
     * De resterende tijd.
     */
    double remainingIntervalTime;
    /**
     * Kijken of dat een speler al gevuurd heeft.
     */
    boolean hasFire;

    /**
     * Default constructor
     */
    public PlayerShootSystem() {
        /*
        this.intervalNs = 500000000;
        this.nextIntervalNS = System.nanoTime() + intervalNs;
        this.remainingIntervalTime = 0;
        this.hasFire = false;

         */
    }

    /**
     * Zal kijken of dat er geschoten moet worden of niet d.m.v. een IInput.
     *
     * @param input De inputcontroller van de entiteit.
     * @return True als er geschoten mag worden. Anders false.
     */
    public boolean checkShoot(IInput input) {
        //Als er input aanwezig is & er is geschoten & (de timer is afgelopen of er is nog niet geschoten)
        return input.inputAvailable() && input.isShoot();
    }
    /*
    public boolean checkShoot(IInput input) {
        remainingIntervalTime += nextIntervalNS - System.nanoTime();
        remainingIntervalTime /= 1000;

        if (input.inputAvailable() && input.isShoot() && remainingIntervalTime <= 0 && !hasFire) {//Als er input aanwezig is & er is geschoten & (de timer is afgelopen of er is nog niet geschoten)
            nextIntervalNS += intervalNs;
            hasFire = true;
            //System.out.println("if1: timer: " + String.valueOf(remainingIntervalTime/1000000) + "\t\t to: " + String.valueOf((nextIntervalNS - System.nanoTime())/1000000) + "\t\t hasFire: "+ hasFire);
            return true;
        } else if (input.inputAvailable() && !input.isShoot() && remainingIntervalTime <= 0 && hasFire) {
            hasFire = false;
            nextIntervalNS += intervalNs;
            //System.out.println("if2: timer: " + String.valueOf(remainingIntervalTime/1000000) + "\t\t to: " + String.valueOf((nextIntervalNS - System.nanoTime())/1000000) + "\t\t hasFire: "+ hasFire);
        } else if (remainingIntervalTime <= 0) {
            hasFire = false;
            nextIntervalNS += intervalNs;
            //System.out.println("if3: timer: " + String.valueOf(remainingIntervalTime/1000000) + "\t\t to: " + String.valueOf((nextIntervalNS - System.nanoTime())/1000000) + "\t\t hasFire: "+ hasFire);
        }
        return false;
    }

     */
}