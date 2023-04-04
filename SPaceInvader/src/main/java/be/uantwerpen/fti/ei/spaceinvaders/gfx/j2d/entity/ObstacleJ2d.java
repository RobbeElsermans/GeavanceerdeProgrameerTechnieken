package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AObstacleEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.StaticComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.GraphicsContext;

import java.awt.*;

public class ObstacleJ2d extends AObstacleEntity {
    private GraphicsContext gfx;

    public ObstacleJ2d(GraphicsContext gfx) {
        super();
        this.setGfx(gfx);
    }

    public ObstacleJ2d(StaticComponent staticComponent, LivableComponent livableComponent, GraphicsContext gfx) {
        super(staticComponent, livableComponent);
        this.setGfx(gfx);
    }

    @Override
    public void visualize() {
        //Use the gfx to draw onto the buffer
        //Graphics2D g2d = getGfx().getG2d();
        if (getGfx().getG2d() != null) {
            if (getLivableComponent().getLife() > 2)
                getGfx().getG2d().setColor(new Color(0, 255, 0));
            else if (getLivableComponent().getLife() == 2)
                getGfx().getG2d().setColor(new Color(244, 195, 8));
            else
                getGfx().getG2d().setColor(new Color(255, 0, 0));
            getGfx().getG2d().fillRect(this.getStaticComponent().getX(), this.getStaticComponent().getY(), this.getStaticComponent().getWidth(), this.getStaticComponent().getHeight());
        }
    }

    public GraphicsContext getGfx() {
        return gfx;
    }

    public void setGfx(GraphicsContext gfx) {
        this.gfx = gfx;
    }
}
