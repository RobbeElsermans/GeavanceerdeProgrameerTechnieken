package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;

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
     * Bevat de sprites.
     */
    private final SpriteLoader spriteLoader;
    /**
     * Bevat de gfx configuratie bestanden.
     */
    private GfxConfig gfxConfig;
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

    /**
     * Overload constructor om een GraphicsContext aan te maken met gegeven parameters.
     * <p>
     * Als het configuratie bestand niet bestaat in het opgegeven pad, zal dit zichzelf genereren met default waarden.
     *
     * @param gameDimension De game dimensie gegeven door Game.
     * @param configFile    Het configuratiebestand waarin verschillende properties staan die we gebruiken.
     */
    public GraphicsContext(IDimension gameDimension, String configFile) {
        //get settings from file
        getSettings(configFile);

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
        frame.setSize((int) gfxConfig.getScreenSize().getWidth(), (int) gfxConfig.getScreenSize().getHeight());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        setGameDimensions(gameDimension);
        setEntityDimensions(gameDimension);
        spriteLoader = new SpriteLoader(gfxConfig); //Configureer de sprites.
    }

    /**
     * Een methode die al de parameters ophaalt van het meegegeven bestand.
     * <p>
     * Als het configuratie bestand niet bestaat in het opgegeven pad, zal dit zichzelf genereren met default waarden.
     *
     * @param configFilePath De locatie van het configuratiebestand.
     */
    private void getSettings(String configFilePath) {
        gfxConfig = new GfxConfig(configFilePath);
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
     * @param dimensions De dimensie van het spel.
     */
    public void setGameDimensions(IDimension dimensions) {
        this.tileWidth = (int) ((gfxConfig.getScreenSize().getWidth()) / dimensions.getWidth());
        this.tileHeight = (int) ((gfxConfig.getScreenSize().getHeight()) / dimensions.getHeight());

        frame.setLocation(0, 0);
        frame.setSize((int) gfxConfig.getScreenSize().getWidth(), (int) (gfxConfig.getScreenSize().getHeight() + 80));
        g2dimage = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g2d = g2dimage.createGraphics();
        //g2d.setBackground(new Color(255, 255, 255));
        g2d.clearRect(0, 0, frame.getWidth(), frame.getHeight());
    }

    /**
     * Past de gegeven dimensies van de entiteiten aan a.d.h.v. de gegeven game dimensie.
     *
     * @param dimensions De dimensie van het spel.
     */
    public void setEntityDimensions(IDimension dimensions) {
        int sizeWidth = (int) (gfxConfig.getScreenSize().getWidth() / dimensions.getWidth());
        int sizeHeight = (int) (gfxConfig.getScreenSize().getHeight() / dimensions.getHeight());

        gfxConfig.setEnemyDimension(new Dimension(sizeWidth * getEnemyDimension().getWidth(), sizeHeight * getEnemyDimension().getHeight()));
        gfxConfig.setBulletDimension(new Dimension(sizeWidth * getBulletDimension().getWidth(), sizeHeight * getBulletDimension().getHeight()));
        gfxConfig.setPlayerDimension(new Dimension(sizeWidth * getPlayerDimension().getWidth(), sizeHeight * getPlayerDimension().getHeight()));
        gfxConfig.setObjectDimension(new Dimension(sizeWidth * getObstacleDimension().getWidth(), sizeHeight * getObstacleDimension().getHeight()));
        gfxConfig.setBonusDimension(new Dimension(sizeWidth * getBonusDimension().getWidth(), sizeHeight * getBonusDimension().getHeight()));
        gfxConfig.setBigEnemyDimension(new Dimension(sizeWidth * getBigEnemyDimension().getWidth(), sizeHeight * getBigEnemyDimension().getHeight()));
    }

    public IDimension getPlayerDimension() {
        return gfxConfig.getPlayerDimension();
    }

    public IDimension getEnemyDimension() {
        return gfxConfig.getEnemyDimension();
    }

    public IDimension getObstacleDimension() {
        return gfxConfig.getObjectDimension();
    }

    public IDimension getBonusDimension() {
        return gfxConfig.getBonusDimension();
    }

    public IDimension getBigEnemyDimension() {
        return gfxConfig.getBigEnemyDimension();
    }

    public IDimension getBulletDimension() {
        return gfxConfig.getBulletDimension();
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }

    public SpriteLoader getSpriteLoader() {
        return spriteLoader;
    }

    public GfxConfig getGfxSetting() {
        return gfxConfig;
    }
}