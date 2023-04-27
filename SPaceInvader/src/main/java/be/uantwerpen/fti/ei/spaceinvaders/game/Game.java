package be.uantwerpen.fti.ei.spaceinvaders.game;

import be.uantwerpen.fti.ei.spaceinvaders.game.collision.BorderCollision;
import be.uantwerpen.fti.ei.spaceinvaders.game.collision.BorderCollisionSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.collision.BulletCollisionSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.collision.EntityCollision;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.*;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.MovementComponent;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.EntityCleanupSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.EntityCreationSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.StatisticsSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.movement.*;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting.EnemyShootSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting.GlobalShootSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.shooting.PlayerShootSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.types.FromWhoBulletType;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.game.filecontroller.FileManager;
import be.uantwerpen.fti.ei.spaceinvaders.game.helper.GameConfig;
import be.uantwerpen.fti.ei.spaceinvaders.game.helper.GameStates;
import be.uantwerpen.fti.ei.spaceinvaders.game.helper.InGameStates;
import be.uantwerpen.fti.ei.spaceinvaders.game.helper.StopWatch;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.Position;
import be.uantwerpen.fti.ei.spaceinvaders.game.sound.ASoundSystem;
import be.uantwerpen.fti.ei.spaceinvaders.game.sound.SoundType;

import java.util.ArrayList;
import java.util.List;

/**
 * De overkoepelende klassen waar al de game mechanics in verwerkt zijn.
 * <p>
 * We moeten het graphics-systeem meegeven zodat het spel zichzelf ook kan renderen.
 * Het configuratiebestand <l>game_config.txt</l> is ook van belang.
 */
public class Game {
    /**
     * Het level waarin het spel start.
     * <p>
     * Wordt gebruikt om te debuggen.
     */
    private static final InGameStates START_GAME_STATE = InGameStates.LEVEL_1;
    /**
     * Gebruikt een GFX-abstract factory om GFX en Game gescheiden te houden.
     */
    private final AFactory gfxFactory;
    /**
     * Een lijst van speler entiteiten.
     */
    private List<APlayerEntity> playerEntityList = new ArrayList<>();
    /**
     * Een lijst van enemy entiteiten.
     */
    private List<AEnemyEntity> enemyEntityList = new ArrayList<>();
    /**
     * Een lijst van big enemy entiteiten.
     */
    private List<ABigEnemyEntity> bigEnemyEntityList = new ArrayList<>();
    /**
     * Een lijst van bonus entiteiten.
     */
    private List<ABonusEntity> bonusEntityList = new ArrayList<>();
    /**
     * Een lijst van obstacle entiteiten.
     */
    private List<AObstacleEntity> obstacleEntityList = new ArrayList<>();

    /**
     * Text over het huidige leven van een speler
     */
    private List<ATextEntity> textLifeList = new ArrayList<>();

    /**
     * Text over de huidige punten van een speler
     */
    private List<ATextEntity> textPointsList = new ArrayList<>();

    /**
     * Een lijst van schermen.
     * <p>
     * Dit zal gedefiniëerd zijn als
     * <ul>
     *     <li>0 -> start scherm</li>
     *     <li>1 -> pauzescherm</li>
     *     <li>2 -> end scherm</li>
     * </ul>
     */
    private final List<AScreenEntity> screenEntityList = new ArrayList<>();

    /**
     * Een collision record die we gebruiken om de entiteiten binnenin het spelvlak te houden.
     * <p>
     * Het bevat de gfx spelgrootte om de grenzen te detecteren. De methode wordt gebruikt om 2
     */
    private BorderCollision borderCollision;

    /**
     * Een speler schiet systeem
     */
    private PlayerShootSystem playerShootSystem;

    /**
     * De schiet systemen
     */
    private EnemyShootSystem enemyShootSystem;
    private EntityCreationSystem entityCreationSystem;

    /**
     * Sound systeem om het geluid aan te zetten.
     */
    private ASoundSystem soundSystem;

    /**
     * De game grootte.
     * <p>
     * Deze is te vinden in <i>game_config.txt</i>
     */
    //private IDimension gameSize;

    /**
     * De tile dimensies van de entiteiten.
     */
    //private IDimension playerDimension, enemyDimension, obstacleDimension, bigEnemyDimension, bonusDimension;

    /**
     * De genomen FPS (Frames per second).
     * <p>
     * Deze is te vinden in <i>game_config.txt</i>
     */
    //private int fps = 40;

    /**
     * De configuratie van het spel.
     */
    private GameConfig gameConfig;

    private final StopWatch gameStopWatch;

    /**
     * De huidige state van het spel.
     */
    private GameStates gameState = GameStates.START_SCREEN;
    /**
     * De vorige state van game.
     */
    private GameStates prevGameState;
    /**
     * De huidige state inGame.
     */
    private InGameStates inGameState = InGameStates.NO_GAME;
    /**
     * De vorige state van inGame.
     */
    private InGameStates prevInGameState;

