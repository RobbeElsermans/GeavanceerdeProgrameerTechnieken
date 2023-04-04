package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.CollectableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;

public abstract class ABonusEntity implements IVisualize  {
    /**
     * De entiteit kan bewegen
     */
    MovementComponent movementComponent;

    /**
     * De entiteit kan leven
     */
    LivableComponent livableComponent;

    /**
     * De entiteit heeft een collectable
     */
    CollectableComponent collectableComponent;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public ABonusEntity(){
        this.movementComponent = new  MovementComponent();
        this.livableComponent = new LivableComponent();
        this.collectableComponent = new CollectableComponent();
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     */
    public ABonusEntity(MovementComponent movementComponent, LivableComponent livableComponent, CollectableComponent collectableComponent){
        this.movementComponent = movementComponent;
        this.livableComponent = livableComponent;
        this.collectableComponent = collectableComponent;
    }

    public MovementComponent getMovementComponent() {
        return movementComponent;
    }
    public LivableComponent getLivableComponent() {
        return livableComponent;
    }
    public CollectableComponent getCollectableComponent() {
        return collectableComponent;
    }
}
