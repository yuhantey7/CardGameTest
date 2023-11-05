package card;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Card {

    // Define fields with predefined card values
    public String[] cardValues = {
            "2@", "2#", "2^", "2*",
            "3@", "3#", "3^", "3*",
            "4@", "4#", "4^", "4*",
            "5@", "5#", "5^", "5*",
            "6@", "6#", "6^", "6*",
            "7@", "7#", "7^", "7*",
            "8@", "8#", "8^", "8*",
            "9@", "9#", "9^", "9*",
            "10@", "10#", "10^", "10*",
            "J@", "J#", "J^", "J*",
            "Q@", "Q#", "Q^", "Q*",
            "K@", "K#", "K^", "K*",
            "A@", "A#", "A^", "A*"
    };

    // Define getter
    public String[] getCardValues() {
        return cardValues;
    }

    public void shuffle() {
        List<String> cardList = Arrays.asList(cardValues);
        Collections.shuffle(cardList);
        cardList.toArray(cardValues);
    }
}
