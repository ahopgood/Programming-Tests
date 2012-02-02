package com.rightmove.test2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Animal{
	
	private int id;
	private Type type;
	private String firstname;
	private String surname;
	private Sex sex;
	private int age;
	private Date dob;
	
	public Animal(String id, Type type, String firstname, String surname, String sex, String age, String dob)
			throws InvalidPersonException {
		//perform validation here on our parameter strings
		this.type = type;
		try {
			this.id = Integer.parseInt(id);
		} catch (NumberFormatException nfe){
			throw new InvalidPersonException("Unexpected id [" + id + "]");
		}
		this.firstname 	= firstname;
		this.surname 	= surname;
		//Using an enum type here to limit having to perform string comparisons
		//every time we wish to check gender also I am assuming we can assume a 
		//fixed number of gender options.
		if (sex.equalsIgnoreCase("male")){
			this.sex = Sex.MALE;
		} else if (sex.equalsIgnoreCase("female")){
			this.sex = Sex.FEMALE;
		} else {
			throw new InvalidPersonException("Unexpected gender [" + sex + "]");
		}
		
		try {
			this.age = Integer.parseInt(age);
		} catch (NumberFormatException nfe){
			throw new InvalidPersonException("Invalid age ["+age+"]");
		}
		
		try {
			//specify the time zone so daylight savings aren't added.
			SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy Z");
			this.dob = date.parse(dob+" -0000");
		} catch (ParseException pe){
			throw new InvalidPersonException("Invalid dob [" + dob + "]", pe);
		}
	}
	
	public int getId() {
		return id;
	}
	
	public Type getType(){
		return type;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getSurname() {
		return surname;
	}

	public Sex getSex() {
		return sex;
	}

	public int getAge() {
		return age;
	}

	public Date getDob() {
		return dob;
	}
}
