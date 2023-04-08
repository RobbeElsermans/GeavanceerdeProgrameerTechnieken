package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.CollectableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;

import java.util.List;

/**
 * Een abstracte klasse voor een bonus.
 * <p>
 * Deze zorgt voor bonussen die de speler kan opnemen.
 * Een ABonusEntity kan bewegen en heeft een bepaalde collectable.
 * De bonus zal bij bepaalde evenementen, vanaf een random locatie, bovenaan het scherm naar beneden vallen.
 * <p>
 * Wanneer men deze entity wilt implementeren, moet men de visualize methode overerven van IVisualize.
 * Deze methode wordt gebruikt om de entiteit af te beelden.
 *
 * @see IVisualize
 * @see be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement.BonusMovementSystem BonusMovementSystem
 * @see be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.EntityCleanupSystem EntityCleanupSystem
 * @see be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.EntityCreationSystem#bonusCreation(List, List, AFactory, IDimension, IDimension) bonusCreation(List, List, AFactory, IDimension, IDimension)
 */
public abstract class ABonusEntity implements IVisualize {
    /*
     * De entiteit kan bewegen
     */
    private final MovementComponent movementComponent;

    /*
     * De entiteit heeft een collectable
     */
    private final CollectableComponent collectableComponent;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     * <p>
     * De default parameters zijn terug te vinden in MovementComponent en CollectableComponent.
     *
     * @see MovementComponent
     * @see CollectableComponent
     */
    public ABonusEntity() {
        this.movementComponent = new MovementComponent();
        this.collectableComponent = new CollectableComponent();
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param movementComponent    De locatie en dimensie van de entiteit (in graphics-coordinates) met zijn snelheid en versnelling.
     * @param collectableComponent Het soort collectable van de entiteit.
     * @see MovementComponent
     * @see CollectableComponent
     */
    public ABonusEntity(MovementComponent movementComponent, CollectableComponent collectableComponent) {
        this.movementComponent = movementComponent;
        this.collectableComponent = collectableComponent;
    }

    /**
     * @return De movementComponent van de entiteit.
     */
    public MovementComponent getMovementComponent() {
        return movementComponent;
    }

    /**
     * @return De collectableComponent van de entiteit.
     */
    public CollectableComponent getCollectableComponent() {
        return collectableComponent;
    }
}
