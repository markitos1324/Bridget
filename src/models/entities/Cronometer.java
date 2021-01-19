package models.entities;

public class Cronometer extends MyThread{

	private int minutes, seconds, miliSeconds, intervals;

	public Cronometer() {
		this. minutes = 0;
		this.seconds = 0;
		this.miliSeconds = 0;
		this.intervals = 0;
	}
	public void executeTask() {
		try	{
			if (!isPause()) {
				Thread.sleep(10);
				miliSeconds += 10;
				if(miliSeconds == 1000) {
					miliSeconds = 0;
					seconds += 1;
					if(seconds == 60) {
						seconds = 0;
						minutes++;
					}
				}
			}
		}catch(Exception e){}
	}

	
	public String getTime(){
		return minutes + " mm:" + seconds + " ss:" + miliSeconds + " ms";
	}

	public void summIntervals() {
		intervals++;
	}

	public int getIntervals() {
		return intervals;
	}
	public void resetTime() {
		pause();
		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this. minutes = 0;
		this.seconds = 0;
		this.miliSeconds = 0;
		this.intervals = 0;
	}
}