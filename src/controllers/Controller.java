package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jvnet.substance.SubstanceLookAndFeel;

import models.dao.ManagerPersonDistance;
import models.dao.ManagerPersonVolumen;
import models.entities.Bridget;
import models.entities.Cronometer;
import models.entities.MyThread;
import models.entities.TimeVideo;
import models.entities.VideoPauseTime;
import persistence.ExccelManager;
import views.DialogBridge;
import views.MainWIndow;

public class Controller implements ActionListener, ChangeListener{

	private DialogBridge dialogBridge;
	private MainWIndow mainWindow;
	private Cronometer cronometer;
	private TimeVideo timeVideoDistance;
	private TimeVideo timeVideoVolumen;
	private TimeVideo timeVideoDensity;
	private VideoPauseTime pauseTimeDistance;
	private VideoPauseTime pauseTimeVolumen;
	private VideoPauseTime pauseTimeDensity;
	private ManagerPersonDistance managerPersonDistance;
	private ManagerPersonVolumen managerPersonVolumen;
	private Bridget bridget;
	private int start;
	
	public Controller() {
		SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.CremeCoffeeSkin");
		cronometer = new Cronometer();
		managerPersonDistance = new ManagerPersonDistance();
		managerPersonVolumen = new ManagerPersonVolumen();
		timeVideoDistance = new TimeVideo(0, 0);
		startAutoPauseDistance(0);
		timeVideoVolumen = new TimeVideo(0, 0);
		startAutoPauseVolumen(0);
		timeVideoDensity = new TimeVideo(0, 0);
		startAutoPauseDensity(0);
		bridget = new Bridget();
		dialogBridge = new DialogBridge(this);
		mainWindow = new MainWIndow(this);
		cronometer.start();
		cronometer.resetTime();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Action.valueOf(e.getActionCommand())) {
		case CHANGE_IMAGE:
			dialogBridge.changeImage(((JButton)e.getSource()).getName());
			break;
		case ACCEPT:
			try {
				startMainWindow();
			}catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error intente nuevamente");
				dialogBridge.setVisible(true);
			}
			break;
		case CHANGE_IMAGE_PLAY:
			if (start > 0 && start < 3) {
				controlTimeIntervals(((JButton) e.getSource()).getName());
				start++;
			}
			break;
		case START:
			if (start == 0) {
				cronometer.resume();
				mainWindow.enableButtons();
				this.start ++;	
			}
			break;
		case END:
			if (start == 3) {
				endProgress();
				start = 0;
			}
			break;
		case SELECT_TYPE:
			selectedPerson(((JButton) e.getSource()).getName());
			break;
		case SELECT_IMAGE:
			dialogBridge.setURL(MainWIndow.openFileChooser());
			break;
		case PAUSE_OR_PLAY_VIDEO:
			if (mainWindow.getSelectedWindow().equals(ConstantUI.NAME_WINDOW_DISTANCE)) {
				pauseOrPlayVideoDistance(((JButton)e.getSource()).getName());
			}else if (mainWindow.getSelectedWindow().equals(ConstantUI.NAME_WINDOW_DENSITY)) {
				pauseOrPlayVideoDensity(((JButton)e.getSource()).getName());
			}else {
				pauseOrPlayVideoVolume(((JButton)e.getSource()).getName());
			}
			mainWindow.continueAutoPause();
			break;
		case EDIT:
			dialogBridge.setVisible(true);
			break;
		case AUTO_PAUSE_VIDEO:
			if (mainWindow.getSelectedWindow().equals(ConstantUI.NAME_WINDOW_DISTANCE)) {
				mainWindow.autoChangeTimePauseDistance((int)((JComboBox<Integer>)e.getSource()).getSelectedItem());
				pauseTimeDistance.setTime((int)((JComboBox<Integer>)e.getSource()).getSelectedItem());
			}else if (mainWindow.getSelectedWindow().equals(ConstantUI.NAME_WINDOW_DENSITY)) {
				mainWindow.autoChangeTimePauseDensity((int)((JComboBox<Integer>)e.getSource()).getSelectedItem());
				pauseTimeDensity.setTime((int)((JComboBox<Integer>)e.getSource()).getSelectedItem());
			}else {
				mainWindow.autoChangeTimePauseVolumen((int)((JComboBox<Integer>)e.getSource()).getSelectedItem());
				pauseTimeVolumen.setTime((int)((JComboBox<Integer>)e.getSource()).getSelectedItem());
			}
			break;
		case SAVE:
			if (ExccelManager.getPathFile().equals("")) {
				mainWindow.addPeriodData(timeVideoDensity.getTime());
				ExccelManager.setPath(MainWIndow.saveFileChooser());
			}
			try {
				ExccelManager.write(managerPersonDistance.getListPersons(), managerPersonVolumen.getListPersons(), mainWindow.getArrayPoints());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case SAVE_AS:
			ExccelManager.setPath(MainWIndow.saveFileChooser());
			try {
				mainWindow.addPeriodData(timeVideoDensity.getTime());
				ExccelManager.write(managerPersonDistance.getListPersons(), managerPersonVolumen.getListPersons(), mainWindow.getArrayPoints());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case DENCITY_PART:
			mainWindow.changeDensityButtonSelectPart(((JButton)e.getSource()).getName());
			break;
		case START_NEW_PERIOD:
			mainWindow.addPeriodData(timeVideoDensity.getTime());
			break;
		}
	}

