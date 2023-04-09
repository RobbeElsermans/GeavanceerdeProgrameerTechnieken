package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting;

import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

/**
 * Dedicated ShootSysteem voor een player entiteit.
 * <p>
 * Hierin staan 2 mogelijke schiet systemen.
 * Een systeem dat enkel kijkt of dat IInput aangeeft dat er geschoten moet worden,
 * of een systeem waarbij er met een interval gewerkt wordt.
 * <p>
 * Dit systeem kan aangezet worden door de juiste constructor aan te roepen.
 *
 * @see GlobalShootSystem
 */
public class PlayerShootSystem extends GlobalShootSystem {
    //Wat parameters zodat een player niet constant kan vuren maar in een tijdsinterval.
    /*
     * Het interval in nanoseconden waarop men wacht. Default is dit 500 ms (500000000 ns).
     */
    double intervalNs = 500000000;
    /*
     * Het volgende interval.
     */
    double nextIntervalNS;
    /*
     * De resterende tijd.
     */
    double remainingIntervalTime;
    /*
     * Kijken of dat een speler al gevuurd heeft.
     */
    boolean hasFire;

    /*
     * Ofdat we met een interval schieten of niet.
     */
    private final boolean withInterval;

    /**
     * Default constructor waarbij:
     * <ul>
     *     <li>withInterval -> false</li>
     * </ul>
     * Hier wordt er niet met het interval gewerkt.
     */
    public PlayerShootSystem() {
        withInterval = false;
    }

    /**
     * Overload constructor waarbij er wel gewerkt wordt met een interval.
     *
     * @param intervalNs Het interval uitgedrukt in nanoseconden.
     * @deprecated geeft error op sound. LineUnavailableException.
     */
    public PlayerShootSystem(int intervalNs) {
        this.withInterval = true;
        this.intervalNs = intervalNs;
        this.nextIntervalNS = System.nanoTime() + intervalNs;
        this.remainingIntervalTime = 0;
        this.hasFire = false;
    }

    /**
     * Zal kijken of dat er geschoten moet worden of niet d.m.v. een IInput.
     * <p>
     * Wanneer <b>withInterval</b> true is, gaan we met een interval werken. Anders niet.
     * @param input De input controller van de entiteit.
     * @return True als er geschoten mag worden. Anders false.
     */
    public boolean checkShoot(IInput input) {
        //Als er input aanwezig is & er is geschoten & (de timer is afgelopen of er is nog niet geschoten)
        if (withInterval) {
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
        } else {
            return input.inputAvailable() && input.isShoot();
        }
        return false;
    }
}