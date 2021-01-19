package views;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import controllers.Action;
import controllers.ConstantUI;
import controllers.Controller;
import models.entities.DensityDataPeriod;

public class PanelCenterDensity extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JButton btThird;
	private JButton btFirst;
	private JButton btSecond;
	private JButton newPeriod;
	private JLabel dataFirst;
	private JLabel dataTwo;
	private JLabel dataTree;
	private PnTableDensity pnTableFirstPart;
	private PnTableDensity pnTableSecondPart;
	private PnTableDensity pnTableThirdPart;
	private JPanelVideo jpVideo;
	private ArrayList<DensityDataPeriod> datas;
	
	private String selectButton = ConstantUI.FIRST_PART;

	public PanelCenterDensity(Controller controller) {
		this.setLayout(null);
		datas = new ArrayList<>();
		
		btThird = new JButton(new ImageIcon(getClass().getResource(ConstantUI.IMG_BRIDGE)));
		btThird.setName(ConstantUI.THIRD_PART);
		btThird.setActionCommand(Action.DENCITY_PART.toString());
		btThird.addActionListener(controller);
		btThird.setBackground(Color.WHITE);
		btThird.setOpaque(false);
		btThird.setContentAreaFilled(false);
		btThird.setBounds(10, 76, 500, 94);
		add(btThird);

		btFirst = new JButton(new ImageIcon(getClass().getResource(ConstantUI.IMG_RAMP)));
		btFirst.setName(ConstantUI.FIRST_PART);
		btFirst.setActionCommand(Action.DENCITY_PART.toString());
		btFirst.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.RED, Color.RED));
		btFirst.addActionListener(controller);
		btFirst.setBackground(Color.WHITE);
		btFirst.setOpaque(false);
		btFirst.setContentAreaFilled(false);
		btFirst.setBounds(10, 350, 94, 180);
		add(btFirst);

		btSecond = new JButton(new ImageIcon(getClass().getResource(ConstantUI.IMG_PLAY)));
		btSecond.setBounds(10, 170, 94, 180);
		btSecond.setName(ConstantUI.SECOND_PART);
		btSecond.setActionCommand(Action.DENCITY_PART.toString());
		btSecond.addActionListener(controller);
		btSecond.setBackground(Color.WHITE);
		btSecond.setOpaque(false);
		btSecond.setContentAreaFilled(false);
		add(btSecond);
		
		dataFirst = new JLabel();
		dataFirst.setBounds(120, 420, 90, 70);
		add(dataFirst);

		dataTwo = new JLabel();
		dataTwo.setBounds(120, 240, 90, 70);
		add(dataTwo);
		
		dataTree = new JLabel();
		dataTree.setBounds(70, 56, 700, 20);
		add(dataTree);

		pnTableFirstPart = new PnTableDensity();
		pnTableFirstPart.setBackground(Color.WHITE);
		pnTableFirstPart.setBorder(BorderFactory.createTitledBorder("Primera zona"));
		pnTableFirstPart.setBounds(520, 0, 500, 200);
		add(pnTableFirstPart);
		
		pnTableSecondPart = new PnTableDensity();
		pnTableSecondPart.setBackground(Color.WHITE);
		pnTableSecondPart.setBorder(BorderFactory.createTitledBorder("Segunda zona"));
		pnTableSecondPart.setBounds(520, 0, 500, 200);
		add(pnTableSecondPart);
		pnTableSecondPart.setVisible(false);
		
		pnTableThirdPart = new PnTableDensity();
		pnTableThirdPart.setBackground(Color.WHITE);
		pnTableThirdPart.setBorder(BorderFactory.createTitledBorder("Tercera zona"));
		pnTableThirdPart.setBounds(520, 0, 500, 200);
		add(pnTableThirdPart);
		pnTableThirdPart.setVisible(false);
		
		newPeriod = new JButton(ConstantUI.NEW_PERIOD);
		newPeriod.setBackground(Color.WHITE);
		newPeriod.setActionCommand(Action.START_NEW_PERIOD.toString());
		newPeriod.addActionListener(controller);
		newPeriod.setBounds(420, 10, 100, 20);
		add(newPeriod);
		
		jpVideo = new JPanelVideo(controller);
		jpVideo.setBackground(Color.WHITE);
		jpVideo.setBounds(220, 200, ConstantUI.WIDTH_VIDEO, ConstantUI.HEIGTH_VIDEO + 40);
		add(jpVideo);
	}

	public void refreshPersons(String persons) {
		if (selectButton.equals(ConstantUI.FIRST_PART)) {
			pnTableFirstPart.refreshPersonList(persons);
		}else if (selectButton.equals(ConstantUI.SECOND_PART)) {
			pnTableSecondPart.refreshPersonList(persons);
		}else {
			pnTableThirdPart.refreshPersonList(persons);
		}
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
	
	private void resetBorderAll() {
		btFirst.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.WHITE, Color.WHITE));
		btSecond.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.WHITE, Color.WHITE));
		btThird.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.WHITE, Color.WHITE));
	}
	
	public void resetBorderBottons(String name) {
		resetBorderAll();
		if (btThird.getName().equals(name)) {
			btThird.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.RED, Color.RED));
			this.selectButton = ConstantUI.THIRD_PART;
			pnTableThirdPart.setVisible(true);
			pnTableFirstPart.setVisible(false);
			pnTableSecondPart.setVisible(false);
		}else if (btSecond.getName().equals(name)) {
			btSecond.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.RED, Color.RED));
			this.selectButton = ConstantUI.SECOND_PART;
			pnTableSecondPart.setVisible(true);
			pnTableFirstPart.setVisible(false);
			pnTableThirdPart.setVisible(false);
		}else if (btFirst.getName().contains(name)) {
			btFirst.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.RED, Color.RED));
			this.selectButton = ConstantUI.FIRST_PART;
			pnTableFirstPart.setVisible(true);
			pnTableThirdPart.setVisible(false);
			pnTableSecondPart.setVisible(false);
		}
	}

	public void setDatas(String one, String two, String tree) {
		dataFirst.setText(one);
		dataTwo.setText(two);
		dataTree.setText(tree);
	}
	
	public String getSelectButton() {
		return selectButton;
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

	private ArrayList<Integer> getArrayPoints() {
		ArrayList<Integer> arrays = new ArrayList<>();
		for (Integer integer : pnTableFirstPart.getPoints()) {
			arrays.add(integer);
		}
		for (Integer integer : pnTableSecondPart.getPoints()) {
			arrays.add(integer);
		}
		for (Integer integer : pnTableThirdPart.getPoints()) {
			arrays.add(integer);
		}
		return arrays;
	}

	public void continueAutoPause() {
		jpVideo.continueAutoPause();
	}
	
	public ArrayList<DensityDataPeriod> getDatas() {
		return datas;
	}

	public void addPeriodData(String hour) {
		datas.add(new DensityDataPeriod(getArrayPoints(), hour));
		pnTableFirstPart.resetPoitns();
		pnTableSecondPart.resetPoitns();
		pnTableThirdPart.resetPoitns();
	}
}