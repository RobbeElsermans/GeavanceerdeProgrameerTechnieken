package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.ShootingComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Een abstracte implementatie van een enemy entiteit. Deze enemy entiteit kan bewegen en heeft een zeker leven.
 * De entiteit kan ook schieten.
 * <p>
 * De enemy entity wordt in een vast patroon opgesteld en bewogen. Per level is een ander patroon voorzien.
 * <p>
 * Wanneer men deze entity wilt implementeren, moet men de visualize methode overerven van IVisualize.
 * Deze methode wordt gebruikt om de entiteit af te beelden.
 *
 * @see IVisualize
 * @see be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement.EnemyMovementSystem EnemyMovementSystem
 * @see be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting.EnemyShootSystem EnEnemyShootSystem
 * @see be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.EntityCleanupSystem EntityCleanupSystem
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
     * <p>
     * De default parameters zijn terug te vinden in MovementComponent, LivableComponent, ShootingComponent.
     *
     * @see MovementComponent
     * @see LivableComponent
     * @see ShootingComponent
     */
    public AEnemyEntity() {//Insert de input
        this.movementComponent = new MovementComponent();
        this.livableComponent = new LivableComponent();
        this.shootingComponent = new ShootingComponent();
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param movementComponent De locatie en dimensie van de entiteit (in graphics-coordinates) met zijn snelheid en versnelling.
     * @param livableComponent  Het leven van de entiteit.
     * @see MovementComponent
     * @see LivableComponent
     * @see ShootingComponent
     */
    public AEnemyEntity(MovementComponent movementComponent, LivableComponent livableComponent) {
        this.movementComponent = movementComponent;
        this.livableComponent = livableComponent;
        this.shootingComponent = new ShootingComponent();
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

    /**
     * @return De shootingComponent van de entiteit.
     */
    public ShootingComponent getShootingComponent() {
        return shootingComponent;
    }
}
