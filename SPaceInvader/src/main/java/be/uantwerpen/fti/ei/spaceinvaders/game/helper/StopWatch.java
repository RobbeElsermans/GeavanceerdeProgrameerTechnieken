package be.uantwerpen.fti.ei.spaceinvaders.game.helper;

/**
 * Een klasse die een gegeven tijd wacht.
 * <p>
 * Men kan hier een bepaalde fps (frames per seconds) met meegeven en deze bepaald hoe lang de functie.
 * <code>delay()</code> wacht.
 * Het is een soort van stopwatch die wanneer we <code>set()</code> aanroemen, zal aftellen.
 * Wanneer de telling nog niet op 0 staat, zal <code>delay()</code> de resterende tijd uitzitten.
 */
public class StopWatch {
    private final long FPS_INTERVAL_NS;
    private long nextFpsIntervalNS;

    /**
     * Overload constructor die de fps zal instellen.
     *
     * @param fps De Frames Per Seconds dat men wilt bereiken.
     */
    public StopWatch(int fps) {
        this.FPS_INTERVAL_NS = 1000000000 / fps;
    }

    /**
     * Start de aftelling.
     */
    public void set() {
        nextFpsIntervalNS = System.nanoTime() + FPS_INTERVAL_NS;
    }

    /**
     * >acht totdat de aftelling volledig op 0 komt.
     * <p>
     * Wanneer de aftelling nog niet gedaan is, zal de delay functie deze uitzitten.
     * <p>
     * Wanneer de aftelling al gedaan is, zal de functie niets uitvoeren.
     */
    public void delay() {
        try {
            long remainingFpsIntervalTime = nextFpsIntervalNS - System.nanoTime();
            remainingFpsIntervalTime /= 1000000;//van ns naar ms.
            if (remainingFpsIntervalTime > 0)
                Thread.sleep(remainingFpsIntervalTime); //Wachten zodat totale tijd FPS behaald wordt.

            nextFpsIntervalNS += FPS_INTERVAL_NS;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
