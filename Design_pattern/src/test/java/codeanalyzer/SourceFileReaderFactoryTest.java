package codeanalyzer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SourceFileReaderFactoryTest {
	private static List<String> expectedList;
	private static String expectedString;
	private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
	private final static String TEST_CLASS_WEB ="https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
	private final static String TYPE_LOCAL = "local";
	private final static String TYPE_WEB = "web";
	private SourceFileReaderFactory factory= new SourceFileReaderFactory();
	private SourceFileReader reader;
	
	@BeforeClass
	public static void setUp() throws IOException {
		expectedList = Files.readAllLines(new File(TEST_CLASS_LOCAL).toPath(), Charset.defaultCharset());
		expectedString = String.join("\n", expectedList) + "\n"; // transforms a list into a String (with 'new line' as delimiter) 
	}
	
	@Test
	public void testcreateReaderLocal() throws IOException {
		reader = new ReadLocalFile();
		assertTrue(reader.getClass().equals(factory.createReader(TYPE_LOCAL).getClass()));
	}
	
	@Test
	public void testcreateReaderWeb() throws IOException {
		reader = new ReadWebFile();
		assertTrue(reader.getClass().equals(factory.createReader(TYPE_WEB).getClass()));
	}
	
	@Test
	public void testcreateReaderNull() throws IOException {
		reader = new ReadNullFile();
		assertTrue(reader.getClass().equals(factory.createReader("sdfds").getClass()));
	}
}
