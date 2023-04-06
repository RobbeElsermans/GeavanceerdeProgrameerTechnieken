package be.uantwerpen.fti.ei.spaceinvaders.game.collision;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;

import java.util.List;

/**
 * Een collision systeem die de taak krijgt om de collisions met de game grenzen te checken en
 * hiermee de entiteit de correcte locatie en velocity kan geven.
 */
public class BorderCollisionSystem {
    /**
     * Dedicated methoden om een borderCollision te detecteren van een speler en hierbij een correcte actie uit te voeren.
     *
     * @param bc Een BorderCollision object met een ingestelde gameBorder.
     * @param mc Een MovementComponent die de data van de player bijhoudt.
     * @implNote Deze functie kijkt enkel links, rechts, boven en onder.
     */
    public static void checkBorderCollisionPlayer(BorderCollision bc, MovementComponent mc) {

        if (bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(1)) {
            // if left collision.
            mc.setX(0);
            mc.setVelocity(0);
            //TODO: Wat als het spel niet in 0 start?
        }
        if (bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(3)) {
            // if right collision.
            mc.setX((int) ((bc.getGameDimensions().getWidth()) - mc.getDimension().getWidth()));
            mc.setVelocity(0);
        }

        if (bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(0)) {
            // if top collision.
            mc.setY(0);
            mc.setVelocity(0);
            //TODO: Wat als het spel niet in 0 start?
        }

        if (bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(2)) {
            // if bottom collision.
            mc.setY((int) (bc.getGameDimensions().getHeight() - mc.getDimension().getHeight()));
            mc.setVelocity(0);
        }
    }

    /**
     * Dedicated methoden om een borderCollision te detecteren van een enemy en hierbij een correcte actie uit te voeren.
     *
     * @param bc  Een BorderCollision object met een ingestelde gameBorder.
     * @param mcl Een lijst van MovementComponents die de data van de enemy's bijhoudt.
     * @implNote Mcl is een lijst van alle MovementComponents van de enemy's.
     * Hiermee kunnen we al de enemy's corrigeren als er 1 enemy te ver is gegaan.
     * Deze functie kijkt enkel links en rechts.
     */
    public static void checkBorderCollisionEnemy(BorderCollision bc, List<MovementComponent> mcl) {
        boolean hasCollideLeft = false;
        boolean hasCollideRight = false;
        for (MovementComponent mc : mcl) {
            if (bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(1)) {
                // if left collision.
                //mc.setX(0);
                hasCollideLeft = true;
                break;
            }
            if (bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(3)) {
                // if right collision.
                //mc.setX(bc.getGameDimensions().getWidth() - (mc.getDimension().getWidth() + (mc.getSpeed())));
                hasCollideRight = true;
                break;
            }
        }

        //Als 1 enemy ergens is tegen gebotst, plaats alle enemy's op velocity 0.
        if (hasCollideLeft || hasCollideRight) {
            mcl.forEach(i -> i.setVelocity(0));
        }

        /*
        if(hasCollideRight){
            //fix alle entiteiten want deze zijn te ver bewogen.
            //mc.setX(bc.getGameDimensions().getWidth() - (mc.getDimension().getWidth() + (mc.getSpeed())));
            //mcl.forEach(mc -> mc.setX((int) ((mc.getX()) - mc.getSpeed()*Math.abs(mc.getDefaultVelocity()))));
        }
        */

    }

    /**
     * Dedicated methoden om een borderCollision te detecteren van een bullet en hierbij een correcte actie uit te voeren.
     *
     * @param bc Een BorderCollision object met een ingestelde gameBorder.
     * @param mc Een MovementComponent die de data van de bullet bijhoudt.
     * @implNote Deze functie kijkt enkel boven en onder.
     */
    public static void checkBorderCollisionBullet(BorderCollision bc, MovementComponent mc) {
        if (bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(0)) {
            // if top collision.
            mc.setY(0);
            mc.setVelocity(0);
        }
        if (bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(2)) {
            // if bottom collision.
            mc.setY((int) (bc.getGameDimensions().getHeight() - mc.getSpeed() * Math.abs(mc.getDefaultVelocity())));
            mc.setVelocity(0);
        }
    }

    /**
     * Dedicated methoden om een borderCollision te detecteren van een Bonus en hierbij een correcte actie uit te voeren.
     *
     * @param bc Een BorderCollision object met een ingestelde gameBorder.
     * @param mc Een MovementComponent die de data van de Bonus bijhoudt.
     * @implNote Deze functie kijkt enkel links en rechts.
     */
    public static void checkBorderCollisionBigEnemy(BorderCollision bc, MovementComponent mc) {
        if (bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(1)) {
            // if left collision.
            mc.setX(0);
            mc.setVelocity(0);
        }
        if (bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(3)) {
            // if right collision.
            mc.setX((int) ((bc.getGameDimensions().getWidth()) - mc.getDimension().getWidth()));
            mc.setVelocity(0);
        }
    }

    /**
     * Dedicated methoden om een borderCollision te detecteren van een Bonus en hierbij een correcte actie uit te voeren.
     *
     * @param bc Een BorderCollision object met een ingestelde gameBorder.
     * @param mc Een MovementComponent die de data van de bullet bijhoudt.
     * @implNote Deze functie kijkt enkel boven en onder.
     */
    public static void checkBorderCollisionBonus(BorderCollision bc, MovementComponent mc) {
        if (bc.checkBorderCollision(mc.getPosition(), mc.getDimension()).get(2)) {
            // if bottom collision.
            mc.setY((int) (bc.getGameDimensions().getHeight() - mc.getSpeed() * Math.abs(mc.getDefaultVelocity())));
            mc.setVelocity(0);
        }
    }
}
