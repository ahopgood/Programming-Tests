package com.rightmove.test2;

public class Pet extends Animal {

	private int owner;
	
	public Pet (String id, String firstname, String surname, String sex, String age, String dob, String owner)
		throws InvalidPersonException{
		super(id, Type.Pet, firstname, surname, sex, age, dob);
		try{
			this.owner = Integer.parseInt(owner);
		} catch (NumberFormatException nfe){
			throw new InvalidPersonException("", nfe);
		}
	}
	
	public int getOwner(){
		return this.owner;
	}
}
