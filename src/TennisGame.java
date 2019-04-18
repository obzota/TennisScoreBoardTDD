public class TennisGame {

    private int p1Score = 0;
    private int p2Score = 0;

    private String names[] = {"love", "fifteen", "thirty", "forty"};

    public String Score() {
        if(p1Score > 3 && p1Score > p2Score + 1) {
            return "Player 1 wins!";
        }
        if(p2Score > 3 && p2Score > p1Score + 1) {
            return "Player 2 wins!";
        }
        if (p1Score < 3 || p2Score < 3) {
            String partOne = names[p1Score];
            String partTwo = names[p2Score];

            return partOne + " - " + partTwo;
        }
        if(p1Score == p2Score) {
            return "deuce";
        } else if (p1Score > p2Score){
            return "advantage - ";
        } else {
            return "- advantage";
        }
    }

    public void PlayerOneScores() {
        p1Score++;
    }

    public void PlayerTwoScores() {
        p2Score++;
    }
}
