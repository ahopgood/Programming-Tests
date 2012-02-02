package com.rightmove.test2;


public class Person extends Animal {
	
	public Person(String id, String firstname, String surname, String sex, String age, String dob)
		throws InvalidPersonException {
		super(id, Type.Human, firstname, surname, sex, age, dob);
	}
	
	@Override
	public String toString(){
		
		return "firstname=" + this.getFirstname() +
				", lastname=" + this.getSurname() +
				", sex=" + this.getSex().toString() +
				", age=" + this.getAge() + 
				", dob="  + this.getDob(); 
	}
}
