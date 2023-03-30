package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.APlayerEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.ShootComponent;

import java.awt.*;

public class Playerj2d extends APlayerEntity {
    private GraphicsContext gfx;
    public Playerj2d(GraphicsContext gfx) {
        super();
        this.setGfx(gfx);
    }

    public Playerj2d(MovementComponent movementComponent, LivableComponent livableComponent, ShootComponent shootComponent, GraphicsContext gfx) {
        super(movementComponent, livableComponent, shootComponent);
        this.gfx = gfx;
    }

    @Override
    public void visualize() {
        //Use the gfx to draw onto the buffer
        //Graphics2D g2d = getGfx().getG2d();
        if (getGfx().getG2d() != null) {
            getGfx().getG2d().setColor(new Color(50, 200, 200));
            getGfx().getG2d().fillRect(this.getMovementComponent().getX() , this.getMovementComponent().getY(), this.getMovementComponent().getWidth(), this.getMovementComponent().getHeight());    //De vorige frame nog verwijderen
        }
    }

    public GraphicsContext getGfx() {
        return gfx;
    }

    public void setGfx(GraphicsContext gfx) {
        this.gfx = gfx;
    }
}
