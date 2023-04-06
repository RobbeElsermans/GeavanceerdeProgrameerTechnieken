package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABonusEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.CollectableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.GraphicsContext;

import java.awt.*;

public class BonusEntity extends ABonusEntity {
    private GraphicsContext gfx;
    public BonusEntity(GraphicsContext gfx) {
        super();
        this.setGfx(gfx);
    }

    public BonusEntity(MovementComponent movementComponent, LivableComponent livableComponent, CollectableComponent collectableComponent, GraphicsContext gfx) {
        super(movementComponent, livableComponent, collectableComponent);
        this.gfx = gfx;
    }
    @Override
    public void visualize() {

        //Use the gfx to draw onto the buffer
        //Graphics2D g2d = getGfx().getG2d();
        if (getGfx().getG2d() != null) {
            //getGfx().getG2d().setColor(new Color(224, 17, 231));
            if(getCollectableComponent().getType() == CollectableComponent.collectableType.life)
                getGfx().getG2d().setColor(new Color(255, 0, 127));
            if(getCollectableComponent().getType() == CollectableComponent.collectableType.moveSpeed)
                getGfx().getG2d().setColor(new Color(128, 128, 128));
            if(getCollectableComponent().getType() == CollectableComponent.collectableType.reloadSpeed)
                getGfx().getG2d().setColor(new Color(255, 255,0));
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
