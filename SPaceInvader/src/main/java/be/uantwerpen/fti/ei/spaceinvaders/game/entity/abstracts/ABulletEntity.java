package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Een abstracte implementatie van een bullet entiteit. Deze bullet entiteit kan bewegen en heeft een zeker leven.
 * <p>
 * Het leven van de bullet entiteit wordt gebruikt om schaden aan te richten aan een andere entiteit.
 * Het ABulletEntity wordt gebruikt door zowel de speler als de enemy om een kogel af te vuren.
 * Het enige verschil tussen beide is de velocity, speed en eventueel life (wat de schaden voorstelt).
 * <p>
 * Wanneer men deze entity wilt implementeren, moet men de visualize methode overerven van IVisualize.
 * Deze methode wordt gebruikt om de entiteit af te beelden.
 * @see IVisualize
 * @see be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement.BulletMovementSystem
 * @see be.uantwerpen.fti.ei.spaceinvaders.game.collision.BulletCollisionSystem
 */
public abstract class ABulletEntity implements IVisualize {
    /**
     * De entiteit kan bewegen
     */
    private final MovementComponent movementComponent;

    /**
     * De entiteit kan leven
     */
    private final LivableComponent livableComponent;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     * <p>
     * De default parameters zijn terug te vinden in MovementComponent en LivableComponent.
     *
     * @see MovementComponent
     * @see LivableComponent
     */
    public ABulletEntity() {
        this.movementComponent = new MovementComponent();
        this.livableComponent = new LivableComponent();
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param movementComponent De locatie en dimensie van de entiteit (in graphics-coordinates) met zijn snelheid en versnelling.
     * @param livableComponent  Het leven van de entiteit. Dit leven stelt de schaden voor dat een bullet kan aanrichten.
     * @see MovementComponent
     * @see LivableComponent
     */
    public ABulletEntity(MovementComponent movementComponent, LivableComponent livableComponent) {
        this.movementComponent = movementComponent;
        this.livableComponent = livableComponent;
    }

    /**
     * @return De movementComponent van de entiteit.
     */
    public MovementComponent getMovementComponent() {
        return movementComponent;
    }

    /**
     * @return De livableComponent van de entiteit.
     */
    public LivableComponent getLivableComponent() {
        return livableComponent;
    }

    @Override
    public String toString() {
        return "ABulletEntity{" +
                "movementComponent=" + movementComponent.toString() +
                ", livableComponent=" + livableComponent.toString() +
                '}';
    }
}
