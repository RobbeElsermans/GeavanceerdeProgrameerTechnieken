package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.ShootingComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.StatisticsComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Een player entiteit dat overerft van livable & movable entiteit.
 * <p>
 * Wanneer men deze entity wilt implementeren, moet men de visualize methode overerven van IVisualize.
 * Deze methode wordt gebruikt om de entiteit af te beelden.
 *
 * @see IVisualize
 * @see be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement.PlayerMovementSystem PlayerMovementSystem
 * @see be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting.PlayerShootSystem PlayerShootSystem
 * @see be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.AInputController AInputController
 * @see be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput IInput
 */
public abstract class APlayerEntity implements IVisualize {
    /**
     * De entiteit kan bewegen.
     */
    private final MovementComponent movementComponent;
    /**
     * De entiteit kan leven.
     */
    private final LivableComponent livableComponent;

    /**
     * De entiteit bevat statistiek waardes.
     */
    private final StatisticsComponent statisticsComponent;

    /**
     * De entiteit kan schieten.
     */
    private final ShootingComponent shootingComponent;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     * <p>
     * De default parameters zijn terug te vinden in MovementComponent, LivableComponent, ShootingComponent, StatisticsComponent.
     *
     * @see MovementComponent
     * @see LivableComponent
     * @see ShootingComponent
     * @see StatisticsComponent
     */
    public APlayerEntity() {//Insert de input
        this.movementComponent = new MovementComponent();
        this.livableComponent = new LivableComponent();
        this.statisticsComponent = new StatisticsComponent();
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
     * @see StatisticsComponent
     */
    public APlayerEntity(MovementComponent movementComponent, LivableComponent livableComponent) {
        this.movementComponent = movementComponent;
        this.livableComponent = livableComponent;
        this.statisticsComponent = new StatisticsComponent();
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
     * @return De statisticsComponent van de entiteit.
     */
    public StatisticsComponent getStatisticsComponent() {
        return statisticsComponent;
    }

    /**
     * @return De shootingComponent van de entiteit.
     */
    public ShootingComponent getShootingComponent() {
        return shootingComponent;
    }

    @Override
    public String toString() {
        return "APlayerEntity{" +
                "movementComponent=" + movementComponent.toString() +
                ", livableComponent=" + livableComponent.toString() +
                ", statisticsComponent=" + statisticsComponent +
                ", shootingComponent=" + shootingComponent +
                '}';
    }
}