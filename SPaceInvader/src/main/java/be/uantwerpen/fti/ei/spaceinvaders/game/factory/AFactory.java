package be.uantwerpen.fti.ei.spaceinvaders.game.factory;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.*;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.CollectableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.types.CollectableType;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

import java.util.List;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Een GFX abstract factory waarmee de game logica zijn entiteiten en abstracties van krijgt.
 * <p>
 * Om een graphics-systeem te maken, moet van AFactory overgeërfd worden en elke methode ingevuld worden.
 * @see be.uantwerpen.fti.ei.spaceinvaders.gfx.console.FactoryConsole Een console graphics-systeem, volledig geïmplementeerd.
 * @see be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.FactoryJ2d Een 2D graphics-systeem, volledig geïmplementeerd.
 */
public abstract class AFactory {

    /**
     * Variabelen die de speldimensie bijhoudt.
     * <p>
     * Deze kan ook benaderd worden door de child classes.
     */
    protected IDimension gameDimension;

    /**
     * @param dimension De game dimensie beschreven in <i>game_config.txt</i>.
     * @description De game dimensies doorspelen naar de abstract factory.
     */
    public void setupGameDimension(IDimension dimension) {
        this.gameDimension = dimension;
    }

    /**
     * Geeft een APlayerEntity object terug met default waarden.
     * <p>
     * De dimensies van een entiteit worden gedefinieerd in het configuratiebestand <i>gfx_config.txt</i> van de GFX-library.
     * Deze dimensie mag niet groter zijn dan de dimensies gedefinieerd in <i>game_config.txt</i>.
     * <p>
     * In de methode kan de dimensie, gedefinieerd in <i>game_config.txt</i>, en positie omgevormd worden naar de graphics-systeem dimensies.
     *
     * @return APlayerEntity object specifiek van een graphics-systeem.
     * @see APlayerEntity
     * @see APlayerEntity#APlayerEntity() APlayerEntity()
     * @see AFactory#getInput() getInput()
     */
    public abstract APlayerEntity getPlayerEntity();

    /**
     * Geeft een APlayerEntity object terug met extra parameters.
     * <p>
     * Het APlayerEntity wordt gebruikt door de speler van het spel. Deze zal d.m.v. IInput kunnen bewegen.
     * <p>
     * De dimensies van een entiteit worden gedefinieerd in het configuratiebestand <i>gfx_config.txt</i> van de GFX-library.
     * Deze dimensie mag niet groter zijn dan de dimensies gedefinieerd in <i>game_config.txt</i>.
     * <p>
     * In de methode kan de dimensie, gedefinieerd in <i>game_config.txt</i>, en positie omgevormd worden naar de graphics-systeem dimensies.
     *
     * @param position Een positie van de entiteit als IPosition. Deze zijn in game dimensie waarden.
     * @param life     Het leven van de entiteit als integer.
     * @param speed    De snelheid waarmee de entiteit zich verplaatst als double.
     * @param velocity De versnelling waarmee de entiteit zich verplaatst als double.
     * @return APlayerEntity Een APlayerEntity specifiek van een graphics-systeem.
     * @see APlayerEntity
     * @see APlayerEntity#APlayerEntity(MovementComponent, LivableComponent) APlayerEntity(MovementComponent, LivableComponent)
     * @see AFactory#getInput() getInput()
     */
    public abstract APlayerEntity getPlayerEntity(IPosition position, int life, double speed, double velocity);

    /**
     * Geeft een AEnemyEntity object terug met default waarden.
     * <p>
     * Het AEnemyEntity wordt gebruikt om een enemy te maken. Deze enemy zal b
     * Een speler kan de enemy doodschieten door zijn life om 0 te brengen.
     * <p>
     * De dimensies van een entiteit worden gedefinieerd in het configuratiebestand <i>gfx_config.txt</i> van de GFX-library.
     * Deze dimensie mag niet groter zijn dan de dimensies gedefinieerd in <i>game_config.txt</i>.
     * <p>
     * In de methode kan de dimensie, gedefinieerd in <i>game_config.txt</i>, en positie omgevormd worden naar de graphics-systeem dimensies.
     *
     * @return AEnemyEntity object specifiek voor een graphics-systeem.
     * @see AEnemyEntity
     * @see AEnemyEntity#AEnemyEntity()  AEnemyEntity()
     */
    public abstract AEnemyEntity getEnemyEntity();

