package com.alexander.jobs.tests.fizzbuzz;

/**
 * 
 * @author Alexander Hopgood
 *
 */
public class FizzBuzz {
	
	protected static String FIZZ 		= "Fizz";
	protected static String BUZZ 		= "Buzz";
	protected static String FIZZBUZZ 	= "FizzBuzz";

	public static void main(String[] args) {
		new FizzBuzz().start();
	}

	public FizzBuzz(){

	}
	
	protected void start(){
		for (int i = 1; i <101; i++){
			System.out.println(getStringValue(i));
		}		
	}
	
	protected String getStringValue(int i){
		if ((i % 3 == 0) && (i % 5 == 0)){
			return FIZZBUZZ;
		} else if (i % 3 == 0){
			return FIZZ;
		} else if (i % 5 == 0){
			return BUZZ;
		} else {
			return ""+i;
		}
	}
}
