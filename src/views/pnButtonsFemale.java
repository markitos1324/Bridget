package views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import controllers.Action;
import controllers.ConstantUI;
import controllers.Controller;

public class pnButtonsFemale extends JPanel{

	private static final long serialVersionUID = 1L;

	private JButton btChildLuggage;
	private JButton btChildNotLuggage;
	private JButton btYoungLuggage;
	private JButton btYoungNotLuggage;
	private JButton btMenNotLuggage;
	private JButton btMenLuggage;
	private JButton btOldLuggage;
	private JButton btOldNotLuggage;
	
	private String selecTypePerson = "niño";
	private String selecSex = ConstantUI.NAME_SEX_WOMEN;
	private String selecLuggage = ConstantUI.NAME_LUGGAGE;
	private boolean isSelect = false;

	public pnButtonsFemale(Controller controller) {
		setLayout(new GridLayout(4, 2, 10,10));

		btChildLuggage = new JButton(new ImageIcon(getClass().getResource(ConstantUI.IMG_WOMEN_CHILD_LUGGAGE)));
		btChildLuggage.setName(ConstantUI.NAME_CHILD_LUGGAGE + "-" + ConstantUI.NAME_SEX_WOMEN);
		btChildLuggage.setActionCommand(Action.SELECT_TYPE.toString());
		btChildLuggage.addActionListener(controller);
		btChildLuggage.setBackground(Color.WHITE);
		btChildLuggage.setOpaque(false);
		btChildLuggage.setContentAreaFilled(false);
		add(btChildLuggage);

		btChildNotLuggage = new JButton(new ImageIcon(getClass().getResource(ConstantUI.IMG_WOMEN_CHILD_NOT_LUGGAGE)));
		btChildNotLuggage.setName(ConstantUI.NAME_CHILD_NOT_LUGGAGE + "-" + ConstantUI.NAME_SEX_WOMEN);
		btChildNotLuggage.setActionCommand(Action.SELECT_TYPE.toString());
		btChildNotLuggage.addActionListener(controller);
		btChildNotLuggage.setBackground(Color.WHITE);
		btChildNotLuggage.setOpaque(false);
		btChildNotLuggage.setContentAreaFilled(false);
		add(btChildNotLuggage);

		btYoungLuggage = new JButton(new ImageIcon(getClass().getResource(ConstantUI.IMG_WOMEN_YOUNG_LUGGAGE)));
		btYoungLuggage.setName(ConstantUI.NAME_YOUNG_LUGGAGE + "-" + ConstantUI.NAME_SEX_WOMEN);
		btYoungLuggage.setActionCommand(Action.SELECT_TYPE.toString());
		btYoungLuggage.addActionListener(controller);
		btYoungLuggage.setBackground(Color.WHITE);
		btYoungLuggage.setOpaque(false);
		btYoungLuggage.setContentAreaFilled(false);
		add(btYoungLuggage);

		btYoungNotLuggage = new JButton(new ImageIcon(getClass().getResource(ConstantUI.IMG_WOMEN_YOUNG_NOT_LUGGAGE)));
		btYoungNotLuggage.setName(ConstantUI.NAME_YOUNG_NOT_LUGGAGE + "-" + ConstantUI.NAME_SEX_WOMEN);
		btYoungNotLuggage.setActionCommand(Action.SELECT_TYPE.toString());
		btYoungNotLuggage.addActionListener(controller);
		btYoungNotLuggage.setBackground(Color.WHITE);
		btYoungNotLuggage.setOpaque(false);
		btYoungNotLuggage.setContentAreaFilled(false);
		add(btYoungNotLuggage);

		btMenLuggage = new JButton(new ImageIcon(getClass().getResource(ConstantUI.IMG_WOMEN_MEN_LUGGAGE)));
		btMenLuggage.setName(ConstantUI.NAME_MEN_LUGGAGE + "-" + ConstantUI.NAME_SEX_WOMEN);
		btMenLuggage.setActionCommand(Action.SELECT_TYPE.toString());
		btMenLuggage.addActionListener(controller);
		btMenLuggage.setBackground(Color.WHITE);
		btMenLuggage.setOpaque(false);
		btMenLuggage.setContentAreaFilled(false);
		add(btMenLuggage);

		btMenNotLuggage = new JButton(new ImageIcon(getClass().getResource(ConstantUI.IMG_WOMEN_MEN_NOT_LUGGAGE)));
		btMenNotLuggage.setName(ConstantUI.NAME_MEN_NOT_LUGGAGE + "-" + ConstantUI.NAME_SEX_WOMEN);
		btMenNotLuggage.setActionCommand(Action.SELECT_TYPE.toString());
		btMenNotLuggage.addActionListener(controller);
		btMenNotLuggage.setBackground(Color.WHITE);
		btMenNotLuggage.setOpaque(false);
		btMenNotLuggage.setContentAreaFilled(false);
		add(btMenNotLuggage);

		btOldLuggage = new JButton(new ImageIcon(getClass().getResource(ConstantUI.IMG_WOMEN_OLD_LUGGAGE)));
		btOldLuggage.setName(ConstantUI.NAME_OLD_LUGGAGE + "-" + ConstantUI.NAME_SEX_WOMEN);
		btOldLuggage.setActionCommand(Action.SELECT_TYPE.toString());
		btOldLuggage.addActionListener(controller);
		btOldLuggage.setBackground(Color.WHITE);
		btOldLuggage.setOpaque(false);
		btOldLuggage.setContentAreaFilled(false);
		add(btOldLuggage);

		btOldNotLuggage = new JButton(new ImageIcon(getClass().getResource(ConstantUI.IMG_WOMEN_OLD_NOT_LUGGAGE)));
		btOldNotLuggage.setName(ConstantUI.NAME_OLD_NOT_LUGGAGE + "-" + ConstantUI.NAME_SEX_WOMEN);
		btOldNotLuggage.setActionCommand(Action.SELECT_TYPE.toString());
		btOldNotLuggage.addActionListener(controller);
		btOldNotLuggage.setBackground(Color.WHITE);
		btOldNotLuggage.setOpaque(false);
		btOldNotLuggage.setContentAreaFilled(false);
		add(btOldNotLuggage);
	}

