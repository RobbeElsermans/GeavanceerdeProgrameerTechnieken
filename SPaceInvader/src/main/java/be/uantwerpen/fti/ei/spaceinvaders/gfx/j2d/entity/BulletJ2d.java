package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABulletEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.GraphicsContext;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.SpriteLoader;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class BulletJ2d extends ABulletEntity {
    private GraphicsContext gfx;

    public BulletJ2d(GraphicsContext gfx) {
        super();
        this.setGfx(gfx);
    }

    public BulletJ2d(MovementComponent movementComponent, LivableComponent livableComponent, GraphicsContext gfx) {
        super(movementComponent, livableComponent);
        this.gfx = gfx;
    }

    @Override
    public void visualize() {

        if (getGfx().getG2d() != null) {
            //Bullet dat naar boven gaat.
            if (getMovementComponent().getVelocity() < 0) {
                getGfx().getG2d().setColor(new Color(219, 15, 15));
                getGfx().getG2d().fillRect((int) this.getMovementComponent().getX(), (int) this.getMovementComponent().getY(), this.getMovementComponent().getWidth(), this.getMovementComponent().getHeight());    //De vorige frame nog verwijderen
            }
            //bullet dat naar beneden gaat
            else {
                BufferedImage image = gfx.getSpriteLoader().getSprite(EntityType.BULLET_ENEMY).get((int) ((this.getMovementComponent().getY() / this.getMovementComponent().getSpeed() / 10) % 2));
                AffineTransform affineTransform = SpriteLoader.scaler(image, gfx.getBulletDimension(), getMovementComponent().getPosition());

                if (gfx.getG2d() != null) {
                    gfx.getG2d().drawImage(image, affineTransform, null);
                }
            }
        }
    }

    public GraphicsContext getGfx() {
        return gfx;
    }

    public void setGfx(GraphicsContext gfx) {
        this.gfx = gfx;
    }
}