package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.ShootingComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;

/**
 * Een abstracte implementatie van een enemy entiteit. Deze enemy entiteit kan bewegen en heeft een zeker leven.
 * De entiteit kan ook schieten.
 */
public abstract class AEnemyEntity implements IVisualize {
    /**
     * De entiteit kan bewegen.
     */
    private final MovementComponent movementComponent;
    /**
     * De entiteit kan leven.
     */
    private final LivableComponent livableComponent;

    /**
     * De entiteit kan schieten.
     */
    private final ShootingComponent shootingComponent;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public AEnemyEntity() {//Insert de input
        this.movementComponent = new MovementComponent();
        this.livableComponent = new LivableComponent();
        this.shootingComponent = new ShootingComponent();
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param movementComponent De locatie en dimensie van de entiteit met zijn snelheid en versnelling.
     * @param livableComponent  Het leven van de entiteit.
     */
    public AEnemyEntity(MovementComponent movementComponent, LivableComponent livableComponent) {
        this.movementComponent = movementComponent;
        this.livableComponent = livableComponent;
        this.shootingComponent = new ShootingComponent();
    }

    public MovementComponent getMovementComponent() {
        return movementComponent;
    }

    public LivableComponent getLivableComponent() {
        return livableComponent;
    }

    public ShootingComponent getShootingComponent() {
        return shootingComponent;
    }
}
