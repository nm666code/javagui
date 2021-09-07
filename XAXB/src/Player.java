
public class Player {
	private String name = new String();
	private long time;
	private int steps;
	
	public Player(String name, long time, int steps) {
		this.name = name;
		this.time = time;
		this.steps = steps;
	}
	
	public Player() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getTime() {
		return time;
	}
	
	public void setTime(long time) {
		this.time = time;
	}
	
	public int getSteps() {
		return steps;
	}
	
	public void setSteps(int steps) {
		this.steps = steps;
	}
}
