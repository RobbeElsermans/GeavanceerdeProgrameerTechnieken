package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABigEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABonusEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.StatisticsComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.types.CollectableType;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.game.helper.Random;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.Position;

import java.util.List;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Deze klassen behandeld het creëren van entiteiten die d.m.v. parameters in het spel gecreëerd worden.
 * Meer bepaald entiteiten BigEnemy en Bonus.
 * Door middel van de StatisticsComponent, weet de functie wat er gecreëerd moet worden.
 *
 * @see ABigEnemyEntity
 * @see ABonusEntity
 * @see StatisticsComponent
 */
public class EntityCreationSystem {
    /*
     * Een Big enemy heeft een snelheid die omgekeerd
     * wordt telkens wanneer deze aangeroepen wordt.
     * Er bestaat maar 1 entiteit in het spel.
     */
    private int velocity = 1;

    //Deze booleans zorgen ervoor dat de bonus maar 1 keer afgevuurd worden wanneer een bepaalde conditie blijft voordoen.
    private boolean hasFiredBigEnemy = false;
    boolean hasFiredBonus0, hasFiredBonus1, hasFiredBonus2, hasFiredBonus3 = false;
    //Deze zorgt ervoor dan we geen bonus creëren op 2 keer dezelfde score.
    int checkScore;

    /**
     * Creëert een BigEnemy als er aan bepaalde condities voldaan is.
     * <p>
     * Er bestaat maar 1 BigEnemy in het spel.
     * Deze bigEnemy zal bij elke spawn, langs de tegenovergestelde kant komen.
     * <p>
     * Een bigEnemy wordt gespawnd wanneer er een shotHit van modulus 5 bereikt is.
     * Dit betekent dat wanneer een speler, 5 keer een enemy kan raken, er een BigEnemy komt.
     * Bij elke 5 hits, spawn er dus een bigEnemy.
     *
     * @param beel              Een lijst van ABigEnemy's waarin de bigEnemy geplaatst kan worden.
     * @param scl               Een lijst van StatisticsComponent waarop we gaan controleren.
     * @param gfx               De AFactory om de correcte BigEnemy implementatie in te spawnen.
     * @param gameDimention     De dimensies van het spel, opgeslagen in <l>game_config.txt</l>, zodat de BigEnemy correct ingeladen wordt.
     * @param bigEnemyDimension De dimensies van de bigEnemy zelf opgeslagen in <l>game_config.txt</l>. Hierdoor zal de enemy niet buiten het gameveld spawnen.
     * @return boolean True als de bigEnemy gespawnd is. Anders false.
     */
    public boolean bigEnemyCreation(List<ABigEnemyEntity> beel, List<StatisticsComponent> scl, AFactory gfx, IDimension gameDimention, IDimension bigEnemyDimension) {
        if (scl.stream().anyMatch(i -> (i.getShotsHits() % 5 == 0) && (i.getShotsHits() > 0)) && !hasFiredBigEnemy) {
            if (beel.size() == 0) {
                velocity *= -1;
                if (velocity > 0)
                    beel.add(gfx.getBigEnemyEntity(new Position(0, 1), 1, 2, velocity));
                else
                    beel.add(gfx.getBigEnemyEntity(new Position((int) (gameDimention.getWidth() - bigEnemyDimension.getWidth()), 1), 1, 2, velocity));
                hasFiredBigEnemy = true;
                return true;
            }
        } else if (scl.stream().noneMatch(i -> (i.getShotsHits() % 5 == 0) && (i.getShotsHits() > 0))) {
            hasFiredBigEnemy = false;
        }

        return false;
    }

