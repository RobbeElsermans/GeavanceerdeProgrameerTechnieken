package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABigEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.GraphicsContext;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.SpriteLoader;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class BigEnemyJ2D extends ABigEnemyEntity {

    private GraphicsContext gfx;

    public BigEnemyJ2D(MovementComponent movementComponent, LivableComponent livableComponent, GraphicsContext gfx) {
        super(movementComponent, livableComponent);
        this.gfx = gfx;
    }

    @Override
    public void visualize() {

        BufferedImage image = gfx.getSpriteLoader().getSprite(EntityType.BIG_ENEMY).get(0);
        AffineTransform affineTransform = SpriteLoader.scaler(image, gfx.getBigEnemyDimension(), getMovementComponent().getPosition());

        if (gfx.getG2d() != null) {
            gfx.getG2d().drawImage(image, affineTransform, null);
        }
    }

    public void setGfx(GraphicsContext gfx) {
        this.gfx = gfx;
    }
}