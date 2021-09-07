import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class Driver extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage){
		// Create a scene and place a button in the scene
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
			Image icon = new Image("icon.png");
			primaryStage.setTitle("change radix"); // Set the stage title
			primaryStage.getIcons().add(icon);// Set the stage icon
			primaryStage.setScene(scene); // Place the scene in the stage
			primaryStage.show(); // Display the stage
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
