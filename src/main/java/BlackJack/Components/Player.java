package BlackJack.Components;

import java.util.Scanner;

public class Player extends Person{
    Scanner input = new Scanner(System.in);

    //Create a new Player
    public Player() {
        super.setName("Player");

    }

    /**
     * Allow the player to decide to hit or stand
     * @param deck - deck we are drawing from when we hit
     * @param discard - deck we discard to, in case we need to shuffle and use when deck runs out
     */
    public void makeDecision(Deck deck, Deck discard) {

        //decision holds their numerical choice
        int  decision = 0;
        //getNum means we're in the process of getting a number (int) from input stream
        boolean getNum = true;

        //while we are getting a number
        while(getNum){
            //try to get that number
            try{
                System.out.println("Would you like to: 1) Hit or 2) Stand");
                decision = input.nextInt();
                getNum = false;

            }
            //catch any exceptions and try again
            catch(Exception e){
                System.out.println("Invalid");
                //we need to go to the next line of input or this will not work
                input.next();
            }
            //we don't close the scanner, because we will need it later.
        }

        //if they decide to hit
        if (decision == 1) {
            //hit the deck
            this.hit(deck, discard);
            //return if they have blackjack or busted
            if(this.getHand().calculatedValue()>20){
                return;
            }
            else{
                //allow them to decide to hit or stand again, using our same decks
                this.makeDecision(deck, discard);
            }

        } else {
            //they stand if enter anything other than 1
            System.out.println("You stand.");
        }


    }
}
