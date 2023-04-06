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
     * De score
     */
    private int score = 0;

    /**
     * Default constructor.
     */
    public StatisticsComponent(){
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }

    public int getDamageDone() {
        return damageDone;
    }

    public void setDamageDone(int damageDone) {
        this.damageDone = damageDone;
    }

    public int getLivesTaken() {
        return livesTaken;
    }

    public void setLivesTaken(int livesTaken) {
        this.livesTaken = livesTaken;
    }

    public int getLivesLose() {
        return livesLose;
    }

    public void setLivesLose(int livesLose) {
        this.livesLose = livesLose;
    }

    public int getShotsFired() {
        return shotsFired;
    }

    public void setShotsFired(int shotsFired) {
        this.shotsFired = shotsFired;
    }

    public int getShotsMissed() {
        return shotsMissed;
    }

    public void setShotsMissed(int shotsMissed) {
        this.shotsMissed = shotsMissed;
    }

    public int getShotsHits() {
        return shotsHits;
    }

    public void setShotsHits(int shotsHits) {
        this.shotsHits = shotsHits;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score  = score;
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
                ", score=" + score +
                '}';
    }
}
