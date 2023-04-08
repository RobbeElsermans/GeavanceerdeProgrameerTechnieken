package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting;

import be.uantwerpen.fti.ei.spaceinvaders.game.helper.Random;

/**
 * Dedicated ShootSysteem voor een enemy entiteit.
 * @see GlobalShootSystem
 */
public class EnemyShootSystem extends GlobalShootSystem {
    /**
     * De difficulty van een enemy shoot systeem. Standaard is dit 1.
     */
    private int diff;

    /**
     * Default constructor waarbij:
     * <ul>
     *     <li>diff -> 1</li>
     * </ul>
     */
    public EnemyShootSystem() {
        diff = 1;
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     * <p>
     * Hoe groter diff genomen is, hoe frequenter een enemy kan schieten.
     *
     * @param diff duid de moeilijkheid aan. Hoe hoger, hoe moeilijker.
     */
    public EnemyShootSystem(int diff) {
        this.diff = diff;
    }

    /**
     * Een functie die bepaald wanneer een enemy mag schieten.
     * <p>
     * Deze is random bepaald. De diff zal de maximale random waarde verlagen waardoor 
     * de kans dat een gezochte waarde, vaker voorkomt.
     * @return True als de enemy mag schieten. Anders false.
     * @see Random#getRandom(int)
     */
    public boolean checkShoot() {
        return Random.getRandom(2000 / diff) == 3;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }
}