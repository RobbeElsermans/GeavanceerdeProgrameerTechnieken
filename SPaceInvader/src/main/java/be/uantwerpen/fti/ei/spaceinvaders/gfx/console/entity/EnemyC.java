package be.uantwerpen.fti.ei.spaceinvaders.gfx.console.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABulletEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.console.GraphicsContext;

public class EnemyC extends AEnemyEntity {
    private final GraphicsContext gfx;


    public EnemyC(MovementComponent movementComponent, LivableComponent livableComponent, GraphicsContext gfx) {
        super(movementComponent, livableComponent);
        this.gfx = gfx;
    }

    @Override
    public void visualize() {
        getShootingComponent().getBulletList().forEach(ABulletEntity::visualize);

        for (int height = 1; height <= this.getMovementComponent().getHeight(); height++) {
            for (int width = 1; width <= this.getMovementComponent().getWidth(); width++) {
                try {
                    gfx.getGamePicture()[(int) (this.getMovementComponent().getY() + height)][(int) (this.getMovementComponent().getX() + width)] = "V";
                } catch (IndexOutOfBoundsException ignored) {

                }
            }
        }
    }
}
