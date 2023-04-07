package be.uantwerpen.fti.ei.spaceinvaders.gfx.console.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AObstacleEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.DimensionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.console.GraphicsContext;

public class ObstacleC extends AObstacleEntity {
    private GraphicsContext gfx;
    public ObstacleC(GraphicsContext gfx){
        this.gfx = gfx;
    }
    public ObstacleC(DimensionComponent dimensionComponent, LivableComponent livableComponent, GraphicsContext gfx) {
        super(dimensionComponent, livableComponent);
        this.gfx = gfx;
    }
    @Override
    public void visualize() {
        for (int height = 1; height <= this.getDimensionComponent().getHeight(); height++)
        {
            for (int width = 1; width <= this.getDimensionComponent().getWidth(); width++){
                try {
                    gfx.getGamePicture()[(int) (this.getDimensionComponent().getY() + height)][(int) (this.getDimensionComponent().getX() + width)] = "-";
                }
                catch (IndexOutOfBoundsException ignored){

                }
            }
        }
    }
}