	public void resetBorderColorTypePerson() {
		btChildLuggage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.WHITE, Color.WHITE));
		btChildNotLuggage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.WHITE, Color.WHITE));
		btYoungLuggage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.WHITE, Color.WHITE));
		btYoungNotLuggage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.WHITE, Color.WHITE));
		btMenLuggage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.WHITE, Color.WHITE));
		btMenNotLuggage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.WHITE, Color.WHITE));
		btOldLuggage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.WHITE, Color.WHITE));
		btOldNotLuggage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.WHITE, Color.WHITE));
	}

	public void selectButtonsPerson(String name) {
		resetBorderColorTypePerson();
		if (name.contains(ConstantUI.NAME_CHILD_LUGGAGE)) {
			btChildLuggage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.RED, Color.RED));
			this.selecLuggage = "si";
			this.selecTypePerson = "Niño";
		}else if (name.contains(ConstantUI.NAME_CHILD_NOT_LUGGAGE)) {
			btChildNotLuggage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.RED, Color.RED));
			this.selecLuggage = "no";
			this.selecTypePerson = "Niño";
		}else if (name.contains(ConstantUI.NAME_YOUNG_LUGGAGE)) {
			btYoungLuggage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.RED, Color.RED));
			this.selecLuggage = "si";
			this.selecTypePerson = "Joven";
		}else if (name.contains(ConstantUI.NAME_YOUNG_NOT_LUGGAGE)) {
			btYoungNotLuggage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.RED, Color.RED));
			this.selecLuggage = "no";
			this.selecTypePerson = "Joven";
		}else if (name.contains(ConstantUI.NAME_MEN_LUGGAGE)) {
			btMenLuggage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.RED, Color.RED));
			this.selecLuggage = "si";
			this.selecTypePerson = "Adulto";
		}else if (name.contains(ConstantUI.NAME_MEN_NOT_LUGGAGE)) {
			btMenNotLuggage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.RED, Color.RED));
			this.selecLuggage = "no";
			this.selecTypePerson = "Adulto";
		}else if (name.contains(ConstantUI.NAME_OLD_LUGGAGE)) {
			btOldLuggage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.RED, Color.RED));
			this.selecLuggage = "si";
			this.selecTypePerson = "Anciano";
		}else if (name.contains(ConstantUI.NAME_OLD_NOT_LUGGAGE)) {
			btOldNotLuggage.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.RED, Color.RED));
			this.selecLuggage = "no";
			this.selecTypePerson = "Anciano";
		}
	}

	public String getButtonTypePersonSelect() {
		return selecTypePerson;
	}

	public String getButtonLuggageSelect() {
		return selecLuggage;
	}

	public String getButtonSexSelect() {
		return selecSex;
	}

	public boolean isSelect() {
		return isSelect;
	}

	public void setSelect(boolean isSelect) {
		this.isSelect = isSelect;
	}
	
}