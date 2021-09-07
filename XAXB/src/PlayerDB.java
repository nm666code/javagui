import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Collections; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class PlayerDB {
	private ArrayList<Player> easyDB = new ArrayList<Player>();
	private ArrayList<Player> hardDB = new ArrayList<Player>();
	
	public void addEasyDB(Player player) {
		easyDB.add(player);
	}
	
	public void addhardDB(Player player) {
		hardDB.add(player);
	}
	
	public ArrayList<Player> getEasyDB(){
		ArrayList<Player> tempDB = new ArrayList<Player>();
		for(Player p: easyDB) {
			tempDB.add(p);
		}
		return tempDB;
	}
	
	public void setEasyDB(ArrayList<Player> DB) {
		this.easyDB = DB;
	}
	
	public ArrayList<Player> getHardDB(){
		ArrayList<Player> tempDB = new ArrayList<Player>();
		for(Player p: hardDB) {
			tempDB.add(p);
		}
		return tempDB;
	}
	
	public void setHardDB(ArrayList<Player> DB) {
		this.hardDB = DB;
	}
	
	public void writeOutDB(ArrayList<Player> DB, String fileName) {
		File file = new File(fileName);
		try (PrintWriter output = new PrintWriter(file);){
			for(Player p: DB) {
				output.println(
						p.getName()+" "+p.getTime()+" "+p.getSteps());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Player> readInDB(String fileName) {
		File file = new File(fileName);
		ArrayList<Player> tempDB = new ArrayList<Player>();
		try (Scanner input = new Scanner(file);){
			while (input.hasNext()) {
				Player p = new Player();
				p.setName(input.next());
				p.setTime(input.nextInt());
				p.setSteps(input.nextInt());
				tempDB.add(p);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempDB;
	}
	
	public void DBSortBySteps(ArrayList<Player> DB) {
		Collections.sort(DB, new SortBySteps()); 
	}
	
	public void DBSortByTime(ArrayList<Player> DB) {
		Collections.sort(DB, new SortByTime()); 
	}
}
