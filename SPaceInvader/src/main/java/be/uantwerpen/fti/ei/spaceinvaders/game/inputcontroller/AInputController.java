package be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller;

//TODO: Meer opsplitsen in andere soorten bv. IInputVolume , IInputMovement, IInputShoot, IInputCanvas
//TODO: En andere abstracties zoals AInputMovement, AInputVolume (of AInputControls)

/**
 * Een abstracte classen die de input controller samen bundelt.
 */
public abstract class AInputController implements IInput {

    /**
     * Interne variabelen om te kijken welke knoppen er ingedrukt zijn.
     */
    private boolean left, right, up, down, shoot, volup, voldown, esc = false;

    /**
     * Default constructor
     */
    public AInputController() {
    }

    /**
     * Wanneer een input available is, kunnen we dit checken door deze functie te gebruiken.
     * @return  True als er een input available is.
     */
    @Override
    public boolean inputAvailable() {
        return (isDown() || isEsc() || isLeft() || isRight() || isUp() || isVolDown() || isVolUp() || isShoot());
    }

    public boolean isShoot() {
        return shoot;
    }

    /**
     * zal de shoot variabelen plaatsen op de mee gegeven state.
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
     * zal de down variabelen plaatsen op de mee gegeven state.
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
     * zal de left variabelen plaatsen op de mee gegeven state.
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
     * zal de right variabelen plaatsen op de mee gegeven state.
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
     * zal de up variabelen plaatsen op de mee gegeven state.
     *
     * @param up wat de nieuwe waarden wordt voor up als boolean.
     */
    protected void setUp(boolean up) {
        this.up = up;
    }

    public boolean isVolUp() {
        return volup;
    }

    /**
     * zal de volup variabelen plaatsen op de mee gegeven state.
     *
     * @param volup wat de nieuwe waarden wordt voor volup als boolean.
     */
    protected void setVolup(boolean volup) {
        this.volup = volup;
    }

    public boolean isVolDown() {
        return voldown;
    }

    /**
     * zal de voldown variabelen plaatsen op de mee gegeven state.
     *
     * @param voldown wat de nieuwe waarden wordt voor voldown als boolean.
     */
    protected void setVoldown(boolean voldown) {
        this.voldown = voldown;
    }

    public boolean isEsc() {
        return esc;
    }

    /**
     * zal de esc variabelen plaatsen op de mee gegeven state.
     *
     * @param esc wat de nieuwe waarden wordt voor esc als boolean.
     */
    protected void setEsc(boolean esc) {
        this.esc = esc;
    }
}
