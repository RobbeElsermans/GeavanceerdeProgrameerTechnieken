package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;

/**
 * Een abstracte implementatie van een bullet entiteit. Deze bullet entiteit kan bewegen en heeft een zeker leven.
 *
 * @implNote Het leven van de bullet entiteit wordt gebruikt om schaden aan te richten.
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
     */
    public ABulletEntity() {
        this.movementComponent = new MovementComponent();
        this.livableComponent = new LivableComponent();
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param movementComponent De locatie en dimensie van de entiteit met zijn snelheid en versnelling.
     * @param livableComponent  Het leven van de entiteit.
     */
    public ABulletEntity(MovementComponent movementComponent, LivableComponent livableComponent) {
        this.movementComponent = movementComponent;
        this.livableComponent = livableComponent;
    }

    public MovementComponent getMovementComponent() {
        return movementComponent;
    }

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
