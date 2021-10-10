import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class LeaderBoardSceneController implements Initializable{
		
	@FXML
	private TableView<Player> easyBoard;
	@FXML
	private TableView<Player> hardBoard;
	@FXML
	private TableColumn<Player,String> eName;
	@FXML
	private TableColumn<Player,String> eTime;
	@FXML
	private TableColumn<Player,String> eStep;
	@FXML
	private TableColumn<Player,String> hName;
	@FXML
	private TableColumn<Player,String> hTime;
	@FXML
	private TableColumn<Player,String> hStep;

	private Stage stage;
	
	public void mainScene(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
		Parent root = loader.load();
		MainSceneController mainSceneController = loader.getController();		
		
		mainSceneController.setStopwatch(new StopWatch());
		mainSceneController.setGame(new Game());
		mainSceneController.setPlayer(new Player());
		
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		eName.setCellValueFactory(new PropertyValueFactory<Player ,String>("name"));
		eTime.setCellValueFactory(new PropertyValueFactory<Player ,String>("formatTime"));
		eStep.setCellValueFactory(new PropertyValueFactory<Player ,String>("steps"));
		hName.setCellValueFactory(new PropertyValueFactory<Player ,String>("name"));
		hTime.setCellValueFactory(new PropertyValueFactory<Player ,String>("formatTime"));
		hStep.setCellValueFactory(new PropertyValueFactory<Player ,String>("steps"));
		
		easyBoard.setItems(PlayerDB.getEasyDB());
		hardBoard.setItems(PlayerDB.getHardDB());
	}
	
	
}
