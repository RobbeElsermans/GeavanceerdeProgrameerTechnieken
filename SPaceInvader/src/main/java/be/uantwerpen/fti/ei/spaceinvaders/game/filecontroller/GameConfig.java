package be.uantwerpen.fti.ei.spaceinvaders.game.filecontroller;

import be.uantwerpen.fti.ei.spaceinvaders.game.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;

public class GameConfig {
    /**
     * De game grootte.
     * <p>
     * Deze is te vinden in <i>game_config.txt</i>
     */
    private IDimension gameSize;

    /**
     * De tile dimensies van de entiteiten.
     */
    private IDimension playerDimension, enemyDimension, obstacleDimension, bigEnemyDimension, bonusDimension;
    /**
     * De genomen FPS (Frames per second).
     * <p>
     * Deze is te vinden in <i>game_config.txt</i>
     */
    private int fps = 40;

    public GameConfig(String configFile){
        gameSize = FileManager.getSettingAsDimension("gameWidth", "gameHeight", configFile, new Dimension(30, 20));

        this.fps = FileManager.getSettingInteger("fps", configFile, 40);

        this.playerDimension = FileManager.getSettingAsDimension("width_player", "height_player", configFile, new Dimension(1, 1));
        this.enemyDimension = FileManager.getSettingAsDimension("width_enemy", "height_enemy", configFile, new Dimension(1, 1));
        this.bigEnemyDimension = FileManager.getSettingAsDimension("width_big_enemy", "height_big_enemy", configFile, new Dimension(2, 1));
        this.obstacleDimension = FileManager.getSettingAsDimension("width_object", "height_object", configFile, new Dimension(2, 1));
        //this.bulletDimension = FileManager.getSettingAsDimension("width_bullet", "height_bullet", configFile, new Dimension(1, 1));
        this.bonusDimension = FileManager.getSettingAsDimension("width_bonus", "height_bonus", configFile, new Dimension(1, 1));
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
