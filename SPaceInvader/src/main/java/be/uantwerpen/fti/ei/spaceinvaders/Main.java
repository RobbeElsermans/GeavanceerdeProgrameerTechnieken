package be.uantwerpen.fti.ei.spaceinvaders;

import be.uantwerpen.fti.ei.spaceinvaders.game.Game;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.console.FactoryConsole;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.FactoryJ2d;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //AFactory aFactory = new FactoryConsole();
        AFactory aFactory = new FactoryJ2d("src/main/resources/gfx_config.txt");
        Game game = new Game(aFactory);

        game.start();
    }
}