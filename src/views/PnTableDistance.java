package views;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controllers.ConstantUI;
import models.entities.Person;

public class PnTableDistance extends JPanel{

	private static final long serialVersionUID = 1L;

	private DefaultTableModel model;
	private JTable table;
	
	public PnTableDistance() {
		model = new DefaultTableModel();
		model.setColumnIdentifiers(ConstantUI.COLUMSDISTANCE);
		table = new JTable(model);
		
		JTableHeader header = table.getTableHeader();
		header.setBackground(ConstantUI.COLOR_BACKGROUND);
		header.setReorderingAllowed(false);
		header.setFont(ConstantUI.FONT_LETTERS_LIST);
		
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	public void refreshPersonList(ArrayList<Person> personList) {
		model.setRowCount(0);
		for (int i = personList.size() -1; i >= 0; i--) {
			ArrayList<Double> intervals = personList.get(i).getIntervalsSpeed();
			model.addRow(new Object[]{personList.get(i).getHour(), personList.get(i).getTypePerson(), personList.get(i).getSex(), personList.get(i).getLuggage(),
					String.format("%.2f", intervals.get(0)), String.format("%.2f", intervals.get(1)), String.format("%.2f", intervals.get(2))
					, String.format("%.2f", personList.get(i).getSpeedTotal())});
		}
	}
}