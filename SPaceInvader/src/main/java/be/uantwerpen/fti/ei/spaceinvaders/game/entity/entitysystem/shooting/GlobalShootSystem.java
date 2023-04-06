package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABulletEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.ShootingComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Position;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;

/**
 * Een overkoepelende shootSystem waar gelijkaardige zaken gebeuren.
 */
public class GlobalShootSystem {

    /**
     * Vuurt een kogel af op een bepaalde positie voor een bepaalde entiteit.
     *
     * @param mc De MovementComponent van de enteit die het afvuurt.
     * @param sc De ShootComponent van de entiteit. Hierin staan de bullets.
     * @param af De Abstract Factory om de bullet entiteit te bemachtigen.
     * @param bt Van wie de kogel afkomstig is.
     */
    public static void fire(MovementComponent mc, ShootingComponent sc, AFactory af, FromWhoBulletType bt) {
        ABulletEntity tempBulletEntity = null;
        if (bt == FromWhoBulletType.ENEMY)
            tempBulletEntity = af.getBulletEntity(new Position(mc.getX() + (mc.getWidth() / 2), mc.getY()), 1, 2, 1);

        if (bt == FromWhoBulletType.PLAYER)
            tempBulletEntity = af.getBulletEntity(new Position(mc.getX() + (mc.getWidth() / 2), mc.getY()), 1, 2, -1);
        sc.getBulletList().add(tempBulletEntity);
    }

    /**
     * Wanneer een bullet een entiteit raakt, wordt er leven vanaf getrokken.
     *
     * @param lc1 De LivableComponent van de entiteit die geraakt wordt.
     * @param lc2 De LivableComponent van de entiteit die damage zal doen.
     * @implNote lc2 zal een life variabelen bevatten. Deze life stelt de damage voor die deze entiteit afgeeft.
     */
    public static void damage(LivableComponent lc1, LivableComponent lc2) {
        lc1.downLifeByAmount(lc2.getLife());    //Damage lc1 met lc2 life
        lc2.downLifeByAmount(lc2.getLife());    //lc2 is ook dood want de waarden is afgegeven
    }
}
