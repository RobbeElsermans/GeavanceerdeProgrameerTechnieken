package be.uantwerpen.fti.ei.spaceinvaders.gfx.console;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.enemy.AEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

public class EnemyEntityC extends AEnemyEntity {
    public EnemyEntityC(IInput input) {
        super(input);
    }

    public EnemyEntityC(IPosition position, IDimension dimension, int life, int speed, IInput input) {
        super(position, dimension, life, speed, input);
    }

    @Override
    public void visualize() {

    }
}
