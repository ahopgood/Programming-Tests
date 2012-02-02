package com.rightmove;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Please read in the data contained within the file manipulate-data.txt
 * Manipulate the data to programmatically answer the following questions:
 * 
 * 1. How many people in the list are male? 
 * 2. In years what is the average age of the people in the list? 
 * 3. How many days older is Jeff Briton than Tom Soyer?
 * 
 * You may add comments to your code to tell us why you chose to do something a
 * particular way, but this is not required. You may create as many classes as
 * you like. You may delete any code in ManipulateDataApplication that you don't
 * want.
 * 
 * Please print your answers out to the screen by using the 'System.out.print'
 * function. Good Luck!
 */

public class ManipulateDataApplication {
	
	//Keeping to a generic list interface for interoperability 
	private static List<Person> people = new LinkedList<Person>();
	
	public static void main(String[] args) throws IOException {
		File file = new File("manipulate-data.txt");
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
				ageDifferenceInDays("Jeff Briton","Tom Soyer"));
		} catch (InvalidPersonException ipe){
			System.err.println("Failed to answer question 3)");
			ipe.printStackTrace();
		}
		
	}

	private static void helpfulMethodFeelFreeToDeleteOrUseElsewhere(String line) {
		//each line (apart from the first representing the header) is a person's details
		
		String[] columns = line.split(",");
		//Each line should contain four fields if not the person is of no interest.
		//Throw an exception
		String fullName 	= columns[0].trim();
		String sex 			= columns[1].trim();
		String age 			= columns[2].trim();
		String dob 			= columns[3].trim();
		
		//Choosing not to remove duplicates since it is entirely possible for two John Smiths
		//to be born on the same day.
		try {
			Person person = new Person(fullName, sex, age, dob);
			people.add(person);
			//choosing not to throw the exception any higher, would rather try to parse as much of the data as possible.
		} catch (InvalidPersonException ipe){
			System.err.println("We had a problem parsing the data for the following person: " + 
								"[fullName="+fullName+"], [sex="+sex+"], [age="+age+"], [dob="+dob+"]");
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
	
	private static long ageDifferenceInDays(String name1 , String name2) 
			throws InvalidPersonException {
		Person person1 = null;
		Person person2 = null;
		for (Person person : people){
			String name = person.getFullName();
			if (name.equalsIgnoreCase(name1)){
				person1 = person;
			} else if (name.equalsIgnoreCase(name2)){
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
			throw new InvalidPersonException("Could not find the people with names:["+name1+"] and ["+name2+"]");
		}

	}
}