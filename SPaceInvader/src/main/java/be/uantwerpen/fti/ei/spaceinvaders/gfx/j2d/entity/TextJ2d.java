package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ATextEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.DimensionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.PositionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.GraphicsContext;

import java.awt.*;

public class TextJ2d extends ATextEntity {
    private GraphicsContext gfx;
    public TextJ2d(GraphicsContext gfx){
        super();
        this.setGfx(gfx);
    }
    public TextJ2d(PositionComponent positionComponent, String preText,GraphicsContext gfx){
        super(positionComponent, preText);
        this.setGfx(gfx);
    }
    public TextJ2d(PositionComponent positionComponent, String preText, String text, GraphicsContext gfx){
        super(positionComponent, preText, text);
        this.setGfx(gfx);
    }

    @Override
    public void visualize() {
        if (getGfx().getG2d() != null) {
            getGfx().getG2d().setColor(new Color(0,20,255));
            getGfx().getG2d().drawString(this.getInformationComponent().getInfoText(),this.getPositionComponent().getX(), this.getPositionComponent().getY());
        }
    }
    public GraphicsContext getGfx() {
        return gfx;
    }

    public void setGfx(GraphicsContext gfx) {
        this.gfx = gfx;
    }
}
