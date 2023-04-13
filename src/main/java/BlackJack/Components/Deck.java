package BlackJack.Components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    
    private ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<Card>();
    }

    public Deck(Deck c){
        Collections.copy(this.deck, c.getCards());
    }

    public Deck(boolean makeDeck){
        deck = new ArrayList<Card>();
        if(makeDeck){
        
            for(Suit suit : Suit.values()){
                
                for(Rank rank : Rank.values()){
                    
                    deck.add(new Card(suit, rank));
                }
            }
        }
    }


    public void addCard(Card card){
        deck.add(card);
    }

    
    public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }

    
    public String toString(){
        
        String output = "";

        for(Card card: deck){
            output += card;
            output += "\n";
        }
        return output;
    }

    
    public void shuffle(){
        Collections.shuffle(deck, new Random());
    }

    
    public Card takeCard(){

            
            Card cardToTake = new Card(deck.get(0));
            
            deck.remove(0);
            return cardToTake;

    }

    
    public boolean hasCards(){
        if (deck.size()>0){
            return true;
        }
        else{
            return false;
        }
    }

    
    public int cardsLeft(){
        return deck.size();
    }

    
    public ArrayList<Card> getCards() {
        return deck;
    }

    
    public void emptyDeck(){
        deck.clear();
    }


    public void reloadDeckFromDiscard(Deck discard){
        this.addCards(discard.getCards());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Ran out of cards, creating new deck from discard pile & shuffling deck.");
    }
    
}
