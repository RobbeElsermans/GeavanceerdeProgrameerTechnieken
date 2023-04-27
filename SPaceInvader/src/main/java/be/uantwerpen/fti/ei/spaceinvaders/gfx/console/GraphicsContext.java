package be.uantwerpen.fti.ei.spaceinvaders.gfx.console;

import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;

public class GraphicsContext {
    private final IDimension gameDimension;
    private final String[][] gamePicture;

    public GraphicsContext(IDimension gameDimension) {
        this.gameDimension = gameDimension;

        gamePicture = new String[(int) gameDimension.getHeight() + 1][(int) gameDimension.getWidth() + 1];
        populateGamePicture();
    }

    public void render() {
        for (int i = 0; i <= gameDimension.getHeight(); i++)
            System.out.println();//Clear the screen.

        //Render the picture
        for (int height = 0; height <= gameDimension.getHeight(); height++) {
            for (int width = 0; width <= gameDimension.getWidth() - 1; width++) {
                System.out.print(gamePicture[height][width]);
            }
            System.out.println(gamePicture[height][(int) gameDimension.getWidth()]);
        }

        //clear the picture.
        populateGamePicture();
    }

    private void populateGamePicture() {
        //populate gamePicture
        for (int height = 0; height <= gameDimension.getHeight(); height++) {
            for (int width = 0; width <= gameDimension.getWidth(); width++) {
                gamePicture[height][width] = " ";
            }

        }
    }

    public String[][] getGamePicture() {
        return gamePicture;
    }

    public IDimension getGameDimension() {
        return gameDimension;
    }
}
