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

public class Controller {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private Label answer;
	@FXML
	private TextField input;
	
	private double num;
	private int intpart;
	private double decimalpart;
	
	public void binary(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Binary scene.fxml"));
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void octal(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Octal scene.fxml"));
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void hexadecimal(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Hexadecimal scene.fxml"));
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();	
	}
	
	public void homepage(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();	
	}
	
	public String intToAnyBase(int num, int base) {		
		char[] ans = new char[100];
		int digit = 0;
		String out = new String();
		
		if(num==0)
			return "0";
			
		else {
			while(num!=0) {
				if(num % base < 10)
					ans[digit++] = (char) (num % base + '0');
				else
					ans[digit++] = (char) (num % base -10 +'A');
				num = num / base;
			}
			
			for(; digit > 0; digit--){
				out += ans[digit-1];
			}
			
			return out;
		}
	}
	
	public String decimalToAnyBase(double decimal,int base) {
		char[] ans = new char[10];
		int digit = 0;
		String out = new String();
		
		if(decimal == 0.0)
			return "";
		
		while(decimal - (int)decimal !=0.0){
			int temp;
			temp = (int) (decimal*base);
			if(temp < 10)
				ans[digit++] = (char) (temp + '0');
			else
				ans[digit++] = (char) (temp - 10 + 'A');
			if(digit == 10) break;
			decimal= base * decimal - (int) (decimal * base);
		}
		
		out+=".";
		for(int i = 0; i < digit; i++)
			out += ans[i];
		return out;
	}
	
	public void showBinary(ActionEvent e) throws IOException{
		double num = Double.parseDouble(input.getText());
		intpart = (int) num;
		decimalpart = num - intpart;
		answer.setText(intToAnyBase(intpart,2)+decimalToAnyBase(decimalpart,2));
	}
	
	public void showOctal(ActionEvent e) throws IOException{
		double num = Double.parseDouble(input.getText());
		intpart = (int) num;
		decimalpart = num - intpart;
		answer.setText(intToAnyBase(intpart,8)+decimalToAnyBase(decimalpart,8));
	}
	
	public void showHexadecimal(ActionEvent e) throws IOException{
		double num = Double.parseDouble(input.getText());
		intpart = (int) num;
		decimalpart = num - intpart;
		answer.setText(intToAnyBase(intpart,16)+decimalToAnyBase(decimalpart,16));
	}
}
