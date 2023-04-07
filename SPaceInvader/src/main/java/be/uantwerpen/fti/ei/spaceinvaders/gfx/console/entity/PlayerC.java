package be.uantwerpen.fti.ei.spaceinvaders.gfx.console.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABulletEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.APlayerEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.console.GraphicsContext;

public class PlayerC extends APlayerEntity {
    private final GraphicsContext gfx;

    public PlayerC(GraphicsContext gfx) {
        this.gfx = gfx;
    }

    public PlayerC(MovementComponent movementComponent, LivableComponent livableComponent, GraphicsContext gfx) {
        super(movementComponent, livableComponent);
        this.gfx = gfx;
    }

    @Override
    public void visualize() {
        getShootingComponent().getBulletList().forEach(ABulletEntity::visualize);

        for (int height = 1; height <= this.getMovementComponent().getHeight(); height++) {
            for (int width = 1; width <= this.getMovementComponent().getWidth(); width++) {
                try {
                    gfx.getGamePicture()[(int) (this.getMovementComponent().getY() + height)][(int) (this.getMovementComponent().getX() + width)] = "=";
                }
                catch (IndexOutOfBoundsException e){
                    //niets doen
                }
            }
        }
    }
}
