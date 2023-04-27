package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;

import be.uantwerpen.fti.ei.spaceinvaders.game.filecontroller.FileManager;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.Position;

/**
 * De GfxConfig classen behoudt de configuratie waardes van Java2D graphics.
 */
public class GfxConfig {
    /**
     * De dimensie van het scherm.
     */
    private IDimension screenSize;
    /**
     * De dimensie van het speler entiteit als IDimension. Dit is afhankelijk van de genomen sprite.
     */
    private IDimension playerDimension;
    /**
     * De dimensie van het enemy entiteit als IDimension. Dit is afhankelijk van de genomen sprite.
     */
    private IDimension enemyDimension;
    /**
     * De dimensie van het object entiteit als IDimension. Dit is afhankelijk van de genomen sprite.
     */
    private IDimension objectDimension;
    /**
     * De dimensie van het projectiel entiteit als IDimension. Dit is afhankelijk van de genomen sprite.
     */
    private IDimension bulletDimension;
    /**
     * De dimensie van het big enemy entiteit als IDimension. Dit is afhankelijk van de genomen sprite.
     */
    private IDimension bigEnemyDimension;
    /**
     * De dimensie van het bonus entiteit als IDimension. Dit is afhankelijk van de genomen sprite.
     */
    private IDimension bonusDimension;
    /**
     * De dimensie van het text veld entiteit als IDimension.
     */
    private IDimension textDimention;

    /**
     * De dimensies van de sprites
     */
    private IDimension enemy1Sprite1Dim, enemy1Sprite2Dim, bigEnemy1Sprite1Dim, bulletPlayer1Sprite1Dim, bulletEnemy1Sprite1Dim, bulletEnemy1Sprite2Dim, bonus1Sprite1Dim, obstacle1Sprite1Dim, obstacle1Sprite2Dim, obstacle1Sprite3Dim, player1Sprite1Dim;
    /**
     * De posities van de sprites
     */
    private IPosition enemy1Sprite1Pos, enemy1Sprite2Pos, bigEnemy1Sprite1Pos, bulletPlayer1Sprite1Pos, bulletEnemy1Sprite1Pos, bulletEnemy1Sprite2Pos, bonus1Sprite1Pos, obstacle1Sprite1Pos, obstacle1Sprite2Pos, obstacle1Sprite3Pos, player1Sprite1Pos;

