package be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

/**
 * Een beweegbare Entiteit die overerft van een static entity.
 */
public abstract class AMoveableEntity extends AEntity {
    /**
     * De snelheid waarmee de entiteit zichzelf voortbeweegt. Default is dit 2.
     */
    private int speed;

    /**
     * Een IInput object waarmee de entiteit zichzelf mee kan bewegen.
     */
    private IInput input;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     * @param input Een IInput object waarmee de entiteit zichzelf mee kan bewegen.
     */
    public AMoveableEntity(IInput input) {
        super();
        this.setInput(input);
        this.setSpeed(2);
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     * @param position  De positie van de entiteit.
     * @param dimension De dimensie van de entiteit.
     * @param speed     De snelheid waarmee de entiteit zich verplaatst.
     * @param input     Een IInput object waarmee de entiteit zichzelf mee kan bewegen.
     */
    public AMoveableEntity(IPosition position, IDimension dimension, int speed, IInput input) {
        super(position, dimension);
        this.setSpeed(speed);
        this.setInput(input);
    }

    /**
     * Een move methode die kan bewerkt worden door onderliggende klasses.
     * Deze move methode zal de entiteit kunnen laten bewegen.
     */
    protected void move(){
        if(getInput().inputAvailable()) {
            if(getInput().isLeft())
                setX(getX()-this.getSpeed());
            if(getInput().isRight())
                setX(getX()+this.getSpeed());
            if(getInput().isUp())
                setY(getY()-this.getSpeed());
            if(getInput().isDown())
                setY(getY()+this.getSpeed());
        }
    }

    /**
     * Update de entiteit a.d.h.v. de gegeven input.
     */
    @Override
    public void update() {
        this.move();
    }

    public int getSpeed() {
        return speed;
    }

    private void setSpeed(int speed) {
        this.speed = speed;
    }
    public IInput getInput() {
        return input;
    }
    private void setInput(IInput input) {
        this.input = input;
    }
    @Override
    public String toString() {
        return "AEntity( x: " + getX() + ", y: " + getY() + ", width: "+getWidth() + ", height: " + getHeight()+ ", speed "+ this.getSpeed()+ " )";
    }
}
