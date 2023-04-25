package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ATextEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.PositionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.GraphicsContext;

import java.awt.*;

public class TextJ2d extends ATextEntity {
    private final GraphicsContext gfx;
    public TextJ2d(GraphicsContext gfx){
        super();
        this.gfx = gfx;
    }
    public TextJ2d(PositionComponent positionComponent, String preText,GraphicsContext gfx){
        super(positionComponent, preText);
        this.gfx = gfx;
    }
    public TextJ2d(PositionComponent positionComponent, String preText, String text, GraphicsContext gfx){
        super(positionComponent, preText, text);
        this.gfx = gfx;
    }

    @Override
    public void visualize() {
        if (gfx.getG2d() != null) {
            gfx.getG2d().setColor(new Color(255,20,255));
            gfx.getG2d().drawString(this.getInformationComponent().getInfoText(), (int) this.getPositionComponent().getX(), (int) this.getPositionComponent().getY());
        }
    }
}