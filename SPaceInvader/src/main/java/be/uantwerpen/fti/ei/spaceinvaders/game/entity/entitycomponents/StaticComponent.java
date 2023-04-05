package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
//TODO: werk static component weg zodat er met PositionComp en DimensionComp gewerkt wordt.
public class StaticComponent extends PositionComponent {

    public StaticComponent() {
        super();
    }

    public StaticComponent(IPosition position, IDimension dimension) {
        super(position, dimension);
    }
}
