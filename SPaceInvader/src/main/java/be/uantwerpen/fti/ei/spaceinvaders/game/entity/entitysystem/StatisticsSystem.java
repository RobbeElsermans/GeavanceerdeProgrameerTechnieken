package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.CollectableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.StatisticsComponent;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Systeem dat de statistieken bijhoud en onderhoud.
 *
 * @see StatisticsComponent
 */
public class StatisticsSystem {
    /**
     * Berekend de score van een StatisticsComponent.
     * <p>
     * De score wordt als volgt berekend:
     * <p>
     * <code>Score = sc.getShotsHits()*10 - sc.getShotsMissed()*10 + (sc.getDamageDone()/10)*10 + sc.getBigEnemyHit()*100;</code>
     * <p>
     * Hierin is te zien dat elke enemy hit, 10 punten zijn.
     * Maar elk schot dat gemist is, is -10 punten.
     * Wanneer men een bigEnemy kan neerhalen is dit 100 punten.
     * <p>
     * De variabele score wordt enkel updated wanneer er geen kogels aan het rond vliegen zijn.
     *
     * @param sc De StatisticsComponent van een entiteit
     */
    public static void calculateScore(StatisticsComponent sc) {
        int tempScore;

        try {
            tempScore = sc.getShotsHits() * 10 - sc.getShotsMissed() * 10 + (sc.getDamageDone() / 10) * 10 + sc.getBigEnemyHit() * 100;
            if (sc.getShotsFired() != 0 && (sc.getShotsFired() == (sc.getShotsHits() + sc.getShotsMissed()))) {
                sc.setScore(tempScore);
            }
        } catch (ArithmeticException ignored) {

        }
    }

    /**
     * Verhoogt shotsFired met 1.
     *
     * @param sc De StatisticsComponent waarin deze value veranderd moet worden.
     * @see StatisticsComponent
     */
    public static void incrementShotFired(StatisticsComponent sc) {
        sc.setShotsFired(sc.getShotsFired() + 1);
    }

    /**
     * Verhoogt shotsHits met 1.
     *
     * @param sc De StatisticsComponent waarin deze value veranderd moet worden.
     * @see StatisticsComponent
     */
    public static void incrementShotHits(StatisticsComponent sc) {
        sc.setShotsHits(sc.getShotsHits() + 1);
    }

    /**
     * Verhoogt shotsMissed met 1.
     *
     * @param sc De StatisticsComponent waarin deze value veranderd moet worden.
     * @see StatisticsComponent
     */
    public static void incrementShotMissed(StatisticsComponent sc) {
        sc.setShotsMissed(sc.getShotsMissed() + 1);
    }

    /**
     * Verhoogt damageTaken met het leven van lc (LivableComponent).
     *
     * @param sc De StatisticsComponent waarin deze value veranderd moet worden.
     * @see StatisticsComponent
     * @see LivableComponent
     */
    public static void incrementDamageTaken(StatisticsComponent sc, LivableComponent lc) {
        sc.setDamageTaken(sc.getDamageTaken() + lc.getLife());
    }

    /**
     * Verhoogt damageDone met het leven van lc (LivableComponent).
     *
     * @param sc De StatisticsComponent waarin deze value veranderd moet worden.
     * @see StatisticsComponent
     * @see LivableComponent
     */
    public static void incrementDamageDone(StatisticsComponent sc, LivableComponent lc) {
        sc.setDamageDone(sc.getDamageDone() + lc.getLife());
    }

    /**
     * Verhoogt livesTaken met de value van cc (CollectableComponent).
     *
     * @param sc De StatisticsComponent waarin deze value veranderd moet worden.
     * @see StatisticsComponent
     * @see CollectableComponent
     */
    public static void incrementLivesTaken(StatisticsComponent sc, CollectableComponent cc) {
        sc.setLivesTaken((int) (sc.getLivesTaken() + cc.getValue()));
    }

    /**
     * Verhoogt bigEnemyHit met 1.
     *
     * @param sc De StatisticsComponent waarin deze value veranderd moet worden.
     * @see StatisticsComponent
     */
    public static void incrementBigEnemyHit(StatisticsComponent sc) {
        sc.setBigEnemyHit(sc.getBigEnemyHit() + 1);
    }

    /**
     * Verhoogt livesLose met 1.
     *
     * @param sc De StatisticsComponent waarin deze value veranderd moet worden.
     * @see StatisticsComponent
     */
    public static void incrementLivesLose(StatisticsComponent sc) {
        sc.setLivesLose(sc.getLivesLose() + 1);
    }
}