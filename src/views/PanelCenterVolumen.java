package views;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import controllers.ConstantUI;
import controllers.Controller;
import models.entities.Person;

public class PanelCenterVolumen extends JPanel{

	private static final long serialVersionUID = 1L;

	public PnTableVolumen pnTable;
	public JPanelVideo jpVideo;

	public PanelCenterVolumen(Controller controller) {
		this.setLayout(null);

		pnTable = new PnTableVolumen();
		pnTable.setBackground(Color.WHITE);
		pnTable.setBounds(250, 0, 500, 190);
		add(pnTable);
		
		jpVideo = new JPanelVideo(controller);
		jpVideo.setBackground(Color.WHITE);
		jpVideo.setBounds(150, 200, ConstantUI.WIDTH_VIDEO, ConstantUI.HEIGTH_VIDEO + 40);
		add(jpVideo);
		
	}

	public void refreshPersons(ArrayList<Person> persons) {
		pnTable.refreshPersonList(persons);
	}

	public void setURL(String url) {
		jpVideo.setFile(url);
	}

	public void playVideo() {
		jpVideo.play();
	}

	public void pauseVideo() {
		jpVideo.pauseVideo();
	}
	
	public void changeImgButton(String name) {
		jpVideo.changeImgButton(name);
	}

	public void autoChangeTimePause(int time) {
		jpVideo.autoChangeTimePause(time);
	}

	public void resumeVideo() {
		jpVideo.resumeVideo();
	}

	public void continueAutoPause() {
		jpVideo.continueAutoPause();
	}
}