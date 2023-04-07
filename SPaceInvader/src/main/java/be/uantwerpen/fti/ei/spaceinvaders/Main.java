package be.uantwerpen.fti.ei.spaceinvaders;

import be.uantwerpen.fti.ei.spaceinvaders.game.Game;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.FactoryJ2d;

public class Main {
    public static void main(String[] args) {
        //IDimension gameDimentions = new Dimension(20,20);

        /*
         * Wanneer je console selecteer, zorg ervoor dat je in een leeg text editor staat met je cursor. De keyevents worden namelijk globaal genomen.
         * Stel de FPS ook in met 1 i.p.v. 40.
         *
         * De console heeft namelijk minder vakjes waarin we iets kunnen tekenen.
         */
        //AFactory aFactory = new FactoryConsole();
        //Game game = new Game(aFactory, "src/main/resources/game_config.txt");

        AFactory aFactory = new FactoryJ2d("src/main/resources/gfx_config.txt");
        Game game = new Game(aFactory, "src/main/resources/game_config.txt");

        game.start();
    }
}