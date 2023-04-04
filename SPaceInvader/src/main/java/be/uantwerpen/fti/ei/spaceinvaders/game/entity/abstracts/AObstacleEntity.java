package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.StaticComponent;

/**
 * Een obstacle entiteit dat een statische entiteit is. Deze bevat enkel een positie, dimensie en een leven.
 */
public abstract class AObstacleEntity implements IVisualize {
    /**
     * De entiteit kan op een positie staan en heeft een dimensie
     */
    private StaticComponent staticComponent;
    /**
     * De entiteit leeft.
     */
    private LivableComponent livableComponent;

    public AObstacleEntity() {
        this.staticComponent = new StaticComponent();
        this.livableComponent = new LivableComponent();
    }

    public AObstacleEntity(StaticComponent staticComponent, LivableComponent livableComponent) {
        this.staticComponent = staticComponent;
        this.livableComponent = livableComponent;
    }

    public LivableComponent getLivableComponent() {
        return livableComponent;
    }

    public void setLivableComponent(LivableComponent livableComponent) {
        this.livableComponent = livableComponent;
    }

    public StaticComponent getStaticComponent() {
        return staticComponent;
    }

    public void setStaticComponent(StaticComponent staticComponent) {
        this.staticComponent = staticComponent;
    }

}
