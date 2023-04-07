package be.uantwerpen.fti.ei.spaceinvaders.gfx.console.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AScreenEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ATextEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.PositionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.console.GraphicsContext;

import java.util.List;

public class EndScreenC extends AScreenEntity {
    private GraphicsContext gfx;
    public EndScreenC(GraphicsContext gfx){
        this.gfx = gfx;
    }
    public EndScreenC(PositionComponent positionComponent, GraphicsContext gfx) {
        super(positionComponent);
        this.gfx = gfx;
    }
    public EndScreenC(PositionComponent positionComponent, List<ATextEntity> textEntities, GraphicsContext graphicsContext) {
        super(positionComponent, textEntities);
        this.gfx = graphicsContext;
    }
    @Override
    public void visualize() {
        this.getTextEntityList().forEach(ATextEntity::visualize);
    }
}
