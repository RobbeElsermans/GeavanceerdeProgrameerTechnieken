package be.uantwerpen.fti.ei.spaceinvaders.gfx.console.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABigEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.console.GraphicsContext;

public class BigEnemyC extends ABigEnemyEntity {
    private final GraphicsContext gfx;

    public BigEnemyC(MovementComponent movementComponent, LivableComponent livableComponent, GraphicsContext gfx) {
        super(movementComponent, livableComponent);
        this.gfx = gfx;
    }

    @Override
    public void visualize() {
        for (int height = 1; height <= this.getMovementComponent().getHeight(); height++) {
            for (int width = 1; width <= this.getMovementComponent().getWidth(); width++) {
                try {
                    gfx.getGamePicture()[(int) (this.getMovementComponent().getY() + height)][(int) (this.getMovementComponent().getX() + width)] = "*";
                } catch (IndexOutOfBoundsException ignored) {

                }
            }
        }
    }
}