    /**
     * De constructor zal de waardes uit een bestand kunnen halen. Als het bestand niet bestaat, wordt dit met default parameters gedaan.
     *
     * @param configFilePath De locatie van het bestand.
     */
    public GfxConfig(String configFilePath) {

        // verkrijg de speldimensie
        this.screenSize = FileManager.getSettingAsDimension("width_console", "height_console", configFilePath, new Dimension(600, 400));

        // verkrijg de entiteit dimensies
        this.playerDimension = FileManager.getSettingAsDimension("width_player", "height_player", configFilePath, new Dimension(1, 1.5));
        this.enemyDimension = FileManager.getSettingAsDimension("width_enemy", "height_enemy", configFilePath, new Dimension(2, 2));
        this.bulletDimension = FileManager.getSettingAsDimension("width_bullet", "height_bullet", configFilePath, new Dimension(0.2, 0.5));
        this.objectDimension = FileManager.getSettingAsDimension("width_object", "height_object", configFilePath, new Dimension(5, 2));
        this.bigEnemyDimension = FileManager.getSettingAsDimension("width_big_enemy", "height_big_enemy", configFilePath, new Dimension(4, 2));
        this.bonusDimension = FileManager.getSettingAsDimension("width_bonus", "height_bonus", configFilePath, new Dimension(0.5, 0.5));

        // verkrijg de sprite posities
        this.player1Sprite1Pos = FileManager.getSettingAsPosition("x_player_1_sprite_1", "y_player_1_sprite_1", configFilePath, new Position(68, 4));
        this.enemy1Sprite1Pos = FileManager.getSettingAsPosition("x_enemy_1_sprite_1", "y_enemy_1_sprite_1", configFilePath, new Position(3, 4));
        this.enemy1Sprite2Pos = FileManager.getSettingAsPosition("x_enemy_1_sprite_2", "y_enemy_1_sprite_2", configFilePath, new Position(19, 4));
        this.bigEnemy1Sprite1Pos = FileManager.getSettingAsPosition("x_big_enemy_1_sprite_1", "y_big_enemy_1_sprite_1", configFilePath, new Position(48, 5));
        this.bonus1Sprite1Pos = FileManager.getSettingAsPosition("x_bonus_1_sprite_1", "y_bonus_1_sprite_1", configFilePath, new Position(38, 38));
        this.bulletEnemy1Sprite1Pos = FileManager.getSettingAsPosition("x_bullet_enemy_1_sprite_1", "y_bullet_enemy_1_sprite_1", configFilePath, new Position(38, 21));
        this.bulletEnemy1Sprite2Pos = FileManager.getSettingAsPosition("x_bullet_enemy_1_sprite_2", "y_bullet_enemy_1_sprite_2", configFilePath, new Position(87, 21));
        this.bulletPlayer1Sprite1Pos = FileManager.getSettingAsPosition("x_bullet_player_1_sprite_1", "y_bullet_player_1_sprite_1", configFilePath, new Position(39, 5));
        this.obstacle1Sprite1Pos = FileManager.getSettingAsPosition("x_obstacle_1_sprite_1", "y_obstacle_1_sprite_1", configFilePath, new Position(51, 52));
        this.obstacle1Sprite2Pos = FileManager.getSettingAsPosition("x_obstacle_1_sprite_2", "y_obstacle_1_sprite_2", configFilePath, new Position(51, 36));
        this.obstacle1Sprite3Pos = FileManager.getSettingAsPosition("x_obstacle_1_sprite_3", "y_obstacle_1_sprite_3", configFilePath, new Position(51, 20));

        // verkrijg de sprite dimensies
        this.player1Sprite1Dim = FileManager.getSettingAsDimension("width_player_1_sprite_1", "height_player_1_sprite_1", configFilePath, new Dimension(9, 10));
        this.enemy1Sprite1Dim = FileManager.getSettingAsDimension("width_enemy_1_sprite_1", "height_enemy_1_sprite_1", configFilePath, new Dimension(11, 9));
        this.enemy1Sprite2Dim = FileManager.getSettingAsDimension("width_enemy_1_sprite_2", "height_enemy_1_sprite_2", configFilePath, new Dimension(11, 9));
        this.bigEnemy1Sprite1Dim = FileManager.getSettingAsDimension("width_big_enemy_1_sprite_1", "height_big_enemy_1_sprite_1", configFilePath, new Dimension(16, 7));
        this.bonus1Sprite1Dim = FileManager.getSettingAsDimension("width_bonus_1_sprite_1", "height_bonus_1_sprite_1", configFilePath, new Dimension(5, 5));
        this.bulletEnemy1Sprite1Dim = FileManager.getSettingAsDimension("width_bullet_enemy_1_sprite_1", "height_bullet_enemy_1_sprite_1", configFilePath, new Dimension(3, 7));
        this.bulletEnemy1Sprite2Dim = FileManager.getSettingAsDimension("width_bullet_enemy_1_sprite_2", "height_bullet_enemy_1_sprite_2", configFilePath, new Dimension(3, 7));
        this.bulletPlayer1Sprite1Dim = FileManager.getSettingAsDimension("width_bullet_player_1_sprite_1", "height_bullet_player_1_sprite_1", configFilePath, new Dimension(1, 6));
        this.obstacle1Sprite1Dim = FileManager.getSettingAsDimension("width_obstacle_1_sprite_1", "height_obstacle_1_sprite_1", configFilePath, new Dimension(26, 12));
        this.obstacle1Sprite2Dim = FileManager.getSettingAsDimension("width_obstacle_1_sprite_2", "height_obstacle_1_sprite_2", configFilePath, new Dimension(26, 12));
        this.obstacle1Sprite3Dim = FileManager.getSettingAsDimension("width_obstacle_1_sprite_3", "height_obstacle_1_sprite_3", configFilePath, new Dimension(26, 12));

    }

