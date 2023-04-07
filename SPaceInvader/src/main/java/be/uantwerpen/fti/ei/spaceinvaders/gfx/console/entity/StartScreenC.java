package be.uantwerpen.fti.ei.spaceinvaders.gfx.console.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AScreenEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ATextEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.PositionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.console.GraphicsContext;

import java.util.List;

public class StartScreenC extends AScreenEntity {
    public StartScreenC(PositionComponent positionComponent) {
        super(positionComponent);
    }

    public StartScreenC(PositionComponent positionComponent, List<ATextEntity> textEntities) {
        super(positionComponent, textEntities);
    }

    @Override
    public void visualize() {
        this.getTextEntityList().forEach(ATextEntity::visualize);
    }
}
