package player;

import card.Card;

import java.util.Arrays;

public class Player2 implements Player {
    private String[] cards;

    public Player2(Card cardDeck) {
        cardDeck.shuffle();
        this.cards = Arrays.copyOf(cardDeck.getCardValues(), 3);
    }

    @Override
    public String[] getCards() {
        return cards;
    }

    @Override
    public void displayCards() {
        System.out.println("Player 2's cards:");
        for (String card : cards) {
            System.out.println(card);
        }
    }

}
