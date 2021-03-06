package codeanalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import codeanalyzer.SourceCodeAnalyzer;

import static org.junit.Assert.*;

public class SourceCodeAnalyzerTest {
	private final static String TYPE_REGEX = "regex";
	private final static String TYPE_STRCOMP = "strcomp";
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	private SourceCodeAnalyzer analyzer;
	private SourceFileReaderFactory fileObj = new SourceFileReaderFactory();
	private SourceFileReader reader = fileObj.createReader("local");

	
	@Test
	public void testCalculateRegexLOC() throws IOException {
		analyzer = new RegexAnalyzer();
		assertEquals(21, analyzer.calculateLOC(TEST_CLASS, TYPE_REGEX, reader));
	}
	
	@Test
	public void testCalculateStrCompLOC() throws IOException {
		analyzer = new StrcompAnalyzer();
		assertEquals(7, analyzer.calculateLOC(TEST_CLASS, TYPE_STRCOMP, reader));
	}
	
	@Test
	public void testCalculateRegexNOM() throws IOException {
		analyzer = new RegexAnalyzer();
		assertEquals(3, analyzer.calculateNOM(TEST_CLASS, TYPE_REGEX, reader));
	}
	
	@Test
	public void testCalculateStrCompNOM() throws IOException {
		analyzer = new StrcompAnalyzer();
		assertEquals(3, analyzer.calculateNOM(TEST_CLASS, TYPE_STRCOMP, reader));
	}
	
	@Test
	public void testCalculateRegexNOC() throws IOException {
		analyzer = new RegexAnalyzer();
		assertEquals(3, analyzer.calculateNOC(TEST_CLASS, TYPE_REGEX, reader));
	}
	
	@Test
	public void testCalculateStrCompNOC() throws IOException {
		analyzer = new StrcompAnalyzer();
		assertEquals(3, analyzer.calculateNOC(TEST_CLASS, TYPE_STRCOMP, reader));
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@Test
	public void testCalculatenNullLOC() throws IOException {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Unknown type");
		analyzer = new NullAnalyzer();
		assertEquals(0, analyzer.calculateLOC(TEST_CLASS, "FDASF", reader));
	}
	
	@Test
	public void testCalculateNullNOM() throws IOException {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Unknown type");
		analyzer = new NullAnalyzer();
		assertEquals(0, analyzer.calculateNOM(TEST_CLASS, "asdas", reader));
	}
	
	@Test
	public void testCalculateNullNOC() throws IOException {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Unknown type");
		analyzer = new NullAnalyzer();
		assertEquals(0, analyzer.calculateNOC(TEST_CLASS, "asdas", reader));
	}
	
}
