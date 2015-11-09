package com.alexander.jobs.tests.fizzbuzz;

public class RecursiveFizzBuzz implements FizzBuzz {

	@Override
	public StringBuilder start() {
		return start(new StringBuilder(), 1);
	}
	
	public StringBuilder start(StringBuilder builder, int count){
		if (count > 100){
			return builder;
		}
		String value = "";
		if (count % 3 == 0){
			value += IterativeFizzBuzz.FIZZ;
		}
		if (count % 5 == 0){
			value +=IterativeFizzBuzz.BUZZ;
		}
		if (value.isEmpty()){
			value += count;
		}
		builder.append(value + IterativeFizzBuzz.NEWLINE);
		return start(builder, ++count);
	}

}