    /**
     * Overload constructor om het spel te initialiseren met de meegegeven parameters.
     * <p>
     * Als het configuratie bestand niet bestaat in het opgegeven pad, zal dit zichzelf genereren met default waarden.
     * <p>
     *
     * @param aFactory       Een GFX-factory om de zaak te tonen.
     * @param configFilePath Het configuratiebestand waarin verschillende parameters staan.
     */
    public Game(AFactory aFactory, String configFilePath) {

        //get the gfxFactory
        this.gfxFactory = aFactory;

        //get the game settings
        this.getSettings(configFilePath);

        //geeft game dimensions over aan factory
        this.gfxFactory.setupGameDimension(new Dimension(gameConfig.getGameSize().getWidth(), gameConfig.getGameSize().getHeight()));

        //Maak de game timer aan met de genomen fps.
        this.gameStopWatch = new StopWatch(gameConfig.getFps());
    }

    /**
     * De start methoden zal het spel starten.
     */
    public void start() {
        try {
            screenInitialize();
            soundInitialize();

            while (true) {
                this.gameStopWatch.set();
                //render screen
                render();

                switch (gameState) {
                    case START_SCREEN, PAUSED -> visualizeScreen();
                    case IN_GAME -> {
                        visualize();
                        //Als er nog geen spel gestart is geweest, doe dan de basis initialisatie.
                        if (prevInGameState == null) {
                            this.baseInitialize();
                        }

                        //Als het level veranderd is t.o.v. het vorige level dat bezig was, initialiseer dan het nieuwe level.
                        if (prevInGameState != inGameState) {
                            this.levelInitialize();
                        }

                        prevInGameState = inGameState;

                        update();

                    }
                    case END_GAME -> {
                        setHighScore();
                        visualizeScreen();
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + gameState);
                }

                checkGameInput(gfxFactory.getInput());
                checkBackgroundMusic();
                this.gameStopWatch.delay();
            }
        } catch (Exception e) {
            System.out.println("Er is iets onverwachts gebeurd!");
        }
    }

    /**
     * De rendermethoden gaat het gamevlak renderen zodat alle wijzigingen doorgevoerd worden.
     */
    private void render() {
        gfxFactory.render();
    }

    /**
     * Verwijder al de entities.
     */
    private void clearEntityLists() {
        //playerEntitieList = new ArrayList<>();
        enemyEntityList = new ArrayList<>();
        bigEnemyEntityList = new ArrayList<>();
        obstacleEntityList = new ArrayList<>();
        bonusEntityList = new ArrayList<>();
    }

    /**
     * De update methoden zal al de objecten van het spel update.
     */
    private void update() {

        updateInGameStates();   // Updates in game states en game states.

        updateBullets();            // Updates kogels.
        updateBonus();              // Updates bonus creatie.
        updateBigEnemy();           // Updates big enemy creatie.

        updateMovements();          // Update movements van entiteiten.

        checkBorderCollisions();        // Checkt de entiteiten dat ze niet buiten de grenzen gaan en reageer gepast wanneer wel.
        checkBulletCollision();         // Checkt wanneer dat kogels ergens inslaan en reageer gepast.


        if (inGameState != InGameStates.DEBUG)
            checkEnemyToPlayerCollision();  // Checkt wanneer een enemy tegen de player aanbotst en reageer gepast.

        checkBonusToPlayerCollision();  // Checkt wanneer een bonus tegen een player en reageer gepast.

        updateText();   //Updates teksten met spelers statistics.

        doCleanup();    //Kuis de entiteiten op als er iets mee gebeurd is waardoor ze dood gaan.
    }

    /**
     * De visualize methode zal elk object afbeelden.
     */
    private void visualize() {
        playerEntityList.forEach(APlayerEntity::visualize);
        enemyEntityList.forEach(AEnemyEntity::visualize);
        obstacleEntityList.forEach(AObstacleEntity::visualize);
        bigEnemyEntityList.forEach(ABigEnemyEntity::visualize);
        bonusEntityList.forEach(ABonusEntity::visualize);
        textLifeList.forEach(ATextEntity::visualize);
        textPointsList.forEach(ATextEntity::visualize);
    }

    /**
     * De visualize methode van de schermen zal elk object afbeelden.
     */
    private void visualizeScreen() {
        switch (gameState) {

            case START_SCREEN -> screenEntityList.get(0).visualize();
            case PAUSED -> screenEntityList.get(1).visualize();
            case END_GAME -> screenEntityList.get(2).visualize();
            default -> throw new IllegalStateException("Unexpected value: " + gameState);
        }

    }

    /**
     * Een methode die al de parameters ophaalt van het meegegeven bestand.
     *
     * @param configFilePath De locatie van het configuratiebestand.
     */
    private void getSettings(String configFilePath) {
        gameConfig = new GameConfig(configFilePath);
    }

