import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

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

		TextInputDialog textInputDialog = new TextInputDialog("");
		textInputDialog.setTitle("XAXB");
		textInputDialog.setHeaderText("");
		textInputDialog.setContentText("您的名字是？");
		Optional<String> opt = textInputDialog.showAndWait();
		String name;
		
		try{
		    name = opt.get(); 
		}catch(final NoSuchElementException ex){
		    name = null;
		}
		
		gameSceneController.setStopwatch(stopwatch);
		gameSceneController.setGame(game);
		gameSceneController.setPlayer(player);
		gameSceneController.setAns(game.genEasyAns());
		
		if(name != null && !name.isEmpty()) {
		
			player.setName(name);
			stopwatch.start();
		
		
			stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}
	
	public void hardScene(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
		Parent root = loader.load();
		GameSceneController gameSceneController = loader.getController();
		
		gameSceneController.setDifficultyLabel("Hard");
		gameSceneController.setStopwatch(stopwatch);
		gameSceneController.setGame(game);
		gameSceneController.setPlayer(player);
		gameSceneController.setAns(game.genHardAns());
		
		TextInputDialog textInputDialog = new TextInputDialog("");
		textInputDialog.setTitle("XAXB");
		textInputDialog.setHeaderText("");
		textInputDialog.setContentText("您的名字是？");
		Optional<String> opt = textInputDialog.showAndWait();
		String name;
		
		try{
		    name = opt.get(); 
		}catch(final NoSuchElementException ex){
		    name = null;
		}
		
		if(name != null && !name.isEmpty()) {

			player.setName(name);
			stopwatch.start();
		
			stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}
	
	public void LeaderBoardScene(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("LeaderBoard.fxml"));
		Parent root = loader.load();
		LeaderBoardSceneController leaderBoardSceneController = loader.getController();
		
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

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
