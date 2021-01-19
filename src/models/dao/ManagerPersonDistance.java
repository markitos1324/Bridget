package models.dao;

import java.util.ArrayList;

import models.entities.Person;

public class ManagerPersonDistance {

	private ArrayList<Person> personList;
	private Person person;
	
	public ManagerPersonDistance() {
		personList = new ArrayList<>();
		person = new Person();
		
	}
	
	public void addPersonToList(String type, String sex, String luggage) {
		personList.add(person);
		person = new Person(type, sex, luggage);
	}
	
	public void addPersonInterval(String interval) {
		person.addIntervalTime(interval);
	}
	
	public void addIntervalSpeed(Double time, Double double1) {
		person.addIntervalSpeed(time, double1);
	}
	
	public void addTypePerson(String typePerson) {
		person.setTypePerson(typePerson);
	}
	
	public void addSex(String sex) {
		person.setSex(sex);
	}
	
	public void addLuggage(String luggage) {
		person.setLuggage(luggage);
	}

	public ArrayList<Person> getListPersons() {
		return personList;
	}

	public void calculateSpeedTotal(Double[] distances, String time) {
		person.calculateTotalSpeed(distances, time);
	}

	public ArrayList<Double> getListTime() {
		return person.getIntervalsTime();
	}

	public void addHour(String time) {
		person.setHour(time);
	}
}