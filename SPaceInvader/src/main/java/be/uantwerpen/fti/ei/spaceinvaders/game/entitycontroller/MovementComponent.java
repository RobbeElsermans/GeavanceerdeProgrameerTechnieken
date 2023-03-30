package be.uantwerpen.fti.ei.spaceinvaders.game.entitycontroller;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

/**
 * Een beweegbaar component
 */
public class MovementComponent extends APositionComponent{
    /**
     * De constante snelheid waarmee de entiteit zichzelf voortbeweegt. Default is dit 2.
     */
    private int speed;

    /**
     * De snelheid waarmee de entiteit zichzelf voortbeweegt. Default is dit 1.
     */
    private double velocity;
    private double prevVelocity;
    private double defaultVelocity;

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     * @param input Een IInput object waarmee de entiteit zichzelf mee kan bewegen.
     */
    public MovementComponent(IInput input) {
        super();
        this.setSpeed(2);
        this.defaultVelocity = 1;
        this.setVelocity(1);
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     *
     * @param position  De positie van de entiteit.
     * @param dimension De dimensie van de entiteit.
     * @param speed     De snelheid waarmee de entiteit zich verplaatst.
     */
    public MovementComponent(IPosition position, IDimension dimension, int speed,double velocity) {
        super(position, dimension);
        this.setSpeed(speed);
        this.defaultVelocity = velocity;
        this.setVelocity(velocity);
    }
    public int getSpeed() {
        return speed;
    }
    private void setSpeed(int speed) {
        this.speed = speed;
    }
    public double getVelocity() {
        return velocity;
    }
    public void setVelocity(double velocity) {
        this.prevVelocity = this.velocity;
        this.velocity = velocity;
    }
    public double getPrevVelocity(){
        return this.prevVelocity;
    }
    public double getDefaultVelocity(){
        return this.defaultVelocity;
    }
}
