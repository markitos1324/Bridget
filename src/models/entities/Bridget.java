package models.entities;

public class Bridget {

	private Double[] firstValue;
	private Double[] secondValue;	
	private Double[] thirdValue;
	
	public Bridget() {
		this.firstValue = new Double[3];
		this.secondValue = new Double[3];
		this.thirdValue = new Double[3];
	}
	
	public void updateValues(Double[] f, Double[] s, Double[] t) {
		this.firstValue = f;
		this.secondValue = s;
		this.thirdValue = t;
	}

	public String getDatasFirstButton() {
		return "<html><body>" + "Distancia: " + String.format("%.2f", firstValue[0]) + "<br>" +
				"Pendiente: " + String.format("%.2f", firstValue[1]) + "<br>" +
				"Ancho: " + String.format("%.2f", firstValue[2]) + "<br>" + "</body></html>";
	}
	
	public String getDatasSecondButton() {
		return "<html><body>"+ "Distancia: " + String.format("%.2f", secondValue[0]) + "<br>" +
				"Pendiente: " + String.format("%.2f", secondValue[1]) + "<br>" +
				"Ancho: " + String.format("%.2f", secondValue[2]) + "<br>" + "</body></html>";
	}
	
	public String getDatasThirdButton() {
		return "Distancia: " + String.format("%.2f", thirdValue[0]) + "     " +
				"Pendiente: " + String.format("%.2f", thirdValue[1]) + "    " +
				"Ancho: " + String.format("%.2f", thirdValue[2]);
	}
	
	public Double[] getFirstValue() {
		return firstValue;
	}

	public Double[] getSecondValue() {
		return secondValue;
	}

	public Double[] getThirdValue() {
		return thirdValue;
	}
	
	public Double[] getDistance() {
		return new Double[] {firstValue[0], secondValue[0], thirdValue[0]};
	}
}