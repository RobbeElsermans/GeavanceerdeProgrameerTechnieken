package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.filecontroller.FileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Properties;

public class GraphicsContext {
    private int screenWidth = 500;
    private int screenHeight = 500;
    private IDimension playerDimention;
    private IDimension enemyDimention;
    private IDimension objectDimention;
    private IDimension projectileDimention;
    private final JFrame frame;
    private final JPanel panel;
    private BufferedImage g2dimage;     // used for drawing
    private Graphics2D g2d;             // always draw in this one
    private IDimension gameDimension;   //game dimensions
    private int size = 0;

    public Graphics2D getG2d() {
        return g2d;
    }
    public JFrame getFrame() {
        return frame;
    }
    public IDimension getGameDimension() {
        return this.gameDimension;
    }

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
     * get the settings from a configuration file given as parameter
     * @description If the file is found, we use it. Otherwise, we create one with default params
     * @param configFilePath the location of the config file
     */
    private void getSettings(String configFilePath) {
        this.screenWidth = FileManager.getSetting("width_console", configFilePath, this.screenWidth);
        this.screenHeight = FileManager.getSetting("height_console", configFilePath, this.screenWidth);
        this.playerDimention = new Dimension(
                FileManager.getSetting("width_player_sprite", configFilePath, 10),
                FileManager.getSetting("height_player_sprite", configFilePath, 10));
    }

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

    public void setGameDimensions(int GameCellsX, int GameCellsY) {
        size = Math.min((screenWidth)/GameCellsX, screenHeight/GameCellsY);
        frame.setLocation(0,0);
        frame.setSize(screenWidth, screenHeight);
        g2dimage = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g2d = g2dimage.createGraphics();
        g2d.setBackground(new Color(255,255,255));
        g2d.clearRect(0,0, frame.getWidth(), frame.getHeight());
    }

    public int getSize() {
        return size;
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
}