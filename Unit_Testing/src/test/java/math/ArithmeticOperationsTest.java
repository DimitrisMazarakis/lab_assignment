package math;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * A test class that implements a Parameterized test
 * for the ArithmeticOperations class, 
 * for demonstrating Unit Testing.
 * @author 
 */
public class ArithmeticOperationsTest {
	
	/* 
	 * A reference to the ArithmeticOperations class
	 * whose methods we are testing in this class
	 */
	ArithmeticOperations arith ;
	
	/*
	 * This is a constructor which is called 
	 * when the ArithmeticOperationsTest class is initialized
	 */
	public ArithmeticOperationsTest() {
		this.arith = new ArithmeticOperations();
	}
	
	/*
	 * A test case that examines the divide method
	 * with normal input values. 
	 */
	@Test
	public void testDivideNormal() {
		Assert.assertEquals(2, arith.divide(4, 2),2);
	}
	
	/*
	 * A test case that examines the divide method
	 * with zeros input values. 
	 */
	@Test
	public void testDivideReturnZero() {
		Assert.assertEquals(0, arith.divide(0, 2),2);
	}
	
	/*
	 * A test case for the exceptions caused when
	 * the result of the addition doesn't fit 
	 * in an Integer variable.
	 */
	@Test 
	public void testDivideShouldThrowExceptionOverflow() {
		arith.divide(Integer.MAX_VALUE, 1 );
	}
	
	/*
	 * A test case for the exceptions caused when
	 * the denominator value is zero. Testing
	 * the exception is performed with a @Rule
	 */
	
	@Test (expected = ArithmeticException.class)
	public void testDivideShouldThrowExceptionOnZeroDenominator() {
		try {
			arith.divide(5, 0);
		} catch (ArithmeticException e) {
		    throw new ArithmeticException("Division by 0");
		}
	}
	
	/*
	 * A test case that examines the multiply method
	 * with normal input values. 
	 */
	@Test
	public void testMultiplyNormal() {
		Assert.assertEquals(4, arith.multiply(2, 2));
	}
	
	/*
	 * A test case that examines the divide method
	 * with zeros input values. 
	 */
	@Test
	public void testMultiplyReturnZero() {
		Assert.assertEquals(0, arith.multiply(0, 2));
	}
	
	/*
	 * A test case for the exceptions caused when
	 * the result of the addition doesn't fit 
	 * in an Integer variable.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testMultiplyShouldThrowExceptionOverflow() {
		arith.multiply(2, Integer.MAX_VALUE);
	}
	
	/*
	 * A test case for the exceptions caused when
	 * one or more input values are negative. Testing
	 * the exception is performed with a @Rule
	 */
	@Rule
	public ExpectedException throwns = ExpectedException.none(); //initialize it to .none()
	@Test 
	public void testMultiplyShouldThrowExceptionOnNegativeInput() {
		throwns.expect(IllegalArgumentException.class);
		throwns.expectMessage("Input numbers should be positive.");
		arith.multiply(-5, 1);
	}
}