    /**
     * Creëert een Bonus als er aan bepaalde condities voldaan is.
     * <p>
     * Er bestaat maar van elk bonus typen, 1 entiteit in het spel.
     * Wanneer er een bonus spawn gebeurd, zal deze (op random locatie)
     * naar beneden vallen vanaf de bovenkant van het spel.
     * <p>
     * Een <b>LIFE</b> bonus kan spawnen wanneer:
     * <ul>
     *     <li>Er een damageTaken is van modulus 2.
     *     Telkens wanneer een speler 2 levens verliest, zal er een life bonus spawnen met 1 leven.</li>
     *     <li>Er een totale score van modulus 100 bereikt is.
     *     Telkens wanneer een speler een score van 100 bereikt, zal er een life bonus spawnen met 1 leven.
     *     Het is aan de speler om het spel goed te kennen om deze bonus ten volle te gebruiken.</li>
     * </ul>
     * <p>
     * Een <b>BULLET_SPEED</b> bonus kan spawnen wanneer:
     * <ul>
     *     <li>Er een getShotsHits is van modulus 10.
     *     Telkens wanneer een speler 10 keer een enemy neerschiet, zal er een bulletSpeed bonus spawnen met +0.5 speed.</li>
     *     <li>Er een getShotMiss is van modulus 20.
     *     Telkens wanneer een speler 20 keer er naast schiet, zal er een bulletSpeed bonus spawnen met -0.5 speed.
     *     Het is aan de speler om bij te houden welke bonus er juist valt.</li>
     * </ul>
     *
     * @param bel            Een lijst van ABonusEntity's waarin de bonus geplaatst kan worden.
     * @param scl            Een lijst van StatisticsComponent waarop we gaan controleren.
     * @param gfx            De AFactory om de correcte BonusEntity implementatie in te spawnen.
     * @param gameDimention  De dimensies van het spel, opgeslagen in <l>game_config.txt</l>, zodat de BonusEntity correct ingeladen wordt.
     * @param bonusDimension De dimensies van de BonusEntity zelf opgeslagen in <l>game_config.txt</l>. Hierdoor zal de bonus niet buiten het gameveld spawnen.
     * @return boolean True als een Bonus gespawnd is. Anders false.
     * @see Random#getRandom(int)
     */
    public boolean bonusCreation(List<ABonusEntity> bel, List<StatisticsComponent> scl, AFactory gfx, IDimension gameDimention, IDimension bonusDimension) {
        // Als er al een BULLET_SPEED bonus bestaat, niets doen.
        if (bel.stream().noneMatch(i -> i.getCollectableComponent().getType() == CollectableType.BULLET_SPEED)) {
            //Heeft een speler shotHit van %10 bereikt? maak dan een bonus van bullet speed van 0.5 dus versnellen.
            if (!hasFiredBonus0 && scl.stream().anyMatch(i -> (i.getShotsHits() % 10 == 0) && (i.getShotsHits() > 0))) {
                //Wanneer de dimensie van bonus groter is dan 1 tile moeten we de random waarde inperken. Anders niet.
                if (gameDimention.getWidth() * bonusDimension.getWidth() > gameDimention.getWidth()) {
                    bel.add(gfx.getBonusEntity(new Position(Random.getRandom((int) (gameDimention.getWidth() - bonusDimension.getWidth())), 0), 2, 0.5, CollectableType.BULLET_SPEED, 0.5));
                } else {
                    bel.add(gfx.getBonusEntity(new Position(Random.getRandom((int) gameDimention.getWidth()), 0), 2, 0.5, CollectableType.BULLET_SPEED, 0.5));
                }

                hasFiredBonus0 = true;
                return true;
            } else if (scl.stream().noneMatch(i -> (i.getShotsHits() % 10 == 0) && (i.getShotsHits() > 0))) {
                hasFiredBonus0 = false;
            }

            //Heeft een speler shotMiss van %20 bereikt? maak dan een bonus van bullet speed van -0.5 dus vertragen.
            if (!hasFiredBonus1 && scl.stream().anyMatch(i -> (i.getShotsMissed() % 20 == 0) && (i.getShotsMissed() > 0))) {
                //Wanneer de dimensie van bonus groter is dan 1 tile moeten we de random waarde inperken. Anders niet.
                if (gameDimention.getWidth() * bonusDimension.getWidth() > gameDimention.getWidth()) {
                    bel.add(gfx.getBonusEntity(new Position(Random.getRandom((int) (gameDimention.getWidth() - bonusDimension.getWidth())), 0), 4, 0.5, CollectableType.BULLET_SPEED, -0.5));
                } else {
                    bel.add(gfx.getBonusEntity(new Position(Random.getRandom((int) gameDimention.getWidth()), 0), 4, 0.5, CollectableType.BULLET_SPEED, -0.5));
                }

                hasFiredBonus1 = true;
                return true;
            } else if (scl.stream().noneMatch(i -> (i.getShotsMissed() % 20 == 0) && (i.getShotsMissed() > 0))) {

                hasFiredBonus1 = false;
            }
        }

        // Als er al een LIFE-bonus bestaat, niets doen.
        if (bel.stream().noneMatch(i -> i.getCollectableComponent().getType() == CollectableType.LIFE)) {
            //Heeft een speler damageTaken van %2 bereikt? maak dan een bonus van life van 1
            if (!hasFiredBonus2 && scl.stream().anyMatch(i -> (i.getDamageTaken() % 2 == 0) && (i.getDamageTaken() > 0))) {
                //Wanneer de dimensie van bonus groter is dan 1 tile moeten we de random waarde inperken. Anders niet.
                if (gameDimention.getWidth() * bonusDimension.getWidth() > gameDimention.getWidth()) {
                    bel.add(gfx.getBonusEntity(new Position(Random.getRandom((int) (gameDimention.getWidth() - bonusDimension.getWidth())), 0), 2, 0.5, CollectableType.LIFE, 1));
                } else {
                    bel.add(gfx.getBonusEntity(new Position(Random.getRandom((int) gameDimention.getWidth()), 0), 2, 0.5, CollectableType.LIFE, 1));
                }

                hasFiredBonus2 = true;
                return true;
            } else if (scl.stream().noneMatch(i -> (i.getDamageTaken() % 2 == 0) && (i.getDamageTaken() > 0))) {
                hasFiredBonus2 = false;
            }

            //Heeft een speler een score van 100 bereikt? maak dan een bonus van life van 1.
            if (!hasFiredBonus3 && scl.stream().anyMatch(i -> (i.getScore() % 100 == 0) && (i.getScore() > 0))) {
                if (checkScore != scl.stream().map(StatisticsComponent::getScore).filter(score -> score % 100 == 0).toList().get(0)) {
                    //Wanneer de dimensie van bonus groter is dan 1 tile moeten we de random waarde inperken. Anders niet.
                    if (gameDimention.getWidth() * bonusDimension.getWidth() > gameDimention.getWidth()) {
                        bel.add(gfx.getBonusEntity(new Position(Random.getRandom((int) (gameDimention.getWidth() - bonusDimension.getWidth())), 0), 4, 0.5, CollectableType.LIFE, 1));
                    } else {
                        bel.add(gfx.getBonusEntity(new Position(Random.getRandom((int) gameDimention.getWidth()), 0), 4, 0.5, CollectableType.LIFE, 1));
                    }

                    hasFiredBonus3 = true;

                    //We houden bij wat de score was. Hierdoor kan de speler niet nog een bonus krijgen op dezelfde score.
                    checkScore = scl.stream().map(StatisticsComponent::getScore).filter(score -> score % 100 == 0).toList().get(0);
                    return true;
                }
            } else if (scl.stream().noneMatch(i -> (i.getScore() % 100 == 0) && (i.getScore() > 0))) {
                hasFiredBonus3 = false;
            }
        }

        return false;
    }
}
