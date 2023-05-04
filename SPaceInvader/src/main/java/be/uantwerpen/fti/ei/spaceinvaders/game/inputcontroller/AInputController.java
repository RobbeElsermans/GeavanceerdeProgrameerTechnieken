package be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller;

/**
 * Een abstracte classen die de input controller samen bundelt.
 * <p>
 * Deze klassen moet overgeërfd worden door een graphics-systeem zijn input controller.
 *
 * @see IInput
 */
public abstract class AInputController implements IInput {

    /*
     * Interne variabelen om te kijken welke knoppen er ingedrukt zijn.
     */
    private boolean left, right, up, down, shoot, volUp, volDown, esc, enter, quit = false;

    public boolean inputAvailable() {
        return (isDown() || isEsc() || isLeft() || isRight() || isUp() || isVolDown() || isVolUp() || isShoot() || isEnter() || isQuit());
    }

    public boolean isShoot() {
        return shoot;
    }

    /**
     * Zal de shoot variabelen plaatsen op de mee gegeven state.
     *
     * @param shoot wat de nieuwe waarden wordt voor shoot als boolean.
     */
    protected void setShoot(boolean shoot) {
        this.shoot = shoot;
    }

    public boolean isDown() {
        return down;
    }

    /**
     * Zal de down variabelen plaatsen op de mee gegeven state.
     *
     * @param down wat de nieuwe waarden wordt voor down als boolean.
     */
    protected void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    /**
     * Zal de left variabelen plaatsen op de mee gegeven state.
     *
     * @param left wat de nieuwe waarden wordt voor left als boolean.
     */
    protected void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    /**
     * Zal de "right" variabelen plaatsen op de mee gegeven state.
     *
     * @param right wat de nieuwe waarden wordt voor right als boolean.
     */
    protected void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    /**
     * Zal de up variabelen plaatsen op de mee gegeven state.
     *
     * @param up wat de nieuwe waarden wordt voor up als boolean.
     */
    protected void setUp(boolean up) {
        this.up = up;
    }

    public boolean isVolUp() {
        return volUp;
    }

    /**
     * Zal de volup variabelen plaatsen op de mee gegeven state.
     *
     * @param volUp wat de nieuwe waarden wordt voor volup als boolean.
     */
    protected void setVolUp(boolean volUp) {
        this.volUp = volUp;
    }

    public boolean isVolDown() {
        return volDown;
    }

    /**
     * Zal de voldown variabelen plaatsen op de mee gegeven state.
     *
     * @param volDown wat de nieuwe waarden wordt voor voldown als boolean.
     */
    protected void setVolDown(boolean volDown) {
        this.volDown = volDown;
    }

    public boolean isEsc() {
        return esc;
    }

    /**
     * Zal de esc variabelen plaatsen op de mee gegeven state.
     *
     * @param esc wat de nieuwe waarden wordt voor esc als boolean.
     */
    protected void setEsc(boolean esc) {
        this.esc = esc;
    }

    public boolean isEnter() {
        return enter;
    }

    /**
     * Zal de enter variabelen plaatsen op de mee gegeven state.
     *
     * @param enter wat de nieuwe waarden wordt voor esc als boolean.
     */
    protected void setEnter(boolean enter) {
        this.enter = enter;
    }

    public boolean isQuit() {
        return quit;
    }

    /**
     * Zal de quit variabelen plaatsen op de mee gegeven state.
     *
     * @param quit wat de nieuwe waarden wordt voor esc als boolean.
     */
    protected void setQuit(boolean quit) {
        this.quit = quit;
    }
}
