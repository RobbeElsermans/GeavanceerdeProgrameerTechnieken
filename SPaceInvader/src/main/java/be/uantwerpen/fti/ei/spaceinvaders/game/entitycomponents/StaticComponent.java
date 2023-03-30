package be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;

public class StaticComponent extends APositionComponent{

    public StaticComponent() {
        super();
    }

    public StaticComponent(IPosition position, IDimension dimension) {
        super(position, dimension);
    }
}
