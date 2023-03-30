package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.ShootComponent;

/**
 * Een player entiteit dat overerft van livable & movable entiteit.
 */
public abstract class APlayerEntity implements IVisualize {
    /**
     * De entiteit kan bewegen
     */
    MovementComponent movementComponent;
    /**
     * De entiteit kan leven
     */
    LivableComponent livableComponent;

    /**
     * De entiteit kan schieten
     */
    ShootComponent shootComponent;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public APlayerEntity(){//Insert de input
        setMovementComponent(new MovementComponent());
        setLivableComponent(new LivableComponent());
        setShootComponent(new ShootComponent());
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     */
    public APlayerEntity(MovementComponent movementComponent, LivableComponent livableComponent, ShootComponent shootComponent){
        setMovementComponent(movementComponent);
        setLivableComponent(livableComponent);
        setShootComponent(shootComponent);
    }
    public MovementComponent getMovementComponent() {
        return movementComponent;
    }

    public void setMovementComponent(MovementComponent movementComponent) {
        this.movementComponent = movementComponent;
    }
    public LivableComponent getLivableComponent() {
        return livableComponent;
    }

    public void setLivableComponent(LivableComponent livableComponent) {
        this.livableComponent = livableComponent;
    }

    public ShootComponent getShootComponent() {
        return shootComponent;
    }

    public void setShootComponent(ShootComponent shootComponent) {
        this.shootComponent = shootComponent;
    }
}