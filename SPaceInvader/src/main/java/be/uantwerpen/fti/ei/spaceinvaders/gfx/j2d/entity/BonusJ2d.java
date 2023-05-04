package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABonusEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.CollectableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.types.CollectableType;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.GraphicsContext;

import java.awt.*;

public class BonusJ2d extends ABonusEntity {
    private GraphicsContext gfx;

    public BonusJ2d(MovementComponent movementComponent, CollectableComponent collectableComponent, GraphicsContext gfx) {
        super(movementComponent, collectableComponent);
        this.gfx = gfx;
    }

    @Override
    public void visualize() {

        //Use the gfx to draw onto the buffer
        //Graphics2D g2d = getGfx().getG2d();
        if (getGfx().getG2d() != null) {
            //getGfx().getG2d().setColor(new Color(224, 17, 231));
            if (getCollectableComponent().getType() == CollectableType.LIFE) {
                getGfx().getG2d().setColor(new Color(255, 0, 127));
            }
            if (getCollectableComponent().getType() == CollectableType.BULLET_SPEED) {
                if (getCollectableComponent().getValue() < 0) {
                    getGfx().getG2d().setColor(new Color(128, 128, 128));
                }
                if (getCollectableComponent().getValue() > 0) {
                    getGfx().getG2d().setColor(new Color(102, 178, 255));
                }
            }
            getGfx().getG2d().fillRect((int) this.getMovementComponent().getX(), (int) this.getMovementComponent().getY(), this.getMovementComponent().getWidth(), this.getMovementComponent().getHeight());    //De vorige frame nog verwijderen
        }
    }

    public GraphicsContext getGfx() {
        return gfx;
    }

    public void setGfx(GraphicsContext gfx) {
        this.gfx = gfx;
    }
}
