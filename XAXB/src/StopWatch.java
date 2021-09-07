import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class StopWatch extends TimerTask{
	
	private double elapsedTime = 0.00;
	private Timer timer = new Timer();
	
	@Override
	public void run() {
		setElapsedTime(getElapsedTime() + 0.01);
	}
	
	public void start() {
		 Calendar calendar = Calendar.getInstance();
		 calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND)+1);
		 Date firstTime = calendar.getTime();
		 timer.schedule(new StopWatch(), firstTime, 10);
	}
	
	public void stop() {
		timer.cancel();
	}

	public double getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(double elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
}
