package com.rightmove.test2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ManipulateDataApplication2 {
	//Keeping to a generic list interface for interoperability 
	private static List<Person> people = new LinkedList<Person>();
	
	//add a map for each pet keyed to the owner's id
	private static Map<String, LinkedList<Pet>> pets = new HashMap<String, LinkedList<Pet>>();
	
	public static void main(String[] args) throws IOException {
		File file = new File("manipulate-data2.txt");
		System.out.println(file.getName() + " file exists = " + file.exists());

		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String line;
		int lineNo = 0;
		while ((line = bufferedReader.readLine()) != null) {
			if (lineNo > 0){ //ignore the header line
				helpfulMethodFeelFreeToDeleteOrUseElsewhere(line);
			}
			lineNo++;
		}
		bufferedReader.close();
		
		System.out.println("How many males in the list? "+noOfMales());
		System.out.println("What is the average age of the people in the list? "+averageAge());
		try {
			System.out.println("How many days older is Jeff Briton than Tom Soyer? "+
				ageDifferenceInDays("Jeff","Briton","Tom","Soyer"));
		} catch (InvalidPersonException ipe){
			System.err.println("Failed to answer question 3)");
			ipe.printStackTrace();
		}
		System.out.println("How many people have pets? "+hasPets());
		System.out.println("How many pet does x have? "+ownsHowManyPets("Suzie","Long"));
		System.out.println("How many pet does x have? "+ownsHowManyPets("Tom","Soyer"));
		
	}

	private static void helpfulMethodFeelFreeToDeleteOrUseElsewhere(String line) {
		//each line (apart from the first representing the header) is a person's details
		
		String[] columns = line.split(",");
		//Each line should contain four fields if not the person is of no interest.
		//Throw an exception
		String id			= columns[0].trim();
		String typeStr		= columns[1].trim();
		String firstname 	= columns[2].trim();
		String surname		= columns[3].trim();
		String sex 			= columns[4].trim();
		String age 			= columns[5].trim();
		String dob 			= columns[6].trim();
		if (columns.length == 8 && typeStr.equalsIgnoreCase(Type.Pet.toString())){
			String owner		= columns[7].trim();
			//add pet to pets map keyed by owner id
			try {
				Pet pet = new Pet(id, firstname, surname, sex, age, dob, owner);
				LinkedList<Pet> petList = pets.get(owner+"");
				if (petList == null){
					petList = new LinkedList<Pet>();
					pets.put(owner+"",petList);
				}
				petList.add(pet);
			} catch (InvalidPersonException ipe){
				System.err.println("We had a problem parsing the data for the following person: " + 
						"[fullName="+firstname+"], [sex="+sex+"], [age="+age+"], [dob="+dob+"]");
			}
		} else {
			//Choosing not to remove duplicates since it is entirely possible for two John Smiths
			//to be born on the same day.
			try {
				Person person = new Person(id, firstname, surname, sex, age, dob);
				people.add(person);
				//choosing not to throw the exception any higher, would rather try to parse as much of the data as possible.
			} catch (InvalidPersonException ipe){
				System.err.println("We had a problem parsing the data for the following person: " + 
									"[fullName="+firstname+"], [sex="+sex+"], [age="+age+"], [dob="+dob+"]");
			}
		}		
	}
	
	private static int noOfMales(){
		int maleCount = 0;
		for (Person person : people){
			if (person.getSex() == Sex.MALE){
				maleCount++;
			}
		}
		return maleCount;
	}
	
	/**
	 * Gets the average age to the nearest year.
	 * @return
	 */
	private static int averageAge(){
		int cumulativeAge = 0;
		for (Person person : people){
			cumulativeAge = cumulativeAge + person.getAge();
		}
		//now take cumulative age and divide by the number of people
		int average = cumulativeAge / people.size();
		//using / ensures we get the average age to the nearest whole year
		return average;
	}
	
	private static long ageDifferenceInDays(String firstname1 , String surname1,
			String firstname2, String surname2) 
			throws InvalidPersonException {
		Person person1 = null;
		Person person2 = null;
		for (Person person : people){
			String firstname = person.getFirstname();
			String surname = person.getSurname();
			
			if (firstname.equalsIgnoreCase(firstname1) && surname.equalsIgnoreCase(surname1)){
				person1 = person;
			} else if (firstname.equalsIgnoreCase(firstname2) && surname.equalsIgnoreCase(surname2)){
				person2 = person;
			}
		}
		if (person1 != null && person2 != null){
			//find the difference in age in miliseconds between the two Person objects
			//what if p1 is younger than p2
			long p1 = person1.getDob().getTime();
			long p2 = person2.getDob().getTime();
			long ageDiff = p2-p1;
			//Useful enum from the concurrency package
			return TimeUnit.DAYS.convert(ageDiff, TimeUnit.MILLISECONDS);
		} else {
			throw new InvalidPersonException("Could not find the people with names:["+firstname1+" "+surname1+"] and ["+firstname2+" "+surname2+"]");
		}
	}
	
	private static int hasPets(){
		return pets.size();
	}
	
	private static int ownsHowManyPets(String firstname, String surname){
		boolean found = false;
		Iterator<Person> iter = people.iterator();
		int ownerId = -1;
		while (!found && iter.hasNext()){
			Person per = iter.next();
			if (per.getFirstname().equalsIgnoreCase(firstname) && 
					per.getSurname().equalsIgnoreCase(surname)){
				found = true;
				ownerId = per.getId();
			}
		}
		if (pets.get(ownerId+"") != null){
			return pets.get(ownerId+"").size();
		} else {
			return -1;
		}
	}
}
