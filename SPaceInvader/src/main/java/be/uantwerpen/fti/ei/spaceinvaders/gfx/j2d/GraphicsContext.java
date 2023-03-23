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
    private int screenWidth = 400;
    /**
     * Scherm hoogte met als default value 500px.
     */
    private int screenHeight = 400;
    /**
     * De dimensie van het speler entiteit als IDimension. Dit is afhankelijk van de genomen sprite.
     */
    private IDimension playerDimention;
    /**
     * De dimensie van het enemy entiteit als IDimension. Dit is afhankelijk van de genomen sprite.
     */
    private IDimension enemyDimention;
    /**
     * De dimensie van het object entiteit als IDimension. Dit is afhankelijk van de genomen sprite.
     */
    private IDimension objectDimention;
    /**
     * De dimensie van het projectiel entiteit als IDimension. Dit is afhankelijk van de genomen sprite.
     */
    private IDimension projectileDimention;
    /**
     * Het frame waarin alles wordt geplaatst.
     */
    private final JFrame frame;
    /**
     * De panel die we later in het frame plaatsen. Hierin zal het spel zich afspelen.
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
    private IDimension gameDimension;   //game dimensions
    private int size;

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
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        setGameDimensions(gameDimension.getWidth(),gameDimension.getHeight());
    }

    /**
     * Een methode die al de parameters ophaalt van het meegegeven bestand.
     * @param configFilePath    De locatie van het configuratiebestand.
     * @description Als het configuratie bestand niet bestaat in het opgegeven pad, zal dit zichzelf genereren met default waarden.
     */
    private void getSettings(String configFilePath) {
        this.screenWidth = FileManager.getSettingInteger("width_console", configFilePath, this.screenWidth);
        this.screenHeight = FileManager.getSettingInteger("height_console", configFilePath, this.screenWidth);
        this.playerDimention = new Dimension(
                FileManager.getSettingInteger("width_player_sprite", configFilePath, 10),
                FileManager.getSettingInteger("height_player_sprite", configFilePath, 10));
    }

    /**
     * Render de gemaakte buffer.
     */
    public void render() {

        if (g2d != null)
            g2d.setBackground(new Color(255, 255, 255));
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
     * @param GameCellsX    game breedte
     * @param GameCellsY    game hoogte
     */
    public void setGameDimensions(int GameCellsX, int GameCellsY) {
        //sizeWidth = (int)(screenWidth)/GameCellsX;
        //sizeHeight = (int)(screenHeight)/GameCellsY;
        size = Math.min((screenWidth) / GameCellsX, screenHeight / GameCellsY);
        frame.setLocation(0,0);
        frame.setSize(screenWidth, screenHeight+40);
        g2dimage = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g2d = g2dimage.createGraphics();
        g2d.setBackground(new Color(255,255,255));
        g2d.clearRect(0,0, frame.getWidth(), frame.getHeight());
    }

    public IDimension getPlayerDimention() {
        return playerDimention;
    }

    public IDimension getEnemyDimention() {
        return enemyDimention;
    }

    public IDimension getObjectDimention() {
        return objectDimention;
    }

    public IDimension getProjectileDimention() {
        return projectileDimention;
    }

    public int getSize() {
        return size;
    }
}