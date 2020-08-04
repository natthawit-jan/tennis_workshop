public class TennisGame2 implements TennisGame {
    private int player2Point;
    private int player1Point;


    public TennisGame2(String player1Name, String player2Name) {
    }

    public String getScore() {
        String score = "";
        String player1Result = "";
        String player2Result = "";


        if (player2Point == player1Point && player2Point <= 4)
            return equalPoint(player2Point);

        else if (player2Point > 0 && player1Point == 0) {
            if (player2Point == 1)
                player1Result = "Fifteen";
            if (player2Point == 2)
                player1Result = "Thirty";
            if (player2Point == 3)
                player1Result = "Forty";

            player2Result = "Love";
            score = player1Result + "-" + player2Result;
        }
        if (player1Point > 0 && player2Point == 0) {
            if (player1Point == 1)
                player2Result = "Fifteen";
            if (player1Point == 2)
                player2Result = "Thirty";
            if (player1Point == 3)
                player2Result = "Forty";

            player1Result = "Love";
            score = player1Result + "-" + player2Result;
        }

        if (player2Point > player1Point && player2Point < 4) {
            if (player2Point == 2)
                player1Result = "Thirty";
            if (player2Point == 3)
                player1Result = "Forty";
            if (player1Point == 1)
                player2Result = "Fifteen";
            if (player1Point == 2)
                player2Result = "Thirty";
            score = player1Result + "-" + player2Result;
        }
        if (player1Point > player2Point && player1Point < 4) {
            if (player1Point == 2)
                player2Result = "Thirty";
            if (player1Point == 3)
                player2Result = "Forty";
            if (player2Point == 1)
                player1Result = "Fifteen";
            if (player2Point == 2)
                player1Result = "Thirty";
            score = player1Result + "-" + player2Result;
        }

        if (player2Point > player1Point && player1Point >= 3) {
            score = "Advantage player1";
        }

        if (player1Point > player2Point && player2Point >= 3) {
            score = "Advantage player2";
        }

        if (player2Point >= 4 && player1Point >= 0 && (player2Point - player1Point) >= 2) {
            score = "Win for player1";
        }
        if (player1Point >= 4 && player2Point >= 0 && (player1Point - player2Point) >= 2) {
            score = "Win for player2";
        }
        return score;
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
        player2Point++;
    }

    public void P2Score() {
        player1Point++;
    }

    public void wonPoint(String player) {
        if ("player1".equals(player))
            P1Score();
        else
            P2Score();
    }
}