package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IVisualize;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycontroller.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entitycontroller.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

/**
 * Een player entiteit dat overerft van livable & movable entiteit.
 */
public abstract class APlayerEntity implements IVisualize {
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
     */
    public APlayerEntity(){//Insert de input
        setMovementComponent(new MovementComponent());
        setLivableComponent(new LivableComponent());
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     */
    public APlayerEntity(MovementComponent movementComponent, LivableComponent livableComponent){
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

/*  movement van player nog naar AmovementPlayer spelen
    @Override
    protected void move(){
        if(getInput().inputAvailable()) {
            switch (getInput().inputState()){
                case LEFT:{
                    setX(getX()-this.getSpeed());
                    break;
                }
                case RIGHT :{
                    setX(getX()+this.getSpeed());
                    break;
                }
                default : {

                }
            }
        }
        //this.setX(getX()+1);
    }
    */
