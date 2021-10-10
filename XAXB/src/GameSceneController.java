import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
	private Label XAXB_Label;
	@FXML
	private TextField userAns;
	@FXML
	private Button leaderBoardbt;
		
	public void setDifficultyLabel(String message) {
		difficulty.setText(message);
	}
	
	public void mainScene(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
		Parent root = loader.load();
		MainSceneController mainSceneController = loader.getController();		
		
		stopwatch.stop();
		
		mainSceneController.setStopwatch(new StopWatch());
		mainSceneController.setGame(new Game());
		mainSceneController.setPlayer(new Player());
		
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void checkbt(ActionEvent e) throws IOException {
		checkAns();
	}
	
	@FXML
	public void textAction(KeyEvent e){
	    if(e.getCode().equals(KeyCode.ENTER))
	    	checkAns();
	}
	
	
	public void checkAns() {

		String uans = userAns.getText();
		
		if(uans.length() == 4) {
			
			String result = game.checkXAXB(ans, uans);
			XAXB_Label.setText(result);
			player.setSteps(player.getSteps()+1);
		
			if(result.equals("4A0B")) {
				stopwatch.stop();
				int t = stopwatch.getElapsedTime();
				player.setTime(t);
			
				leaderBoardbt.setVisible(true);
				XAXB_Label.setText(result+"\nwell done");
			
				if(difficulty.getText().equals("Easy")) {
					PlayerDB.addEasyDB(player);
					PlayerDB.writeOutDB(PlayerDB.getEasyDB(), "easyDB.txt");
				}
				
				else {
					PlayerDB.addHardDB(player);
					PlayerDB.writeOutDB(PlayerDB.getHardDB(), "hardDB.txt");
				}
			}
			else
				userAns.setText("");
	
			}
		
		else {
			XAXB_Label.setText("input must be four letter");
			userAns.setText("");
		}
			
	}
	public void leaderBoardbt(ActionEvent e) throws IOException {
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
	
	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}