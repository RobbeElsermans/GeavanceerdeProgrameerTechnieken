package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;

import java.util.List;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Een abstracte klasse van een big enemy entiteit. Deze big enemy entiteit kan bewegen en heeft een zeker leven.
 * <p>
 * De big enemy zal bij bepaalde evenementen, bovenaan het scherm overvliegen.
 * Wanneer een speler deze enemy raakt, krijgt de enemy meer punten dan bij een gewone enemy.
 * De enemy zal telkens in het spel komen in de inverse richting (togglen).
 * <p>
 * Wanneer men deze entity wilt implementeren, moet men de visualize methode overerven van IVisualize.
 * Deze methode wordt gebruikt om de entiteit af te beelden.
 * @see IVisualize
 * @see be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement.BigEnemyMovementSystem BigEnemyMovementSystem
 * @see be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.EntityCleanupSystem EntityCleanupSystem
 * @see be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.EntityCreationSystem#bigEnemyCreation(List, List, AFactory, IDimension, IDimension) bigEnemyCreation(List, List, AFactory, IDimension, IDimension)
 */
public abstract class ABigEnemyEntity implements IVisualize {
    /*
     * De entiteit kan bewegen.
     */
    private final MovementComponent movementComponent;

    /*
     * De entiteit kan leven.
     */
    private final LivableComponent livableComponent;

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param movementComponent De locatie en dimensie van de entiteit (in graphics-coordinates) met zijn snelheid en versnelling.
     * @param livableComponent  Het leven van de entiteit.
     * @see MovementComponent
     * @see LivableComponent
     */
    public ABigEnemyEntity(MovementComponent movementComponent, LivableComponent livableComponent) {
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
}
