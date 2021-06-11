package codeanalyzer;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SourceCodeAnalyzerFactoryTest {

	private final static String TYPE_REGEX = "regex";
	private final static String TYPE_STRCOMP = "strcomp";
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	private SourceCodeAnalyzerFactory factory = new SourceCodeAnalyzerFactory();
	private SourceCodeAnalyzer analyzer;
	
	@Test
	public void testCreateAnalyzerRegex() throws IOException {
		analyzer = new RegexAnalyzer();
		assertTrue(analyzer.getClass().equals(factory.createAnalyzer(TEST_CLASS, TYPE_REGEX, "local").getClass()));
	}
	
	@Test
	public void testCreateAnalyzerStrComp() throws IOException {
		analyzer = new StrcompAnalyzer();
		assertTrue(analyzer.getClass().equals(factory.createAnalyzer(TEST_CLASS, TYPE_STRCOMP, "local").getClass()));
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@Test
	public void testCreateAnalyzerNull() throws IOException {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Unknown type :unkwown");
		analyzer = new NullAnalyzer();
		assertTrue(analyzer.getClass().equals(factory.createAnalyzer(TEST_CLASS, "unkwown", "local").getClass()));
	}
}
