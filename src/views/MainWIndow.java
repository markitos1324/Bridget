package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;

import controllers.ConstantUI;
import controllers.Controller;
import models.entities.DensityDataPeriod;
import models.entities.Person;

public class MainWIndow extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private PanelCenterDistance pnWindowDistance;
	private PanelCenterVolumen pnWindowVolumen;
	private PanelCenterDensity pnWindowDensity;
	private PnCronometer pnCronometer;
	private pnButtonsMale pnButtonsMale;
	private pnButtonsFemale pnButtonsFemale;
	private MenuBar menuBar;
	private static JFileChooser fcLoadurl;
	private static JFileChooser fcSaveurl;
	private JTabbedPane panels;

	public MainWIndow(Controller controller) {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,700);
		setTitle(ConstantUI.TITLE_MAIN_WINDOW);
		fcLoadurl = new JFileChooser();
		fcLoadurl.setDialogTitle(ConstantUI.SELECT_FILE);
		
		fcSaveurl = new JFileChooser();
		fcLoadurl.setDialogTitle(ConstantUI.SELECT_FILE);
		
		fcSaveurl.setFileFilter(new FileNameExtensionFilter("xlsx", "xlsx"));
		fcLoadurl.setFileFilter(new FileNameExtensionFilter("mp4", "MP4"));
		
		menuBar = new MenuBar(controller);
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		
		pnWindowDistance = new PanelCenterDistance(controller);
		pnWindowDistance.setName(ConstantUI.NAME_WINDOW_DISTANCE);
		pnWindowDistance.setBackground(Color.WHITE);
		
		pnWindowVolumen = new PanelCenterVolumen(controller);
		pnWindowVolumen.setName(ConstantUI.NAME_WINDOW_VOlUMEN);
		pnWindowVolumen.setBackground(Color.WHITE);
		
		pnWindowDensity = new PanelCenterDensity(controller);
		pnWindowDensity.setName(ConstantUI.NAME_WINDOW_DENSITY);
		pnWindowDensity.setBackground(Color.WHITE);

		panels = new JTabbedPane();
		panels.setFont(ConstantUI.FONT_LETTERS);
		panels.setBackground(Color.WHITE);
		panels.addChangeListener(controller);
		
		panels.add(ConstantUI.NAME_WINDOW_SPEED, pnWindowDistance);
		panels.add(ConstantUI.NAME_WINDOW_VOlUMEN, pnWindowVolumen);
		panels.add(ConstantUI.NAME_WINDOW_DENSITY, pnWindowDensity);
		add(panels, BorderLayout.CENTER);
		
		pnCronometer = new PnCronometer();
		pnCronometer.setBackground(Color.WHITE);
		add(pnCronometer, BorderLayout.NORTH);
		
		pnButtonsMale = new pnButtonsMale(controller);
		pnButtonsMale.setBorder(BorderFactory.createTitledBorder(null, ConstantUI.TITLE_BUTTONS_MALE, 0, 0, ConstantUI.FONT_LETTERS, Color.BLACK));
		pnButtonsMale.setBackground(Color.WHITE);
		add(pnButtonsMale, BorderLayout.WEST);
		
		pnButtonsFemale = new pnButtonsFemale(controller);
		pnButtonsFemale.setBorder(BorderFactory.createTitledBorder(null, ConstantUI.TITLE_BUTTONS_FEMALE, 0, 0, ConstantUI.FONT_LETTERS, Color.BLACK));
		pnButtonsFemale.setBackground(Color.WHITE);
		add(pnButtonsFemale, BorderLayout.EAST);
		
		SwingWorker<Integer, Integer> swingWorker = new SwingWorker<Integer, Integer>(){
			@Override
			protected synchronized Integer doInBackground() throws Exception {
				while (true) {
					setTime(controller.getTimeActual());
					Thread.sleep(10);
				}
			}
		};
		swingWorker.execute();
	}
	
	public void refreshPersonsDistance(ArrayList<Person> persons) {
		pnWindowDistance.refreshPersons(persons);
	}
	
	public void refreshPersonsVolumen(ArrayList<Person> persons) {
		pnWindowVolumen.refreshPersons(persons);
	}
	
	public void refreshPersonsDensity(String persons) {
		pnWindowDensity.refreshPersons(persons);
	}
	
	public void disableAllButtons() {
		pnWindowDistance.disableAllButtons();
	}
	
	public void setTime(String time) {
		pnCronometer.editTime(time);
	}
	public void setBridget(String btOne, String btTwo) {
		pnWindowDistance.setBridget(btOne, btTwo);
		pnWindowDensity.setBridget(btOne, btTwo);
	}
	
	public void setDatas(String one, String two, String tree) {
		pnWindowDistance.setDatas(one, two, tree);
	}

	public void dissableButton(String namebt) {
		pnWindowDistance.disableButton(namebt);
	}
	
	public void enableButtons() {
		pnWindowDistance.enableButtons();
	}

	public void selectButtonsPerson(String name) {
		if (pnButtonsMale.isSelect()) {
			pnButtonsFemale.resetBorderColorTypePerson();
			pnButtonsMale.selectButtonsPerson(name);;
		}else {
			pnButtonsMale.resetBorderColorTypePerson();
			pnButtonsFemale.selectButtonsPerson(name);
		}
	}
	
	public String getButtonTypePersonSelect() {
		if (pnButtonsFemale.isSelect()) {
			return pnButtonsFemale.getButtonTypePersonSelect();
		}else {
			return pnButtonsMale.getButtonTypePersonSelect();
		}
	}

	public String getButtonSexSelect() {
		if (pnButtonsFemale.isSelect()) {
			return pnButtonsFemale.getButtonSexSelect();
		}else {
			return pnButtonsMale.getButtonSexSelect();
		}
	}
	
	public void setSelectView(String name) {
		if (name.contains(ConstantUI.NAME_SEX_MEN)) {
			pnButtonsMale.setSelect(true);
			pnButtonsFemale.setSelect(false);
		}else {
			pnButtonsMale.setSelect(false);
			pnButtonsFemale.setSelect(true);
		}
	}
	
	public String getButtonLuggageSelect() {
		if (pnButtonsFemale.isSelect()) {
			return pnButtonsFemale.getButtonLuggageSelect();
		}else {
			return pnButtonsMale.getButtonLuggageSelect();
		}
	}

	public void setURL(String url) {
		pnWindowDistance.setURL(url);
		pnWindowVolumen.setURL(url);
		pnWindowDensity.setURL(url);
	}

	public void startVideoDistance() {
		pnWindowDistance.playVideo();
	}
	
	public void startVideoDensity() {
		pnWindowDensity.playVideo();
	}

	public void startVideoVolumen() {
		pnWindowVolumen.playVideo();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pnWindowVolumen.pauseVideo();
	}
	
	public void resumeVideoDistance() {
		pnWindowDistance.resumeVideo();
	}
	
	public void resumeVideoDensity() {
		pnWindowDensity.resumeVideo();
	}
	
	public void resumeVideoVolumen() {
		pnWindowVolumen.resumeVideo();
	}

	public void pauseVideoDensity() {
		pnWindowDensity.pauseVideo();		
	}
	
	public void pauseVideoDistance() {
		pnWindowDistance.pauseVideo();
	}
	
	public void pauseVideoVolumen() {
		pnWindowVolumen.pauseVideo();
	}
	
	public void changeImgButtonPlayDistance(String name) {
		pnWindowDistance.changeImgButton(name);
	}
	
	public void changeImgButtonPlayDensity(String name) {
		pnWindowDensity.changeImgButton(name);		
	}
	
	public void changeImgButtonPlayVolumen(String name) {
		pnWindowVolumen.changeImgButton(name);
	}

	public void message(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

	public void autoChangeTimePauseDistance(int time) {
		pnWindowDistance.autoChangeTimePause(time);
	}
	
	public void autoChangeTimePauseVolumen(int time) {
		pnWindowVolumen.autoChangeTimePause(time);
	}
	
	public void autoChangeTimePauseDensity(int time) {
		pnWindowDensity.autoChangeTimePause(time);
	}
	
	public static String openFileChooser(){
		int option = fcLoadurl.showOpenDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			return fcLoadurl.getSelectedFile().getPath();
		}
		return "";
	}
	
	public static String saveFileChooser(){
		int option = fcSaveurl.showSaveDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			return fcSaveurl.getSelectedFile().getPath();
		}
		return "";
	}

	public String getSelectedWindow() {
		return ((JPanel)panels.getSelectedComponent()).getName();
	}

	public void changeDensityButtonSelectPart(String name) {
		pnWindowDensity.resetBorderBottons(name);
	}

	public ArrayList<DensityDataPeriod> getArrayPoints() {
		return pnWindowDensity.getDatas();
	}

	public void revalidateAllScreens() {
		pnWindowDensity.revalidate();
		pnWindowDistance.revalidate();
		pnWindowVolumen.revalidate();
	}

	public void continueAutoPause() {
		pnWindowDensity.continueAutoPause();
		pnWindowDistance.continueAutoPause();
		pnWindowVolumen.continueAutoPause();
	}

	public void addPeriodData(String hour) {
		pnWindowDensity.addPeriodData(hour);
	}
}