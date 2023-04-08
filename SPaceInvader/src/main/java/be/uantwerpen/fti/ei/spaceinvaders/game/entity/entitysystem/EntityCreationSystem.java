package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem;

import be.uantwerpen.fti.ei.spaceinvaders.game.helper.Random;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABigEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABonusEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.types.CollectableType;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.StatisticsComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.Position;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;

import java.util.List;

public class EntityCreationSystem {


    /**
     * Een Big enemy heeft een snelheid die omgekeerd
     * wordt telkens wanneer deze aangeroepen wordt.
     * Er bestaat maar 1 entiteit in het spel.
     */
    private int velocity = 1;
    private boolean hasFiredBigEnemy = false;

    boolean hasFiredBonus0, hasFiredBonus1, hasFiredBonus2, hasFiredBonus3 = false;
    int checkScore;

    /**
     * Update BigEnemy wanneer deze ingeladen wordt en hoe.
     * @param bee
     * @param sc
     * @return
     */
    public boolean bigEnemyCreation(List<ABigEnemyEntity> bee, List<StatisticsComponent> sc, AFactory gfx, IDimension gameDimention, IDimension bigEnemyDimension){
        if (sc.stream().anyMatch(i -> (i.getShotsHits() % 5 == 0) && (i.getShotsHits() > 0)) && !hasFiredBigEnemy) {
            if (bee.size() == 0) {
                velocity *= -1;
                if (velocity > 0)
                    bee.add(gfx.getBigEnemyEntity(new Position(0, 1), 1, 2, velocity));
                else
                    bee.add(gfx.getBigEnemyEntity(new Position((int) (gameDimention.getWidth()-bigEnemyDimension.getWidth()), 1), 1, 2, velocity));
                hasFiredBigEnemy = true;
                return true;
            }
        }
        else if (sc.stream().noneMatch(i -> (i.getShotsHits() % 5 == 0) && (i.getShotsHits() > 0))){
            hasFiredBigEnemy = false;
        }

        return false;
    }

    /**
     * Update Bonus hoe deze ingeladen wordt en waar.
     *
     * @param be
     * @param sc
     * @return
     */
    public boolean bonusCreation(List<ABonusEntity> be, List<StatisticsComponent> sc, AFactory gfx, IDimension gameDimention, IDimension bonusDimension) {
        // Als er al een MOVE_SPEED bonus bestaat, niets doen.
        if (be.stream().noneMatch(i -> i.getCollectableComponent().getType() == CollectableType.BULLET_SPEED)) {
            //Heeft een speler shotHit van %10 bereikt? maak dan een bonus van bullet speed van 0.5 dus versnellen.
            if (!hasFiredBonus0 && sc.stream().anyMatch(i -> (i.getShotsHits() % 10 == 0) && (i.getShotsHits() > 0))) {
                be.add(gfx.getBonusEntity(new Position(Random.getRandom((int) gameDimention.getWidth()), 0), 2, 0.5, CollectableType.BULLET_SPEED, 0.5));
                hasFiredBonus0 = true;
                return true;
            } else if (sc.stream().noneMatch(i -> (i.getShotsHits() % 10 == 0) && (i.getShotsHits() > 0))) {
                hasFiredBonus0 = false;
            }

            //Heeft een speler shotMiss van %20 bereikt? maak dan een bonus van bullet speed van -0.5 dus vertragen.
            if (!hasFiredBonus1 && sc.stream().anyMatch(i -> (i.getShotsMissed() % 20 == 0) && (i.getShotsMissed() > 0))) {
                be.add(gfx.getBonusEntity(new Position(Random.getRandom((int) gameDimention.getWidth()), 0), 4, 0.5, CollectableType.BULLET_SPEED, -0.5));
                hasFiredBonus1 = true;
                return true;
            }
            else if (sc.stream().noneMatch(i -> (i.getShotsMissed() % 20 == 0) && (i.getShotsMissed() > 0))){

                hasFiredBonus1 = false;
            }
        }

        // Als er al een LIFE bonus bestaat, niets doen.
        if (be.stream().noneMatch(i -> i.getCollectableComponent().getType() == CollectableType.LIFE)) {
            //Heeft een speler damageTaken van %2 bereikt? maak dan een bonus van life van 1
            if (!hasFiredBonus2 && sc.stream().anyMatch(i -> (i.getDamageTaken() % 2 == 0) && (i.getDamageTaken() > 0))) {
                be.add(gfx.getBonusEntity(new Position(Random.getRandom((int) gameDimention.getWidth()), 0), 2, 0.5, CollectableType.LIFE, 1));
                hasFiredBonus2 = true;
                return true;
            } else if (sc.stream().noneMatch(i -> (i.getDamageTaken() % 2 == 0) && (i.getDamageTaken() > 0))) {
                hasFiredBonus2 = false;
            }

            //Heeft een speler een score van 100 bereikt? maak dan een bonus van life van 1.
            if (!hasFiredBonus3 && sc.stream().anyMatch(i -> (i.getScore() % 100 == 0) && (i.getScore() > 0))) {
                if(checkScore != sc.stream().map(StatisticsComponent::getScore).filter(score -> score %100 ==0).toList().get(0)) {
                    be.add(gfx.getBonusEntity(new Position(Random.getRandom((int) gameDimention.getWidth()), 0), 4, 0.5, CollectableType.LIFE, 1));
                    hasFiredBonus3 = true;
                    checkScore = sc.stream().map(StatisticsComponent::getScore).filter(score -> score % 100 == 0).toList().get(0);
                    return true;
                }
            }
            else if (sc.stream().noneMatch(i -> (i.getScore() % 100 == 0) && (i.getScore() > 0))){
                hasFiredBonus3 = false;
            }
        }

        return false;
    }
}
