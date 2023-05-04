package be.uantwerpen.fti.ei.spaceinvaders.gfx.console.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AScreenEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ATextEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.PositionComponent;

import java.util.List;

public class PauseScreenC extends AScreenEntity {

    public PauseScreenC(PositionComponent positionComponent, List<ATextEntity> textEntities) {
        super(positionComponent, textEntities);
    }

    @Override
    public void visualize() {
        this.getTextEntityList().forEach(ATextEntity::visualize);
    }
}