    /**
     * We initialiseren hiermee het spel.
     * We laden alle basis objecten, die nodig zijn om het spel te spelen, in.
     */
    private void baseInitialize() {
        // Systemen initialiseren
        this.borderCollision = new BorderCollision(new Dimension(gameConfig.getGameSize().getWidth() * gfxFactory.getScale().getWidth(), gameConfig.getGameSize().getHeight() * gfxFactory.getScale().getHeight()));

        this.playerShootSystem = new PlayerShootSystem();
        this.enemyShootSystem = new EnemyShootSystem(1);

        this.entityCreationSystem = new EntityCreationSystem();

        // Player & texten zijn basis.
        playerEntityList = new ArrayList<>();
        textLifeList = new ArrayList<>();
        textPointsList = new ArrayList<>();

        // Initialiseer de rest van de entiteiten.
        clearEntityLists();

        //Create player
        if (inGameState != InGameStates.DEBUG) {
            playerEntityList.add(
                    this.gfxFactory.getPlayerEntity(
                            new Position((gameConfig.getGameSize().getWidth() - gameConfig.getPlayerDimension().getWidth()) / 2, gameConfig.getGameSize().getHeight() - gameConfig.getPlayerDimension().getHeight()),
                            3,
                            2,
                            1)
            );
        } else {
            playerEntityList.add(
                    this.gfxFactory.getPlayerEntity(
                            new Position(gameConfig.getGameSize().getWidth() - gameConfig.getPlayerDimension().getWidth() / 2, gameConfig.getGameSize().getHeight() - gameConfig.getPlayerDimension().getHeight()),
                            3,
                            2,
                            1.5)
            );
        }

        //Create texten a.d.h.v. aantal players.
        for (int i = 0; i < playerEntityList.size(); i++) {
            this.textLifeList.add(gfxFactory.getTextEntity(new Position(0, i * 2 + 1), "life: ", String.valueOf(this.playerEntityList.get(i).getLivableComponent().getLife())));
            this.textPointsList.add(gfxFactory.getTextEntity(new Position(0, i * 2 + 2), "points: ", "0"));
        }
    }

    private void soundInitialize() {
        this.soundSystem = gfxFactory.getSoundSystem();
    }

    private void screenInitialize() {
        //Create de schermen
        screenEntityList.add(gfxFactory.getStartScreen(
                new Position(gameConfig.getGameSize().getWidth() / 2 - 5, gameConfig.getGameSize().getHeight() / 2 - 5),
                "Start",
                "Enter om te starten",
                "ESC om af te sluiten"));

        screenEntityList.add(gfxFactory.getPauseScreen(
                new Position(gameConfig.getGameSize().getWidth() / 2 - 5, gameConfig.getGameSize().getHeight() / 2 - 5),
                "Pause",
                "Enter om verder te spelen",
                "Q/A om te stoppen"));

        screenEntityList.add(gfxFactory.getEndScreen(
                new Position(gameConfig.getGameSize().getWidth() / 2 - 5, gameConfig.getGameSize().getHeight() / 2 - 5),
                "End",
                "Enter om opnieuw te starten",
                "Q/A om te stoppen",
                "speler score: ",
                "highscore: "));
    }

