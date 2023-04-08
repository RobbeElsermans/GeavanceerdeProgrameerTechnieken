package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABulletEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.ShootingComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.types.FromWhoBulletType;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.Position;

/**
 * Een overkoepelende shootSystem waar gelijkaardige zaken gebeuren voor elke entiteit die kan schieten.
 */
public class GlobalShootSystem {

    /**
     * Vuurt een kogel af op een bepaalde positie voor een bepaalde entiteit.
     *
     * @param mc De MovementComponent van de entiteit die het afvuurt.
     * @param sc De ShootComponent van de entiteit. Hierin staan de bullets.
     * @param af De Abstract Factory om de bullet entiteit te bemachtigen.
     * @param bt Van wie de kogel afkomstig is.
     * @see MovementComponent
     * @see ShootingComponent
     * @see ABulletEntity
     * @see AFactory#getBulletEntity(IPosition, int, double, double)
     * @see FromWhoBulletType
     */
    public static void fire(MovementComponent mc, ShootingComponent sc, AFactory af, FromWhoBulletType bt) {
        ABulletEntity tempBulletEntity = null;
        if (bt == FromWhoBulletType.ENEMY)
            tempBulletEntity = af.getBulletEntity(new Position(mc.getX() + (mc.getWidth() / 2.0), mc.getY()), 1, sc.getSpeed(), 1);

        if (bt == FromWhoBulletType.PLAYER)
            tempBulletEntity = af.getBulletEntity(new Position(mc.getX() + (mc.getWidth() / 2.0), mc.getY()), 1, sc.getSpeed(), -1);
        sc.getBulletList().add(tempBulletEntity);
    }

    /**
     * Wanneer een bullet een entiteit raakt, wordt er leven vanaf getrokken.
     * <p>
     * Het leven van lc2 wordt van lc1 afgetrokken. Wanneer het leven van lc2 is afgegeven, is zijn leven ook 0.
     * <p>
     * De volgorde is van belang want lc2 zal een life variabelen bevatten.
     * Deze life stelt de damage voor die deze entiteit afgeeft.
     *
     * @param lc1 De LivableComponent van de entiteit die geraakt wordt.
     * @param lc2 De LivableComponent van de entiteit die damage zal doen.
     * @see be.uantwerpen.fti.ei.spaceinvaders.game.collision.BulletCollisionSystem BulletCollisionSystem
     * @see LivableComponent
     */
    public static void damage(LivableComponent lc1, LivableComponent lc2) {
        lc1.downLifeByAmount(lc2.getLife());    //Damage lc1 met lc2 life
        lc2.downLifeByAmount(lc2.getLife());    //lc2 is ook dood want de waarden is afgegeven
    }
}
