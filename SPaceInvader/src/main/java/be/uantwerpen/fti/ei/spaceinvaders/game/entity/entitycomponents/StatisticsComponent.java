package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents;

/**
 * @author Robbe Elsermans
 * @version 1.0
 * <p>
 * Een component dat verschillende statistieke waardes bevat die gebruikt worden in het spel.
 * @see be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitysystem.StatisticsSystem StatisticsSystem
 */
public class StatisticsComponent {
    /**
     * De hoeveelheid damage dat het kreeg.
     */
    private int damageTaken;
    /**
     * De hoeveelheid damage dat er uitgedeeld is.
     */
    private int damageDone;
    /**
     * De hoeveelheid levens genomen.
     */
    private int livesTaken;
    /**
     * De hoeveelheid levens verloren.
     */
    private int livesLose;
    /**
     * De hoeveelheid schoten afgevuurd.
     */
    private int shotsFired;
    /**
     * De hoeveelheid schoten er gemist zijn.
     */
    private int shotsMissed;
    /**
     * De hoeveelheid schoten dat raak waren.
     */
    private int shotsHits;
    /**
     * Hoeveelheid big enemy hits.
     */
    private int bigEnemyHit;
    /**
     * De score
     */
    private int score;

    /**
     * Default constructor waarbij:
     * <ul>
     *     <li>damageTaken -> 0</li>
     *     <li>damageDone -> 0</li>
     *     <li>livesTaken -> 0</li>
     *     <li>livesLose -> 0</li>
     *     <li>shotsFired -> 0</li>
     *     <li>shotsMissed -> 0</li>
     *     <li>shotsHits -> 0</li>
     *     <li>bigEnemyHit -> 0</li>
     *     <li>score -> 0</li>
     *
     * </ul>
     */
    public StatisticsComponent() {
        damageTaken = 0;
        damageDone = 0;
        livesTaken = 0;
        livesLose = 0;
        shotsFired = 0;
        shotsMissed = 0;
        shotsHits = 0;
        bigEnemyHit = 0;
        score = 0;
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

    public int getBigEnemyHit() {
        return bigEnemyHit;
    }

    public void setBigEnemyHit(int bigEnemyHit) {
        this.bigEnemyHit = bigEnemyHit;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
                ", bigEnemyHit=" + bigEnemyHit +
                ", score=" + score +
                '}';
    }
}
