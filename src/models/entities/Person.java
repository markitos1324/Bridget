package models.entities;

import java.util.ArrayList;

import controllers.ConstantUI;

public class Person {

	private ArrayList<Double> intervalsTime;
	private ArrayList<Double> intervalsSpeed;
	private String hour;
	private double speedTotal;
	private String typePerson;
	private String sex;
	private String luggage;
	
	public Person() {
		intervalsTime = new ArrayList<>();
		intervalsSpeed = new ArrayList<>();
		this.typePerson = ConstantUI.NAME_CHILD_LUGGAGE;
		this.sex = ConstantUI.NAME_SEX_MEN;
		this.luggage = ConstantUI.NAME_LUGGAGE;
	}
	
	public Person(String typePerson, String sex, String luggage) {
		intervalsTime = new ArrayList<>();
		intervalsSpeed = new ArrayList<>();
		this.typePerson = typePerson;
		this.sex = sex;
		this.luggage = luggage;
	}
	
	public void addIntervalSpeed(Double interval, Double double1) {
		intervalsSpeed.add(double1/interval);
	}
	
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	public String getHour() {
		return hour;
	}
	
	public void addIntervalTime(String interval) {
		if (intervalsTime.size() == 0) {
			intervalsTime.add(noCero(changeTime(interval)));
		}else if (intervalsTime.size() == 1) {
			intervalsTime.add(noCero(changeTime(interval) - intervalsTime.get(0)));
		}else if (intervalsTime.size() == 2) {
			intervalsTime.add(noCero(changeTime(interval) - intervalsTime.get(0) - intervalsTime.get(1)));
		}
	}
	
	private double noCero(double num) {
		if (num <= 0) {
			return 1;
		}else {
			return num;
		}
	}
	
	public String getTypePerson() {
		return typePerson;
	}

	public void calculateTotalSpeed(Double[] distances, String time) {
		double summ = 0;
		for (Double double1 : distances) {
			summ += double1;
		}
		this.speedTotal = summ/noCero(changeTime(time));
	}
	
	public void setTypePerson(String typePerson) {
		this.typePerson = typePerson;
	}

	public String getSex() {
		return sex;
	}
	
	public double getSpeedTotal() {
		return speedTotal;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLuggage() {
		return luggage;
	}

	public void setLuggage(String luggage) {
		this.luggage = luggage;
	}

	private double changeTime(String time) {
		String[] split = time.split(":");
		int totalSeconds = 0;
		String aux = "";
		char letter;
		int timeValue = 60;
		for (int i = 0; i < split.length-1; i++) {
			for (int j = 0; j < split[i].length(); j++) {
				letter = split[i].charAt(j);
				if (letter == ' ') {
					totalSeconds += Integer.parseInt(aux) * timeValue;
					timeValue = 1;
					aux = "";
					break;
				}
				aux += letter;
			}
		}
		return totalSeconds;
	}
	
	public ArrayList<Double> getIntervalsTime() {
		return intervalsTime;
	}

	public ArrayList<Double> getIntervalsSpeed() {
		return intervalsSpeed;
	}
	
	@Override
	public String toString() {
		return intervalsSpeed + "";
	}

	public double getSummTime() {
		double summ = 0;
		for (Double double1 : intervalsTime) {
			summ += double1;
		}
		return summ;
	}
	
	public Object[] toObjectVectorDistance() {
		return new Object[] {hour, typePerson, sex, luggage,
				intervalsTime.get(0), intervalsTime.get(1), intervalsTime.get(2), getSummTime(),
				intervalsSpeed.get(0), intervalsSpeed.get(1), intervalsSpeed.get(2), speedTotal};
	}
	
	public Object[] toObjectVectorVolumen() {
		return new Object[] {hour, typePerson, sex, luggage};
	}
	
	public Object[] toObjectVectorDensity() {
		return new Object[] {typePerson, sex, luggage,
				intervalsTime.get(0), intervalsTime.get(1), intervalsTime.get(2), getSummTime(),
				intervalsSpeed.get(0), intervalsSpeed.get(1), intervalsSpeed.get(2), speedTotal};
	}
}