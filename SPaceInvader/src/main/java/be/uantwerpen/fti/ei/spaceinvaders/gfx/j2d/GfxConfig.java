package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;

import be.uantwerpen.fti.ei.spaceinvaders.game.filecontroller.FileManager;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;

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

    public GfxConfig(String configFilePath){
        this.screenSize = FileManager.getSettingAsDimension("width_console", "height_console", configFilePath, new Dimension(600, 400));
        this.playerDimension = FileManager.getSettingAsDimension("width_player_sprite", "height_player_sprite", configFilePath, new Dimension(1, 1));
        this.enemyDimension = FileManager.getSettingAsDimension("width_enemy_sprite", "height_enemy_sprite", configFilePath, new Dimension(1, 1));
        this.bulletDimension = FileManager.getSettingAsDimension("width_bullet_sprite", "height_bullet_sprite", configFilePath, new Dimension(0.5, 1));
        this.objectDimension = FileManager.getSettingAsDimension("width_object_sprite", "height_object_sprite", configFilePath, new Dimension(3, 1));
        this.bigEnemyDimension = FileManager.getSettingAsDimension("width_big_enemy_sprite", "height_big_enemy_sprite", configFilePath, new Dimension(2, 1));
        this.bonusDimension = FileManager.getSettingAsDimension("width_bonus_sprite", "height_bonus_sprite", configFilePath, new Dimension(0.5, 0.5));
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
}
