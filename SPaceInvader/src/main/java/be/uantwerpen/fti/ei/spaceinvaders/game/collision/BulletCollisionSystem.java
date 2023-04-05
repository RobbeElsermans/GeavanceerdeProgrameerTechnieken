package be.uantwerpen.fti.ei.spaceinvaders.game.collision;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.StaticComponent;

/**
 * Een bullet collision systeem waarbij elke collision van de bullet met een entiteit gechecked wordt en de juiste actie uitgevoerd.
 */
public class BulletCollisionSystem {
    /**
     * Bekijkt bullet met een Movable Entiteit.
     *
     * @param mc1 MovementComponent van de bullet.
     * @param mc2 MovementComponent van de entiteit.
     * @return true als de bullet collided is met de gegeven entiteit. Anders false.
     */
    public static boolean bulletEntityCollision(MovementComponent mc1, MovementComponent mc2) {
        if (EntityCollision.entityCollision(mc1, mc2)) {
            mc1.setVelocity(0);
            return true;
        }
        return false;
    }

    /**
     * Bekijkt bullet met een Statische Entiteit.
     *
     * @param mc MovementComponent van de bullet.
     * @param sc StaticComponent van de entiteit.
     * @return true als de bullet collided is met de gegeven statische entiteit. Anders false.
     * @implNote We converteren StaticComponent naar MovableComponent om dezelfde collision methode te kunnen gebruiken.
     * TODO: Nog omzetten zodat dit niet is.
     */
    public static boolean bulletEntityCollision(MovementComponent mc, StaticComponent sc) {
        //Converteer static naar movable
        //TODO: wegwerken door betere conversie of meer structuur in componenten te brengen.
        MovementComponent temp = new MovementComponent(sc.getPosition(), sc.getDimension(), 0, 0);

        if (EntityCollision.entityCollision(mc, temp)) {
            mc.setVelocity(0);
            return true;
        }
        return false;
    }
}
