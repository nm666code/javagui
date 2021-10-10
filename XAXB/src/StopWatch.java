import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class StopWatch {
	
	private int elapsedTime;
	private Timer timer = new Timer();
	
	public void start() {
		 Calendar calendar = Calendar.getInstance();
		 calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND)+1);
		 Date firstTime = calendar.getTime();
		 timer = new Timer();
		 timer.schedule(new MyTimeTask(this), firstTime, 10);
	}
	
	public void stop() {
		timer.cancel();
		timer.purge();
		timer = null;
	}

	public int getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(int elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
}
