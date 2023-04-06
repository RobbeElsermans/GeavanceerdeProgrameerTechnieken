package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;

import java.util.List;

public interface IMovement {
    void move(List<MovementComponent> mcl);
}
