import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Collections; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class PlayerDB {
	private static ObservableList<Player> easyDB = FXCollections.observableArrayList();
	private static ObservableList<Player> hardDB = FXCollections.observableArrayList();
	
	public static void addEasyDB(Player player) {
		easyDB.add(player);
	}
	
	public static void addHardDB(Player player) {
		hardDB.add(player);
	}
	
	public static ObservableList<Player> getEasyDB(){
		return easyDB;
	}
	
	public static void setEasyDB(ObservableList<Player> DB) {
		easyDB = DB;
	}
	
	public static ObservableList<Player> getHardDB(){
		return hardDB;
	}
	
	public static void setHardDB(ObservableList<Player> DB) {
		hardDB = DB;
	}
	
	public static void writeOutDB(ObservableList<Player> DB, String fileName) {
		File file = new File(fileName);
		try (PrintWriter output = new PrintWriter(file);){
			for(Player p: DB) {
				output.println(
						p.getName()+" "+p.getFormatTime()+" "+p.getSteps());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ObservableList<Player> readInDB(String fileName) {
		File file = new File(fileName);
		ObservableList<Player> tempDB = FXCollections.observableArrayList();
		Scanner input;
		try {
			input = new Scanner(file);
			while (input.hasNext()) {
				Player p = new Player();
				p.setName(input.next());
				p.setFormatTime(input.next());
				p.setSteps(input.nextInt());
				tempDB.add(p);
			}
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempDB;
	}
	
	public static void DBSortBySteps(ObservableList<Player> DB) {
		Collections.sort(DB, new SortBySteps()); 
	}
	
	public static void DBSortByTime(ObservableList<Player> DB) {
		Collections.sort(DB, new SortByTime()); 
	}
}
