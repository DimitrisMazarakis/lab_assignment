package math;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


import org.junit.Assert;

/**
 * A test class that implements a Parameterized test
 * for the MyMath factorial method, 
 * for demonstrating Unit Testing.
 * @author DimitrsMazarakis (dimitrismazarakis77@gmail.com)
 */
@RunWith(Parameterized.class)
public class MyMathFactorialParameterizedTest {
	
	// the value is the id of each parameter
	@Parameter (value = 0) 
	public int input;
	@Parameter (value = 1)
	public int result;
//	@Parameter (value = 1) 
//	public int input2;
//	@Parameter (value = 1)
//	public int result2;
//	@Parameter (value = 2) 
//	public int input3;
//	@Parameter (value = 2)
//	public int result3;
//	@Parameter (value = 12) 
//	public int input4;
//	@Parameter (value = 479001600)
//	public int result4;

	MyMath mam = new MyMath();
	
	/*
	 * The following method generates the input values 
	 * for the tests. 
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{0,1},{1,1},{2,2},{12,479001600}};
		
		return Arrays.asList(data);
	}
	
	/*
	 * A unit test that is executed for each pair of 
	 * parameters. 
	 */
	@Test
	public void testPowerOfTwoWithNormalCases() {
		Assert.assertEquals(result, mam.factorial(input));
//		Assert.assertEquals(result2, mam.factorial(input2));
//		Assert.assertEquals(result3, mam.factorial(input3));
//		Assert.assertEquals(result4, mam.factorial(input4));
	}
	
}