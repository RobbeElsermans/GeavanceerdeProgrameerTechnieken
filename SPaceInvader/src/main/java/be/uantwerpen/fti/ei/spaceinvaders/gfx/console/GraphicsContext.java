package be.uantwerpen.fti.ei.spaceinvaders.gfx.console;

import java.io.Console;

public class GraphicsContext {
    private Console gfx;

    public GraphicsContext(){
        this.gfx = System.console();
    }

    public void render(){
        this.gfx.flush();
    }
}
