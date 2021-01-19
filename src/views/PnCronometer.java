package views;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.ConstantUI;

public class PnCronometer extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel lbTime;
	
	public PnCronometer() {
		lbTime = new JLabel(ConstantUI.DEFAULT_TIME_CRONOMETER);
		lbTime.setFont(ConstantUI.FONT_LETTERS_CRONOMETER);
		add(lbTime, BorderLayout.CENTER);
	}
	
	public void editTime(String timeActual){
		lbTime.setText(timeActual);
	}
}