package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.DimensionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Een obstacle entiteit dat een statische entiteit is. Deze bevat enkel een positie, dimensie en een leven.
 * <p>
 * Het AObstacleEntity is een niet-beweegbaar entiteit dat kan gebruikt worden als schild door de speler.
 * Een obstakel kan zowel door de enemy als door de speler weg geschoten worden.
 * <p>
 * Wanneer men deze entity wilt implementeren, moet men de visualize methode overerven van IVisualize.
 * Deze methode wordt gebruikt om de entiteit af te beelden.
 * @see IVisualize
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
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param dimensionComponent De locatie en dimensie van de entiteit (in graphics-coordinates).
     * @param livableComponent   Het leven van de entiteit.
     * @see DimensionComponent
     * @see LivableComponent
     */
    public AObstacleEntity(DimensionComponent dimensionComponent, LivableComponent livableComponent) {
        this.dimensionComponent = dimensionComponent;
        this.livableComponent = livableComponent;
    }

    /**
     * @return De livableComponent van de entiteit.
     */
    public LivableComponent getLivableComponent() {
        return livableComponent;
    }

    /**
     * @return De dimensionComponent van de entiteit.
     */
    public DimensionComponent getDimensionComponent() {
        return dimensionComponent;
    }
}
