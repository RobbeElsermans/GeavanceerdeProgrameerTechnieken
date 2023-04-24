package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;

import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.entity.EntityType;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class SpriteLoader {
    private List<List<SpriteData>> sprites;
    public SpriteLoader(GfxConfig gfxConfig){
        sprites = new ArrayList<>();

        //Get image
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/main/resources/sprite/SpaceInvaders.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //split images and rescale
        List<SpriteData> tempList = new ArrayList<>();
        tempList.add(scaler(image.getSubimage(3, 4, 11, 9), gfxConfig.getEnemyDimension()));
        tempList.add(scaler(image.getSubimage(19, 4, 11, 9), gfxConfig.getEnemyDimension()));
        sprites.add(tempList);  //Enemy 1

        tempList = new ArrayList<>();
        tempList.add(scaler(image.getSubimage(48,5,16,7), gfxConfig.getEnemyDimension()));
        sprites.add(tempList); //BigEnemy

        tempList = new ArrayList<>();
        tempList.add(scaler(image.getSubimage(39,5,1,6), gfxConfig.getEnemyDimension()));
        sprites.add(tempList);  //Bullet Player

        tempList = new ArrayList<>();
        tempList.add(scaler(image.getSubimage(38,21,3,7), gfxConfig.getEnemyDimension()));
        tempList.add(scaler(image.getSubimage(87,21,3,7), gfxConfig.getEnemyDimension()));
        sprites.add(tempList);  //Bullet Enemy

        tempList = new ArrayList<>();
        tempList.add(scaler(image.getSubimage(38,38,5,5), gfxConfig.getEnemyDimension()));
        sprites.add(tempList);  //Bonus

        tempList = new ArrayList<>();
        tempList.add(scaler(image.getSubimage(51,20,26,12), gfxConfig.getEnemyDimension()));   //1
        tempList.add(scaler(image.getSubimage(51,36,26,12), gfxConfig.getEnemyDimension()));   //2
        tempList.add(scaler(image.getSubimage(51,52,26,12), gfxConfig.getEnemyDimension()));   //3
        sprites.add(tempList);  //Obstacle

        tempList = new ArrayList<>();
        tempList.add(scaler(image.getSubimage(68,4,9,10), gfxConfig.getEnemyDimension()));
        sprites.add(tempList);  //Player
    }

    public List<SpriteData> getSprite(EntityType entityType){
        switch (entityType){

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

    /**
     * https://stackoverflow.com/questions/4216123/how-to-scale-a-bufferedimage/4216635#4216635
     * @param bufferedImage
     * @return
     */
    private SpriteData scaler(BufferedImage bufferedImage, IDimension scale){

        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        AffineTransform at = new AffineTransform();
        at.scale(scale.getWidth()/w, scale.getHeight()/h);
        return new SpriteData(bufferedImage, at);
    }

    public class SpriteData{
        private BufferedImage bufferedImage;
        private AffineTransform affineTransform;
        public SpriteData(BufferedImage bi, AffineTransform at){
            bufferedImage = bi;
            affineTransform = at;
        }

        public BufferedImage getBufferedImage() {
            return bufferedImage;
        }

        public AffineTransform getAffineTransform() {
            return affineTransform;
        }
    }
}
