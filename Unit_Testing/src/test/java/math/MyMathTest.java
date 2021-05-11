package math;

import org.junit.Test;

/**
 * An class that provides test cases for the 
 * factorial operations of the MyMath 
 * class, for demonstrating Unit Testing.
 * @author DimitrisMazarakis (dimitrismazarakis77@gmail.com)
 */
public class MyMathTest {
	MyMath mym = new MyMath();
	
	/*
	 * A unit test that checks a non valid negative input
	 */
	 @Test (expected = IllegalArgumentException.class)
    public void testFactorialWhenInputIsNegative() {
    	 mym.factorial(-1);
    }
    
	/*
	* A unit test that checks a non valid zero input
	*/
	@Test 
	public void testFactorialWhenInputIsZero() {
		mym.factorial(0);
	}	
	
	/*
	* A unit test that checks a non valid 12 input
	*/
	@Test 
	public void testFactorialWhenInputIsTwelve() {
		mym.factorial(12);
	}
	
	/*
	* A unit test that checks a non valid >12 input
	*/
	@Test (expected = IllegalArgumentException.class)
	public void testFactorialWhenInputIsMoreThanTwelve() {
		mym.factorial(13);
	}
	

	/*
	 * A unit test that checks a non valid negative input
	 */
	 @Test (expected = IllegalArgumentException.class)
    public void testIsPrimeWhenInputIsNegative() {
    	 mym.isPrime(-1);
    }
    
	/*
	* A unit test that checks a non valid zero input
	*/
	@Test (expected = IllegalArgumentException.class)
	public void testIsPrimeWhenInputIsZero() {
		mym.isPrime(0);
	}	
	
	/*
	* A unit test that checks a border valid 2 input
	*/
	@Test 
	public void testIsPrimeWhenInputIsTwo() {
		mym.isPrime(2);
	}
	
	/*
	* A unit test that checks a high input
	*/
	@Test 
	public void testIsPrimeWhenInputIsHigh() {
		mym.isPrime(540);
	}
	
	/*
	* A unit test that checks a normal input
	*/
	@Test 
	public void testIsPrimeWhenInputIsNormal() {
		mym.isPrime(13);
	}
	
	/*
	* A unit test that checks a input that is divided by three 
	*/
	@Test 
	public void testIsPrimeWhenInputIsDividedBy3() {
		mym.isPrime(15);
	}
	
}


