package BlackJack;

import java.io.IOException;

import BlackJack.Components.Card;
import BlackJack.Components.Dealer;
import BlackJack.Components.Game;
import BlackJack.Components.Player;
import BlackJack.Components.Deck;
import BlackJack.Components.Hand;
import BlackJack.Components.Person;
import BlackJack.Components.Rank;
import BlackJack.Components.Suit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class BlackJackController {
    @FXML private TextField texty;
    @FXML private TextField playerValue, dealerValue, playerName, gName;
    @FXML private Button hitButton, standButton;

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    private Deck deck, discarded;

    private Dealer dealer;
    private Player player;
    private int wins, losses, pushes, decision;



    @FXML 
    public void kjøssMæIReva() {
        System.out.println("Flink du er " + texty.getText());
    }

    @FXML
    public void startGame(ActionEvent event) throws IOException{

        switchScene(event);

        // setPName();
        playerName = gName;
        playerName.setText(gName.getText());
        System.out.println(gName.getText());

        deck = new Deck(true);
        discarded = new Deck();

        dealer = new Dealer();
        player = new Player();


        deck.shuffle();
        startRound();
    }

    @FXML
    public void startRound(){

        if(wins>0 || losses>0 || pushes > 0){
            System.out.println();
            System.out.println("Starting Next Round... Wins: " + wins + " Losses: "+ losses+ " Pushes: "+pushes);
            dealer.getHand().discardHandToDeck(discarded);
            player.getHand().discardHandToDeck(discarded);
        }

        if(deck.cardsLeft() < 4){
            deck.reloadDeckFromDiscard(discarded);
        }

        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        dealer.printFirstHand();

        // player.printHand();

        setDealerValue();
        setPlayerValue();
        


        if(dealer.hasBlackjack()){
            dealer.printHand();

            if(player.hasBlackjack()){
                System.out.println("You both have 21 - Push.");
                pushes++;
                startRound();
            }
            else{
                System.out.println("Dealer has BlackJack. You lose.");
                dealer.printHand();
                losses++;
                startRound();
            }
        }

        if(player.hasBlackjack()){
            System.out.println("You have Blackjack! You win!");
            wins++;
            startRound();
        }

        player.makeDecision(deck, discarded, decision);

        if(player.getHand().calculatedValue() > 21){
            System.out.println("You have gone over 21.");
            losses ++;
            startRound();
        }

        dealer.printHand();
        while(dealer.getHand().calculatedValue()<17){
            dealer.hit(deck, discarded);
        }

        if(dealer.getHand().calculatedValue()>21){
            System.out.println("Dealer busts");
            wins++;
        }
        else if(dealer.getHand().calculatedValue() > player.getHand().calculatedValue()){
            System.out.println("You lose.");
            losses++;
        }
        else if(player.getHand().calculatedValue() > dealer.getHand().calculatedValue()){
            System.out.println("You win.");
            wins++;
        }
        else{
            System.out.println("Push.");
            pushes++;
        }

        startRound();
    }

    @FXML
    public void switchScene(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Table.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        System.out.println(gName.getText());
    }

    
    // @FXML
    // public void setPName() {
    //     if (playerName != null) {
    //         playerName.setText(gName.getText());
    //     } else {
    //         playerName.setPromptText("null");
    //     }
    //     // this.playerName = playerName;
    //     // playerName.setText(gName.getText());
    //     System.out.println(this.playerName.getText());
    // }

    @FXML
    public void setPlayerValue() {
        playerValue.setText(String.valueOf(player.getHand().calculatedValue()));
    
    }

    @FXML
    public void setDealerValue() {
        dealerValue.setText(String.valueOf(dealer.getHand().calculatedValue()));
    }

    @FXML
    public void cardHit() {
        decision = 1;
        player.makeDecision(deck, discarded, decision);
        // decision = 0;

        
    }

    @FXML
    public void cardStand() {

    }

}
