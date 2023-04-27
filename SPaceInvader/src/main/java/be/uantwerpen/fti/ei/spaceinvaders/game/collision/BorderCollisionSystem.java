package be.uantwerpen.fti.ei.spaceinvaders.game.collision;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;

import java.util.List;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Een collision systeem die de taak krijgt om de collisions met de graphics-systeem grenzen te checken en
 * hiermee de entiteit de correcte locatie en velocity toe kan geven zodat ze niet uit het veld verdwijnen.
 * <p>
 * De methodes zijn static omdat ze geen waardes moeten opslaan.
 * <p>
 * We gaan ervan uit dat de coördinaten van het spel, in de links boven hoek starten op [0,0].
 * @see BorderCollision
 * @see Edge
 * @see MovementComponent
 */
public class BorderCollisionSystem {
    /**
     * Dedicated methoden om een borderCollision te detecteren van een entiteit en hierbij een correcte actie uit te voeren.
     * <p>
     * We gebruiken de gameDimension in BorderCollision om de speler op een collision
     * te detecteren en het MovementComponent samen met de gameDimension om de entiteit op de juiste plaats te plaatsen.
     * Bij een collision, plaatsen we de velocity in MovementComponent op 0.
     * <p>
     * Er wordt naar alle kanten gekeken.
     *
     * @param bc Een BorderCollision object met een ingestelde gameDimensions.
     * @param mc Een MovementComponent die de beweegbare data van de player bijhoudt.
     */
    public static void checkBorderCollision(BorderCollision bc, MovementComponent mc) {
        checkCollision(bc, mc, Edge.LEFT, 0);
        checkCollision(bc, mc, Edge.RIGHT, (int) ((bc.gameDimensions().getWidth()) - mc.getDimension().getWidth()));
        checkCollision(bc, mc, Edge.TOP, 0);
        checkCollision(bc, mc, Edge.BOTTOM, (int) (bc.gameDimensions().getHeight() - mc.getDimension().getHeight()));
    }

    /**
     * Dedicated methoden om een borderCollision te detecteren van een player en hierbij een correcte actie uit te voeren.
     * <p>
     * We gebruiken de gameDimension in BorderCollision om de speler op een collision
     * te detecteren en het MovementComponent samen met de gameDimension om de entiteit op de juiste plaats te plaatsen.
     * Bij een collision, plaatsen we de velocity in MovementComponent op 0.
     * <p>
     * Deze functie kijkt enkel links en rechts.
     *
     * @param bc Een BorderCollision object met een ingestelde gameDimensions.
     * @param mc Een MovementComponent die de beweegbare data van de player bijhoudt.
     */
    public static void checkBorderCollisionPlayer(BorderCollision bc, MovementComponent mc) {
        checkCollision(bc, mc, Edge.LEFT, 0);
        checkCollision(bc, mc, Edge.RIGHT, (int) ((bc.gameDimensions().getWidth()) - mc.getDimension().getWidth()));
    }