	private void pauseOrPlayVideoVolume(String name) {
		mainWindow.changeImgButtonPlayVolumen(name);
		if (name.contains(ConstantUI.IMG_PLAY)) {
			timeVideoVolumen.pause();
			pauseTimeVolumen.setAutoPlay(false);
		}else {
			timeVideoVolumen.resume();
			pauseTimeVolumen.setAutoPlay(true);
		}
	}
	
	private void pauseOrPlayVideoDensity(String name) {
		mainWindow.changeImgButtonPlayDensity(name);
		if (name.contains(ConstantUI.IMG_PLAY)) {
			timeVideoDensity.pause();
			pauseTimeDensity.setAutoPlay(false);
		}else {
			timeVideoDensity.resume();
			pauseTimeDensity.setAutoPlay(true);
		}
	}
	
	public void pauseOrPlayVideoDistance(String name) {
		mainWindow.changeImgButtonPlayDistance(name);
		if (name.contains(ConstantUI.IMG_PLAY)) {
			timeVideoDistance.pause();
			pauseTimeDistance.setAutoPlay(false);
		}else {
			timeVideoDistance.resume();
			pauseTimeDistance.setAutoPlay(true);
		}
	}

	private void startAutoPauseDistance(int time) {
		pauseTimeDistance = new VideoPauseTime(time*1000);
		pauseTimeDistance.setPnVideo(timeVideoDistance);
		pauseTimeDistance.start();
		pauseTimeDistance.pause();
	}
	
	private void startAutoPauseVolumen(int time) {
		pauseTimeVolumen = new VideoPauseTime(time*1000);
		pauseTimeVolumen.setPnVideo(timeVideoVolumen);
		pauseTimeVolumen.start();
		pauseTimeVolumen.pause();
	}
	
	private void startAutoPauseDensity(int time) {
		pauseTimeDensity = new VideoPauseTime(time*1000);
		pauseTimeDensity.setPnVideo(timeVideoDensity);
		pauseTimeDensity.start();
		pauseTimeDensity.pause();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (!(dialogBridge.getURL().equals(""))) {
			if (((JPanel)((JTabbedPane)e.getSource()).getSelectedComponent()).getName().equals(ConstantUI.NAME_WINDOW_DISTANCE)) {
				timeVideoDistance.resume();
				pauseTimeDistance.setAutoPlay(true);
				mainWindow.resumeVideoDistance();
				mainWindow.pauseVideoVolumen();
				mainWindow.pauseVideoDensity();
				timeVideoVolumen.pause();
				pauseTimeVolumen.setAutoPlay(false);
				timeVideoDensity.pause();
				pauseTimeDensity.setAutoPlay(false);
			}else if (((JPanel)((JTabbedPane)e.getSource()).getSelectedComponent()).getName().equals(ConstantUI.NAME_WINDOW_VOlUMEN)) {
				timeVideoVolumen.resume();
				pauseTimeVolumen.setAutoPlay(true);
				mainWindow.resumeVideoVolumen();
				mainWindow.pauseVideoDistance();
				mainWindow.pauseVideoDensity();
				timeVideoDistance.pause();
				pauseTimeDistance.setAutoPlay(false);
				timeVideoDensity.pause();
				pauseTimeDensity.setAutoPlay(false);
			}else if (((JPanel)((JTabbedPane)e.getSource()).getSelectedComponent()).getName().equals(ConstantUI.NAME_WINDOW_DENSITY)) {
				timeVideoDensity.resume();
				pauseTimeDensity.setAutoPlay(true);
				mainWindow.resumeVideoDensity();
				mainWindow.pauseVideoDistance();
				mainWindow.pauseVideoVolumen();
				timeVideoDistance.pause();
				pauseTimeDistance.setAutoPlay(false);
				timeVideoVolumen.pause();
				pauseTimeVolumen.setAutoPlay(false);
			}
		}
	}

	private void selectedPerson(String name) {
		if (mainWindow.getSelectedWindow().equals(ConstantUI.NAME_WINDOW_DISTANCE)) {
			mainWindow.setSelectView(name);
			managerPersonDistance.addTypePerson(name);
			mainWindow.selectButtonsPerson(name);
		}else if(mainWindow.getSelectedWindow().equals(ConstantUI.NAME_WINDOW_VOlUMEN)) {
			mainWindow.setSelectView(name);
			managerPersonVolumen.addTypePerson(name);
			mainWindow.selectButtonsPerson(name);
			addAtributesPersonVolumen();
			managerPersonVolumen.addPersonToList(mainWindow.getButtonTypePersonSelect(), mainWindow.getButtonSexSelect(), mainWindow.getButtonLuggageSelect());
			mainWindow.refreshPersonsVolumen(managerPersonVolumen.getListPersons());
		}else if(mainWindow.getSelectedWindow().equals(ConstantUI.NAME_WINDOW_DENSITY)) {
			mainWindow.setSelectView(name);
			mainWindow.selectButtonsPerson(name);
			mainWindow.refreshPersonsDensity(name);
		}
	}

