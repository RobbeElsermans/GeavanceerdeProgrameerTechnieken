package be.uantwerpen.fti.ei.spaceinvaders.gfx.console.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABonusEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.CollectableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.console.GraphicsContext;

public class BonusC extends ABonusEntity {
    private GraphicsContext gfx;
    public BonusC(GraphicsContext gfx){
        this.gfx = gfx;
    }
    public BonusC(MovementComponent movementComponent, CollectableComponent collectableComponent, GraphicsContext gfx) {
        super(movementComponent, collectableComponent);
        this.gfx = gfx;
    }
    @Override
    public void visualize() {
        for (int height = 1; height <= this.getMovementComponent().getHeight(); height++)
        {
            for (int width = 1; width <= this.getMovementComponent().getWidth(); width++){
                try {
                    gfx.getGamePicture()[(int) (this.getMovementComponent().getY() + height)][(int) (this.getMovementComponent().getX() + width)] = "*";
                }
                catch (IndexOutOfBoundsException ignored){

                }
            }
        }
    }

}
