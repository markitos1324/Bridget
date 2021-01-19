package views;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.Action;
import controllers.ConstantUI;
import controllers.Controller;
import models.entities.Person;

public class PanelCenterDistance extends JPanel{

	private static final long serialVersionUID = 1L;
	public JLabel lbThird;
	public JButton btFirst;
	public JButton btSecond;
	public JLabel dataFirst;
	public JLabel dataTwo;
	public JLabel dataTree;
	public JButton btThird;
	public PnTableDistance pnTable;
	public JPanelVideo jpVideo;

	public PanelCenterDistance(Controller controller) {
		this.setLayout(null);

		lbThird = new JLabel(new ImageIcon(getClass().getResource(ConstantUI.IMG_BRIDGE)));
		lbThird.setBounds(10, 36, 500, 94);
		add(lbThird);

		btFirst = new JButton(new ImageIcon(getClass().getResource(ConstantUI.IMG_RAMP)));
		btFirst.setBounds(10, 310, 94, 180);
		btFirst.setName(ConstantUI.NAME_PLAY + "1");
		btFirst.setActionCommand(Action.CHANGE_IMAGE_PLAY.toString());
		btFirst.addActionListener(controller);
		btFirst.setBackground(Color.WHITE);
		btFirst.setOpaque(false);
		btFirst.setContentAreaFilled(false);
		btFirst.setBorderPainted(false);
		add(btFirst);

		btSecond = new JButton(new ImageIcon(getClass().getResource(ConstantUI.IMG_PLAY)));
		btSecond.setBounds(10, 130, 94, 180);
		btSecond.setName(ConstantUI.NAME_PLAY + "2");
		btSecond.setActionCommand(Action.CHANGE_IMAGE_PLAY.toString());
		btSecond.addActionListener(controller);
		btSecond.setBackground(Color.WHITE);
		btSecond.setOpaque(false);
		btSecond.setContentAreaFilled(false);
		btSecond.setBorderPainted(false);
		add(btSecond);

		btThird = new JButton(new ImageIcon(getClass().getResource(ConstantUI.IMG_END)));
		btThird.setBounds(370, 50, 70, 70);
		btThird.setName(ConstantUI.NAME_PLAY + "3");
		btThird.setActionCommand(Action.END.toString());
		btThird.addActionListener(controller);
		btThird.setBackground(Color.WHITE);
		btThird.setOpaque(false);
		btThird.setContentAreaFilled(false);
		btThird.setBorderPainted(false);
		add(btThird);
		
		JButton btStart = new JButton(new ImageIcon(getClass().getResource(ConstantUI.IMG_START)));
		btStart.setBounds(25, 500, 70, 83);
		btStart.setName(ConstantUI.NAME_PLAY + "3");
		btStart.setActionCommand(Action.START.toString());
		btStart.addActionListener(controller);
		btStart.setBackground(Color.WHITE);
		btStart.setOpaque(false);
		btStart.setContentAreaFilled(false);
		btStart.setBorderPainted(false);
		add(btStart);
		
		dataFirst = new JLabel();
		dataFirst.setBounds(120, 380, 90, 70);
		add(dataFirst);

		dataTwo = new JLabel();
		dataTwo.setBounds(120, 200, 90, 70);
		add(dataTwo);
		
		dataTree = new JLabel();
		dataTree.setBounds(70, 16, 700, 20);
		add(dataTree);

		
		pnTable = new PnTableDistance();
		pnTable.setBackground(Color.WHITE);
		pnTable.setBounds(520, 0, 500, 190);
		add(pnTable);
		
		jpVideo = new JPanelVideo(controller);
		jpVideo.setBackground(Color.WHITE);
		jpVideo.setBounds(220, 200, ConstantUI.WIDTH_VIDEO, ConstantUI.HEIGTH_VIDEO + 40);
		add(jpVideo);
		
		disable();
	}

	public void refreshPersons(ArrayList<Person> persons) {
		pnTable.refreshPersonList(persons);
	}
	
	public void setBridget(String btOne, String btTwo) {
		if (btOne.contains(ConstantUI.NAME_RAMP)) {
			btFirst.setIcon(new ImageIcon(getClass().getResource(ConstantUI.IMG_RAMP)));
		}else {
			btFirst.setIcon(new ImageIcon(getClass().getResource(ConstantUI.IMG_STAIRS)));
		}
		if (btTwo.contains(ConstantUI.NAME_RAMP)) {
			btSecond.setIcon(new ImageIcon(getClass().getResource(ConstantUI.IMG_RAMP)));
		}else {
			btSecond.setIcon(new ImageIcon(getClass().getResource(ConstantUI.IMG_STAIRS)));
		}
	}

	public void setDatas(String one, String two, String tree) {
		dataFirst.setText(one);
		dataTwo.setText(two);
		dataTree.setText(tree);
	}

	public void disable() {
		btFirst.setEnabled(false);
		btSecond.setEnabled(false);
		btThird.setEnabled(false);
	}
	
	public void disableButton(String namebt) {
		if (namebt.contains("1")) {
			btFirst.setEnabled(false);
		}else {
			btSecond.setEnabled(false);
		}		
	}
	public void enableButtons() {
		btFirst.setEnabled(true);
		btSecond.setEnabled(true);
		btThird.setEnabled(true);
	}

	public void disableAllButtons() {
		disable();
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
	
	public void resumeVideo() {
		jpVideo.resumeVideo();
	}
	
	public void changeImgButton(String name) {
		jpVideo.changeImgButton(name);
	}

	public void autoChangeTimePause(int time) {
		jpVideo.autoChangeTimePause(time);
	}

	public void continueAutoPause() {
		jpVideo.continueAutoPause();
	}
}