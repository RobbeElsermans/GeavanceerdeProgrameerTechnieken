package be.uantwerpen.fti.ei.spaceinvaders.gfx.console.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AScreenEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ATextEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.PositionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.console.GraphicsContext;

import java.util.List;

public class PauseScreenC  extends AScreenEntity {
    public PauseScreenC(GraphicsContext gfx){
    }
    public PauseScreenC(PositionComponent positionComponent) {
        super(positionComponent);
    }
    public PauseScreenC(PositionComponent positionComponent, List<ATextEntity> textEntities) {
        super(positionComponent, textEntities);
    }
    @Override
    public void visualize() {
        this.getTextEntityList().forEach(ATextEntity::visualize);
    }
}
