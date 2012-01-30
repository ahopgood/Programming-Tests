package com.rightmove;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Person {
	private String fullName;
	private Sex sex;
	private int age;
	private Date dob;
	
	public Person(String fullName, String sex, String age, String dob)
		throws InvalidPersonException {
		//perform validation here on our parameter strings
		this.fullName = fullName;
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

	public String getFullName() {
		return fullName;
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
	
	@Override
	public String toString(){
		
		return "fullname=" + this.getFullName() +
				", sex=" + this.getSex().toString() +
				", age=" + this.getAge() + 
				", dob="  + this.getDob(); 
	}
}
