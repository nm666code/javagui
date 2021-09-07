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

public class GameSceneController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private Player player;
	private StopWatch stopwatch;
	private Game game; 
	private String ans;
	
	@FXML
	private Label difficulty;
	@FXML
	private Label XAXB;
	@FXML
	private TextField userAns;
	
	public void GameSceneController(Player player, StopWatch stopwatch) {
		this.player = player;
		this.setStopwatch(stopwatch);
	}
	
	public void setDifficultyLabel(String message) {
		difficulty.setText(message);
	}
	
	public void mainScene(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void checkbt(ActionEvent e) throws IOException {
		String result = game.checkXAXB(ans, userAns.getText());
		XAXB.setText(result);
		if(result.equals("4A0B")) {
			stopwatch.stop();
		}
		else
			userAns.setText("");
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
	
	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}
}
