package com.alexander.jobs.tests.fizzbuzz;

/**
 * 
 * @author Alexander Hopgood
 *
 */
public class IterativeFizzBuzz implements FizzBuzz {
	
	protected static String FIZZ 		= "Fizz";
	protected static String BUZZ 		= "Buzz";
	protected static String FIZZBUZZ 	= "FizzBuzz";
	protected static String NEWLINE		= "\n";

	public static void main(String[] args) {
		System.out.println(new IterativeFizzBuzz().start());
	}

	public IterativeFizzBuzz(){

	}
	
	public StringBuilder start(){
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i <101; i++){
			builder.append(getStringValue(i) + NEWLINE);
		}
		return builder;
	}
	
	protected String getStringValue(int i){
		String output = "";
		if (i % 3 == 0){
			output += FIZZ;
		}
		if (i % 5 == 0){
			output += BUZZ;
		}
		if (output.isEmpty()){
			output = "" + i;
		}
		return output;
	}
}
