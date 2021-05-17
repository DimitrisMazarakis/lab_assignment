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
     * @exception IllegalArgumentException when input is <0 or >12
     */
    public int factorial(int n) {
        if (n < 0 || n > 12) {
            throw new IllegalArgumentException("Input should be >0 and <12");
        }
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }


    /**
     * Check if the input number is prime.
     * @param an int number of the operation
     * @return false if the number is not a prime true otherwise
     * @exception IllegalArgumentException when input is <2
     */
    public boolean isPrime(int n) {
        if (n < 2) {
            throw new IllegalArgumentException("Input should be >= 2");
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}