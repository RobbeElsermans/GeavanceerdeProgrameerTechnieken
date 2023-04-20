package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;

import be.uantwerpen.fti.ei.spaceinvaders.game.filecontroller.FileManager;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Beheert alles wat moet gebeuren met java2D.
 */
public class GraphicsContext {
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
     *
     * @param gameDimension De game dimensie gegeven door Game.
     * @param configFile    Het configuratiebestand waarin verschillende properties staan die we gebruiken.
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
        panel.setDoubleBuffered(true);
        frame.setFocusable(true);
        frame.add(panel);
        frame.setTitle("SpaceInvader");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        setGameDimensions(gameDimension);
        setEntityDimensions(gameDimension);
    }

    /**
     * Een methode die al de parameters ophaalt van het meegegeven bestand.
     *
     * @param configFilePath De locatie van het configuratiebestand.
     * @description Als het configuratie bestand niet bestaat in het opgegeven pad, zal dit zichzelf genereren met default waarden.
     */
    private void getSettings(String configFilePath) {
        this.screenSize = FileManager.getSettingAsDimension("width_console", "height_console", configFilePath, new Dimension(600, 400));
        this.playerDimension = FileManager.getSettingAsDimension("width_player_sprite", "height_player_sprite", configFilePath, new Dimension(1, 1));
        this.enemyDimension = FileManager.getSettingAsDimension("width_enemy_sprite", "height_enemy_sprite", configFilePath, new Dimension(1, 1));
        this.bulletDimension = FileManager.getSettingAsDimension("width_bullet_sprite", "height_bullet_sprite", configFilePath, new Dimension(0.5, 1));
        this.objectDimension = FileManager.getSettingAsDimension("width_object_sprite", "height_object_sprite", configFilePath, new Dimension(3, 1));
        this.bigEnemyDimension = FileManager.getSettingAsDimension("width_big_enemy_sprite", "height_big_enemy_sprite", configFilePath, new Dimension(2, 1));
        this.bonusDimension = FileManager.getSettingAsDimension("width_bonus_sprite", "height_bonus_sprite", configFilePath, new Dimension(0.5, 0.5));
    }

    /**
     * Render de gemaakte buffer.
     */
    public void render() {

        if (g2d != null) {
            //g2d.setBackground(new Color(0, 0, 0));
            g2d.clearRect(0, 0, frame.getWidth(), frame.getHeight());
        }
        frame.repaint();
        //panel.repaint();
    }

    private void doDrawing(Graphics g) {
        Graphics2D graph2d = (Graphics2D) g;
        Toolkit.getDefaultToolkit().sync();
        graph2d.drawImage(g2dimage, 0, 0, null);   // copy buffered image
        graph2d.dispose();
    }

    /**
     * Past de gegeven dimensies aan, aan de hoogte en breedte van het scherm.
     *
     * @param dimensions    De dimensie van het spel.
     */
    public void setGameDimensions(IDimension dimensions) {
        this.tileWidth = (int) ((screenSize.getWidth()) / dimensions.getWidth());
        this.tileHeight = (int) ((screenSize.getHeight()) / dimensions.getHeight());

        frame.setLocation(0, 0);
        frame.setSize((int) screenSize.getWidth(), (int) (screenSize.getHeight() + 80));
        g2dimage = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g2d = g2dimage.createGraphics();
        //g2d.setBackground(new Color(255, 255, 255));
        g2d.clearRect(0, 0, frame.getWidth(), frame.getHeight());
    }

    /**
     * Past de gegeven dimensies van de entiteiten aan a.d.h.v. de gegeven game dimensie.
     *
     * @param dimensions    De dimensie van het spel.
     */
    public void setEntityDimensions(IDimension dimensions) {
        int sizeWidth = (int) (screenSize.getWidth() / dimensions.getWidth());
        int sizeHeight = (int) (screenSize.getHeight() / dimensions.getHeight());

        this.enemyDimension = new Dimension(sizeWidth * getEnemyDimension().getWidth(), sizeHeight * getEnemyDimension().getHeight());
        this.bulletDimension = new Dimension(sizeWidth * getBulletDimension().getWidth(), sizeHeight * getBulletDimension().getHeight());
        this.playerDimension = new Dimension(sizeWidth * getPlayerDimension().getWidth(), sizeHeight * getPlayerDimension().getHeight());
        this.objectDimension = new Dimension(sizeWidth * getObstacleDimension().getWidth(), sizeHeight * getObstacleDimension().getHeight());
        this.bonusDimension = new Dimension(sizeWidth * getBonusDimension().getWidth(), sizeHeight * getBonusDimension().getHeight());
        this.bigEnemyDimension = new Dimension(sizeWidth * getBigEnemyDimension().getWidth(), sizeHeight * getBigEnemyDimension().getHeight());
    }

    public IDimension getPlayerDimension() {
        return playerDimension;
    }

    public IDimension getEnemyDimension() {
        return enemyDimension;
    }

    public IDimension getObstacleDimension() {
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

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }
}