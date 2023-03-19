package be.uantwerpen.fti.ei.spaceinvaders.game.entity.projectile;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

public abstract class ABonusEntity extends AProjectileEntity {

    public ABonusEntity(IInput input) {
        super(input);
    }

    public ABonusEntity(IPosition position, IDimension dimension, int speed, IInput input) {
        super(position, dimension, speed, input);
    }
}
