package views;

import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import controllers.Action;
import controllers.ConstantUI;
import controllers.Controller;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import models.entities.VideoPause;
/**
 * @see http://www.jc-mouse.net/
 * @author mouse
 */
public class JPanelVideo extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JFXPanel jfxPanel;
	private File file;
	private MediaView media;
	private MediaPlayer oracleVid;
	private VideoPause videoPause;
	
	private JButton btPause;
	private JComboBox<Object> cbSeconds;
	private ArrayList<Integer> seconds;
	
	public JPanelVideo(Controller controller) {
		jfxPanel = new JFXPanel();
		media = new MediaView();
		setLayout(null);
		seconds = new ArrayList<>();
		int num = 0;
		for (int i = 0; i < 7; i++) {
			seconds.add(num);
			num +=5;
		}
		
		cbSeconds = new JComboBox<>(seconds.toArray());
		cbSeconds.setBorder(BorderFactory.createTitledBorder(ConstantUI.TITLE_VIDEO_PAUSE));
		cbSeconds.setSelectedIndex(0);
		cbSeconds.setName(ConstantUI.NAME_CB_SECONDS_PLAY);
		cbSeconds.addActionListener(controller);
		cbSeconds.setActionCommand(Action.AUTO_PAUSE_VIDEO.toString());
		cbSeconds.setBounds(680, 355, 120, 50);
		add(cbSeconds);
		
		btPause = new JButton(new ImageIcon(getClass().getResource(ConstantUI.IMG_PLAY)));
		btPause.setName(ConstantUI.IMG_PLAY);
		btPause.addActionListener(controller);
		btPause.setActionCommand(Action.PAUSE_OR_PLAY_VIDEO.toString());
		btPause.setBounds(770, 325, 30, 30);
		add(btPause);
		
		jfxPanel.setBounds(0, 0, 800, 400);
		add(jfxPanel);
	}

	public void changeImgButton(String name) {
		if (name.contains(ConstantUI.IMG_PLAY)) {
			pauseVideo();
			videoPause.setAutoPlay(false);
		}else {
			startVideo();
			videoPause.setAutoPlay(true);
		}
	}

	public void startVideo() {
		btPause.setName(ConstantUI.IMG_PLAY);
		cbSeconds.setName(ConstantUI.NAME_CB_SECONDS_STOP);
		btPause.setIcon((new ImageIcon(getClass().getResource(ConstantUI.IMG_PLAY))));
		oracleVid.play();
	}

	public void pauseVideo() {
		btPause.setName(ConstantUI.IMG_PAUSE);
		cbSeconds.setName(ConstantUI.NAME_CB_SECONDS_PLAY);
		btPause.setIcon(new ImageIcon(getClass().getResource(ConstantUI.IMG_PAUSE)));
		oracleVid.pause();
	}
	
	public void resumeVideo() {
		btPause.setName(ConstantUI.IMG_PLAY);
		cbSeconds.setName(ConstantUI.NAME_CB_SECONDS_STOP);
		btPause.setIcon((new ImageIcon(getClass().getResource(ConstantUI.IMG_PLAY))));
		oracleVid.play();
	}
	
	public void setFile(String url) {
		file = new File(url);
	}

	public void play() {
		createScene();
	}
	
	public void mute() {
		oracleVid.muteProperty();
	}
	
	public void createScene(){
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {                 
				oracleVid = new MediaPlayer(new Media(file.toURI().toString()));
				media = new MediaView(oracleVid);
				media.setFitHeight(ConstantUI.HEIGTH_VIDEO);
				media.setFitWidth(ConstantUI.WIDTH_VIDEO);
				jfxPanel.setScene(new Scene(new Group(media)));
				oracleVid.setVolume(0.7);
				oracleVid.setCycleCount(MediaPlayer.INDEFINITE);
				oracleVid.play();
				startAutoPause();
			}
		});
	}
	
	private void startAutoPause() {
		videoPause = new VideoPause((int)cbSeconds.getSelectedItem()*1000, this);
//		videoPause.setPnVideo(this);
		videoPause.start();
		videoPause.pause();
	}
	
	public void autoChangeTimePause(int time) {
		if (time>1) {
			videoPause.setTime(time);
			videoPause.resume();
		}else {
			videoPause.pause();
		}
	}
	
	public String getCbSecondsName() {
		return cbSeconds.getName();
	}

	public void continueAutoPause() {
		videoPause.setAutoPlay(true);;
	}
}