package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.ShootingComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.StatisticsComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;

/**
 * Een player entiteit dat overerft van livable & movable entiteit.
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
     * @param movementComponent De locatie en dimensie van de entiteit met zijn snelheid en versnelling.
     * @param livableComponent  Het leven van de entiteit.
     */
    public APlayerEntity(MovementComponent movementComponent, LivableComponent livableComponent) {
        this.movementComponent = movementComponent;
        this.livableComponent = livableComponent;
        this.statisticsComponent = new StatisticsComponent();
        this.shootingComponent = new ShootingComponent();
    }

    public MovementComponent getMovementComponent() {
        return movementComponent;
    }

    public LivableComponent getLivableComponent() {
        return livableComponent;
    }

    public StatisticsComponent getStatisticsComponent() {
        return statisticsComponent;
    }

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