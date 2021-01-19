package models.dao;

import java.util.ArrayList;

import models.entities.Person;

public class ManagerPersonVolumen {

	private ArrayList<Person> personList;
	private Person person;
	
	public ManagerPersonVolumen() {
		personList = new ArrayList<>();
		person = new Person();
		
	}
	
	public void addPersonToList(String type, String sex, String luggage) {
		personList.add(person);
		person = new Person(type, sex, luggage);
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

	public void addHour(String time) {
		person.setHour(time);
	}
}