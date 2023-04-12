package BlackJack;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BlackJackController {
    @FXML private TextField texty;
    @FXML 
    public void kjøssMæIReva() {
        System.out.println("Flink du er " + texty.getText());
    }
}
