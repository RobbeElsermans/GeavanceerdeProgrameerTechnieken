package be.uantwerpen.fti.ei.spaceinvaders.gfx.console;

import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.GfxConfig;

public class GraphicsContext {
    private final IDimension gameDimension;
    private final String[][] gamePicture;
    /**
     * Bevat de gfx configuratie bestanden.
     */
    private GfxConfig gfxConfig;

    public GraphicsContext(IDimension gameDimension, String configFile) {
        this.gameDimension = gameDimension;
        getSettings(configFile);

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

    public String[][] getGamePicture() {
        return gamePicture;
    }

    public GfxConfig getGfxSetting() {
        return gfxConfig;
    }
}
