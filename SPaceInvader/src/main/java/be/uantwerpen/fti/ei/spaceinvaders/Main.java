package be.uantwerpen.fti.ei.spaceinvaders;

import be.uantwerpen.fti.ei.spaceinvaders.game.Game;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.Dimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d.FactoryJ2d;

public class Main {
    public static void main(String[] args) {
        //IDimension gameDimentions = new Dimension(20,20);
        //AFactory aFactory = new FactoryConsole();
        AFactory aFactory = new FactoryJ2d("src/main/resources/gfx_config.txt");
        Game game = new Game(aFactory, "src/main/resources/game_config.txt");

        game.start();
    }
}