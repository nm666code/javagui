import java.util.Comparator;

public class SortByTime implements Comparator<Player> {

	@Override
	public int compare(Player p1, Player p2) {	
		return p1.getTime()-p2.getTime();
	}
	
}
