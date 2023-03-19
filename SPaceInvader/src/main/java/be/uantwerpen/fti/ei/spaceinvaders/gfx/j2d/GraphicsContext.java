package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Properties;

public class GraphicsContext {
    private int screenWidth = 500;
    private int screenHeight = 500;
    private int spriteWidth = 0;
    private int spriteHeight = 0;
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

        try
        {
            FileInputStream configuration = new FileInputStream(configFilePath);
            Properties prop = new Properties();
            prop.load(configuration);

            /*
            System.out.println(prop.getProperty("width_game"));
            System.out.println(prop.getProperty("height_game"));
            System.out.println(prop.getProperty("width_sprite"));
            System.out.println(prop.getProperty("height_sprite"));
            */

            this.screenWidth = Integer.parseInt(prop.getProperty("width_game"));
            this.screenHeight = Integer.parseInt(prop.getProperty("height_game"));
            this.spriteWidth = Integer.parseInt(prop.getProperty("width_sprite"));
            this.spriteHeight = Integer.parseInt(prop.getProperty("height_sprite"));

        } catch (FileNotFoundException e) {
            try {
                File file = new File(configFilePath);
                file.createNewFile();

                String configString = "width_game="+ this.screenWidth;
                configString = configString + "\nheight_game="+ this.screenHeight;
                configString = configString + "\nwidth_sprite="+ this.spriteWidth;
                configString = configString + "\nheight_sprite="+ this.spriteHeight;

                FileWriter fileWriter = new FileWriter(configFilePath);
                fileWriter.write(configString);
                fileWriter.close();

            } catch (IOException ex) {
                //throw new RuntimeException(ex);
                System.out.println("Er is een fout bestand pad meegegeven!");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        frame.setLocation(50,50);
        frame.setSize(screenWidth, screenHeight);
        g2dimage = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g2d = g2dimage.createGraphics();
        g2d.setBackground(new Color(255,255,255));
        g2d.clearRect(0,0, frame.getWidth(), frame.getHeight());
    }

    public int getSize() {
        return size;
    }
}