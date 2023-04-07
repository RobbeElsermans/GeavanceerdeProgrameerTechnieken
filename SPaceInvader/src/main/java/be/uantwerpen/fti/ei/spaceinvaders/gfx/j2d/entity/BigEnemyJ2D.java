package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABigEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.CollectableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.GraphicsContext;

import java.awt.*;

public class BigEnemyJ2D extends ABigEnemyEntity {

    private GraphicsContext gfx;
    public BigEnemyJ2D(GraphicsContext gfx) {
        super();
        this.setGfx(gfx);
    }

    public BigEnemyJ2D(MovementComponent movementComponent, LivableComponent livableComponent, GraphicsContext gfx) {
        super(movementComponent, livableComponent);
        this.gfx = gfx;
    }
    @Override
    public void visualize() {

        if (getGfx().getG2d() != null) {
            //getGfx().getG2d().setColor(new Color(224, 17, 231));
            if (getLivableComponent().getLife() > 2)
                getGfx().getG2d().setColor(new Color(0, 255, 25));
            else if (getLivableComponent().getLife() == 2)
                getGfx().getG2d().setColor(new Color(244, 195, 100));
            else
                getGfx().getG2d().setColor(new Color(255, 100, 0));
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