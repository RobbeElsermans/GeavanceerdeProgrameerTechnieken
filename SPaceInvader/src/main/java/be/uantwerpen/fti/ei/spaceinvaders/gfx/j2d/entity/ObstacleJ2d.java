package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AObstacleEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.DimensionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.GraphicsContext;

import java.awt.*;

public class ObstacleJ2d extends AObstacleEntity {
    private GraphicsContext gfx;

    public ObstacleJ2d(GraphicsContext gfx) {
        super();
        this.setGfx(gfx);
    }

    public ObstacleJ2d(DimensionComponent dimensionComponent, LivableComponent livableComponent, GraphicsContext gfx) {
        super(dimensionComponent, livableComponent);
        this.setGfx(gfx);
    }

    @Override
    public void visualize() {
        //Use the gfx to draw onto the buffer
        //Graphics2D g2d = getGfx().getG2d();
        if (getGfx().getG2d() != null) {
            if (getLivableComponent().getLife() == 1)
                getGfx().getG2d().setColor(new Color(102, 0, 0));
            else if (getLivableComponent().getLife() == 2)
                getGfx().getG2d().setColor(new Color(102, 51, 0));
            else if (getLivableComponent().getLife() == 3)
                getGfx().getG2d().setColor(new Color(102, 102, 100));
            else if (getLivableComponent().getLife() == 4)
                getGfx().getG2d().setColor(new Color(51, 102, 100));
            else
                getGfx().getG2d().setColor(new Color(0, 102, 0));
            getGfx().getG2d().fillRect((int) this.getDimensionComponent().getX(), (int) this.getDimensionComponent().getY(), this.getDimensionComponent().getWidth(), this.getDimensionComponent().getHeight());
        }
    }

    public GraphicsContext getGfx() {
        return gfx;
    }

    public void setGfx(GraphicsContext gfx) {
        this.gfx = gfx;
    }
}
