package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABulletEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.APlayerEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.GraphicsContext;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.SpriteLoader;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Playerj2d extends APlayerEntity {
    private final GraphicsContext gfx;

    public Playerj2d(GraphicsContext gfx) {
        super();
        this.gfx = gfx;
    }

    public Playerj2d(MovementComponent movementComponent, LivableComponent livableComponent, GraphicsContext gfx) {
        super(movementComponent, livableComponent);
        this.gfx = gfx;
    }

    @Override
    public void visualize() {
        for (ABulletEntity aBulletEntity : getShootingComponent().getBulletList()) {
            aBulletEntity.visualize();
        }
        //Use the gfx to draw onto the buffer
        //Graphics2D g2d = getGfx().getG2d();
        BufferedImage image = gfx.getSpriteLoader().getSprite(EntityType.PLAYER).get(0);
        AffineTransform affineTransform = SpriteLoader.scaler(image, gfx.getPlayerDimension(), getMovementComponent().getPosition());

        if (gfx.getG2d() != null) {
            gfx.getG2d().drawImage(image, affineTransform, null);
        }
    }
}