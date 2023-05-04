package be.uantwerpen.fti.ei.spaceinvaders.game.helper;

import be.uantwerpen.fti.ei.spaceinvaders.game.filecontroller.FileManager;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;

/**
 * De GameConfig classen behoudt de configuratie waardes van Game.
 */
public class GameConfig {
    /**
     * De game grootte.
     * <p>
     * Deze is te vinden in <i>game_config.txt</i>
     */
    private final IDimension gameSize;

    /**
     * De tile dimensies van de entiteiten.
     */
    private final IDimension playerDimension;
    private final IDimension enemyDimension;
    private final IDimension obstacleDimension;
    private final IDimension bigEnemyDimension;
    private final IDimension bonusDimension;
    /**
     * De genomen FPS (Frames per second).
     * <p>
     * Deze is te vinden in <i>game_config.txt</i>
     */
    private final int fps;

    /**
     * De constructor zal de waardes uit een bestand kunnen halen. Als het bestand niet bestaat, wordt dit met default parameters gedaan.
     *
     * @param configFilePath De locatie van het bestand.
     */
    public GameConfig(String configFilePath) {
        gameSize = FileManager.getSettingAsDimension("gameWidth", "gameHeight", configFilePath, new Dimension(30, 20));

        this.fps = FileManager.getSettingInteger("fps", configFilePath, 40);

        this.playerDimension = FileManager.getSettingAsDimension("width_player", "height_player", configFilePath, new Dimension(1, 1));
        this.enemyDimension = FileManager.getSettingAsDimension("width_enemy", "height_enemy", configFilePath, new Dimension(1, 1));
        this.bigEnemyDimension = FileManager.getSettingAsDimension("width_big_enemy", "height_big_enemy", configFilePath, new Dimension(2, 1));
        this.obstacleDimension = FileManager.getSettingAsDimension("width_object", "height_object", configFilePath, new Dimension(2, 1));
        //this.bulletDimension = FileManager.getSettingAsDimension("width_bullet", "height_bullet", configFilePath, new Dimension(1, 1));
        this.bonusDimension = FileManager.getSettingAsDimension("width_bonus", "height_bonus", configFilePath, new Dimension(1, 1));
    }

    public IDimension getPlayerDimension() {
        return playerDimension;
    }

    public IDimension getEnemyDimension() {
        return enemyDimension;
    }

    public IDimension getObstacleDimension() {
        return obstacleDimension;
    }

    public IDimension getBigEnemyDimension() {
        return bigEnemyDimension;
    }

    public IDimension getBonusDimension() {
        return bonusDimension;
    }

    public int getFps() {
        return fps;
    }

    public IDimension getGameSize() {
        return gameSize;
    }
}
