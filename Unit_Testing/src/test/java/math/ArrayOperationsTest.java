package math;

import org.junit.Assert;
import org.junit.Test;
import io.FileIO;
import static org.mockito.Mockito.*;

/**
 * A test class that implements test
 * for the ArrayOperations class, 
 * for demonstrating Unit Testing.
 * @author DimitrisMazarakis
 */
public class ArrayOperationsTest {
	
	/* 
	 * A reference to the ArrayOperations class
	 * whose methods we are testing in this class
	 */
	ArrayOperations arop = new ArrayOperations();
	
	public static String resourcesPath = "src/test/resources/";
	
	/*
	 * A test case that examines if the FindPrimesInFile works correctly. 
	 */
	@Test
	public void testFindPrimesInFileMethod() {
	String validInputFilepath = resourcesPath.concat("testArrayOperations.txt");
	int[] expectedPrimes = new int[] {
			2,3,2,3,5};
	int[] expectedNumbers = new int[] {
			0,6,2,3,1,124,1246,2,-23,3,5};
	FileIO fileIo = mock(FileIO.class);
	MyMath myMath = mock(MyMath.class);
	when(fileIo.readFile(validInputFilepath)).thenReturn(expectedNumbers);
	//when(myMath.isPrime(0)).thenThrow(IllegalArgumentException.class);
	when(myMath.isPrime(6)).thenReturn(false);
	when(myMath.isPrime(2)).thenReturn(true);
	when(myMath.isPrime(3)).thenReturn(true);
	//when(myMath.isPrime(1)).thenThrow(IllegalArgumentException.class);
	when(myMath.isPrime(124)).thenReturn(false);
	when(myMath.isPrime(1246)).thenReturn(false);
	when(myMath.isPrime(2)).thenReturn(true);
	//when(myMath.isPrime(-23)).thenThrow(IllegalArgumentException.class);
	when(myMath.isPrime(3)).thenReturn(true);
	when(myMath.isPrime(5)).thenReturn(true);
	Assert.assertArrayEquals(expectedPrimes, arop.findPrimesInFile(fileIo, validInputFilepath, myMath));
	}
}

 