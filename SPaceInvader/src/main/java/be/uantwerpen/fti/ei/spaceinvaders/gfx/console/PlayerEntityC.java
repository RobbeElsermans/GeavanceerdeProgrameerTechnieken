package be.uantwerpen.fti.ei.spaceinvaders.gfx.console;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.player.APlayerEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

public class PlayerEntityC extends APlayerEntity {

    public PlayerEntityC(IInput input) {
        super(input);
    }

    public PlayerEntityC(IPosition position, IDimension dimension, int life, int speed, IInput input) {
        super(position, dimension, life, speed, input);
    }

    @Override
    public void update() {

    }

    @Override
    public void visualize() {

    }


}
