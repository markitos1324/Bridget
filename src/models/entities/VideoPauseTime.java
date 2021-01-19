package models.entities;

public class VideoPauseTime extends MyThread{

	private int time;
	private boolean AutoPlay;
	private TimeVideo timeVideo;
	
	public VideoPauseTime(int time) {
		this.time = time;
		this.AutoPlay = true;
	}
	
	@Override
	void executeTask() {
		if (AutoPlay) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (time != 0) {
				timeVideo.pause();
			}
		}
	}
	
	public TimeVideo getPnVideo() {
		return timeVideo;
	}

	public void setPnVideo(TimeVideo runnable) {
		this.timeVideo = runnable;
	}

	public boolean isAutoPlay() {
		return AutoPlay;
	}

	public void setAutoPlay(boolean autoPlay) {
		AutoPlay = autoPlay;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		if (time>1) {
			this.time = time * 1000;
			resume();
		}else {
			pause();
		}

	}
}