    public IDimension getScreenSize() {
        return screenSize;
    }

    public IDimension getPlayerDimension() {
        return playerDimension;
    }

    public IDimension getEnemyDimension() {
        return enemyDimension;
    }

    public IDimension getObjectDimension() {
        return objectDimension;
    }

    public IDimension getBulletDimension() {
        return bulletDimension;
    }

    public IDimension getBigEnemyDimension() {
        return bigEnemyDimension;
    }

    public IDimension getBonusDimension() {
        return bonusDimension;
    }

    public IDimension getTextDimention() {
        return textDimention;
    }

    public void setScreenSize(IDimension screenSize) {
        this.screenSize = screenSize;
    }

    public void setPlayerDimension(IDimension playerDimension) {
        this.playerDimension = playerDimension;
    }

    public void setEnemyDimension(IDimension enemyDimension) {
        this.enemyDimension = enemyDimension;
    }

    public void setObjectDimension(IDimension objectDimension) {
        this.objectDimension = objectDimension;
    }

    public void setBulletDimension(IDimension bulletDimension) {
        this.bulletDimension = bulletDimension;
    }

    public void setBigEnemyDimension(IDimension bigEnemyDimension) {
        this.bigEnemyDimension = bigEnemyDimension;
    }

    public void setBonusDimension(IDimension bonusDimension) {
        this.bonusDimension = bonusDimension;
    }

    public void setTextDimention(IDimension textDimention) {
        this.textDimention = textDimention;
    }

    public IDimension getEnemy1Sprite1Dim() {
        return enemy1Sprite1Dim;
    }

    public IDimension getEnemy1Sprite2Dim() {
        return enemy1Sprite2Dim;
    }

    public IDimension getBigEnemy1Sprite1Dim() {
        return bigEnemy1Sprite1Dim;
    }

    public IDimension getBulletPlayer1Sprite1Dim() {
        return bulletPlayer1Sprite1Dim;
    }

    public IDimension getBulletEnemy1Sprite1Dim() {
        return bulletEnemy1Sprite1Dim;
    }

    public IDimension getBulletEnemy1Sprite2Dim() {
        return bulletEnemy1Sprite2Dim;
    }

    public IDimension getBonus1Sprite1Dim() {
        return bonus1Sprite1Dim;
    }

    public IDimension getObstacle1Sprite1Dim() {
        return obstacle1Sprite1Dim;
    }

    public IDimension getObstacle1Sprite2Dim() {
        return obstacle1Sprite2Dim;
    }

    public IDimension getObstacle1Sprite3Dim() {
        return obstacle1Sprite3Dim;
    }

    public IDimension getPlayer1Sprite1Dim() {
        return player1Sprite1Dim;
    }

    public IPosition getEnemy1Sprite1Pos() {
        return enemy1Sprite1Pos;
    }

    public IPosition getEnemy1Sprite2Pos() {
        return enemy1Sprite2Pos;
    }

    public IPosition getBigEnemy1Sprite1Pos() {
        return bigEnemy1Sprite1Pos;
    }

    public IPosition getBulletPlayer1Sprite1Pos() {
        return bulletPlayer1Sprite1Pos;
    }

    public IPosition getBulletEnemy1Sprite1Pos() {
        return bulletEnemy1Sprite1Pos;
    }

    public IPosition getBulletEnemy1Sprite2Pos() {
        return bulletEnemy1Sprite2Pos;
    }

    public IPosition getBonus1Sprite1Pos() {
        return bonus1Sprite1Pos;
    }

    public IPosition getObstacle1Sprite1Pos() {
        return obstacle1Sprite1Pos;
    }

    public IPosition getObstacle1Sprite2Pos() {
        return obstacle1Sprite2Pos;
    }

    public IPosition getObstacle1Sprite3Pos() {
        return obstacle1Sprite3Pos;
    }

    public IPosition getPlayer1Sprite1Pos() {
        return player1Sprite1Pos;
    }
}
