package be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents;

/**
 * Bevat verschillende statistieke waardes.
 */
public class StatisticsComponent {
    private int damageTaken = 0;
    private int damageDone = 0;
    private int livesTaken = 0;
    private int livesLose = 0;
    private int shotsFired = 0;
    private int shotsMissed = 0;
    private int shotsHits = 0;

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