	private void startMainWindow() {
		if (!dialogBridge.getURL().equals("")) {
			if ((dialogBridge.getURL().substring((dialogBridge.getURL().length()-3), dialogBridge.getURL().length()).equals(ConstantUI.EXTENSION_VIDEO))) {
				timeVideoDistance.resetTime(dialogBridge.getTimeHour(), dialogBridge.getTimeMinutes());
				timeVideoDistance.resume();
				timeVideoVolumen.resetTime(dialogBridge.getTimeHour(), dialogBridge.getTimeMinutes());
				timeVideoVolumen.pause();
				timeVideoDensity.resetTime(dialogBridge.getTimeHour(), dialogBridge.getTimeMinutes());
				timeVideoDensity.pause();
				dialogBridge.setVisible(false);
				mainWindow.setURL(dialogBridge.getURL());
				mainWindow.startVideoDistance();
				mainWindow.startVideoVolumen();
				mainWindow.startVideoDensity();
				bridget.updateValues(dialogBridge.getFirstDatas(), dialogBridge.getSecondDatas(), dialogBridge.getThirdDatas());
				mainWindow.setBridget(dialogBridge.getNameFirstButton(), dialogBridge.getNameSecondButton());
				mainWindow.setDatas(bridget.getDatasFirstButton(), bridget.getDatasSecondButton(), bridget.getDatasThirdButton());
				mainWindow.setVisible(true);
				mainWindow.revalidateAllScreens();
			}else {
				mainWindow.message(ConstantUI.MSSG_ERROR_EXTENCION_VIDEO.toString());
			}
		}else {
			dialogBridge.setVisible(false);
			bridget.updateValues(dialogBridge.getFirstDatas(), dialogBridge.getSecondDatas(), dialogBridge.getThirdDatas());
			mainWindow.setBridget(dialogBridge.getNameFirstButton(), dialogBridge.getNameSecondButton());
			mainWindow.setDatas(bridget.getDatasFirstButton(), bridget.getDatasSecondButton(), bridget.getDatasThirdButton());
			mainWindow.setVisible(true);
		}
	}
	
	private void endProgress() {
		addAndSumm();
		mainWindow.enableButtons();
		managerPersonDistance.calculateSpeedTotal(bridget.getDistance(), cronometer.getTime());
		addAtributesPersonDistance();
		managerPersonDistance.addPersonToList(mainWindow.getButtonTypePersonSelect(), mainWindow.getButtonSexSelect(), mainWindow.getButtonLuggageSelect());
		mainWindow.refreshPersonsDistance(managerPersonDistance.getListPersons());
		mainWindow.disableAllButtons();
		cronometer.resetTime();
	}

	private void addAtributesPersonDistance() {
		managerPersonDistance.addLuggage(mainWindow.getButtonLuggageSelect());
		managerPersonDistance.addTypePerson(mainWindow.getButtonTypePersonSelect());
		managerPersonDistance.addSex(mainWindow.getButtonSexSelect());
		managerPersonDistance.addHour(timeVideoDistance.getTime());
	}
	
	private void addAtributesPersonVolumen() {
		managerPersonVolumen.addLuggage(mainWindow.getButtonLuggageSelect());
		managerPersonVolumen.addTypePerson(mainWindow.getButtonTypePersonSelect());
		managerPersonVolumen.addSex(mainWindow.getButtonSexSelect());
		managerPersonVolumen.addHour(timeVideoVolumen.getTime());
	}
	
	private void addAndSumm() {
		cronometer.summIntervals();
		managerPersonDistance.addPersonInterval(cronometer.getTime());
		managerPersonDistance.addIntervalSpeed(outTime(cronometer.getIntervals()), outInterval(cronometer.getIntervals()));
	}

	private void controlTimeIntervals(String namebt) {
		addAndSumm();
		addAtributesPersonDistance();
		mainWindow.dissableButton(namebt);
	}

	private Double outTime(int interval) {
		switch (interval) {
		case 1:
			return managerPersonDistance.getListTime().get(0);
		case 2:	
			return managerPersonDistance.getListTime().get(1);
		case 3:
			return managerPersonDistance.getListTime().get(2);
		}
		return 0.0;
	}
	
	private Double outInterval(int interval) {
		switch (interval) {
		case 1:
			return bridget.getFirstValue()[0];
		case 2:
			return bridget.getSecondValue()[0];
		case 3:
			return bridget.getThirdValue()[0];
		}
		return 0.0;
	}
	
	public String getTimeActual() {
		return cronometer.getTime();
	}

	public static void main(String[] args) {
		new Controller();
	}
}