package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycontroller.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycontroller.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

public abstract class AEnemyEntity  implements IVisualize {
    /**
     * De entiteit kan bewegen
     */
    MovementComponent movementComponent;
    /**
     * De entiteit kan leven
     */
    LivableComponent livableComponent;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     * @param input Een IInput object waarmee de entiteit zichzelf mee kan bewegen.
     */
    public AEnemyEntity(IInput input){//Insert de input
        setMovementComponent(new MovementComponent(input));
        setLivableComponent(new LivableComponent());
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     */
    public AEnemyEntity(MovementComponent movementComponent, LivableComponent livableComponent){
        setMovementComponent(movementComponent);
        setLivableComponent(livableComponent);
    }
    public MovementComponent getMovementComponent() {
        return movementComponent;
    }

    public void setMovementComponent(MovementComponent movementComponent) {
        this.movementComponent = movementComponent;
    }

    public LivableComponent getLivableComponent() {
        return livableComponent;
    }

    public void setLivableComponent(LivableComponent livableComponent) {
        this.livableComponent = livableComponent;
    }
}
