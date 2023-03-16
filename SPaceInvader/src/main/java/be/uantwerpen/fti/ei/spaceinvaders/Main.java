package be.uantwerpen.fti.ei.spaceinvaders;

import be.uantwerpen.fi.ei.spaceinvaders.game.Game;
import be.uantwerpen.fi.ei.spaceinvaders.game.factory.AFactory;
import be.uantwerpen.fi.ei.spaceinvaders.gfx.console.FactoryConsole;
import be.uantwerpen.fi.ei.spaceinvaders.gfx.j2d.FactoryJ2d;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        AFactory aFactory = new FactoryConsole();
        //AFactory aFactory = new FactoryJ2d();
        Game game = new Game(aFactory);
    }
}