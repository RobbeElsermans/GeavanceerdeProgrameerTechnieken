package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;

import java.util.ArrayList;
import java.util.List;

public abstract class AEnemyEntity  implements IVisualize {
    /**
     * De entiteit kan bewegen
     */
    MovementComponent movementComponent;
    /**
     * De entiteit kan leven
     */
    LivableComponent livableComponent;

    /**
     * De entiteit bevat kogels.
     */
    private final List<ABulletEntity> bulletList;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public AEnemyEntity(){//Insert de input
        setMovementComponent(new MovementComponent());
        setLivableComponent(new LivableComponent());
        this.bulletList = new ArrayList<>();
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     */
    public AEnemyEntity(MovementComponent movementComponent, LivableComponent livableComponent){
        setMovementComponent(movementComponent);
        setLivableComponent(livableComponent);
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
    public List<ABulletEntity> getBulletList() {
        return bulletList;
    }
}