    /**
     * Geeft een AEnemyEntity object terug met extra parameters.
     * <p>
     * Het AEnemyEntity wordt gebruikt om een enemy te maken. Deze enemy zal bewegen in een bepaalde voorop samengesteld patroon.
     * Een speler kan de enemy doodschieten door zijn life om 0 te brengen.
     * <p>
     * De dimensies van een entiteit worden gedefinieerd in het configuratiebestand <i>gfx_config.txt</i> van de GFX-library.
     * Deze dimensie mag niet groter zijn dan de dimensies gedefinieerd in <i>game_config.txt</i>.
     * <p>
     * In de methode kan de dimensie, gedefinieerd in <i>game_config.txt</i>, en positie omgevormd worden naar de graphics-systeem dimensies.
     *
     * @param position Een positie van de entiteit als IPosition. Deze zijn in game dimensie waarden.
     * @param life     Het leven van de entiteit als integer.
     * @param speed    De snelheid waarmee de entiteit zich verplaatst als double.
     * @param velocity De versnelling waarmee de entiteit zich verplaatst als double.
     * @return AEnemyEntity Een AEnemyEntity specifiek van een graphics-systeem.
     * @see AEnemyEntity
     * @see AEnemyEntity#AEnemyEntity(MovementComponent, LivableComponent) AEnemyEntity(MovementComponent, LivableComponent)
     */
    public abstract AEnemyEntity getEnemyEntity(IPosition position, int life, double speed, double velocity);

    /**
     * Geeft een ABulletEntity object terug met default waarden.
     * <p>
     * Het ABulletEntity wordt gebruikt door zowel de speler als de enemy om een kogel af te vuren.
     * Het enige verschil tussen beide is de velocity, speed en eventueel life (wat de schaden voorstelt).
     * <p>
     * De dimensies van een entiteit worden gedefinieerd in het configuratiebestand <i>gfx_config.txt</i> van de GFX-library.
     * Deze dimensie mag niet groter zijn dan de dimensies gedefinieerd in <i>game_config.txt</i>. Mag wel kleiner zijn.
     * <p>
     * In de methode kan de dimensie, gedefinieerd in <i>game_config.txt</i>, en positie omgevormd worden naar de graphics-systeem dimensies.
     *
     * @return ABulletEntity Een ABulletEntity specifiek van een graphics-systeem.
     * @see ABulletEntity
     * @see ABulletEntity#ABulletEntity() ABulletEntity()
     */
    public abstract ABulletEntity getBulletEntity();

    /**
     * Geeft een ABulletEntity object terug met extra parameters.
     * <p>
     * Het ABulletEntity wordt gebruikt door zowel de speler als de enemy om een kogel af te vuren.
     * Het enige verschil tussen beide is de velocity, speed en eventueel life (wat de schaden voorstelt).
     * <p>
     * De dimensies van een entiteit worden gedefinieerd in het configuratiebestand <i>gfx_config.txt</i> van de GFX-library.
     * Deze dimensie mag niet groter zijn dan de dimensies gedefinieerd in <i>game_config.txt</i>. Mag wel kleiner zijn.
     * <p>
     * In de methode kan de dimensie, gedefinieerd in <i>game_config.txt</i>, en positie omgevormd worden naar de graphics-systeem dimensies.
     *
     * @param position Een positie van de entiteit als IPosition. Deze zijn in game dimensie waarden.
     * @param life     Het leven van de entiteit als integer.
     * @param speed    De snelheid waarmee de entiteit zich verplaatst als double.
     * @param velocity De versnelling waarmee de entiteit zich verplaatst als double.
     * @return ABulletEntity Een ABulletEntity specifiek van een graphics-systeem.
     * @see ABulletEntity
     * @see ABulletEntity#ABulletEntity() ABulletEntity()
     */
    public abstract ABulletEntity getBulletEntity(IPosition position, int life, double speed, double velocity);