    /**
     * Dedicated methoden om een borderCollision te detecteren van een lijst van enemy's en
     * hierbij een correcte actie uit te voeren.
     * <p>
     * We gebruiken de gameDimension in BorderCollision om een enemy op een collision
     * te detecteren en het MovementComponent samen met de gameDimension om de entiteit op de juiste plaats te plaatsen.
     * Bij een collision, plaatsen we de velocity in MovementComponent op 0.
     * <p>
     * Deze functie kijkt enkel links en rechts.
     * <p>
     * Het is belangrijk om elke enemy mee te geven in deze border collision check.
     * Wanneer namelijk 1 enemy een rand raakt, moeten alle enemy's mee bewegen naar de andere kant.
     * We moeten dus elke enemy kunnen corrigeren wanneer er 1 enemy tegen een rand komt.
     *
     * @param bc  Een BorderCollision object met een ingestelde gameDimensions.
     * @param mcl Een lijst van MovementComponent die de beweegbare data van de enemy's bijhoudt.
     */
    public static void checkBorderCollisionEnemy(BorderCollision bc, List<MovementComponent> mcl) {
        boolean hasCollideLeft = false;
        boolean hasCollideRight = false;
        for (MovementComponent mc : mcl) {
            if (bc.checkBorderCollision(mc)[Edge.LEFT.getValue()]) {
                // if left collision.
                //mc.setX(0);
                hasCollideLeft = true;
                break;
            }
            if (bc.checkBorderCollision(mc)[Edge.RIGHT.getValue()]) {
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
    }

    /**
     * Dedicated methoden om een borderCollision te detecteren van een bullet en hierbij een correcte actie uit te voeren.
     * <p>
     * We gebruiken de gameDimension in BorderCollision om de bullet op een collision
     * te detecteren en het MovementComponent samen met de gameDimension om de entiteit op de juiste plaats te plaatsen.
     * Bij een collision, plaatsen we de velocity in MovementComponent op 0.
     * <p>
     * Deze functie kijkt enkel boven en onder.
     *
     * @param bc Een BorderCollision object met een ingestelde gameDimensions.
     * @param mc Een MovementComponent die de beweegbare data van de bullet bijhoudt.
     */
    public static void checkBorderCollisionBullet(BorderCollision bc, MovementComponent mc) {
        checkCollision(bc, mc, Edge.TOP, 0);
        checkCollision(bc, mc, Edge.BOTTOM, (int) (bc.gameDimensions().getHeight() - mc.getSpeed() * Math.abs(mc.getDefaultVelocity())));
    }

    /**
     * Dedicated methoden om een borderCollision te detecteren van een big enemy en hierbij een correcte actie uit te voeren.
     * <p>
     * We gebruiken de gameDimension in BorderCollision om de big enemy op een collision
     * te detecteren en het MovementComponent samen met de gameDimension om de entiteit op de juiste plaats te plaatsen.
     * Bij een collision, plaatsen we de velocity in MovementComponent op 0.
     * <p>
     * Deze functie kijkt enkel links en rechts.
     *
     * @param bc Een BorderCollision object met een ingestelde gameDimensions.
     * @param mc Een MovementComponent die de beweegbare data van een big enemy bijhoudt.
     */
    public static void checkBorderCollisionBigEnemy(BorderCollision bc, MovementComponent mc) {
        checkCollision(bc, mc, Edge.LEFT, 0);
        checkCollision(bc, mc, Edge.RIGHT, (int) ((bc.gameDimensions().getWidth()) - mc.getDimension().getWidth()));
    }

    /**
     * Dedicated methoden om een borderCollision te detecteren van een bonus en hierbij een correcte actie uit te voeren.
     * <p>
     * We gebruiken de gameDimension in BorderCollision om de bonus op een collision
     * te detecteren en het MovementComponent samen met de gameDimension om de entiteit op de juiste plaats te plaatsen.
     * Bij een collision, plaatsen we de velocity in MovementComponent op 0.
     * <p>
     * Deze functie kijkt enkel onder.
     *
     * @param bc Een BorderCollision object met een ingestelde gameDimensions.
     * @param mc Een MovementComponent die de beweegbare data van een big enemy bijhoudt.
     */
    public static void checkBorderCollisionBonus(BorderCollision bc, MovementComponent mc) {
        checkCollision(bc, mc, Edge.BOTTOM, (int) (bc.gameDimensions().getHeight() - mc.getSpeed() * Math.abs(mc.getDefaultVelocity())));
    }

    /**
     * Een refactor methode om minder code te schrijven.
     * <p>
     * De methode zal kijken of dat er een collision is, en hierop de juiste actie uit voeren
     *
     * @param bc       Een BorderCollision object met een ingestelde gameDimensions.
     * @param mc       Een MovementComponent die de beweegbare data van een big enemy bijhoudt.
     * @param edge     Welke Edge er bekeken moet worden.
     * @param resetVal Wanneer er een collision is, met welke waarde we de positie willen wijzigen.
     */
    private static void checkCollision(BorderCollision bc, MovementComponent mc, Edge edge, int resetVal) {
        if (bc.checkBorderCollision(mc)[edge.getValue()]) {

            if (edge == Edge.LEFT || edge == Edge.RIGHT)
                mc.setX(resetVal);
            if (edge == Edge.TOP || edge == Edge.BOTTOM)
                mc.setY(resetVal);

            mc.setVelocity(0);
        }
    }
}
