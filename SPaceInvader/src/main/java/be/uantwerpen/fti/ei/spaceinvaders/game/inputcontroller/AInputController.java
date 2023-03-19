package be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller;

import java.util.LinkedList;

public abstract class AInputController implements IInput{

    private boolean left, right, up, down,shoot, volup, voldown, esc = false;

    public AInputController() {
    }

    @Override
    public boolean inputAvailable() {
        return (isDown() || isEsc() || isLeft() || isRight() || isUp() || isVolDown() || isVolUp() || isShoot());
    }

    public boolean isShoot() {
        return shoot;
    }

    protected void setShoot(boolean shoot) {
        this.shoot = shoot;
    }

    public boolean isDown() {
        return down;
    }

    protected void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    protected void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    protected void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    protected void setUp(boolean up) {
        this.up = up;
    }

    public boolean isVolUp() {
        return volup;
    }

    protected void setVolup(boolean volup) {
        this.volup = volup;
    }

    public boolean isVolDown() {
        return voldown;
    }

    protected void setVoldown(boolean voldown) {
        this.voldown = voldown;
    }

    public boolean isEsc() {
        return esc;
    }

    protected void setEsc(boolean esc) {
        this.esc = esc;
    }
}