    /**
     * Geeft een AObstacleEntity object terug met default waarden.
     * <p>
     * Het AObstacleEntity is een niet-beweegbaar entiteit dat kan gebruikt worden als schild door de speler.
     * <p>
     * De dimensies van een entiteit worden gedefinieerd in het configuratiebestand <i>gfx_config.txt</i> van de GFX-library.
     * Deze dimensie mag niet groter zijn dan de dimensies gedefinieerd in <i>game_config.txt</i>. Mag wel kleiner zijn.
     * <p>
     * In de methode kan de dimensie, gedefinieerd in <i>game_config.txt</i>, en positie omgevormd worden naar de graphics-systeem dimensies.
     *
     * @return AObstacleEntity Een AObstacleEntity specifiek van een graphics-systeem.
     * @see AObstacleEntity
     * @see AObstacleEntity#AObstacleEntity() AObstacleEntity()
     */
    public abstract AObstacleEntity getObstacleEntity();

    /**
     * Geeft een AObstacleEntity object terug met extra parameters.
     * <p>
     * Het AObstacleEntity is een niet-beweegbaar entiteit dat kan gebruikt worden als schild door de speler.
     * <p>
     * De dimensies van een entiteit worden gedefinieerd in het configuratiebestand <i>gfx_config.txt</i> van de GFX-library.
     * Deze dimensie mag niet groter zijn dan de dimensies gedefinieerd in <i>game_config.txt</i>. Mag wel kleiner zijn.
     * <p>
     * In de methode kan de dimensie, gedefinieerd in <i>game_config.txt</i>, en positie omgevormd worden naar de graphics-systeem dimensies.
     *
     * @param position Een positie van de entiteit als IPosition. Deze zijn in game dimensie waarden.
     * @param life     Het leven van de entiteit als integer.
     * @return AObstacleEntity Een v specifiek van een graphics-systeem.
     * @see AObstacleEntity
     * @see AObstacleEntity#AObstacleEntity() AObstacleEntity()
     */
    public abstract AObstacleEntity getObstacleEntity(IPosition position, int life);

    /**
     * Geeft een ABigEnemyEntity object terug met default waarden.
     * <p>
     * Het ABigEnemyEntity is een speciale enemy die bij een bepaalde voorwaarde, bovenaan het spel voorbij komt.
     * <p>
     * De dimensies van een entiteit worden gedefinieerd in het configuratiebestand <i>gfx_config.txt</i> van de GFX-library.
     * Deze dimensie mag niet groter zijn dan de dimensies gedefinieerd in <i>game_config.txt</i>. Mag wel kleiner zijn.
     * <p>
     * In de methode kan de dimensie, gedefinieerd in <i>game_config.txt</i>, en positie omgevormd worden naar de graphics-systeem dimensies.
     *
     * @return ABigEnemyEntity Een ABigEnemyEntity specifiek van een graphics-systeem.
     * @see ABigEnemyEntity
     * @see ABigEnemyEntity#ABigEnemyEntity() ABigEnemyEntity()
     */
    public abstract ABigEnemyEntity getBigEnemyEntity();

    /**
     * Geeft een ABigEnemyEntity object terug met extra parameters.
     * <p>
     * Het ABigEnemyEntity is een speciale enemy die bij een bepaalde voorwaarde, bovenaan het spel voorbij komt.
     * <p>
     * De dimensies van een entiteit worden gedefinieerd in het configuratiebestand <i>gfx_config.txt</i> van de GFX-library.
     * Deze dimensie mag niet groter zijn dan de dimensies gedefinieerd in <i>game_config.txt</i>. Mag wel kleiner zijn.
     * <p>
     * In de methode kan de dimensie, gedefinieerd in <i>game_config.txt</i>, en positie omgevormd worden naar de graphics-systeem dimensies.
     *
     * @param position Een positie van de entiteit als IPosition. Deze zijn in game dimensie waarden.
     * @param life     Het leven van de entiteit als integer.
     * @param speed    De snelheid waarmee de entiteit zich verplaatst als double.
     * @param velocity De versnelling waarmee de entiteit zich verplaatst als double.
     * @return ABigEnemyEntity Een ABigEnemyEntity specifiek van een graphics-systeem.
     * @see ABigEnemyEntity
     * @see ABigEnemyEntity#ABigEnemyEntity() ABigEnemyEntity()
     */
    public abstract ABigEnemyEntity getBigEnemyEntity(IPosition position, int life, double speed, double velocity);

