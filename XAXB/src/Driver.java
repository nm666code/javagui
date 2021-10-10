import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Callback;
public class Driver extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) throws IOException{
			
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
		StopWatch stopwatch = new StopWatch();
		Game game = new Game();
		Player player = new Player();
		
		PlayerDB.setEasyDB(PlayerDB.readInDB("easyDB.txt"));
		PlayerDB.setHardDB(PlayerDB.readInDB("hardDB.txt"));
		
		Parent root = loader.load();
		MainSceneController mainSceneController = loader.getController();
		mainSceneController.setStopwatch(stopwatch);
		mainSceneController.setGame(game);
		mainSceneController.setPlayer(player);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("XAXB"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
