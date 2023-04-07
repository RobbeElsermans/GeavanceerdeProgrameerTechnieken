package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.DimensionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;

/**
 * Een obstacle entiteit dat een statische entiteit is. Deze bevat enkel een positie, dimensie en een leven.
 */
public abstract class AObstacleEntity implements IVisualize {
    /**
     * De entiteit kan op een positie staan en heeft een dimensie
     */
    private final DimensionComponent dimensionComponent;
    /**
     * De entiteit leeft.
     */
    private final LivableComponent livableComponent;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public AObstacleEntity() {
        this.dimensionComponent = new DimensionComponent();
        this.livableComponent = new LivableComponent();
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param dimensionComponent   De locatie en dimensie van de entiteit.
     * @param livableComponent  Het leven van de entiteit.
     */
    public AObstacleEntity(DimensionComponent dimensionComponent, LivableComponent livableComponent) {
        this.dimensionComponent = dimensionComponent;
        this.livableComponent = livableComponent;
    }

    public LivableComponent getLivableComponent() {
        return livableComponent;
    }
    public DimensionComponent getDimensionComponent() {
        return dimensionComponent;
    }
}
