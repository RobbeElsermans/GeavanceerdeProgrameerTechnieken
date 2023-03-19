package be.uantwerpen.fti.ei.spaceinvaders;

import be.uantwerpen.fti.ei.spaceinvaders.game.Game;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.FactoryJ2d;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        IDimension dim = new Dimension(20,20);
        //AFactory aFactory = new FactoryConsole();
        AFactory aFactory = new FactoryJ2d(dim, "src/main/resources/gfx_config.txt");
        Game game = new Game(dim, aFactory);

        game.start();
    }
}