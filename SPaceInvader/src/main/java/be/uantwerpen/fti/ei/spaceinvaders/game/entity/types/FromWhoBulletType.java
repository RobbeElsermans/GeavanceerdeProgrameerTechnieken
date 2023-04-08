package be.uantwerpen.fti.ei.spaceinvaders.game.entity.types;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Het typen kogel. Dit zorgt voor de richting van de kogel.
 */
public enum FromWhoBulletType {
    /**
     * ENEMY typen betekent dat de kogel van boven naar onder zal gaan (velocity = 1).
     */
    ENEMY,
    /**
     * PLAYER typen betekent dat de kogel van onder naar boven zal gaan (velocity = -1).
     */
    PLAYER
}
