package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.StatisticsComponent;

import java.util.ArrayList;
import java.util.List;

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
     * De entiteit bevat statistiek waardes.
     */
    private final StatisticsComponent statisticsComponent;

    /**
     * De entiteit bevat kogels.
     */
    private final List<ABulletEntity> bulletList;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public APlayerEntity(){//Insert de input
        setMovementComponent(new MovementComponent());
        setLivableComponent(new LivableComponent());
        this.statisticsComponent = new StatisticsComponent();
        this.bulletList = new ArrayList<>();
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     */
    public APlayerEntity(MovementComponent movementComponent, LivableComponent livableComponent){
        setMovementComponent(movementComponent);
        setLivableComponent(livableComponent);
        this.statisticsComponent = new StatisticsComponent();
        this.bulletList = new ArrayList<>();
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
    public StatisticsComponent getStatisticsComponent() {
        return statisticsComponent;
    }

    public List<ABulletEntity> getBulletList() {
        return bulletList;
    }

    @Override
    public String toString() {
        return "APlayerEntity{" +
                "movementComponent=" + movementComponent.toString() +
                ", livableComponent=" + livableComponent.toString() +
                ", statisticsComponent=" + statisticsComponent.toString() +
                ", bulletList=" + bulletList.size() +
                '}';
    }
}