package math;

import java.util.ArrayList;
import java.util.List;

import io.FileIO;

public class ArrayOperations {
	
	/**
	 * Take as an input a filepath whick contains numbers and return an array with prime numbers of the file.
	 * @param an FileIo object
	 * @param String filepath
	 * @param MyMath object
	 * @return the int array with the prime numbers
	 */
	public  int[] findPrimesInFile(FileIO fileIo,
			String filepath, MyMath myMath) {
 
		int arraySize = fileIo.readFile(filepath).length;

		List<Integer> numbersPrime = new ArrayList<>();
		int[] numbersArray=new int[arraySize];//initialize array with the length of the array from fileIo 
		
		for (int i = 0; i < numbersArray.length; i++) {
			if ( myMath.isPrime(numbersArray[i])) { //checks if the number is prime
				numbersPrime.add(numbersArray[i]); //adds the prime number to the return list
			}
		}
		return numbersPrime.stream().mapToInt(i -> i).toArray();//convert list to array
	}
}