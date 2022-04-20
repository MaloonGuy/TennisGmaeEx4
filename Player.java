import java.io.Serializable;

public class Player implements Serializable {

    private String name;
    private int totalScore;
    private int tournamentScore;

    public Player(String name, int totalScore) {
        this.name = name;
        this.totalScore = totalScore;
        this.tournamentScore = 0;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", totalScore=" + totalScore +
                ", tournamentScore=" + tournamentScore +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getTournamentScore() {
        return tournamentScore;
    }

    public void updateGameWin (){this.tournamentScore += 10;}

    public void updateTotalScore(){
        this.totalScore += this.tournamentScore;
        this.tournamentScore = 0;
    }

}
