package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents;

/**
 * Een component dat verschillende statistieke waardes bevat.
 */
public class StatisticsComponent {
    /**
     * De hoeveelheid damage dat het kreeg.
     */
    private int damageTaken = 0;
    /**
     * De hoeveelheid damage dat er uitgedeeld is.
     */
    private int damageDone = 0;
    /**
     * De hoeveelheid levens genomen.
     */
    private int livesTaken = 0;
    /**
     * De hoeveelheid levens verloren.
     */
    private int livesLose = 0;
    /**
     * De hoeveelheid schoten afgevuurd.
     */
    private int shotsFired = 0;
    /**
     * De hoeveelheid schoten er gemist zijn.
     */
    private int shotsMissed = 0;
    /**
     * De hoeveelheid schoten dat raak waren.
     */
    private int shotsHits = 0;

    /**
     * Default constructor.
     */
    public StatisticsComponent(){
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void incrementDamageTaken(int damageTaken) {
        this.damageTaken = this.damageTaken + damageTaken;
    }

    public int getDamageDone() {
        return damageDone;
    }

    public void incrementDamageDone(int damageDone) {
        this.damageDone = this.damageDone + damageDone;
    }

    public int getLivesTaken() {
        return livesTaken;
    }

    public void incrementLivesTaken(int livesTaken) {
        this.livesTaken = this.livesTaken + livesTaken;
    }

    public int getLivesLose() {
        return livesLose;
    }

    public void incrementLivesLose(int livesLose) {
        this.livesLose = this.livesLose + livesLose;
    }

    public int getShotsFired() {
        return shotsFired;
    }

    public void incrementShotsFired(int shotsFired) {
        this.shotsFired = this.shotsFired + shotsFired;
    }

    public int getShotsMissed() {
        return shotsMissed;
    }

    public void incrementShotsMissed(int shotsMissed) {
        this.shotsMissed = this.shotsMissed + shotsMissed;
    }

    public int getShotsHits() {
        return shotsHits;
    }

    public void incrementShotsHits(int shotsHits) {
        this.shotsHits = this.shotsHits + shotsHits;
    }

    @Override
    public String toString() {
        return "StatisticsComponent{" +
                "damageTaken=" + damageTaken +
                ", damageDone=" + damageDone +
                ", livesTaken=" + livesTaken +
                ", livesLose=" + livesLose +
                ", shotsFired=" + shotsFired +
                ", shotsMissed=" + shotsMissed +
                ", shotsHits=" + shotsHits +
                '}';
    }
}
