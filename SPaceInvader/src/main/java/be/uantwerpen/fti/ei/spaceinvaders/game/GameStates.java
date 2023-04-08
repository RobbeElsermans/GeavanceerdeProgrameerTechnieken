package be.uantwerpen.fti.ei.spaceinvaders.game;

/**
 * De verschillende states dat een game kan doorlopen
 */
public enum GameStates {
    /**
     * Het startscherm waarin de gebruiker kan verder gaan naar het spel of het spel afsluiten.
     */
    START_SCREEN,
    /**
     * In het spel zelf waar we InGameStates hebben
     *
     * @see InGameStates
     */
    IN_GAME,
    /**
     * Het pauzescherm. Hier is het spel in pauze en kan de gebruiker verder spelen of stoppen.
     */
    PAUSED,
    /**
     * Het einde spel. Hierin komt de gebruiker als hij is dood gegaan of gewonnen is.
     * De gebruiker kan kiezen om opnieuw te starten of om het spel af te sluiten.
     */
    END_GAME
}