    /**
     * Geeft een ABonusEntity object terug met default waarden.
     * <p>
     * Het ABonusEntity is een bonus die volgende bonussen kan afgeven.
     * <ul>
     *     <li>LIFE</li> -> Kan het leven van de entiteit bevorderen.
     *     <li>BULLET_SPEED</li> -> Kan de schietsnelheid van de entiteit veranderen.
     * </ul>
     * Deze bonussen worden afgegeven in EntityCreationSystem wanneer een bepaalde eigenschap voldaan is in StatisticsComponent.
     * TODO: Nog in game_config.txt plaatsen en doorvoeren.
     * <p>
     * De dimensies van een entiteit worden gedefinieerd in het configuratiebestand <i>gfx_config.txt</i> van de GFX-library.
     * Deze dimensie mag niet groter zijn dan de dimensies gedefinieerd in <i>game_config.txt</i>. Mag wel kleiner zijn.
     * <p>
     * In de methode kan de dimensie, gedefinieerd in <i>game_config.txt</i>, en positie omgevormd worden naar de graphics-systeem dimensies.
     *
     * @return ABonusEntity Een ABonusEntity specifiek van een graphics-systeem.
     * @see ABonusEntity
     * @see ABonusEntity#ABonusEntity() ABonusEntity()
     * @see CollectableType
     * @see be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.StatisticsComponent StatisticsComponent
     * @see be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.EntityCreationSystem#bonusCreation(List, List, AFactory, IDimension, IDimension)  bonusCreation(List, List, AFactory, IDimension, IDimension)
     */
    public abstract ABonusEntity getBonusEntity();

    /**
     * Geeft een ABonusEntity object terug met extra parameters.
     * <p>
     * Het ABonusEntity is een bonus ( positief of negatief ) die volgende bonussen kan afgeven.
     * <ul>
     *     <li>LIFE</li> -> Kan het leven van de entiteit bevorderen.
     *     <li>BULLET_SPEED</li> -> Kan de schietsnelheid van de entiteit veranderen.
     * </ul>
     * Deze bonussen worden afgegeven in EntityCreationSystem wanneer een bepaalde eigenschap voldaan is in StatisticsComponent.
     * TODO: Nog in game_config.txt plaatsen en doorvoeren.
     * <p>
     * De dimensies van een entiteit worden gedefinieerd in het configuratiebestand <i>gfx_config.txt</i> van de GFX-library.
     * Deze dimensie mag niet groter zijn dan de dimensies gedefinieerd in <i>game_config.txt</i>. Mag wel kleiner zijn.
     * <p>
     * In de methode kan de dimensie, gedefinieerd in <i>game_config.txt</i>, en positie omgevormd worden naar de graphics-systeem dimensies.
     *
     * @param position Een positie van de entiteit als IPosition. Deze zijn in game dimensies.
     * @param speed    De snelheid waarmee de entiteit zich verplaatst als double.
     * @param velocity De versnelling waarmee de entiteit zich verplaatst als double.
     * @param type     het type collectable gedefinieerd in CollectableType.
     * @param value    De waarde van de collectable. Dit kan zowel positief als negatief zijn.
     * @return ABonusEntity Een ABonusEntity specifiek van een graphics-systeem.
     * @see ABonusEntity
     * @see ABonusEntity#ABonusEntity(MovementComponent, CollectableComponent) ABonusEntity(MovementComponent, CollectableComponent)
     * @see CollectableType
     * @see MovementComponent
     * @see CollectableComponent
     * @see be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.StatisticsComponent StatisticsComponent
     * @see be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.EntityCreationSystem#bonusCreation(List, List, AFactory, IDimension, IDimension)  bonusCreation(List, List, AFactory, IDimension, IDimension)
     */
    public abstract ABonusEntity getBonusEntity(IPosition position, double speed, double velocity, CollectableType type, double value);

