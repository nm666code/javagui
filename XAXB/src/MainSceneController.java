import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainSceneController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private Player player;
	private StopWatch stopwatch;
	private Game game;
	
	public void easyScene(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
		Parent root = loader.load();
		GameSceneController gameSceneController = loader.getController();
		
		gameSceneController.setStopwatch(stopwatch);
		gameSceneController.setGame(game);
		gameSceneController.setAns(game.genEasyAns());
		
		stopwatch.start();
		
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void hardScene(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
		Parent root = loader.load();
		GameSceneController gameSceneController = loader.getController();
		
		gameSceneController.setDifficultyLabel("Hard");
		gameSceneController.setStopwatch(stopwatch);
		gameSceneController.setGame(game);
		gameSceneController.setAns(game.genHardAns());
		
		stopwatch.start();
		
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public StopWatch getStopwatch() {
		return stopwatch;
	}

	public void setStopwatch(StopWatch stopwatch) {
		this.stopwatch = stopwatch;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
