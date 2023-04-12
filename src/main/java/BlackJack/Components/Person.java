package BlackJack.Components;

public abstract class Person {
    //hand holds the Persons active playing cards
    private Hand hand;
    //their name will be either Player or Dealer, this String just holds that info
    private String name;

    /**
     * Create a new Person
     */
    public Person(){
        //Give them a Hand and a name
        this.hand = new Hand();
        this.name = "";
    }


    //Setters and Getters
    public Hand getHand(){
        return this.hand;
    }
    public void setHand(Hand hand){
        this.hand = hand;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    /**
     * Prints a formatted version of the Person's hand
     */
    public void printHand(){
        System.out.println(this.name + "'s hand looks like this:");
        System.out.println(this.hand + " Valued at: " + this.hand.calculatedValue());
    }

    /**
     * Player takes a card from the deck
     * @param deck - the deck we are drawing from
     * @param discard - the deck we discard cards to, in case we need to reshuffle this when we run out of deck cards
     */
    public void hit(Deck deck, Deck discard){

        //If there's no cards left in the deck
        if (!deck.hasCards()) {
            //reload the deck from the discard pile
            deck.reloadDeckFromDiscard(discard);
        }
        //take a card from the deck
        this.hand.takeCardFromDeck(deck);
        System.out.println(this.name + " gets a card");
        //print out the hand
        this.printHand();
        //pause for a moment
        Game.pause();

    }

    /**
     * Check if Person has 21
     * @return True if the Person has 21
     */
    public boolean hasBlackjack(){
        if(this.getHand().calculatedValue() == 21){
            return true;
        }
        else{
            return false;
        }
    }
}