    /**
     * Geeft een ABonusEntity object terug met extra parameters.
     * <p>
     * Het ABonusEntity is een bonus ( positief of negatief ) die volgende bonussen kan afgeven.
     * <ul>
     *     <li>LIFE</li> -> Kan het leven van de entiteit bevorderen.
     *     <li>BULLET_SPEED</li> -> Kan de schietsnelheid van de entiteit veranderen.
     * </ul>
     * Deze bonussen worden afgegeven in EntityCreationSystem wanneer een bepaalde eigenschap voldaan is in StatisticsComponent.
     * TODO: Nog in game_config.txt plaatsen en doorvoeren.
     * <p>
     * De <b>randValueRange</b> kan gebruikt worden om een random waarde door te voeren naar
     * CollectableComponent wat de value betreft van de collectable. Om de random te genereren is er
     * een help klasse ontworpen genaamd Random.
     * <p>
     * De dimensies van een entiteit worden gedefinieerd in het configuratiebestand <i>gfx_config.txt</i> van de GFX-library.
     * Deze dimensie mag niet groter zijn dan de dimensies gedefinieerd in <i>game_config.txt</i>. Mag wel kleiner zijn.
     * <p>
     * In de methode kan de dimensie, gedefinieerd in <i>game_config.txt</i>, en positie omgevormd worden naar de graphics-systeem dimensies.
     *
     * @param position       Een positie van de entiteit als IPosition. Deze zijn in game dimensies.
     * @param speed          De snelheid waarmee de entiteit zich verplaatst als double.
     * @param velocity       De versnelling waarmee de entiteit zich verplaatst als double.
     * @param randValueRange De random range startend van 0 tot randValueRange dus [0, randValueRange].
     * @return ABonusEntity Een ABonusEntity specifiek van een graphics-systeem.
     * @see ABonusEntity
     * @see ABonusEntity#ABonusEntity(MovementComponent, CollectableComponent)  ABonusEntity(MovementComponent, CollectableComponent)
     * @see CollectableType
     * @see MovementComponent
     * @see CollectableComponent
     * @see be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.StatisticsComponent StatisticsComponent
     * @see be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.EntityCreationSystem#bonusCreation(List, List, AFactory, IDimension, IDimension)  bonusCreation(List, List, AFactory, IDimension, IDimension)
     */
    public abstract ABonusEntity getRandomBonusEntity(IPosition position, double speed, double velocity, int randValueRange);

    /**
     * Geeft een ATextEntity object terug met default waarden.
     * <p>
     * De ATextEntity zorgt voor text visualisatie met eventueel variabele informatie die elk moment kan wijzigen.
     * <p>
     * De waarde hierin bestaan uit Strings. Het is aan het graphics-systeem om deze String waardes te tonen, op een correcte manier.
     * <p>
     * In de methode kan de positie omgevormd worden naar de graphics-systeem dimensies.
     *
     * @return ATextEntity Een ATextEntity specifiek van een graphics-systeem.
     * @see ATextEntity
     * @see ATextEntity#ATextEntity() ATextEntity()
     */
    public abstract ATextEntity getTextEntity();

    /**
     * Geeft een ATextEntity object terug met extra parameters.
     * <p>
     * De ATextEntity zorgt voor text visualisatie met eventueel variabele informatie die elk moment kan wijzigen.
     * <p>
     * De waarde hierin bestaan uit Strings. Het is aan het graphics-systeem om deze String waardes te tonen, op een correcte manier.
     * <p>
     * In de methode kan de positie omgevormd worden naar de graphics-systeem dimensies.
     *
     * @param pos     Een positie van de entiteit als IPosition. Deze zijn in game dimensies.
     * @param preText Een preText dat voor de informatie text komt te staan als String.
     * @return ATextEntity Een ATextEntity specifiek van een graphics-systeem.
     * @see ATextEntity
     * @see ATextEntity#ATextEntity() ATextEntity()
     */
    public abstract ATextEntity getTextEntity(IPosition pos, String preText);

    /**
     * Geeft een ATextEntity object terug met extra parameters.
     * <p>
     * De ATextEntity zorgt voor text visualisatie met eventueel variabele informatie die elk moment kan wijzigen.
     * <p>
     * De waarde hierin bestaan uit Strings. Het is aan het graphics-systeem om deze String waardes te tonen, op een correcte manier.
     * <p>
     * In de methode kan de positie omgevormd worden naar de graphics-systeem dimensies.
     *
     * @param pos     Een positie van de entiteit als IPosition. Deze zijn in game dimensies.
     * @param preText Een preText dat voor de informatie text komt te staan als String.
     * @param text    De informatie tekst die getoond kan worden na de preText als String.
     * @return ATextEntity Een ATextEntity specifiek van een graphics-systeem.
     * @see ATextEntity
     * @see ATextEntity#ATextEntity() ATextEntity()
     */
    public abstract ATextEntity getTextEntity(IPosition pos, String preText, String text);

