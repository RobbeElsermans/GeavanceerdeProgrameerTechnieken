package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABulletEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Een component dat kan schieten en dat een lijst van zijn schoten bijhoudt.
 */
public class ShootingComponent {
    /**
     * De lijst met afgevuurde schoten.
     */
    private List<ABulletEntity> bulletList;

    /**
     * Default constructor die positie en dimensie op default zal plaatsen.
     */
    public ShootingComponent() {
        this.bulletList = new ArrayList<>();
    }

    /**
     * Een functie dat schiet.
     * @param bulletEntity  De kogel die wordt afgeschoten.
     */
    public void shoot(ABulletEntity bulletEntity){
        this.bulletList.add(bulletEntity);
    }

    public List<ABulletEntity> getBulletList() {
        return bulletList;
    }

    @Override
    public String toString() {
        return "ShootingComponent{" +
                "bulletList=" + bulletList.stream().map(ABulletEntity::toString) +
                '}';
    }
}
