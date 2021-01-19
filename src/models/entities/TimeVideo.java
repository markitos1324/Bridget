package models.entities;

public class TimeVideo extends MyThread{

	private int hours, minutes, seconds, miliSeconds;

	public TimeVideo(int hour, int minute) {
		this.hours = hour;
		this. minutes = minute;
		this.seconds = 0;
		this.miliSeconds = 0;
		start();
	}

	public void executeTask() {
		try	{
			if (!isPause()) {
				Thread.sleep(10);
				miliSeconds += 10;
				if(miliSeconds >= 1000) {
					seconds += miliSeconds / 1000;
					miliSeconds = 0;
					if(seconds >= 60) {
						seconds = 0;
						minutes++;
						if (minutes == 60) {
							minutes = 0;
							hours++;
						}
					}
				}
			}
		}catch(Exception e){}
	}

	public String getTime(){
		return hours + ":" + minutes + ":" + seconds;
	}
	
	public void resetTime(int hour, int minute) {
		pause();
		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.hours = hour;
		this. minutes = minute;
		this.seconds = 0;
		this.miliSeconds = 0;
	}
}