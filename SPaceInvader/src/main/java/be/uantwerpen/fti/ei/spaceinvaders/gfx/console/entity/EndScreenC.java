package be.uantwerpen.fti.ei.spaceinvaders.gfx.console.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AScreenEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ATextEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.PositionComponent;

import java.util.List;

public class EndScreenC extends AScreenEntity {
    public EndScreenC(){

    }
    public EndScreenC(PositionComponent positionComponent) {
        super(positionComponent);
    }
    public EndScreenC(PositionComponent positionComponent, List<ATextEntity> textEntities) {
        super(positionComponent, textEntities);
    }
    @Override
    public void visualize() {
        this.getTextEntityList().forEach(ATextEntity::visualize);
    }
}
