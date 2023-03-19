package be.uantwerpen.fti.ei.spaceinvaders.gfx.j2d;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.player.APlayerEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

import java.awt.*;

public class Playerj2d extends APlayerEntity {
    private GraphicsContext gfx;
    public Playerj2d(IInput input, GraphicsContext gfx) {
        super(input);
        this.setGfx(gfx);
    }

    public Playerj2d(IPosition position, int life, int speed, IInput input, GraphicsContext gfx) {
        super(position, gfx.getPlayerDimention(), life, speed, input);
        this.setGfx(gfx);
    }

    @Override
    public void visualize() {
        //Use the gfx to draw onto the buffer
        //Graphics2D g2d = getGfx().getG2d();
        if (getGfx().getG2d() != null) {
            getGfx().getG2d().setColor(new Color(50, 200, 200));
            getGfx().getG2d().fillRect(this.getX(), this.getY(), this.getDimentions().getWidth(), this.getDimentions().getHeight());    //De vorige frame nog verwijderen
        }
    }

    public GraphicsContext getGfx() {
        return gfx;
    }

    public void setGfx(GraphicsContext gfx) {
        this.gfx = gfx;
    }
}
