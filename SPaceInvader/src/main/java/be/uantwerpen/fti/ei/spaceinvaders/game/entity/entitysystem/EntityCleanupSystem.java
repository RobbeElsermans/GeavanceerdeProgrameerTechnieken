package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABonusEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABulletEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AObstacleEntity;

import java.util.List;

/**
 * Een klasse die entiteiten kan opkuisen a.d.h.v. enkele parameters.
 */
public class EntityCleanupSystem {
    /**
     * Wanneer een bullet een velocity heeft gekregen van 0 of een life van 0,
     * dan is de bullet ergens gebotst en mag deze verwijderd worden.
     *
     * @param bulletEntityList De ABulletEntity lijst van de bullet entiteiten. Hierin worden de bullets bewaard.
     * @return True als er een entiteit verwijderd is.
     */
    public static boolean cleanupBullets(List<ABulletEntity> bulletEntityList) {
        if (!bulletEntityList.isEmpty()) {
            bulletEntityList.removeIf(b -> b.getMovementComponent().getVelocity() == 0);  //Als de entiteit ergens is tegen gebotst.
            bulletEntityList.removeIf(b -> b.getLivableComponent().getLife() == 0);       //Als de entiteit ergens is ingeslagen.
            return true;
        }
        return false;
    }

    /**
     * Wanneer een enemy een life heeft gekregen van 0, is deze dood en mag deze verwijderd worden.
     *
     * @param enemyEntityList De AEnemyEntity lijst van de enemy entiteiten. Hierin worden de enemy's bewaard.
     * @return True als er een entiteit verwijderd is door een life = 0.
     */
    public static boolean cleanupEnemys(List<AEnemyEntity> enemyEntityList) {
        if (!enemyEntityList.isEmpty()) {
            return enemyEntityList.removeIf(b -> b.getLivableComponent().getLife() == 0);       //Als de entiteit geen leven meer heeft.
        }
        return false;
    }

    /**
     * Wanneer een obstacle een life heeft gekregen van 0, is deze kapot en mag deze verwijderd worden.
     *
     * @param obstacleEntitieList De AObstacleEntity lijst van de obstacle entiteiten. Hierin worden de obstacles bewaard.
     * @return True als er een entiteit verwijderd is door een life = 0.
     */
    public static boolean cleanupObstacles(List<AObstacleEntity> obstacleEntitieList) {
        if (!obstacleEntitieList.isEmpty()) {
            return obstacleEntitieList.removeIf(b -> b.getLivableComponent().getLife() == 0);       //Als de entiteit geen leven meer heeft.
        }
        return false;
    }

    /**
     * Wanneer een bonus een life heeft gekregen van 0, is deze dood en mag deze verwijderd worden.
     *
     * @param bonusEntityList De ABonusEntity lijst van de bonus entiteiten. Hierin worden de bonussen bewaard.
     * @return True als er een entiteit verwijderd is door een life = 0.
     */
    public static boolean cleanupBonuses(List<ABonusEntity> bonusEntityList) {
        if (!bonusEntityList.isEmpty()) {
            bonusEntityList.removeIf(b -> b.getMovementComponent().getVelocity() == 0);  //Als de entiteit ergens is tegen gebotst.
            return bonusEntityList.removeIf(b -> b.getLivableComponent().getLife() == 0);       //Als de entiteit geen leven meer heeft.
        }
        return false;
    }
}
