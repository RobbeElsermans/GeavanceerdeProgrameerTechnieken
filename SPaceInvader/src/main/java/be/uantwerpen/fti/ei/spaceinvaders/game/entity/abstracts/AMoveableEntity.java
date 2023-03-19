package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces.IMoveable;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

/**
 * Een Entiteit die overerft van een static entity. Deze AMoveableEntity zal dus kunnen bewegen.
 */
public abstract class AMoveableEntity extends AEntity {
    /**
     * De snelheid waarmee de entiteit zichzelf voortbeweegt. Default is dit 2.
     */
    private int speed = 2;

    /**
     * De Input interface die de entiteit kan bewegen
     */
    private IInput input;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     * @param input de input klasse die de entiteit kan laten bewegen
     */
    public AMoveableEntity(IInput input) {
        super();
        this.setInput(input);
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param x     de x-coördinaat als integer
     * @param y     de y-coördinaat als integer
     * @param speed de snelheid als integer
     * @param input de input klasse die de entiteit kan laten bewegen
     */

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     * @param position  de positie als IPosition
     * @param dimension de dimensie als IPosition
     * @param speed
     * @param input
     */
    public AMoveableEntity(IPosition position, IDimension dimension, int speed, IInput input) {
        super(position, dimension);
        this.setSpeed(speed);
        this.setInput(input);
    }


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
                case UP :{
                    setY(getY()-this.getSpeed());
                    break;
                }
                case DOWN :{
                    setY(getY()+this.getSpeed());
                    break;
                }
                default : {

                }
            }
        }
    }

    @Override
    public void update() {
        this.move();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "AStaticEntity( x: " + getX() + ", y: " + getY() + ", speed: " + getSpeed() + " )";
    }

    public IInput getInput() {
        return input;
    }

    private void setInput(IInput input) {
        this.input = input;
    }
}
