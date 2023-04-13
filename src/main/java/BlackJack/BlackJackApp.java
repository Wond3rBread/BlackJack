package BlackJack;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BlackJackApp extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Blacky Jacky");
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Start.fxml"))));
        primaryStage.show();
    }
    // try {
    //     Parent root = FXMLLoader.load(getClass().getResource("Table.fxml"));
    //     Scene scene = new Scene(root);
    //     stage.setScene(scene);
    //     stage.show();
        
    // } catch(Exception e) {
    //     e.printStackTrace();
    // }
}
