package be.uantwerpen.fti.ei.spaceinvaders.game.helper;

/*
 * Probleem dat -1.5 -> -1 en 1.5 -> 2.
 * Oplossing: Roundingmode Down
 * https://docs.oracle.com/javase/7/docs/api/java/math/RoundingMode.html
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Een helper klasse die voor ons decimale waardes gaat afronden naar integer waardes.
 * <p>
 *
 */
public class RoundEvenly {
    public static int toInteger(double value){
        BigDecimal temp = BigDecimal.valueOf(value);
        temp = temp.setScale(0, RoundingMode.DOWN);

        return temp.intValue();
    }
}
