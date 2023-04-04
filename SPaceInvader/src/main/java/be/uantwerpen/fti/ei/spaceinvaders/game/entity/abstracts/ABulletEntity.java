package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;

public abstract class ABulletEntity implements IVisualize {
    /**
     * De entiteit kan bewegen
     */
    MovementComponent movementComponent;

    /**
     * De entiteit kan leven
     */
    LivableComponent livableComponent;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public ABulletEntity(){
        setMovementComponent(new MovementComponent());
        setLivableComponent(new LivableComponent());
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     */
    public ABulletEntity(MovementComponent movementComponent, LivableComponent livableComponent){
        setMovementComponent(movementComponent);
        setLivableComponent(livableComponent);
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

    @Override
    public String toString() {
        return "ABulletEntity{" +
                "movementComponent=" + movementComponent +
                ", livableComponent=" + livableComponent +
                '}';
    }
}
