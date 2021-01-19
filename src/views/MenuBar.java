package views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import controllers.Action;
import controllers.Controller;

public class MenuBar extends JMenuBar{

	private static final long serialVersionUID = 1L;

	private JMenu mainMenuBar;
	private JMenuItem itemEdit;
	private JMenuItem itemSave;
	
	public MenuBar(Controller controller) {
		this.setBackground(Color.WHITE);
		mainMenuBar = new JMenu("Archivo");
		mainMenuBar.setBackground(Color.WHITE);
		
		itemEdit = new JMenuItem("Editar");
		itemEdit.setBackground(Color.WHITE);
		itemEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		itemEdit.addActionListener(controller);
		itemEdit.setActionCommand(Action.EDIT.toString());
		mainMenuBar.add(itemEdit);
		
		itemSave = new JMenuItem("Guardar");
		itemSave.setBackground(Color.WHITE);
		itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		itemSave.addActionListener(controller);
		itemSave.setActionCommand(Action.SAVE.toString());
		mainMenuBar.add(itemSave);
		
		itemSave = new JMenuItem("Guardar como");
		itemSave.setBackground(Color.WHITE);
//		itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		itemSave.addActionListener(controller);
		itemSave.setActionCommand(Action.SAVE_AS.toString());
		mainMenuBar.add(itemSave);
		
		add(mainMenuBar);
	}
}
