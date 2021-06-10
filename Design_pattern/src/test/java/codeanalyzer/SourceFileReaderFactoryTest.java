package codeanalyzer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class SourceFileReaderFactoryTest {
	private static List<String> expectedList;
	private static String expectedString;
	private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
	private final static String TEST_CLASS_WEB ="https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
	private final static String TYPE_LOCAL = "local";
	private final static String TYPE_WEB = "web";
	private SourceFileReaderFactory reader;
	
	@BeforeClass
	public static void setUp() throws IOException {
		expectedList = Files.readAllLines(new File(TEST_CLASS_LOCAL).toPath(), Charset.defaultCharset());
		expectedString = String.join("\n", expectedList) + "\n"; // transforms a list into a String (with 'new line' as delimiter) 
	}
	
	@Test
	public void testStringFileReaderLocal() throws IOException {
		reader = new SourceFileReaderFactory(TYPE_LOCAL);
		assertEquals(expectedString, reader.StringFileReader(TEST_CLASS_LOCAL));
	}
	
	@Test
	public void testStrFileReaderLocal() throws IOException {
		reader = new SourceFileReaderFactory(TYPE_LOCAL);
		List<String> actualList = reader.StrFileReader(TEST_CLASS_LOCAL);
		
		String[] expecteds = expectedList.stream().toArray(String[]::new);
		String[] actuals = actualList.stream().toArray(String[]::new);
		
		assertArrayEquals(expecteds, actuals);

	}
	
	@Test
	public void testStringFileReaderWeb() throws IOException {
		reader = new SourceFileReaderFactory(TYPE_WEB);
		assertEquals(expectedString, reader.StringFileReader(TEST_CLASS_WEB));
	}
	
	@Test
	public void testStrFileReaderWeb() throws IOException {
		reader = new SourceFileReaderFactory(TYPE_WEB);
		List<String> actualList = reader.StrFileReader(TEST_CLASS_WEB);
		
		String[] expecteds = expectedList.stream().toArray(String[]::new);
		String[] actuals = actualList.stream().toArray(String[]::new);
		
		assertArrayEquals(expecteds, actuals);

	}
//	@Test
//	public void testCreateCalculationsStrComp() throws IOException {
//		assertEquals("{loc=21, noc=3, nom=3}", analyzer.createCalculations(TEST_CLASS, TYPE_STRCOMP, "local"));
//	}
}
