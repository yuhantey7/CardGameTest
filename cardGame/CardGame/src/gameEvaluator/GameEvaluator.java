package gameEvaluator;

public class GameEvaluator {

    public String evaluateWinner(String[] players, String[][] playerHands) {
        String winner = null;
        int maxSameAlphanumericCount = 0;
        int maxAlphanumericValue = 0;
        int maxSymbolValue = 0;

        for (int i = 0; i < players.length; i++) {
            String[] hand = playerHands[i];
            int sameAlphanumericCount = calculateSameAlphanumeric(hand);
            int alphanumericValue = getAlphanumeric(hand[0].charAt(0));
            int symbolValue = getSymbol(hand[0].charAt(1));

            if (sameAlphanumericCount > maxSameAlphanumericCount ||
                    (sameAlphanumericCount == maxSameAlphanumericCount && alphanumericValue > maxAlphanumericValue) ||
                    (sameAlphanumericCount == maxSameAlphanumericCount && alphanumericValue == maxAlphanumericValue && symbolValue > maxSymbolValue)) {
                maxSameAlphanumericCount = sameAlphanumericCount;
                maxAlphanumericValue = alphanumericValue;
                maxSymbolValue = symbolValue;
                winner = players[i];
            }
        }

        return winner;
    }

    private int calculateSameAlphanumeric(String[] hand) {
        int maxCount = 0;
        for (String card : hand) {
            char alphanumeric = card.charAt(0);
            int count = countAlphanumeric(hand, alphanumeric);
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    private int countAlphanumeric(String[] hand, char target) {
        int count = 0;
        for (String card : hand) {
            if (card.charAt(0) == target) {
                count++;
            }
        }
        return count;
    }

    public static int getSymbol(char s) {
        switch (s) {
            case '@':
                return 4;
            case '#':
                return 3;
            case '^':
                return 2;
            case '*':
                return 1;
            default:
                return 0;
        }
    }

    public static int getAlphanumeric(char a) {
        if (a >= '2' && a <= '9') {
            return a - '0';
        } else if (a == '1') {
            return 10;
        } else if (a == 'J') {
            return 11;
        } else if (a == 'Q') {
            return 12;
        } else if (a == 'K') {
            return 13;
        } else if (a == 'A') {
            return 14;
        } else {
            return 0;
        }
    }
}
