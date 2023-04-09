package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABulletEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Een component dat kan schieten en dat een lijst van zijn schoten bijhoudt.
 *
 * @see ABulletEntity
 */
public class ShootingComponent {
    /**
     * De lijst met afgevuurde schoten.
     */
    private final List<ABulletEntity> bulletList;

    /**
     * De snelheid van een bullet
     */
    private double speed;

    /**
     * Default constructor waarbij:
     * <ul>
     *     <li>speed  -> 2</li>
     * </ul>
     *
     * @see ABulletEntity
     */
    public ShootingComponent() {
        this.bulletList = new ArrayList<>();
        this.speed = 2;
    }

    /**
     * Een functie dat schiet.
     * @param bulletEntity  De kogel die wordt afgeschoten.
     */
    public void shoot(ABulletEntity bulletEntity){
        this.bulletList.add(bulletEntity);
        this.speed = 2;
    }

    public List<ABulletEntity> getBulletList() {
        return bulletList;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        if(speed < 1)
            this.speed = 1;
        else
            this.speed = speed;
    }


    @Override
    public String toString() {
        return "ShootingComponent{" +
                "bulletList=" + bulletList.stream().map(ABulletEntity::toString) +
                ", speed=" + speed +
                '}';
    }
}