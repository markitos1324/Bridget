package views;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controllers.Action;
import controllers.ConstantUI;
import controllers.Controller;

public class DialogBridge extends JDialog{

	private static final long serialVersionUID = 1L;
	private JButton btFirst;
	private JButton btSecond;
	private JLabel lbBridge;
	
	private JSpinner spDistanceFirst;
	private JSpinner spPendingFirst;
	private JSpinner spWidthFirst;
	
	private JSpinner spDistanceSecond;
	private JSpinner spPendingSecond;
	private JSpinner spWidthSecond;
	
	private JSpinner spDistanceThird;
	private JSpinner spPendingThird;
	private JSpinner spWidthThird;
	
	private JLabel lbUrl;
	
	private JSpinner spHour;
	private JSpinner spMinutes;
	
	public DialogBridge(Controller controller) {
		setLayout(null);
		setSize(800, 700);
		setResizable(false);
		setUndecorated(true);
		setBackground(Color.WHITE);
		
		lbUrl = new JLabel();
		lbUrl.setBorder(BorderFactory.createTitledBorder(null, ConstantUI.TITLE_URL_LABEL, 0, 0, ConstantUI.FONT_LETTERS, Color.BLACK));
		lbUrl.setFont(ConstantUI.FONT_LETTERS);
		lbUrl.setBounds(420, 210, 200, 50);
		add(lbUrl);
		
		SpinnerModel modelHour = new SpinnerNumberModel(0, 0, 24, 1);
		SpinnerModel modelMinute = new SpinnerNumberModel(0, 0, 60, 1);
		
		JLabel lbHoras = new JLabel("Hora de inicio del video(Hora militar):");
		lbHoras.setFont(ConstantUI.FONT_LETTERS);
		lbHoras.setBounds(440, 300, 300, 20);
		add(lbHoras);
		
		JLabel lbHora = new JLabel("Hora:");
		lbHora.setFont(ConstantUI.FONT_LETTERS);
		lbHora.setBounds(440, 330, 50, 20);
		add(lbHora);
		
		spHour = new JSpinner(modelHour);
		spHour.setBounds(490, 330, 60, 23);
		spHour.setFont(ConstantUI.FONT_LETTERS);
		add(spHour);
		
		JLabel lbMinute = new JLabel("Minutos:");
		lbMinute.setFont(ConstantUI.FONT_LETTERS);
		lbMinute.setBounds(560, 330, 70, 20);
		add(lbMinute);
		
		spMinutes = new JSpinner(modelMinute);
		spMinutes.setBounds(640, 330, 60, 23);
		spMinutes.setFont(ConstantUI.FONT_LETTERS);
		add(spMinutes);
		
		JButton btUrl = new JButton(ConstantUI.SELECT);
		btUrl.setActionCommand(Action.SELECT_IMAGE.toString());
		btUrl.addActionListener(controller);
		btUrl.setFont(ConstantUI.FONT_LETTERS);
		btUrl.setBounds(620, 210, 80, 50);
		btUrl.setBackground(Color.WHITE);
		btUrl.setBackground(Color.decode("#D1B18C"));
		add(btUrl);
		
		JLabel lbDistanceFirst = new JLabel(ConstantUI.NAME_lB_DISTANCE);
		lbDistanceFirst.setFont(ConstantUI.FONT_LETTERS);
		lbDistanceFirst.setBounds(240, 380, 80, 20);
		add(lbDistanceFirst);
		
		
		SpinnerNumberModel model = new SpinnerNumberModel(0.0, -1000.0, 1000.0, 0.1);
		SpinnerNumberModel modelTwo = new SpinnerNumberModel(0.0, -1000.0, 1000.0, 0.1);
		SpinnerNumberModel modelThree = new SpinnerNumberModel(0.0, -1000.0, 1000.0, 0.1);
		SpinnerNumberModel modelFour= new SpinnerNumberModel(0.0, -1000.0, 1000.0, 0.1);
		SpinnerNumberModel modelFive = new SpinnerNumberModel(0.0, -1000.0, 1000.0, 0.1);
		SpinnerNumberModel modelSix = new SpinnerNumberModel(0.0, -1000.0, 1000.0, 0.1);
		SpinnerNumberModel modelSeven = new SpinnerNumberModel(0.0, -1000.0, 1000.0, 0.1);
		SpinnerNumberModel modelEigth = new SpinnerNumberModel(0.0, -1000.0, 1000.0, 0.1);
		SpinnerNumberModel modelNine = new SpinnerNumberModel(0.0, -1000.0, 1000.0, 0.1);
		
		spDistanceFirst = new JSpinner();
		spDistanceFirst.setModel(model);
		spDistanceFirst.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Double value = (Double) spDistanceFirst.getValue();
                long magnitude = Math.round(Math.log10(value));
                double stepSize = ConstantUI.STEP_RATIO * Math.pow(10, magnitude);
                model.setStepSize(stepSize);				
			}
        });
		spDistanceFirst.setBounds(320, 380, 80, 23);
		spDistanceFirst.setFont(ConstantUI.FONT_LETTERS);
		add(spDistanceFirst);
		
		JLabel lbPendingFirst = new JLabel(ConstantUI.NAME_LB_PENDING);
		lbPendingFirst.setFont(ConstantUI.FONT_LETTERS);
		lbPendingFirst.setBounds(240, 420, 90, 20);
		add(lbPendingFirst);
		
		spPendingFirst = new JSpinner();
		spPendingFirst.setModel(modelTwo); 
        spPendingFirst.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Double value = (Double) spPendingFirst.getValue();
                long magnitude = Math.round(Math.log10(value));
                double stepSize = ConstantUI.STEP_RATIO * Math.pow(10, magnitude);
                modelTwo.setStepSize(stepSize);				
			}
        });
		spPendingFirst.setFont(ConstantUI.FONT_LETTERS);
		spPendingFirst.setBounds(320, 420, 80, 23);
		add(spPendingFirst);
		
		JLabel lbWidthFirst = new JLabel(ConstantUI.NAME_LB_WIDTH);
		lbWidthFirst.setFont(ConstantUI.FONT_LETTERS);
		lbWidthFirst.setBounds(240, 460, 80, 20);
		add(lbWidthFirst);
		
		spWidthFirst = new JSpinner();
		spWidthFirst = new JSpinner();
		spWidthFirst.setModel(modelThree);
		spWidthFirst.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Double value = (Double) spPendingFirst.getValue();
                long magnitude = Math.round(Math.log10(value));
                double stepSize = ConstantUI.STEP_RATIO * Math.pow(10, magnitude);
                modelThree.setStepSize(stepSize);				
			}
        });
		spWidthFirst.setFont(ConstantUI.FONT_LETTERS);
		spWidthFirst.setBounds(320, 460, 80, 23);
		add(spWidthFirst);
		
		btFirst = new JButton(new ImageIcon(getClass().getResource(ConstantUI.IMG_STAIRS)));
		btFirst.setName(ConstantUI.NAME_STAIRS + "-1");
		btFirst.setActionCommand(Action.CHANGE_IMAGE.toString());
		btFirst.addActionListener(controller);
		btFirst.setBounds(140, 350, 94, 180);
		btFirst.setBackground(Color.WHITE);
		btFirst.setOpaque(false);
		btFirst.setContentAreaFilled(false);
		btFirst.setBorderPainted(false);
		add(btFirst);
		
		JLabel lbDistanceSecond = new JLabel(ConstantUI.NAME_lB_DISTANCE);
		lbDistanceSecond.setFont(ConstantUI.FONT_LETTERS);
		lbDistanceSecond.setBounds(240, 200, 80, 20);
		add(lbDistanceSecond);
		
		spDistanceSecond = new JSpinner();
		spDistanceSecond.setModel(modelFour); 
		spDistanceSecond.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Double value = (Double) spPendingFirst.getValue();
                long magnitude = Math.round(Math.log10(value));
                double stepSize = ConstantUI.STEP_RATIO * Math.pow(10, magnitude);
                modelFour.setStepSize(stepSize);				
			}
        });
		spDistanceSecond.setFont(ConstantUI.FONT_LETTERS);
		spDistanceSecond.setBounds(320, 200, 80, 23);
		add(spDistanceSecond);
		
		JLabel lbPendingSecond = new JLabel(ConstantUI.NAME_LB_PENDING);
		lbPendingSecond.setFont(ConstantUI.FONT_LETTERS);
		lbPendingSecond.setBounds(240, 240, 90, 20);
		add(lbPendingSecond);
		
		spPendingSecond = new JSpinner();
		spPendingSecond.setModel(modelFive); 
		spPendingSecond.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Double value = (Double) spPendingFirst.getValue();
                long magnitude = Math.round(Math.log10(value));
                double stepSize = ConstantUI.STEP_RATIO * Math.pow(10, magnitude);
                modelFive.setStepSize(stepSize);				
			}
        });
		spPendingSecond.setFont(ConstantUI.FONT_LETTERS);
		spPendingSecond.setBounds(320, 240, 80, 23);
		add(spPendingSecond);
		
		JLabel lbWidthSecond = new JLabel(ConstantUI.NAME_LB_WIDTH);
		lbWidthSecond.setFont(ConstantUI.FONT_LETTERS);
		lbWidthSecond.setBounds(240, 280, 80, 20);
		add(lbWidthSecond);
		
		spWidthSecond = new JSpinner();
		spWidthSecond.setModel(modelSix); 
		spWidthSecond.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Double value = (Double) spPendingFirst.getValue();
                long magnitude = Math.round(Math.log10(value));
                double stepSize = ConstantUI.STEP_RATIO * Math.pow(10, magnitude);
                modelSix.setStepSize(stepSize);				
			}
        });
		spWidthSecond.setFont(ConstantUI.FONT_LETTERS);
		spWidthSecond.setBounds(320, 280, 80, 23);
		add(spWidthSecond);
		
		btSecond = new JButton(new ImageIcon(getClass().getResource(ConstantUI.IMG_RAMP)));
		btSecond.setName(ConstantUI.NAME_RAMP + "-2");
		btSecond.setActionCommand(Action.CHANGE_IMAGE.toString());
		btSecond.addActionListener(controller);
		btSecond.setBounds(140, 170, 94, 180);
		btSecond.setBackground(Color.WHITE);
		btSecond.setOpaque(false);
		btSecond.setContentAreaFilled(false);
		btSecond.setBorderPainted(false);
		add(btSecond);
		
		lbBridge = new JLabel(new ImageIcon(getClass().getResource(ConstantUI.IMG_BRIDGE)));
		lbBridge.setBounds(140, 76, 500, 94);
		add(lbBridge);
		
		JLabel lbDistanceThird = new JLabel(ConstantUI.NAME_lB_DISTANCE);
		lbDistanceThird.setFont(ConstantUI.FONT_LETTERS);
		lbDistanceThird.setBounds(150, 50, 80, 20);
		add(lbDistanceThird);
		
		spDistanceThird = new JSpinner();
		spDistanceThird.setModel(modelSeven); 
		spDistanceThird.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Double value = (Double) spPendingFirst.getValue();
                long magnitude = Math.round(Math.log10(value));
                double stepSize = ConstantUI.STEP_RATIO * Math.pow(10, magnitude);
                modelSeven.setStepSize(stepSize);				
			}
        });
		
		spDistanceThird.setFont(ConstantUI.FONT_LETTERS);
		spDistanceThird.setBounds(230, 50, 80, 20);
		add(spDistanceThird);
		
		JLabel lbPendingThird = new JLabel(ConstantUI.NAME_LB_PENDING);
		lbPendingThird.setFont(ConstantUI.FONT_LETTERS);
		lbPendingThird.setBounds(320, 50, 90, 20);
		add(lbPendingThird);
		
		spPendingThird = new JSpinner();
		spPendingThird.setModel(modelEigth); 
		spPendingThird.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Double value = (Double) spPendingFirst.getValue();
                long magnitude = Math.round(Math.log10(value));
                double stepSize = ConstantUI.STEP_RATIO * Math.pow(10, magnitude);
                modelEigth.setStepSize(stepSize);				
			}
        });
		spPendingThird.setFont(ConstantUI.FONT_LETTERS);
		spPendingThird.setBounds(400, 50, 80, 20);
		add(spPendingThird);
		
		JLabel lbWidthThird = new JLabel(ConstantUI.NAME_LB_WIDTH);
		lbWidthThird.setFont(ConstantUI.FONT_LETTERS);
		lbWidthThird.setBounds(490, 50, 80, 20);
		add(lbWidthThird);
		
		spWidthThird = new JSpinner();
		spWidthThird.setModel(modelNine); 
		spWidthThird.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Double value = (Double) spPendingFirst.getValue();
                long magnitude = Math.round(Math.log10(value));
                double stepSize = ConstantUI.STEP_RATIO * Math.pow(10, magnitude);
                modelNine.setStepSize(stepSize);				
			}
        });
		spWidthThird.setFont(ConstantUI.FONT_LETTERS);
		spWidthThird.setBounds(540, 50, 80, 20);
		add(spWidthThird);
		
		setDefaultValues();
		
		JButton btAccept = new JButton(ConstantUI.BUTTON_ACCEPT);
		btAccept.setFont(ConstantUI.FONT_LETTERS);
		btAccept.setBounds(330, 550, 200, 70);
		btAccept.setActionCommand(Action.ACCEPT.toString());
		btAccept.addActionListener(controller);
		add(btAccept);
		
		JLabel lbUptc = new JLabel(new ImageIcon(getClass().getResource(ConstantUI.IMG_UPTC)));
		lbUptc.setBounds(0, 550, 170, 80);
		add(lbUptc);
		
		JLabel lbDescription = new JLabel(ConstantUI.DESCRIPTION_APLICATION);
		lbDescription.setFont(ConstantUI.FONT_LETTERS);
		lbDescription.setBounds(0, 630, 600, 80);
		add(lbDescription);
		
		JLabel lbTrack = new JLabel(new ImageIcon(getClass().getResource(ConstantUI.IMG_TRACK)));
		lbTrack.setBounds(660, 570, 90, 79);
		add(lbTrack);
		
		setVisible(true);
	}
	
	private void setDefaultValues() {
		spDistanceFirst.setValue((double)1);
		spPendingFirst.setValue((double)1);
		spWidthFirst.setValue((double)1);
		spDistanceSecond.setValue((double)1);
		spPendingSecond.setValue((double)1);
		spWidthSecond.setValue((double)1);
		spDistanceThird.setValue((double)1);
		spPendingThird.setValue((double)1);
		spWidthThird.setValue((double)1);
	}
	
	public void changeImage(String name) {
		String[] names = name.split("-");
		switch (names[1]) {
		case "1":
			switchImage(names[0], btFirst, "1");
			break;
		case "2":
			switchImage(names[0], btSecond, "2");
			break;
		}
	}
	
	public String getURL() {
		return lbUrl.getText();
	}
	
	private void switchImage(String actual, JButton bt, String num) {
		if (actual.equals(ConstantUI.NAME_STAIRS)) {
			bt.setIcon(new ImageIcon(getClass().getResource(ConstantUI.IMG_RAMP)));
			bt.setName(ConstantUI.NAME_RAMP + "-" + num);
		}else {
			bt.setIcon(new ImageIcon(getClass().getResource(ConstantUI.IMG_STAIRS)));
			bt.setName(ConstantUI.NAME_STAIRS + "-" + num);
		}
	}
	
	public String[] getFirst() {
		return new String[] {btFirst.getName(),
							String.valueOf(spDistanceFirst.getValue()),
							String.valueOf(spPendingFirst.getValue()),
							String.valueOf(spWidthFirst.getValue())};
	}

	public Double[] getFirstDatas() {
		return new Double[] {(Double) spDistanceFirst.getValue(), (Double) spPendingFirst.getValue(), (Double) spWidthFirst.getValue()};
	}

	public Double[] getSecondDatas() {
		return new Double[] {(Double) spDistanceSecond.getValue(), (Double) spPendingSecond.getValue(), (Double) spWidthSecond.getValue()};
	}
	
	public Double[] getThirdDatas() {
		return new Double[] {(Double) spDistanceThird.getValue(), (Double) spPendingThird.getValue(), (Double) spWidthThird.getValue()};
	}
	
	public String[] getSecond() {
		return new String[] {btSecond.getName(),
							String.valueOf(spDistanceSecond.getValue()),
							String.valueOf(spPendingSecond.getValue()),
							String.valueOf(spWidthSecond.getValue())};
	}
	
	public String getNameFirstButton() {
		return btFirst.getName();
	}
	
	public String getNameSecondButton() {
		return btSecond.getName();
	}

	public void setURL(String openFileChooser) {
		this.lbUrl.setText(openFileChooser);
	}

	public int getTimeHour() {
		return (int) spHour.getValue();
	}
	
	public int getTimeMinutes() {
		return (int) spMinutes.getValue();
	}
}