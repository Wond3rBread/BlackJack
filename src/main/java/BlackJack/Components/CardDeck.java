package BlackJack.Components;

import java.util.ArrayList;

public class CardDeck {
    private int decks;
    String suit[] = {"Hearts", "Clubs", "Diamonds", "Spades"};
    String rank[] = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    int pointValue[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    private ArrayList<Card> kort = new ArrayList<Card>();

    public CardDeck(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Kan ikke ha mindre enn 1 kortstokk");
        } else if (n > 5) {
            throw new IllegalArgumentException("Kan ikke har mer enn 5 kortstokker");
        }
        for(int h = 0; h < n; h++) {
            for(int i=0;i<suit.length;i++){
                for(int j=0;j<rank.length;j++) {
                    Card card = new Card(suit[i], pointValue[j], rank[j]); 
                    kort.add(card);
                }
            }
        }
    }

    public int getDeckAmount() {
        return decks;
    }

    public int[] getPointValue() {
        return this.pointValue;
    }

    public String[] getSuit() {
        return this.suit;
    }

    public String[] getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : kort) {
            sb.append(card.getRank())
            .append(" of ")
            .append(card.getSuit())
            .append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CardDeck decky = new CardDeck(2);
        System.out.println(decky.toString());
        System.out.println(decky.kort.size());
        // System.err.println(decky.kort.getPointValue());
    }
    
}
