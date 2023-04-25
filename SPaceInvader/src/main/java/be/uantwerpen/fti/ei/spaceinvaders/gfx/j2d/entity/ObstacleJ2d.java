package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AObstacleEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.DimensionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.GraphicsContext;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.SpriteLoader;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class ObstacleJ2d extends AObstacleEntity {
    private GraphicsContext gfx;

    public ObstacleJ2d(GraphicsContext gfx) {
        super();
        this.setGfx(gfx);
    }

    public ObstacleJ2d(DimensionComponent dimensionComponent, LivableComponent livableComponent, GraphicsContext gfx) {
        super(dimensionComponent, livableComponent);
        this.setGfx(gfx);
    }

    @Override
    public void visualize() {

        BufferedImage image;
        if(getLivableComponent().getLife() <= gfx.getSpriteLoader().getSprite(EntityType.OBSTACLE).size())
            image = gfx.getSpriteLoader().getSprite(EntityType.OBSTACLE).get(getLivableComponent().getLife()-1);
        else{
            image = gfx.getSpriteLoader().getSprite(EntityType.OBSTACLE).get((gfx.getSpriteLoader().getSprite(EntityType.OBSTACLE).size()-1));
        }

        AffineTransform affineTransform = SpriteLoader.scaler(image, gfx.getObstacleDimension(), getDimensionComponent().getPosition());

        if (gfx.getG2d() != null) {
            gfx.getG2d().drawImage(image, affineTransform, null);
        }
    }

    public GraphicsContext getGfx() {
        return gfx;
    }

    public void setGfx(GraphicsContext gfx) {
        this.gfx = gfx;
    }
}