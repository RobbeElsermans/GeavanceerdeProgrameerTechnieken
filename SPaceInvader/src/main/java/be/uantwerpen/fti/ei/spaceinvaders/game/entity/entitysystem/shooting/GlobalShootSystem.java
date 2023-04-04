package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABulletEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Position;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;

import java.util.List;

public class GlobalShootSystem {

    /**
     * Vuurt een kogel af op een bepaalde positie voor een bepaalde entiteit.
     * @param mc De MovementComponent van de enteit die het afvuurt.
     * @param bulletEntities De ShootComponent van de entiteit. Hierin gaan we de bullets bewaren.
     * @param af De Abstract Factory om het bullet typen te bemachtigen
     */
    public static void fire(MovementComponent mc, List<ABulletEntity> bulletEntities, AFactory af, FromWhoBulletType bt){
        ABulletEntity tempBulletEntity = null;
        if(bt == FromWhoBulletType.enemy)
            tempBulletEntity = af.getBulletEntity(new Position(mc.getX()+(mc.getWidth()/2), mc.getY()), 1, 2, 1);

        if(bt == FromWhoBulletType.player)
            tempBulletEntity = af.getBulletEntity(new Position(mc.getX()+(mc.getWidth()/2), mc.getY()), 1, 2, -1);
        bulletEntities.add(tempBulletEntity);
    }

    /**
     * Wanneer een bullet een entiteit raakt, wordt er leven vanaf getrokken.
     * @param lc1 De LivableComponent van de entiteit die geraakt wordt.
     * @param lc2 De LivableComponent van de entiteit die damage zal doen.
     *
     * @implNote lc2 zal een life variabelen bevatten. Deze life stelt de damage voor die deze entiteit afgeeft.
     */
    public static void damage(LivableComponent lc1, LivableComponent lc2){
        lc1.downLifeByAmount(lc2.getLife());    //Damage lc1 met lc2 life
        lc2.downLifeByAmount(lc2.getLife());    //lc2 is ook dood want de waarden is afgegeven
    }
}
