package views;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelComponent extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel txTipo;
	private JLabel txValor;
	private String name;
	
	public PanelComponent(String tipo, String name) {
		setLayout(null);
		txTipo = new JLabel(tipo +": ");
		txTipo.setBounds(5, 3, 180, 17);
		add(txTipo);
		
		txValor = new JLabel("0");
		txValor.setBounds(190, 3, 50, 17);
		add(txValor);
		
		this.name = name;
	}
	
	public String getTxvalor() {
		return txValor.getText();
	}
	
	public void resetTxValor() {
		txValor.setText("0");
	}
	
	public String getTxTipo() {
		return txTipo.getText();
	}
	
	public String getName() {
		return name;
	}
	
	public void setTxvalor(String txvalor) {
		this.txValor.setText(txvalor);
	}
}