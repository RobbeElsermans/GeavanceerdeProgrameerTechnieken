package be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABulletEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Position;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;

import java.util.ArrayList;
import java.util.List;

public class ShootComponent {
    private List<ABulletEntity> bullets;

    public ShootComponent(){
        bullets = new ArrayList<>();
    }

    /**
     *
     * @param fromPos
     * @param power
     * @param speed
     * @param velocity
     * @param gfxFact
     */
    public void shoot(Position fromPos, int power,int speed, int velocity,AFactory gfxFact){
        bullets.add(gfxFact.getBulletEntity(fromPos, power, speed, velocity));
    }
    public void shoot(ABulletEntity abe){
        bullets.add(abe);
    }

    public List<ABulletEntity> getBullets(){
        return this.bullets;
    }
}
