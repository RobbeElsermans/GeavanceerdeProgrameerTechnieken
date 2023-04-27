package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;

import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity.EntityType;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Een klasse om de sprites te laden in een lijst. Deze lijst wordt dan weer gebruikt om de verschillende sprites te tonen in gfxLibrary.
 * Het is dedicated voor java2D.
 */
public class SpriteLoader {
    // Een lijst van een lijst van sprites.
    private List<List<BufferedImage>> sprites;

    /**
     * Overload constructor die de graphics Configuraties nodig heeft.
     * <p>
     * De Constructor zal alle sprites uit de sprite foto nemen en lokaal opslaan.
     */
    public SpriteLoader(GfxConfig gfxConfig) {
        sprites = new ArrayList<>();

        //Get image
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/main/resources/sprite/SpaceInvaders.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //split images
        imageSplitter(image, gfxConfig);
    }

    /**
     * De imageSplitter zal de gegeven BufferedImage splitten met de gegeven gfxConfig
     *
     * @param image
     */
    private void imageSplitter(BufferedImage image, GfxConfig gfxConfig) {

        List<BufferedImage> tempList = new ArrayList<>();
        tempList.add(image.getSubimage((int) gfxConfig.getEnemy1Sprite1Pos().getX(), (int) gfxConfig.getEnemy1Sprite1Pos().getY(), (int) gfxConfig.getEnemy1Sprite1Dim().getWidth(), (int) gfxConfig.getEnemy1Sprite1Dim().getHeight()));
        tempList.add(image.getSubimage((int) gfxConfig.getEnemy1Sprite2Pos().getX(), (int) gfxConfig.getEnemy1Sprite2Pos().getY(), (int) gfxConfig.getEnemy1Sprite2Dim().getWidth(), (int) gfxConfig.getEnemy1Sprite2Dim().getHeight()));
        sprites.add(tempList);  //Enemy 1

        tempList = new ArrayList<>();
        tempList.add(image.getSubimage((int) gfxConfig.getBigEnemy1Sprite1Pos().getX(), (int) gfxConfig.getBigEnemy1Sprite1Pos().getY(), (int) gfxConfig.getBigEnemy1Sprite1Dim().getWidth(), (int) gfxConfig.getBigEnemy1Sprite1Dim().getHeight()));
        sprites.add(tempList); //BigEnemy

        tempList = new ArrayList<>();
        tempList.add(image.getSubimage((int) gfxConfig.getBulletPlayer1Sprite1Pos().getX(), (int) gfxConfig.getBulletPlayer1Sprite1Pos().getY(), (int) gfxConfig.getBulletPlayer1Sprite1Dim().getWidth(), (int) gfxConfig.getBulletPlayer1Sprite1Dim().getHeight()));
        sprites.add(tempList);  //Bullet Player

        tempList = new ArrayList<>();
        tempList.add(image.getSubimage((int) gfxConfig.getBulletEnemy1Sprite1Pos().getX(), (int) gfxConfig.getBulletEnemy1Sprite1Pos().getY(), (int) gfxConfig.getBulletEnemy1Sprite1Dim().getWidth(), (int) gfxConfig.getBulletEnemy1Sprite1Dim().getHeight()));
        tempList.add(image.getSubimage((int) gfxConfig.getBulletEnemy1Sprite2Pos().getX(), (int) gfxConfig.getBulletEnemy1Sprite2Pos().getY(), (int) gfxConfig.getBulletEnemy1Sprite2Dim().getWidth(), (int) gfxConfig.getBulletEnemy1Sprite2Dim().getHeight()));
        sprites.add(tempList);  //Bullet Enemy

        tempList = new ArrayList<>();
        tempList.add(image.getSubimage((int) gfxConfig.getBonus1Sprite1Pos().getX(), (int) gfxConfig.getBonus1Sprite1Pos().getY(), (int) gfxConfig.getBonus1Sprite1Dim().getWidth(), (int) gfxConfig.getBonus1Sprite1Dim().getHeight()));
        sprites.add(tempList);  //Bonus

        tempList = new ArrayList<>();
        tempList.add(image.getSubimage((int) gfxConfig.getObstacle1Sprite1Pos().getX(), (int) gfxConfig.getObstacle1Sprite1Pos().getY(), (int) gfxConfig.getObstacle1Sprite1Dim().getWidth(), (int) gfxConfig.getObstacle1Sprite1Dim().getHeight()));   //3
        tempList.add(image.getSubimage((int) gfxConfig.getObstacle1Sprite2Pos().getX(), (int) gfxConfig.getObstacle1Sprite2Pos().getY(), (int) gfxConfig.getObstacle1Sprite2Dim().getWidth(), (int) gfxConfig.getObstacle1Sprite2Dim().getHeight()));   //2
        tempList.add(image.getSubimage((int) gfxConfig.getObstacle1Sprite3Pos().getX(), (int) gfxConfig.getObstacle1Sprite3Pos().getY(), (int) gfxConfig.getObstacle1Sprite3Dim().getWidth(), (int) gfxConfig.getObstacle1Sprite3Dim().getHeight()));   //1
        sprites.add(tempList);  //Obstacle

        tempList = new ArrayList<>();
        tempList.add(image.getSubimage((int) gfxConfig.getPlayer1Sprite1Pos().getX(), (int) gfxConfig.getPlayer1Sprite1Pos().getY(), (int) gfxConfig.getPlayer1Sprite1Dim().getWidth(), (int) gfxConfig.getPlayer1Sprite1Dim().getHeight()));
        sprites.add(tempList);  //Player
    }

    /**
     * Vraag de lijst van sprites op voor een specifiel entity typen
     *
     * @param entityType Het typen entiteit dat wordt gevraagd.
     * @return Een lijst met al de sprites van de gevraagde entiteit.
     * @see EntityType
     */
    public List<BufferedImage> getSprite(EntityType entityType) {
        switch (entityType) {

            case PLAYER -> {
                return sprites.get(6);
            }
            case ENEMY -> {
                return sprites.get(0);
            }
            case BIG_ENEMY -> {
                return sprites.get(1);
            }
            case OBSTACLE -> {
                return sprites.get(5);
            }
            case BULLET_ENEMY -> {
                return sprites.get(3);
            }
            case BULLET_PLAYER -> {
                return sprites.get(2);
            }
            case BONUS -> {
                return sprites.get(4);
            }
        }
        return new ArrayList<>();
    }

    // Bron: https://stackoverflow.com/questions/4216123/how-to-scale-a-bufferedimage/4216635#4216635

    /**
     * Een static methode die een sprite zal schalen en op een positie zal plaatsen.
     *
     * @param bufferedImage De sprite als BufferedImage
     * @return Een AffineTransform die specifiek zijn voor de verkregen BufferedImage.
     */
    public static AffineTransform scaler(BufferedImage bufferedImage, IDimension scale, IPosition position) {

        AffineTransform at = new AffineTransform();

        //Verplaats de image
        at.translate(position.getX(), position.getY());
        //Schaal de image
        at.scale(scale.getWidth() / bufferedImage.getWidth(), scale.getHeight() / bufferedImage.getHeight());
        return at;
    }
}