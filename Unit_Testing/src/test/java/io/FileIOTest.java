package io;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class FileIOTest {
	
	FileIO fileio = new FileIO();
	public static String resourcesPath = "src/test/resources/";
	
	@Test
	public void testReadFileValidInput() {
		Integer[] expectedNumbers = new Integer[] {
				4,6,16,12,1007,
				13131,0,-1};
		String validInputFilepath = resourcesPath.concat("numbers_valid.txt");
		
		Assert.assertEquals(expectedNumbers, fileio.readFile(validInputFilepath));
	}
	
	@Rule
	public ExpectedException throwns = ExpectedException.none(); //initialize it to .none()
	@Test
	public void testReadFileNoFileFoundException() {
		throwns.expect(IllegalArgumentException.class);
		throwns.expectMessage("Input file does not exist");
		
		String validInputFilepath = resourcesPath.concat("numbers_validpppp.txt");
		
		fileio.readFile(validInputFilepath);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none(); //initialize it to .none()
	@Test
	public void testReadFileEmptyFileException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file is empty");
		
		String validInputFilepath = resourcesPath.concat("numbers_valid_empty.txt");
		
		fileio.readFile(validInputFilepath);
	}
	
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