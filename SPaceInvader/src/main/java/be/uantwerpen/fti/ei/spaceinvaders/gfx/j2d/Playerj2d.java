package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.player.APlayerEntity;

import java.awt.*;

public class Playerj2d extends APlayerEntity {
    private GraphicsContext gfx;
    public Playerj2d(GraphicsContext gfx) {
        super();
        this.setGfx(gfx);
    }

    public Playerj2d(int x, int y, int life, int speed, GraphicsContext gfx) {
        super(x, y, life, speed);
        this.setGfx(gfx);
    }

    @Override
    public void update() {

    }

    @Override
    public void visualize() {
        //Use the gfx to draw onto the buffer
        //Graphics2D g2d = getGfx().getG2d();
        getGfx().getG2d().setColor(new Color(219, 15, 15));
        getGfx().getG2d().fillRect(0,0,100,100);
    }

    @Override
    public void move() {

    }

    public GraphicsContext getGfx() {
        return gfx;
    }

    public void setGfx(GraphicsContext gfx) {
        this.gfx = gfx;
    }
}
