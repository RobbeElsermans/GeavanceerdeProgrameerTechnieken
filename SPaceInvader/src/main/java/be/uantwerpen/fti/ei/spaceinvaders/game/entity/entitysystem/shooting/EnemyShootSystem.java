package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting;

import be.uantwerpen.fti.ei.spaceinvaders.game.Random;

/**
 * Dedicated ShootSysteem voor een enemy entiteit.
 */
public class EnemyShootSystem extends GlobalShootSystem {
    /**
     * De difficulty van een enemy shoot systeem. Standaard is dit 1.
     */
    private int diff;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public EnemyShootSystem() {
        diff = 1;
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param diff duid de moeilijkheid aan. Hoe hoger, hoe moeilijker.
     */
    public EnemyShootSystem(int diff) {
        this.diff = diff;
    }

    /**
     * Een functie die bepaald wanneer een enemy mag schieten.
     * @return  True als de enemy mag schieten. Anders false.
     */
    public boolean checkShoot() {
        return Random.getRandom(2000/diff) == 3;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }
}