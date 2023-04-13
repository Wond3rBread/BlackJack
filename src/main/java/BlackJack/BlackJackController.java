package BlackJack;

import BlackJack.Components.Card;
import BlackJack.Components.Dealer;
import BlackJack.Components.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BlackJackController {
    @FXML private TextField texty;
    @FXML private TextField playerValue, dealerValue;
    @FXML private Button hitButton, standButton;
    
    private Dealer dealer;
    private Player player;



    @FXML 
    public void kjøssMæIReva() {
        System.out.println("Flink du er " + texty.getText());
    }

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
        player.hit();
    }

}
