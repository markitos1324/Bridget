package models.entities;

import java.util.ArrayList;

public class DensityDataPeriod {

	private ArrayList<Integer> numbers;
	private String hour;
	
	public DensityDataPeriod(ArrayList<Integer> numbers, String hour) {
		this.numbers = numbers;
		this.hour = hour;
	}
	
	public ArrayList<Integer> getNumbers() {
		return numbers;
	}
	
	public String getHour() {
		return hour;
	}
}