package be.uantwerpen.fti.ei.spaceinvaders.game.helper;

/**
 * De verschillende states dat een IN_GAME state kan doorlopen.
 *
 * @see GameStates
 */
public enum InGameStates {
    /**
     * Geen spel aanwezig.
     */
    NO_GAME,
    /**
     * Level 1 is bezig.
     */
    LEVEL_1,
    /**
     * Level 2 is bezig.
     */
    LEVEL_2,
    /**
     * debug level is bezig.
     */
    DEBUG
}
