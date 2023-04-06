package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.filecontroller.FileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Beheert alles wat moet gebeuren met java2D.
 */
public class GraphicsContext {
    /**
     * Scherm breedte met als default value 500px.
     */
    private int screenWidth = 600;
    /**
     * Scherm hoogte met als default value 500px.
     */
    private int screenHeight = 400;
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
     * Het frame waarin alles wordt geplaatst.
     */
    private final JFrame frame;
    /**
     * Het panel dat we later in het frame plaatsen. Hierin zal het spel zich afspelen.
     */
    private final JPanel panel;
    /**
     * Een buffer waarop we het spel opnieuw tekenen in de achtergrond.
     */
    private BufferedImage g2dimage;     // used for drawing
    /**
     * Het object dat de buffer zal bevatten. Deze gebruiken we wanneer we iets willen teken op de achtergrond.
     */
    private Graphics2D g2d;             // always draw in this one
    /**
     * De game dimensies meegegeven vanuit Game.
     */
    private final IDimension gameDimension;   //game dimensions
    /**
     * De game dimensie in pixels per vak.
     */
    private int tileWidth;
    /**
     * De game dimensie in pixels per vak.
     */
    private int tileHeight;

    public Graphics2D getG2d() {
        return g2d;
    }
    public JFrame getFrame() {
        return frame;
    }
    public IDimension getGameDimension() {
        return this.gameDimension;
    }

    /**
     * Overload constructor om een GraphicsContext aan te maken met gegeven parameters.
     * @param gameDimension De game dimensie gegeven door Game.
     * @param configFile    Het configuratiebestand waarin verschillende properties staan die we gebruiken.
     *
     * @implNote Als het configuratie bestand niet bestaat in het opgegeven pad, zal dit zichzelf genereren met default waarden.
     */
    public GraphicsContext(IDimension gameDimension, String configFile) {
        //get settings from file
        getSettings(configFile);
        this.gameDimension = gameDimension;

        frame = new JFrame();

        panel = new JPanel(true) {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                //super.paint(g);
                doDrawing(g);
            }
        };

        frame.setFocusable(true);
        frame.add(panel);
        frame.setTitle("SpaceInvader");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(screenWidth, screenHeight);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        setGameDimensions(gameDimension.getWidth(),gameDimension.getHeight());
        setEntityDimensions(gameDimension.getWidth(),gameDimension.getHeight());
    }

    /**
     * Een methode die al de parameters ophaalt van het meegegeven bestand.
     * @param configFilePath    De locatie van het configuratiebestand.
     * @description Als het configuratie bestand niet bestaat in het opgegeven pad, zal dit zichzelf genereren met default waarden.
     */
    private void getSettings(String configFilePath) {
        this.screenWidth = FileManager.getSettingInteger("width_console", configFilePath, this.screenWidth);
        this.screenHeight = FileManager.getSettingInteger("height_console", configFilePath, this.screenWidth);
        this.playerDimension = new Dimension(
                FileManager.getSettingDouble("width_player_sprite", configFilePath, 1),
                FileManager.getSettingDouble("height_player_sprite", configFilePath, 1));
        this.enemyDimension = new Dimension(
                FileManager.getSettingDouble("width_enemy_sprite", configFilePath, 1),
                FileManager.getSettingDouble("height_enemy_sprite", configFilePath, 1));
        this.bulletDimension = new Dimension(
                FileManager.getSettingDouble("width_bullet_sprite", configFilePath, 0.5),
                FileManager.getSettingDouble("height_bullet_sprite", configFilePath, 1));
        this.objectDimension = new Dimension(
                FileManager.getSettingDouble("width_object_sprite", configFilePath, 3),
                FileManager.getSettingDouble("height_object_sprite", configFilePath, 1));
        this.bigEnemyDimension = new Dimension(
                FileManager.getSettingDouble("width_big_enemy_sprite", configFilePath, 2),
                FileManager.getSettingDouble("height_big_enemy_sprite", configFilePath, 1));
        this.bonusDimension = new Dimension(
                FileManager.getSettingDouble("width_bonus_sprite", configFilePath, 0.5),
                FileManager.getSettingDouble("height_bonus_sprite", configFilePath, 0.5));
        this.textDimention = new Dimension(
                FileManager.getSettingDouble("width_text", configFilePath, 20),
                FileManager.getSettingDouble("height_text", configFilePath, 1));
    }

    /**
     * Render de gemaakte buffer.
     */
    public void render() {

        if (g2d != null)
            g2d.setBackground(new Color(0, 0, 0));
            g2d.clearRect(0, 0, frame.getWidth(), frame.getHeight());

        frame.repaint();
        panel.repaint();
    }

    private void doDrawing(Graphics g) {
        Graphics2D graph2d = (Graphics2D) g;
        Toolkit.getDefaultToolkit().sync();
        graph2d.drawImage(g2dimage, 0, 0, null);   // copy buffered image
        graph2d.dispose();
    }

    //TODO: Zet parameters om in IDimension
    /**
     * Past de gegeven dimensies aan, aan de hoogte en breedte van het scherm
     * @param gameCellsX    game breedte
     * @param gameCellsY    game hoogte
     */
    public void setGameDimensions(double gameCellsX, double gameCellsY) {
        //sizeWidth = (int)(screenWidth)/GameCellsX;
        //sizeHeight = (int)(screenHeight)/GameCellsY;
        this.tileWidth = (int) ((screenWidth) / gameCellsX);
        this.tileHeight = (int) ((screenHeight) / gameCellsY);

        frame.setLocation(0,0);
        frame.setSize(screenWidth, screenHeight+80);
        g2dimage = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g2d = g2dimage.createGraphics();
        g2d.setBackground(new Color(255,255,255));
        g2d.clearRect(0,0, frame.getWidth(), frame.getHeight());
    }

    /**
     * Past de gegeven dimensies aan van de entiteiten a.d.h.v. de gegeven game dimensie.
     * @param gameCellsX
     * @param gameCellsY
     */
    public void setEntityDimensions(double gameCellsX, double gameCellsY) {
        int sizeWidth = (int) (screenWidth/gameCellsX);
        int sizeHeight = (int) (screenHeight/gameCellsY);

        this.enemyDimension = new Dimension(sizeWidth* getEnemyDimension().getWidth(), sizeHeight* getEnemyDimension().getHeight());
        this.bulletDimension = new Dimension(sizeWidth* getBulletDimension().getWidth(), sizeHeight* getBulletDimension().getHeight());
        this.playerDimension = new Dimension(sizeWidth* getPlayerDimension().getWidth(), sizeHeight* getPlayerDimension().getHeight());
        this.textDimention = new Dimension(sizeWidth*getTextDimention().getWidth(), sizeHeight*getTextDimention().getHeight());
        this.objectDimension = new Dimension(sizeWidth* getObjectDimension().getWidth(), sizeHeight* getObjectDimension().getHeight());
        this.bonusDimension = new Dimension(sizeWidth* getBonusDimension().getWidth(), sizeHeight* getBonusDimension().getHeight());
        this.bigEnemyDimension = new Dimension(sizeWidth* getBigEnemyDimension().getWidth(), sizeHeight* getBigEnemyDimension().getHeight());
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

    public IDimension getBonusDimension() {
        return bonusDimension;
    }
    public IDimension getBigEnemyDimension() {
        return bigEnemyDimension;
    }

    public IDimension getBulletDimension() {
        return bulletDimension;
    }
    public IDimension getTextDimention() {return textDimention;
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }
}