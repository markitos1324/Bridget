package models.entities;

import views.JPanelVideo;

public class VideoPause extends MyThread{

	private int time;
	private boolean AutoPlay;
	private JPanelVideo pnVideo;
	
	public VideoPause(int time, JPanelVideo pnVideo) {
		this.time = time;
		this.AutoPlay = true;
		this.pnVideo = pnVideo;
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
				pnVideo.pauseVideo();
				AutoPlay = false;
			}
		}
	}
	
	public JPanelVideo getPnVideo() {
		return pnVideo;
	}

	public void setPnVideo(JPanelVideo runnable) {
		this.pnVideo = runnable;
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
		this.time = time * 1000;
	}
}