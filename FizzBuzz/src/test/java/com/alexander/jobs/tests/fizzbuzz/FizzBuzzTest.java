package com.alexander.jobs.tests.fizzbuzz;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Alexander Hopgood
 *
 */
public class FizzBuzzTest {

	public FizzBuzz fb;
	
	@Before
	public void setUp() throws Exception {
		fb = new FizzBuzz();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetStringValueMultipleOfThree() {
		int value = 3;
		String expected = FizzBuzz.FIZZ;
		String actual 	= fb.getStringValue(value); 
		assertEquals(expected,actual);
	}

	@Test
	public void testGetStringValueMultipleOfFive() {
		int value = 5;
		String expected = FizzBuzz.BUZZ;
		String actual 	= fb.getStringValue(value); 
		assertEquals(expected,actual);
	}
	
	@Test
	public void testGetStringValueMultipleOfThreeAndFive() {
		int value = 15;
		String expected = FizzBuzz.FIZZBUZZ;
		String actual 	= fb.getStringValue(value); 
		assertEquals(expected,actual);
	}
	
	@Test
	public void testGetStringValueNoMultiples() {
		FizzBuzz fb = new FizzBuzz();
		int value = 1;
		String expected = "1";
		String actual 	= fb.getStringValue(value); 
		assertEquals(expected,actual);
	}
	
}
