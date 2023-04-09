package be.uantwerpen.fti.ei.spaceinvaders.game.helper;

/*
 * Probleem dat -1.5 -> -1 en 1.5 -> 2.
 * Oplossing: Roundingmode Down
 * https://docs.oracle.com/javase/7/docs/api/java/math/RoundingMode.html
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Een helper klasse die decimale waardes gaat afronden naar
 * integer waardes op een uniforme manier voor zowel positieve als negatieven getallen.
 */
public class RoundEvenly {
    /**
     * Een methode die een double variabelen zal omzetten naar een integer.
     * <p>
     * Het zal bij positieven en negatieven getallen, hetzelfde afronden.
     * <b>Voorbeeld</b>
     * <p>Gegeven -1.5 en 1.5. Deze getallen worden door (int) afgerond naar boven waardoor we -1 en 2 verkrijgen. </p>
     * <p>Een oplossing hiervoor is RoundingMode.DOWN</p>
     *
     * @param value De waarde die naar een integer gebracht moet worden.
     * @return De integer value van de afgeronde waarde.
     * @see BigDecimal#setScale(int, RoundingMode)
     * @see RoundingMode
     */
    public static int toInteger(double value) {
        BigDecimal temp = BigDecimal.valueOf(value);
        temp = temp.setScale(0, RoundingMode.DOWN);

        return temp.intValue();
    }
}