    /**
     * De graphics-systeem renderen.
     * <p>
     * De graphics-systeem moet eerst zijn scherm clearen om daarna alles te tonen.
     * Men kan best een systeem ontwerpen om alles wat getoond moet worden, in op te slaan om vervolgens, na de clear, alles te renderen.
     */
    public abstract void render();

    /**
     * Het startscherm van het spel. Hierop wordt de speler geïnformeerd wat zijn acties zijn.
     * <p>
     * Hierop kan de gebruiker
     * <ul>
     *     <li><b>ENTER</b> -> naar spel gaan </li>
     *     <li><b>ESC</b> -> het spel afsluiten</li>
     * </ul>
     * <p>
     * Geen bewegende delen zijn nodig.
     *
     * @param pos       De Positie van het start scherm. Deze zijn in game dimensies.
     * @param titleText titel tekst.
     * @param enterText De tekst waar we willen aantonen dat enter, verder gaan is.
     * @param excText   De tekst waar we willen aantonen dat ecs, stoppen is.
     * @return AScreenEntity Hierin zitten enkelen ATextEntities waar informatie in kan opgeslagen worden zoals een text.
     */
    public abstract AScreenEntity getStartScreen(IPosition pos, String titleText, String enterText, String excText);

    /**
     * Het pauzescherm van het spel. Hierop wordt de speler geïnformeerd wat zijn acties zijn.
     * <p>
     * Hierop kan de gebruiker
     * <ul>
     *     <li><b>ENTER</b> -> terugkeren naar het huidige spel </li>
     *     <li><b>Q</b> of <b>A</b> -> het spel afsluiten</li>
     * </ul>
     *
     * @param pos       De Positie van het pause scherm. Deze zijn in game dimensies.
     * @param titleText Titel tekst.
     * @param enterText De tekst waar we willen aantonen dat enter, verder gaan is.
     * @param excText   De tekst waar we willen aantonen dat Q of A, stoppen is en afsluiten.
     * @return AScreenEntity Hierin zitten enkelen ATextEntities waar informatie in kan opgeslagen worden zoals een text.
     */
    public abstract AScreenEntity getPauseScreen(IPosition pos, String titleText, String enterText, String excText);

    /**
     * Het eindscherm van het spel. Hierop wordt de speler geïnformeerd wat zijn acties zijn.
     * <p>
     * Hierop kan de gebruiker
     * <ul>
     *     <li><b>ENTER</b> -> het spel opnieuw starten </li>
     *     <li><b>Q</b> of <b>A</b> -> het spel afsluiten</li>
     * </ul>
     * De huidige score van de speler wordt hier getoond.
     * <p>
     * Eveneens de high score wordt hier getoond dat uit het bestand <i>highscore.txt</i>.
     *
     * @param pos       De Positie van het eind scherm. Deze zijn in game dimensies.
     * @param titleText titel tekst.
     * @param enterText De tekst waar we willen aantonen dat enter, verder gaan is.
     * @param excText   De tekst waar we willen aantonen dat ecs, stoppen is.
     * @return AScreenEntity Hierin zitten enkelen ATextEntities waar informatie in kan opgeslagen worden zoals een text.
     */
    public abstract AScreenEntity getEndScreen(IPosition pos, String titleText, String enterText, String excText, String preScore, String preHighScore);

    /**
     * De player's zijn input controller.
     * <p>
     * Hierin wordt de player's zijn IInput controller doorgegeven en deze is afhankelijk van de graphics-systeem.
     *
     * @return IInput met de methods om acties uit te voeren op de player.
     */
    public abstract IInput getInput();

    /**
     * Geeft de schaal factor van het graphics-systeem.
     * <p>
     * Wanneer we werken met een onafhankelijke graphics-systeem, is het noodzakelijk om te weten hoe
     * de gameDimensions, gedefinieerd in het bestand <i>game_config.txt</i>, vertaald worden naar het graphics-systeem.
     *
     * @return IDimension die de schalen bevat als width (breedte) en height (hoogte) schaal.
     */
    public abstract IDimension getScale();
}
