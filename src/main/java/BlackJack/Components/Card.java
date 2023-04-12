package BlackJack.Components;

import java.util.ArrayList;
import java.util.Arrays;

public class Card implements CardContainer{
    private String farge;
    private int tall;
    private String rank;
    // private ArrayList<Character> fargeRekke = new ArrayList<>(Arrays.asList('C', 'D', 'H', 'S'));

    public Card(String farge, int tall, String rank) {
        this.farge = farge;
        this.tall = tall;
        this.rank = rank;

        if (!(this.farge == "Spades" || this.farge == "Hearts" || this.farge == "Diamonds" || this.farge == "Clubs")) {
            throw new IllegalArgumentException("Ugyldig farge");
        }
        else if (this.tall < 1 || this.tall > 13 ) {
            throw new IllegalArgumentException("Ugyldig tall");
        }

    }

    public String getSuit() {
        return this.farge;
    }

    public String getRank() {
        return this.rank;
    }

    public int getPointValue() {
        return this.tall;
    }

    // public void changeAce() {

    // }

    

    @Override
    public String toString() {
        return this.farge + String.valueOf(this.tall) + this.rank;
    }

    public static void main(String[] args) {
        
    }
}
