package com.alexander.jobs.tests.fizzbuzz;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author Alexander Hopgood
 *
 */
public class FizzBuzzTest {

	public IterativeFizzBuzz fb;
	public RecursiveFizzBuzz rfb;
	public static StringBuilder builder = new StringBuilder();
	
	@BeforeClass
	public static void setUpBefore() throws Exception {	
		for (String value : BruteForceFizzBuzz.values){
			builder.append(value + IterativeFizzBuzz.NEWLINE);
		}
	}
	
	@Before
	public void setUp() throws Exception {
		fb = new IterativeFizzBuzz();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRecursiveFizzBizz_start(){
		rfb = new RecursiveFizzBuzz();
		assertEquals(builder.toString(), rfb.start().toString());
	}
	
	@Test
	public void testFizzBuzz_start(){
		assertEquals(builder.toString(), fb.start().toString());
	}
	
	@Test
	public void testFizzBuzz_GetStringValueMultipleOfThree() {
		int value = 3;
		String expected = IterativeFizzBuzz.FIZZ;
		String actual 	= fb.getStringValue(value); 
		assertEquals(expected,actual);
	}

	@Test
	public void testFizzBuzz_GetStringValueMultipleOfFive() {
		int value = 5;
		String expected = IterativeFizzBuzz.BUZZ;
		String actual 	= fb.getStringValue(value); 
		assertEquals(expected,actual);
	}
	
	@Test
	public void testFizzBuzz_GetStringValueMultipleOfThreeAndFive() {
		int value = 15;
		String expected = IterativeFizzBuzz.FIZZBUZZ;
		String actual 	= fb.getStringValue(value); 
		assertEquals(expected,actual);
	}
	
	@Test
	public void testFizzBuzz_GetStringValueNoMultiples() {
		IterativeFizzBuzz fb = new IterativeFizzBuzz();
		int value = 1;
		String expected = "1";
		String actual 	= fb.getStringValue(value); 
		assertEquals(expected,actual);
	}
	
}
