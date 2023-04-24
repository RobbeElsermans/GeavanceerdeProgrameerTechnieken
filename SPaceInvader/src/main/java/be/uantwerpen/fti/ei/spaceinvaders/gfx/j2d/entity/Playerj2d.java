package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABulletEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.APlayerEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.GraphicsContext;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.SpriteLoader;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Playerj2d extends APlayerEntity {
    private GraphicsContext gfx;
    public Playerj2d(GraphicsContext gfx) {
        super();
        this.setGfx(gfx);
    }

    public Playerj2d(MovementComponent movementComponent, LivableComponent livableComponent, GraphicsContext gfx) {
        super(movementComponent, livableComponent);
        this.setGfx(gfx);
    }

    @Override
    public void visualize() {
        for (ABulletEntity aBulletEntity : getShootingComponent().getBulletList()) {
            aBulletEntity.visualize();
        }
        //Use the gfx to draw onto the buffer
        //Graphics2D g2d = getGfx().getG2d();
        BufferedImage playerImage = getGfx().getSpriteLoader().getSprite(EntityType.PLAYER).get(0);
        BufferedImage after = new BufferedImage(playerImage.getWidth(), playerImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        //Schaal de image
        at.scale(gfx.getEnemyDimension().getWidth()/playerImage.getWidth(), gfx.getEnemyDimension().getHeight()/playerImage.getHeight());
        //Verplaats de image
        at.translate(this.getMovementComponent().getX(),this.getMovementComponent().getY());

        if (getGfx().getG2d() != null) {
            getGfx().getG2d().drawImage(playerImage, at, null);
            //getGfx().getG2d().setColor(new Color(50, 200, 200));
            //getGfx().getG2d().fillRect((int) this.getMovementComponent().getX(), (int) this.getMovementComponent().getY(), this.getMovementComponent().getWidth(), this.getMovementComponent().getHeight());
        }
    }

    public GraphicsContext getGfx() {
        return gfx;
    }

    public void setGfx(GraphicsContext gfx) {
        this.gfx = gfx;
    }
}
