package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controllers.ConstantUI;

public class PnTableDensity extends JPanel{

	private static final long serialVersionUID = 1L;

	private ArrayList<PanelComponent> persons;
	
	public PnTableDensity() {
		setLayout(new GridLayout(8, 2));
		persons = new ArrayList<>();
		fillArray();
		addArray();
	}
	
	private void addArray() {
		for (PanelComponent jTextField : persons) {
			this.add(jTextField);
		}
	}

	private void fillArray() {
		for (int i = 0; i < ConstantUI.VECTOR_ALL_TYPES_PERSONS_NAMES.length; i++) {
			PanelComponent pnField = new PanelComponent(ConstantUI.VECTOR_ALL_TYPES_PERSONS_TX_FIELDS[i], ConstantUI.VECTOR_ALL_TYPES_PERSONS_NAMES[i]);
			pnField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			pnField.setBackground(Color.WHITE);
			persons.add(pnField);
		}
	}
	
	public void refreshPersonList(String personType) {
		for (PanelComponent pnComponent : persons) {
			if (pnComponent.getName().contains(personType)) {
				pnComponent.setTxvalor(String.valueOf(Integer.parseInt(pnComponent.getTxvalor()) + 1));
			}
		}
		revalidate();
	}

	public ArrayList<Integer> getPoints() {
		ArrayList<Integer> points = new ArrayList<>();
		for (PanelComponent panelComponent : persons) {
			points.add(Integer.parseInt(panelComponent.getTxvalor()));
		}
		return points;
	}

	public void resetPoitns() {
		for (PanelComponent panelComponent : persons) {
			panelComponent.resetTxValor();
		}
	}
}