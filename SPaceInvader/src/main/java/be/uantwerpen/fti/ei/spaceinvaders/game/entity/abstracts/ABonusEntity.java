package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.CollectableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;

public abstract class ABonusEntity implements IVisualize {
    /**
     * De entiteit kan bewegen
     */
    private final MovementComponent movementComponent;

    /**
     * De entiteit heeft een collectable
     */
    private final CollectableComponent collectableComponent;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public ABonusEntity(){
        this.movementComponent = new  MovementComponent();
        this.collectableComponent = new CollectableComponent();
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param movementComponent    De locatie en dimensie van de entiteit met zijn snelheid en versnelling.
     * @param collectableComponent Het soort collectable van de entiteit.
     */
    public ABonusEntity(MovementComponent movementComponent, CollectableComponent collectableComponent){
        this.movementComponent = movementComponent;
        this.collectableComponent = collectableComponent;
    }

    public MovementComponent getMovementComponent() {
        return movementComponent;
    }
    public CollectableComponent getCollectableComponent() {
        return collectableComponent;
    }
}
