package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycontroller.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycontroller.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

import java.awt.*;

public class EnemyJ2d extends AEnemyEntity {
    private GraphicsContext gfx;
    public EnemyJ2d(GraphicsContext gfx) {
        super();
        this.setGfx(gfx);
    }

    public EnemyJ2d(MovementComponent movementComponent, LivableComponent livableComponent, GraphicsContext gfx) {
        super(movementComponent, livableComponent);
        this.gfx = gfx;
    }
    @Override
    public void visualize() {
        //Use the gfx to draw onto the buffer
        //Graphics2D g2d = getGfx().getG2d();
        if (getGfx().getG2d() != null) {
            getGfx().getG2d().setColor(new Color(224, 17, 231));
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
