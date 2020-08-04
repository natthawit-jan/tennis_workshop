import java.util.Map;

public class TennisGame2 implements TennisGame {
    private int player2Point;
    private int player1Point;

    private final Map<Integer, String> SCORE_DECODER = Map.of(0, "Love", 1, "Fifteen", 2, "Thirty", 3, "Forty");

    public TennisGame2(String player1Name, String player2Name) {
    }

    public String getScore() {

        // handle Deuce and exactly the same point
        if (player2Point == player1Point && player2Point <= 4)
            return equalPoint(player2Point);
            // No one wins, simply tells score
        else if (player1Point < 4 && player2Point < 4) {
            return String.format("%s-%s", SCORE_DECODER.get(player1Point), SCORE_DECODER.get(player2Point));
        }
        // Check if there is a winner
        else if (Math.abs(player1Point - player2Point) >= 2) {
            return (player2Point > player1Point) ? "Win for player2" : "Win for player1";
        }
        // There is no winner, meaning that there was a deuce and a player has the advantage
        else {
            return (player2Point > player1Point) ? "Advantage player2" : "Advantage player1";
        }
    }

    private String equalPoint(int p1point) {
        if (p1point >= 3)
            return "Deuce";
        else if (p1point == 0)
            return "Love-All";
        else if (p1point == 1)
            return "Fifteen-All";
        else
            return "Thirty-All";
    }


    public void P1Score() {
        player1Point++;
    }

    public void P2Score() {
        player2Point++;
    }

    public void wonPoint(String player) {
        if ("player1".equals(player))
            P1Score();
        else
            P2Score();
    }
}