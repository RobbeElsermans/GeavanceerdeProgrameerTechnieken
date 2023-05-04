package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.*;

import java.util.List;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Een klasse die entiteiten kan opkuisen a.d.h.v. parameters.
 */
public class EntityCleanupSystem {
    /**
     * Een methode dedicated voor het opkuisen van bullets.
     * <p>
     * Wanneer een bullet een velocity heeft gekregen van 0 of een life van 0,
     * dan is de bullet ergens gebotst of ingeslagen en mag deze verwijderd worden.
     *
     * @param bulletEntityList De ABulletEntity lijst van de bullet entiteiten. Hierin worden de bullets bewaard.
     */
    public static void cleanupBullets(List<ABulletEntity> bulletEntityList) {
        if (!bulletEntityList.isEmpty()) {
            bulletEntityList.removeIf(b -> b.getMovementComponent().getVelocity() == 0);  //Als de entiteit ergens is tegen gebotst.
            bulletEntityList.removeIf(b -> b.getLivableComponent().getLife() == 0);       //Als de entiteit ergens is ingeslagen.
        }
    }

    /**
     * Een methode dedicated voor het opkuisen van enemy's.
     * <p>
     * Wanneer een enemy een life heeft gekregen van 0, is deze dood en mag deze verwijderd worden.
     *
     * @param enemyEntityList De AEnemyEntity lijst van de enemy entiteiten. Hierin worden de enemy's bewaard.
     * @return True als er een entiteit verwijderd is. Anders false.
     */
    public static boolean cleanupEnemys(List<AEnemyEntity> enemyEntityList) {
        if (!enemyEntityList.isEmpty()) {
            return enemyEntityList.removeIf(b -> b.getLivableComponent().getLife() == 0);       //Als de entiteit geen leven meer heeft.
        }
        return false;
    }

    /**
     * Een methode dedicated voor het opkuisen van obstakels.
     * <p>
     * Wanneer een obstacle een life heeft gekregen van 0, is deze kapot en mag deze verwijderd worden.
     *
     * @param obstacleEntitieList De AObstacleEntity lijst van de obstacle entiteiten. Hierin worden de obstacles bewaard.
     */
    public static void cleanupObstacles(List<AObstacleEntity> obstacleEntitieList) {
        if (!obstacleEntitieList.isEmpty()) {
            obstacleEntitieList.removeIf(b -> b.getLivableComponent().getLife() == 0);       //Als de entiteit geen leven meer heeft.
        }
    }

    /**
     * Een methode dedicated voor het opkuisen van big enemy's.
     * <p>
     * Wanneer een bonus een life heeft gekregen van 0, is deze dood en mag deze verwijderd worden.
     *
     * @param bonusEntityList De ABonusEntity lijst van de bonus entiteiten. Hierin worden de bonussen bewaard.
     * @return True als er een entiteit verwijderd is. Anders false.
     */
    public static boolean cleanupBigEnemy(List<ABigEnemyEntity> bonusEntityList) {
        if (!bonusEntityList.isEmpty()) {
            bonusEntityList.removeIf(b -> b.getMovementComponent().getVelocity() == 0);  //Als de entiteit ergens is tegen gebotst.
            return bonusEntityList.removeIf(b -> b.getLivableComponent().getLife() == 0);       //Als de entiteit geen leven meer heeft.
        }
        return false;
    }

    /**
     * Een methode dedicated voor het opkuisen van bonussen.
     * <p>
     * Wanneer een bonus een velocity heeft gekregen van 0 of collected is,
     * dan is deze ergens gebotst of opgenomen door een entiteit en mag deze verwijderd worden.
     *
     * @param bonusEntityList De ABonusEntity lijst van de bonus entiteiten. Hierin worden de bonussen bewaard.
     */
    public static void cleanupBonuses(List<ABonusEntity> bonusEntityList) {
        if (!bonusEntityList.isEmpty()) {
            bonusEntityList.removeIf(b -> b.getMovementComponent().getVelocity() == 0);         //Als de entiteit ergens is tegen gebotst.
            bonusEntityList.removeIf(b -> b.getCollectableComponent().getValue() == 0);  //Als de entiteit collected is.
        }
    }
}
