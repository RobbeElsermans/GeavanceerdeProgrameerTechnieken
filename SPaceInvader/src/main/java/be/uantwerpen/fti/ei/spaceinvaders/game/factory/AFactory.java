package be.uantwerpen.fti.ei.spaceinvaders.game.factory;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.*;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.CollectableType;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.LivableComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

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
     * @return AEnemyEntity Een AEnemyEntity specifiek van een graphics-systeem.
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
     * @return AEnemyEntity Een AEnemyEntity specifiek van een graphics-systeem.
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
     * @return AEnemyEntity Een AEnemyEntity specifiek van een graphics-systeem.
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
     *
     * @return ABonusEntity object
     */
    public abstract ABonusEntity getBonusEntity();

    /**
     * Geeft een ABonusEntity object terug met volgende parameters.
     *
     * @param position Een positie van de entiteit als IPosition.
     * @param speed    De snelheid waarmee de entiteit zich verplaatst als integer.
     * @param velocity De versnelling waarmee de entiteit zich verplaatst als integer.
     * @param type     het type collectable.
     * @param value    De waarde van de collectable.
     * @return ABonusEntity object.
     * @implNote De dimensies van een entiteit worden gedefinieerd in het configuratiebestand van de GFX-library. Dit wordt geschaald.
     */
    public abstract ABonusEntity getBonusEntity(IPosition position, double speed, double velocity, CollectableType type, double value);

    /**
     * Geeft een ABonusEntity object terug met volgende parameters.
     *
     * @param position       Een positie van de entiteit als IPosition.
     * @param speed          De snelheid waarmee de entiteit zich verplaatst als integer.
     * @param velocity       De versnelling waarmee de entiteit zich verplaatst als integer.
     * @param randValueRange De range startend van 0 tot randValueRange -1.
     * @return ABonusEntity object.
     * @implNote De dimensies van een entiteit worden gedefinieerd in het configuratiebestand van de GFX-library. Dit wordt geschaald.
     * De collectable wordt random geselecteerd.
     */
    public abstract ABonusEntity getRandomBonusEntity(IPosition position, double speed, double velocity, int randValueRange);

    /**
     * Geeft een ATextEntity object terug met default waarden.
     *
     * @return ATextEntity object
     */
    public abstract ATextEntity getTextEntity();

    /**
     * Geeft een ATextEntity object terug met volgende parameters.
     *
     * @param pos     Een positie van de entiteit als IPosition.
     * @param preText Een preText dat voor de informatie text komt.
     * @return ATextEntity object.
     */
    public abstract ATextEntity getTextEntity(IPosition pos, String preText);

    /**
     * Geeft een ATextEntity object terug met volgende parameters.
     *
     * @param pos     Een positie van de entiteit als IPosition.
     * @param preText Een preText dat voor de informatie text komt.
     * @param text    De effectieve informatie.
     * @return ATextEntity object.
     */
    public abstract ATextEntity getTextEntity(IPosition pos, String preText, String text);

    /**
     * De gekozen GFX renderen.
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
     * @param pos       positie
     * @param titleText titel tekst
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
     * @param pos       positie
     * @param titleText titel tekst
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
     * Eveneens de high score wordt hier getoond dat uit het bestand highscore.txt.
     *
     * @param pos       positie
     * @param titleText titel tekst
     * @param enterText De tekst waar we willen aantonen dat enter, verder gaan is.
     * @param excText   De tekst waar we willen aantonen dat ecs, stoppen is.
     * @return AScreenEntity Hierin zitten enkelen ATextEntities waar informatie in kan opgeslagen worden zoals een text.
     */
    public abstract AScreenEntity getEndScreen(IPosition pos, String titleText, String enterText, String excText, String preScore, String preHighScore);

    /**
     * De player input controller terug geven
     *
     * @return IInput
     */
    public abstract IInput getInput();

    /**
     * Geeft de schaal factor van het graphics-systeem.
     * <p>
     * Wanneer we werken met een onafhankelijke graphics-systeem, is het noodzakelijk om te weten hoe
     * de gameDimensions, gedefiniëerd in het bestand <i>game_config.txt</i>, vertaald worden naar het graphics-systeem.
     *
     * @return IDimension die de schalen bevat als width (breedte) en height (hoogte) schaal.
     */
    public abstract IDimension getScale();
}
