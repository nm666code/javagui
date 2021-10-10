import java.util.TimerTask;

public class MyTimeTask extends TimerTask{
	
	private StopWatch stopWatch;
	
	public MyTimeTask(StopWatch stopWatch) {
		this.stopWatch = stopWatch;
	}

	@Override
	public void run() {
		stopWatch.setElapsedTime(stopWatch.getElapsedTime() + 1);
	}
}
