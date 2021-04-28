package math;

/**
* The MyMath provides a simple factorial operation
* that serve as hands-on practice on Unit Testing.
*
* @author  DimitrisMazarakis
* @version 1.0
* @since   2021-04-28
*/

public class MyMath {
	
	/**
	 * Performs the factorial operation to a number.
	 * @param an int number of the operation
	 * @param denominator the denominator of the operation
	 * @return the result of the factorial of the input
	 * @exception ArithmeticException when input is <0 or >12
	 */
	public int factorial(int n) {
		if (n < 0 || n > 12) {
			throw new IllegalArgumentException("Input should be >0 and <12");
		}
		int fact = 1;
		for(int i = 1; i <= n;i++) {
			fact = fact*i;
		}
		return fact;
	}
		
}
