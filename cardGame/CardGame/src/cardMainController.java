import card.Card;
import player.*;
import gameEvaluator.GameEvaluator;

public class cardMainController {

    public static void main(String[] args) {
        Card cardDeck = new Card();

        Player[] players = new Player[] {
                new Player1(cardDeck),
                new Player2(cardDeck),
                new Player3(cardDeck),
                new Player4(cardDeck)
        };

        for (Player player : players) {
            player.displayCards();
        }

        GameEvaluator gameEvaluator = new GameEvaluator();
        String[] playerNames = {"Player1", "Player2", "Player3", "Player4"};
        String[][] playerHands = new String[players.length][];
        for (int i = 0; i < players.length; i++) {
            playerHands[i] = players[i].getCards();
        }
        String winner = gameEvaluator.evaluateWinner(playerNames, playerHands);

        System.out.println("The winner is: " + winner);


        // Testdata
        GameEvaluator evaluateWinner = new GameEvaluator();

        // Sample 1
        String[] sample1Players = {"Player1", "Player2"};
        String[][] sample1Hands = {
                {"K@", "K#", "K*"},
                {"A@", "A#", "A^"}
        };
        // Sample 2
        String[][] sample2Hands = {
                {"A@", "A*"},
                {"A#", "A^"}
        };

        String winnerSample1 = evaluateWinner.evaluateWinner(sample1Players, sample1Hands);
        String winnerSample2 = evaluateWinner.evaluateWinner(sample1Players, sample2Hands);

        System.out.println("Sample 1 Winner: " + winnerSample1);
        System.out.println("Sample 2 Winner: " + winnerSample2);

    }
}
