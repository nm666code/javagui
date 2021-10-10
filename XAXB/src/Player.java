
public class Player {
	private String name = new String();
	private int time;
	private int steps;
	private String formatTime; 
	
	public Player(String name, int time, int steps) {
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
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
		setFormatTime(Integer.toString(time/100)+"."+Integer.toString(time%100)+"s");
	}
	
	public int getSteps() {
		return steps;
	}
	
	public void setSteps(int steps) {
		this.steps = steps;
	}

	public String getFormatTime() {
		return formatTime;
	}

	public void setFormatTime(String formatTime) {
		this.formatTime = formatTime;
	}
}
