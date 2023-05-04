package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABulletEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.GraphicsContext;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.SpriteLoader;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class EnemyJ2d extends AEnemyEntity {
    private GraphicsContext gfx;

    public EnemyJ2d(MovementComponent movementComponent, LivableComponent livableComponent, GraphicsContext gfx) {
        super(movementComponent, livableComponent);
        this.gfx = gfx;
    }

    @Override
    public void visualize() {
        for (ABulletEntity aBulletEntity : getShootingComponent().getBulletList()) {
            aBulletEntity.visualize();
        }

        BufferedImage image = gfx.getSpriteLoader().getSprite(EntityType.ENEMY).get(getLivableComponent().getLife() - 1);
        AffineTransform affineTransform = SpriteLoader.scaler(image, gfx.getEnemyDimension(), getMovementComponent().getPosition());

        if (gfx.getG2d() != null) {
            gfx.getG2d().drawImage(image, affineTransform, null);
        }
    }

    public void setGfx(GraphicsContext gfx) {
        this.gfx = gfx;
    }
}