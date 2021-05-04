package io;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

/**
 * A test class that implements tests
 * for the FileIO class, 
 * for demonstrating Unit Testing.
 * @author DimitrisMazarakis
 */
public class FileIOTest {
	
	/* 
	 * A reference to the FileIO class
	 * whose methods we are testing in this class
	 */
	FileIO fileio = new FileIO();
	public static String resourcesPath = "src/test/resources/";
	
	/*
	 * A test case that examines if the readFile method reads a file correctly. 
	 */
	@Test
	public void testReadFileValidInput() {
		int[] expectedNumbers = new int[] {
				4,6,16,12,1007,
				13131,0,-1};
		String validInputFilepath = resourcesPath.concat("numbers_valid.txt");
		
		Assert.assertArrayEquals(expectedNumbers, fileio.readFile(validInputFilepath));
	}
	
	/*
	 * A test case that examines if the readFile method throws exception when the input file does not exist. 
	 */
	@Rule
	public ExpectedException throwns = ExpectedException.none(); //initialize it to .none()
	@Test
	public void testReadFileNoFileFoundException() {
		throwns.expect(IllegalArgumentException.class);
		throwns.expectMessage("Input file does not exist");
		
		String validInputFilepath = resourcesPath.concat("numbers_validpppp.txt");
		
		fileio.readFile(validInputFilepath);
	}
	
	/*
	 * A test case that examines if the readFile method  throws exception when the input file is empty. 
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
	@Test
	public void testReadFileEmptyFileException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file is empty");
		
		String validInputFilepath = resourcesPath.concat("numbers_valid_empty.txt");
		
		fileio.readFile(validInputFilepath);
	}
	
	/*
	 * A test case that examines if the readFile method  throws exception when the input file has not valid characters. 
	 */
	@Rule
	public ExpectedException thrownss = ExpectedException.none(); //initialize it to .none()
	@Test
	public void testReadFileContainsInvalidEntries() {
		thrownss.expect(IllegalArgumentException.class);
		thrownss.expectMessage("Given file has non valid characters");
		
		String validInputFilepath = resourcesPath.concat("numbers_non_valid.txt");
		
		fileio.readFile(validInputFilepath);
	}
	
}