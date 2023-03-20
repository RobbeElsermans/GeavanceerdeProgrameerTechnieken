package be.uantwerpen.fti.ei.spaceinvaders.game.entity.interfaces;

public interface ILivable {
    /**
     * Geeft het huidigen leven terug.
     * @return
     */
    int getLife();

    /**
     * Verhoogt het leven met 1.
     */
    void upLife();

    /**
     * Verhoogt het leven met amount.
     * @param amount het aantal levenspunten waarmee we verhogen.
     */
    void upLifeByAmount(int amount);

    /**
     * Verlaagt het leven met 1.
     */
    void downLife();

    /**
     * Verlaagt het leven met amount
     * @param amount het aantal levenspunten waarmee we verlagen.
     */
    void downLifeByAmount(int amount);
}
