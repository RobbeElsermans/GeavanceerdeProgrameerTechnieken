package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.CollectableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.StatisticsComponent;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Systeem dat de statistieken bijhoud en onderhoud.
 */
public class StatisticsSystem {
    /**
     * Berekend de score van een entiteit
     * @param sc    De StatisticsComponent van een entiteit
     */
    public static void calculateScore(StatisticsComponent sc){
        // (hits/fired)*damageDone*10
        // System.out.println(sc);
        int tempScore;
        try{
            tempScore = sc.getShotsHits()*10 - sc.getShotsMissed()*10 + (sc.getDamageDone()/10)*10;
            if(sc.getShotsFired() != 0 && (sc.getShotsFired() == (sc.getShotsHits() + sc.getShotsMissed()))) {
                sc.setScore(tempScore);
            }
        }
        catch (ArithmeticException ignored){

        }
        /*
        int tempScore = sc.getShotsHits()*10 - ((sc.getShotsMissed()/sc.getDamageDone())/10)*10;
        System.out.println(tempScore);
        if(sc.getShotsFired() != 0 && (sc.getShotsFired() == (sc.getShotsHits() + sc.getShotsMissed()))) {
            sc.setScore(tempScore);
        }

         */
    }

    public static void incrementShotFired(StatisticsComponent sc){
        sc.setShotsFired(sc.getShotsFired() + 1);
    }

    public static void incrementShotHit(StatisticsComponent sc){
        sc.setShotsHits(sc.getShotsHits() + 1);
    }

    public static void incrementShotMiss(StatisticsComponent sc){
        sc.setShotsMissed(sc.getShotsMissed() + 1);
    }

    public static void incrementDamageTaken(StatisticsComponent sc, LivableComponent lc) {
        sc.setDamageTaken(sc.getDamageTaken() + lc.getLife());
    }

    public static void incrementDamageDone(StatisticsComponent sc, LivableComponent lc) {
        sc.setDamageDone(sc.getDamageDone() + lc.getLife());
    }

    public static void incrementLivesTaken(StatisticsComponent sc, CollectableComponent cc) {
        sc.setLivesTaken((int) (sc.getLivesTaken()+cc.getValue()));
    }
}
