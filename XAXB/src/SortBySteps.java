import java.util.Comparator;

public class SortBySteps implements Comparator<Player> {

	@Override
	public int compare(Player p1, Player p2) {
		// TODO Auto-generated method stub
		return p1.getSteps()-p2.getSteps();
	}

}