    /**
     * Initialiseer een level a.d.h.v. de inGameState.
     *
     * @level_1 In LEVEL_1 wordt 1/3 van de breedte benut om enemy's te genereren. Het is een gewone blokvorm in de vorm van:
     * <p>x x x x x</p>
     * <p>x x x x x</p>
     * @level_2 In LEVEL_2 wordt een vaste structuur gevormd ( -_-_- ) die op 1/8 van de hoogte start.
     * De hoeveelheid is vast ingesteld. De enemy's schieten en gaan hier sneller.
     */
    private void levelInitialize() {
        //Clear all entities
        clearEntityLists();

        switch (inGameState) {

            case LEVEL_1 -> {
                //Create enemy
                int shift = (int) ((int) gameConfig.getGameSize().getWidth() / (3 * gameConfig.getEnemyDimension().getWidth()));
                for (int i = 0; i < shift; i++) {
                    if (i % 2 == 0) {
                        //Kijken of dat de coördinaat op het scherm past met de entiteit zijn grootte.
                        if ((gameConfig.getEnemyDimension().getWidth() * i + gameConfig.getEnemyDimension().getWidth()) <= gameConfig.getGameSize().getHeight() && (gameConfig.getEnemyDimension().getHeight() * i + gameConfig.getEnemyDimension().getHeight()) <= gameConfig.getGameSize().getHeight()) {

                            enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(gameConfig.getEnemyDimension().getWidth() * i, gameConfig.getEnemyDimension().getHeight()), 2, 1, 1));
                            enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(gameConfig.getEnemyDimension().getWidth() * i, gameConfig.getEnemyDimension().getHeight() * 2), 2, 1, 1));
                            enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(gameConfig.getEnemyDimension().getWidth() * i, gameConfig.getEnemyDimension().getHeight() * 3), 2, 1, 1));
                            enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(gameConfig.getEnemyDimension().getWidth() * i, gameConfig.getEnemyDimension().getHeight() * 4), 1, 1, 1));
                        }
                    }
                }

                //Create Obstacles
                obstacleEntityList.add(gfxFactory.getObstacleEntity(new Position(gameConfig.getPlayerDimension().getWidth(), gameConfig.getGameSize().getHeight() - gameConfig.getObstacleDimension().getHeight() * 3), 5));
                obstacleEntityList.add(gfxFactory.getObstacleEntity(new Position((gameConfig.getGameSize().getWidth()) / 2.0, gameConfig.getGameSize().getHeight() - gameConfig.getObstacleDimension().getHeight() * 4), 5));
                obstacleEntityList.add(gfxFactory.getObstacleEntity(new Position(gameConfig.getGameSize().getWidth() - (gameConfig.getPlayerDimension().getWidth() + gameConfig.getObstacleDimension().getWidth()), gameConfig.getGameSize().getHeight() - gameConfig.getObstacleDimension().getHeight() * 3), 5));
            }
            case LEVEL_2 -> {
                this.enemyShootSystem.setDiff(10);

                for (int i = 0; i < 4; i++) {
                    enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(gameConfig.getEnemyDimension().getWidth() * i, gameConfig.getEnemyDimension().getHeight() * i + gameConfig.getGameSize().getHeight() / 8.0), (i % 2) + 1, 2, 1));
                    enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(gameConfig.getEnemyDimension().getWidth() * (10 - i), gameConfig.getEnemyDimension().getHeight() * i + gameConfig.getGameSize().getHeight() / 8.0), (i % 2) + 1, 2, 1));
                }

                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(gameConfig.getEnemyDimension().getWidth() * 4, gameConfig.getEnemyDimension().getHeight() * 2 + gameConfig.getGameSize().getHeight() / 8), 2, 2, 1));
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(gameConfig.getEnemyDimension().getWidth() * 5, gameConfig.getEnemyDimension().getHeight() * 1 + gameConfig.getGameSize().getHeight() / 8), 2, 2, 1));
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(gameConfig.getEnemyDimension().getWidth() * 6, gameConfig.getEnemyDimension().getHeight() * 2 + gameConfig.getGameSize().getHeight() / 8), 2, 2, 1));

                //Create Obstacles
                obstacleEntityList.add(gfxFactory.getObstacleEntity(new Position(0, gameConfig.getGameSize().getHeight() - gameConfig.getObstacleDimension().getHeight() * 3), 5));
                obstacleEntityList.add(gfxFactory.getObstacleEntity(new Position(gameConfig.getObstacleDimension().getWidth() * 1, gameConfig.getGameSize().getHeight() - gameConfig.getObstacleDimension().getHeight() * 4), 5));

                obstacleEntityList.add(gfxFactory.getObstacleEntity(new Position(gameConfig.getGameSize().getWidth() / (2.0), gameConfig.getGameSize().getHeight() - gameConfig.getObstacleDimension().getHeight() * 3), 5));

                obstacleEntityList.add(gfxFactory.getObstacleEntity(new Position(gameConfig.getGameSize().getWidth() - gameConfig.getObstacleDimension().getWidth() * 1, gameConfig.getGameSize().getHeight() - gameConfig.getObstacleDimension().getHeight() * 3), 5));
                obstacleEntityList.add(gfxFactory.getObstacleEntity(new Position(gameConfig.getGameSize().getWidth() - gameConfig.getObstacleDimension().getWidth() * 2, gameConfig.getGameSize().getHeight() - gameConfig.getObstacleDimension().getHeight() * 4), 5));

            }
            case DEBUG -> {

                //Stel nieuwe enemy van [2,0] tot [2,2] rekeninghoudend met zijn dimensies.
                //Dimensie is 2x2.
                //Dus als we coordinate [2,2] geven wordt dit in werkelijkheid -> [2,6].
                /*
                 *   0 1 2 3 4 5 6 7 8 width
                 * 0 . . X X . . . . .
                 * 1 . . X X . . . . .
                 * 2 . . x x . . . . .
                 * 3 . . x x . . . . .
                 * 4 . . X X . . . . .
                 * 5 . . X X . . . . .
                 * 6 . . . . . . . . .
                 * 7 . . . . . . . . .
                 * 8 . . . . . . . . .
                 * height
                 */

                //Stel nieuwe enemy op [1,2] tot [3, 2] + [2,3] rekeninghoudend met zijn dimensies.
                //Dimensie is 2x2.
                // [1,2] tot [3, 2] is makkelijk.
                // [2,3] is moeilijker omdat er al een object staat. We moeten coordinates opschuiven naar [2,4]
                /*
                 *   0 1 2 3 4 5 6 7 8
                 * 0 . . . . . . . . .
                 * 1 . . . . . . . . .
                 * 2 . x x X X x x . .
                 * 3 . x x X X x x . .
                 * 4 . . . . . . . . .
                 * 5 . . . . . . . . .
                 * 6 . . . . . . . . .
                 * 7 . . . . . . . . .
                 * 8 . . . . . . . . .
                 */
                // We moeten dus in een loop vertrekken vanaf i = x-as en hierbij telkens de dimensie bijtellen.
                // Voor y-as moeten we in een aparte loop doen idem als x-as.
/*
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(enemyDimension.getWidth()*0,enemyDimension.getHeight()*0), 3, 1, 1));
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(enemyDimension.getWidth()*1,enemyDimension.getHeight()*1), 2, 1, 1));
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(enemyDimension.getWidth()*2,enemyDimension.getHeight()*2), 3, 1, 1));
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(enemyDimension.getWidth()*3,enemyDimension.getHeight()*0), 3, 1, 1));
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(enemyDimension.getWidth()*4,enemyDimension.getHeight()*1), 2, 1, 1));
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(enemyDimension.getWidth()*5,enemyDimension.getHeight()*2), 3, 1, 1));

 */

                for (int i = 0; i < 100; i++) {
                    if ((gameConfig.getEnemyDimension().getWidth() * i + gameConfig.getEnemyDimension().getWidth()) <= gameConfig.getGameSize().getHeight() && (gameConfig.getEnemyDimension().getHeight() * i + gameConfig.getEnemyDimension().getHeight()) <= gameConfig.getGameSize().getHeight())
                        enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(gameConfig.getEnemyDimension().getWidth() * i, gameConfig.getEnemyDimension().getHeight() * (i)), i % 2 + 1, 1, 1));
                }


                //Neem 1/3 van het scherm vakjes


            }
        }

            /*
            case BOSS_LEVEL -> {
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(2, 2), 1, 2, 0.5));
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(2, 3), 3, 3, 0.5));
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(4, 4), 3, 4, 0.5));
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(4, 4), 3, 5, 0.5));
                enemyEntityList.add(this.gfxFactory.getEnemyEntity(new Position(4, 4), 3, 6, 0.5));
            }
             */
    }


    /**
     * Bekijkt de inputs die de game states kunnen beïnvloeden
     *
     * @param input De input van de gebruiker
     */
    private void checkGameInput(IInput input) {
        if (input.inputAvailable()) {

            //Als we in het startscherm staan en er wordt enter gedrukt.
            if (gameState == GameStates.START_SCREEN && input.isEnter()) {
                gameState = GameStates.IN_GAME;     //Start game loop.
                inGameState = START_GAME_STATE;     //STARTGAME
            }

            //Als we in het startscherm staan en er wordt esc gedrukt.
            if (gameState == GameStates.START_SCREEN && input.isEsc()) {
                System.exit(0);
            }

            //Als er gespeeld wordt en esc wordt ingedrukt.
            if (gameState == GameStates.IN_GAME && input.isEsc()) {
                gameState = GameStates.PAUSED;  //Pause het spel.
            }

            //Als we in pausescherm staan en er wordt op enter gedrukt.
            if (gameState == GameStates.PAUSED && input.isEnter()) {
                gameState = GameStates.IN_GAME;  //resume het spel
            }
            //Als we in pausescherm staan en er wordt op q/ a gedrukt.
            if (gameState == GameStates.PAUSED && input.isQuit()) {
                System.exit(0);
            }

            //Als we in endScherm staan en er wordt op enter gedrukt.
            if (gameState == GameStates.END_GAME && input.isEnter()) {
                gameState = GameStates.IN_GAME;  //opnieuw

                //Basic initialize zodat alles zichzelf reset.
                this.prevInGameState = null;
                inGameState = START_GAME_STATE;   //STARTGAME
            }

            //Als we in endScherm staan en er wordt op quit gedrukt.
            if (gameState == GameStates.END_GAME && input.isQuit()) {
                System.exit(0);
            }
        }
    }

    /**
     * Checkt wanneer de achtergrondmuziek mag afgespeeld worden.
     */
    private void checkBackgroundMusic() {

        if ((prevGameState == null || prevGameState == GameStates.START_SCREEN || prevGameState == GameStates.PAUSED || prevGameState == GameStates.END_GAME) && gameState == GameStates.IN_GAME) {
            this.soundSystem.playBackgroundMusic(SoundType.BACKGROUND_MUSIC);
        }
        if (prevGameState == GameStates.IN_GAME && gameState == GameStates.PAUSED) {
            this.soundSystem.stopBackgroundMusic(SoundType.BACKGROUND_MUSIC);
        }
        if (prevGameState == GameStates.IN_GAME && gameState == GameStates.END_GAME) {
            this.soundSystem.stopBackgroundMusic(SoundType.BACKGROUND_MUSIC);
        }

        prevGameState = gameState;
    }

    /**
     * Checkt wanneer een enemy tegen de player aanbotst en reageer gepast.
     */
    private void checkEnemyToPlayerCollision() {
        //Check player to an enemy collision
        for (MovementComponent emc : enemyEntityList.stream().map(AEnemyEntity::getMovementComponent).toList())
            if (EntityCollision.entityIsOnSameLine(playerEntityList.get(0).getMovementComponent(), emc)) {
                System.out.println("DEAD!");
                gameState = GameStates.END_GAME;
                break;
            }
    }

    /**
     * Checkt wanneer een bonus tegen de speler botst
     */
    private void checkBonusToPlayerCollision() {
        //Check player to an enemy collision
        for (ABonusEntity bonus : bonusEntityList)
            for (APlayerEntity player : playerEntityList) {
                if (EntityCollision.entityCollision(player.getMovementComponent(), bonus.getMovementComponent())) {
                    //Bonus toevoegen
                    switch (bonus.getCollectableComponent().getType()) {
                        case LIFE -> {
                            //STATISTICS
                            StatisticsSystem.incrementLivesTaken(player.getStatisticsComponent(), bonus.getCollectableComponent());
                            //STATISTICS

                            player.getLivableComponent().upLifeByAmount((int) bonus.getCollectableComponent().takeValue());
                        }
                        case BULLET_SPEED -> {
                            double temp = (player.getShootingComponent().getSpeed() + bonus.getCollectableComponent().takeValue());
                            if (temp >= 6)
                                player.getShootingComponent().setSpeed(6);
                            else
                                player.getShootingComponent().setSpeed(Math.max(temp, 2));  //speed mag niet kleiner zijn dan 2.

                        }
                    }
                }
            }
    }

    /**
     * Checkt wanneer dat kogels ergens inslaan en reageer gepast.
     */
    private void checkBulletCollision() {

        //Check for bullet to enemy collision
        //Probleem dat wanneer 1 bullet, 2 enemy's raakt.
        // Statistics kunnen hier niet goed mee om dus moeten we opvangen in onderstaande code.
        for (AEnemyEntity enemy : enemyEntityList) {
            for (APlayerEntity player : playerEntityList) {
                for (ABulletEntity bullet : player.getShootingComponent().getBulletList()) {
                    if (BulletCollisionSystem.bulletEntityCollision(bullet.getMovementComponent(), enemy.getMovementComponent())) {

                        //STATISTICS
                        //Als de bullet al gebruikt is, niet bijwerken in statistics.
                        if (bullet.getLivableComponent().getLife() > 0) {
                            StatisticsSystem.incrementDamageDone(player.getStatisticsComponent(), bullet.getLivableComponent());
                            StatisticsSystem.incrementShotHits(player.getStatisticsComponent());
                        }
                        //STATISTICS

                        GlobalShootSystem.damage(enemy.getLivableComponent(), bullet.getLivableComponent());
                        break;
                    }
                }
            }
        }

        //Check for bullet to player collision
        for (APlayerEntity player : playerEntityList) {
            for (AEnemyEntity enemy : enemyEntityList) {
                for (ABulletEntity bullet : enemy.getShootingComponent().getBulletList()) {
                    if (BulletCollisionSystem.bulletEntityCollision(bullet.getMovementComponent(), player.getMovementComponent())) {

                        //STATISTICS
                        StatisticsSystem.incrementDamageTaken(player.getStatisticsComponent(), bullet.getLivableComponent());
                        StatisticsSystem.incrementLivesLose(player.getStatisticsComponent());
                        //STATISTICS

                        GlobalShootSystem.damage(player.getLivableComponent(), bullet.getLivableComponent());
                    }
                }
            }
        }

        //Check for bullet to obstacle from enemy and player
        for (AObstacleEntity obstacle : obstacleEntityList) {
            for (AEnemyEntity enemy : enemyEntityList) {
                for (ABulletEntity bullet : enemy.getShootingComponent().getBulletList()) {
                    if (BulletCollisionSystem.bulletEntityCollision(bullet.getMovementComponent(), obstacle.getDimensionComponent())) {
                        GlobalShootSystem.damage(obstacle.getLivableComponent(), bullet.getLivableComponent());
                    }
                }
            }
        }

        for (AObstacleEntity obstacle : obstacleEntityList) {
            for (APlayerEntity player : playerEntityList) {
                for (ABulletEntity bullet : player.getShootingComponent().getBulletList()) {
                    if (BulletCollisionSystem.bulletEntityCollision(bullet.getMovementComponent(), obstacle.getDimensionComponent())) {
                        GlobalShootSystem.damage(obstacle.getLivableComponent(), bullet.getLivableComponent());

                        //STATISTICS
                        StatisticsSystem.incrementShotMissed(player.getStatisticsComponent());
                        //STATISTICS
                    }
                }
            }
        }

        //Check for bullets from player to BigEnemy
        for (ABigEnemyEntity bigEnemy : bigEnemyEntityList) {
            for (APlayerEntity player : playerEntityList) {
                for (ABulletEntity bullet : player.getShootingComponent().getBulletList()) {
                    if (BulletCollisionSystem.bulletEntityCollision(bullet.getMovementComponent(), bigEnemy.getMovementComponent())) {

                        //STATISTICS
                        if (bullet.getLivableComponent().getLife() > 0) {
                            StatisticsSystem.incrementShotHits(player.getStatisticsComponent());
                            StatisticsSystem.incrementDamageDone(player.getStatisticsComponent(), bigEnemy.getLivableComponent());
                            StatisticsSystem.incrementBigEnemyHit(player.getStatisticsComponent());
                        }
                        //STATISTICS

                        GlobalShootSystem.damage(bigEnemy.getLivableComponent(), bullet.getLivableComponent());
                    }
                }
            }
        }
    }

    /**
     * Checkt de entiteiten dat ze niet buiten de grenzen gaan en reageer gepast wanneer wel.
     */
    private void checkBorderCollisions() {
        //checkBorderCollisionPlayer
        if (inGameState != InGameStates.DEBUG)
            playerEntityList.forEach(i -> BorderCollisionSystem.checkBorderCollisionPlayer(borderCollision, i.getMovementComponent()));
        else
            playerEntityList.forEach(i -> BorderCollisionSystem.checkBorderCollision(borderCollision, i.getMovementComponent()));
        //Check bullet collision player with game ends
        for (APlayerEntity player : playerEntityList) {
            for (ABulletEntity b : player.getShootingComponent().getBulletList()) {

                //STATISTICS
                double tempVelocityBullets = b.getMovementComponent().getVelocity();
                //STATISTICS

                BorderCollisionSystem.checkBorderCollisionBullet(borderCollision, b.getMovementComponent());

                //STATISTICS
                if (tempVelocityBullets != b.getMovementComponent().getVelocity()) {  //Als er een bullet stopt met bewegen dus ergens tegen botst
                    StatisticsSystem.incrementShotMissed(player.getStatisticsComponent());
                }
                //STATISTICS
            }
        }

        //Check bullet collision enemy with game ends
        for (AEnemyEntity enemy : enemyEntityList) {
            for (ABulletEntity b : enemy.getShootingComponent().getBulletList()) {
                BorderCollisionSystem.checkBorderCollisionBullet(borderCollision, b.getMovementComponent());
            }
        }

        //Check Enemy Border Collision
        //enemyEntityList.forEach(i -> CollisionManager.checkBorderCollision(borderCollisionSystem,i.getMovementComponent()));
        BorderCollisionSystem.checkBorderCollisionEnemy(
                borderCollision,
                enemyEntityList.stream().map(AEnemyEntity::getMovementComponent).toList());

        //Check for BigEnemy Border Collsion
        bigEnemyEntityList
                .forEach(bonus -> BorderCollisionSystem.checkBorderCollisionBigEnemy(borderCollision, bonus.getMovementComponent()));

        //Check for Bonus Border Collsion
        bonusEntityList
                .forEach(bonus -> BorderCollisionSystem.checkBorderCollisionBonus(borderCollision, bonus.getMovementComponent()));

    }

    /**
     * Updates teksten met spelers statistics.
     */
    private void updateText() {
        //Check voor wijzigingen in life en points van de spelers.
        for (int i = 0; i < playerEntityList.size(); i++) {
            textLifeList
                    .get(i)
                    .getInformationComponent()
                    .setInformation(
                            String.valueOf(playerEntityList.get(i).getLivableComponent().getLife()));

            //Bereken de score
            StatisticsSystem.calculateScore(playerEntityList.get(i).getStatisticsComponent());

            textPointsList
                    .get(i)
                    .getInformationComponent()
                    .setInformation(
                            String.valueOf(playerEntityList.get(i).getStatisticsComponent().getScore()));
        }
    }

    /**
     * Updates in game states en game states.
     */
    private void updateInGameStates() {
        //Al de enemies zijn dood en elke speler heeft nog genoeg leven
        if (enemyEntityList.isEmpty() && playerEntityList.stream().noneMatch(i -> i.getLivableComponent().getLife() == 0)) {
            //System.out.println("WIN!");
            switch (inGameState) {
                case LEVEL_1 -> inGameState = InGameStates.LEVEL_2;
                case LEVEL_2 -> gameState = GameStates.END_GAME;
                /*
                case BOSS_LEVEL -> {
                    gameState = GameStates.END_GAME;
                }
                */
            }
        }

        //De speler zijn leven is 0.
        if (playerEntityList.stream().map(APlayerEntity::getLivableComponent).anyMatch(i -> i.getLife() == 0)) {
            soundSystem.playShortSound(SoundType.PLAYER_DEAD_SOUND);
            System.out.println("LOSE!");
            gameState = GameStates.END_GAME;
        }
    }

    /**
     * Updates bonus creatie.
     */
    private void updateBonus() {
        if (this.entityCreationSystem.bonusCreation(
                bonusEntityList,
                playerEntityList.stream().map(APlayerEntity::getStatisticsComponent).toList(),
                gfxFactory,
                gameConfig.getGameSize(),
                gameConfig.getBonusDimension()
        ))
            soundSystem.playShortSound(SoundType.BONUS_SOUND);
    }

    /**
     * Updates bigEnemy creatie.
     */
    private void updateBigEnemy() {
        //Heeft een speler shotHits van %20 bereikt? maak dan een big Enemy van life van 1
        if (this.entityCreationSystem.bigEnemyCreation(
                bigEnemyEntityList,
                playerEntityList.stream().map(APlayerEntity::getStatisticsComponent).toList(),
                gfxFactory,
                gameConfig.getGameSize(),
                gameConfig.getBigEnemyDimension()
        ) && (enemyEntityList.size() >= 1 && enemyEntityList.stream().anyMatch(i -> i.getMovementComponent().getVelocity() != 0)))
            this.soundSystem.playShortSound(SoundType.BIG_ENEMY_SOUND);
    }

    /**
     * Updates kogel movement.
     */
    private void updateBullets() {
        // Check for player bullets
        playerEntityList.forEach(player -> {
            //De speler kan maar 1 schot uitvoeren.
            if (playerShootSystem.checkShoot(gfxFactory.getInput()) && player.getShootingComponent().getBulletList().isEmpty()) {
                //Voer het schot uit.
                GlobalShootSystem.fire(
                        player.getMovementComponent(),
                        player.getShootingComponent(),
                        gfxFactory,
                        FromWhoBulletType.PLAYER);

                //Voer sound uit
                this.soundSystem.playShortSound(SoundType.PLAYER_SHOOT_SOUND);

                //STATISTICS
                //houd bij hoe vaak een speler geschoten heeft.
                StatisticsSystem.incrementShotFired(player.getStatisticsComponent());
                //STATISTICS
            }
        });

        // Check for enemy bullets
        enemyEntityList.forEach(i -> {
            if (enemyShootSystem.checkShoot()) {
                //Voer het schot uit.
                GlobalShootSystem.fire(i.getMovementComponent(), i.getShootingComponent(), gfxFactory, FromWhoBulletType.ENEMY);
                //Voer sound uit
                //this.soundSystem.playShortSound(SoundType.ENEMY_SHOOT_SOUND);
            }
        });
    }

    private void updateMovements() {
        if (inGameState != InGameStates.DEBUG) {
            playerEntityList
                    .stream()
                    .map(APlayerEntity::getMovementComponent)
                    .forEach(mc -> PlayerMovementSystem.move(mc, gfxFactory.getInput()));
        } else {
            playerEntityList
                    .stream()
                    .map(APlayerEntity::getMovementComponent)
                    .forEach(mc -> GlobalMovementSystem.move(mc, gfxFactory.getInput()));
        }

        if (inGameState != InGameStates.DEBUG) {
            EnemyMovementSystem.move(enemyEntityList.stream().map(AEnemyEntity::getMovementComponent).toList());
        }
        bonusEntityList.stream().map(ABonusEntity::getMovementComponent).forEach(BonusMovementSystem::move);

        bigEnemyEntityList.stream().map(ABigEnemyEntity::getMovementComponent).forEach(BigEnemyMovementSystem::move);

        //Als er bullets aanwezig zijn van een speler, beweeg ze
        playerEntityList.forEach(player -> {
            if (!player.getShootingComponent().getBulletList().isEmpty()) {
                player.getShootingComponent().getBulletList().forEach(b -> BulletMovementSystem.move(b.getMovementComponent()));
            }
        });

        //Als er bullets aanwezig zijn van een enemy, beweeg ze
        enemyEntityList.forEach(enemy -> {
            if (!enemy.getShootingComponent().getBulletList().isEmpty()) {
                enemy.getShootingComponent().getBulletList().forEach(b -> BulletMovementSystem.move(b.getMovementComponent()));
            }
        });
    }

    /**
     * Kuis de entiteiten op als er iets mee gebeurd is waardoor ze dood gaan of stil staan.
     */
    void doCleanup() {
        //Cleanup bullets van een speler
        playerEntityList.forEach(player -> EntityCleanupSystem.cleanupBullets(player.getShootingComponent().getBulletList()));

        //Cleanup bullets van een enemy
        enemyEntityList.forEach(enemy -> EntityCleanupSystem.cleanupBullets(enemy.getShootingComponent().getBulletList()));

        //Cleanup enemy's
        if (EntityCleanupSystem.cleanupEnemys(enemyEntityList)) {
            soundSystem.playShortSound(SoundType.ENEMY_DEAD_SOUND);
        }

        //Cleanup obstacles
        EntityCleanupSystem.cleanupObstacles(obstacleEntityList);

        //Cleanup BigEnemy
        if (EntityCleanupSystem.cleanupBigEnemy(bigEnemyEntityList)) {
            soundSystem.playShortSound(SoundType.ENEMY_DEAD_SOUND);
        }

        //Cleanup bonuses
        EntityCleanupSystem.cleanupBonuses(bonusEntityList);
    }

    private void setHighScore() {
        //De values doorspelen naar endscherm.
        if (playerEntityList.get(0).getStatisticsComponent().getScore() > FileManager.getSettingInteger("high_score", "src/main/resources/highScore.txt", 0)) {
            FileManager.overwriteFile("high_score", "src/main/resources/highScore.txt", String.valueOf(playerEntityList.get(0).getStatisticsComponent().getScore()));
        }

        screenEntityList.get(2).getTextEntityList().get(1).getInformationComponent().setInformation(String.valueOf(playerEntityList.get(0).getStatisticsComponent().getScore()));
        screenEntityList.get(2).getTextEntityList().get(2).getInformationComponent().setInformation(String.valueOf(FileManager.getSettingInteger("high_score", "src/main/resources/highScore.txt", 0)));
    }
}