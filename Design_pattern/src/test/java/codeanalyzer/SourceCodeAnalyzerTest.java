package codeanalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import codeanalyzer.SourceCodeAnalyzer;

import static org.junit.Assert.*;

public class SourceCodeAnalyzerTest {
	private final static String TYPE_REGEX = "regex";
	private final static String TYPE_STRCOMP = "strcomp";
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	private SourceCodeAnalyzer analyzer;
	private SourceFileReaderFactory fileObj = new SourceFileReaderFactory("local");
	
	@Test
	public void testCalculateRegexLOC() throws IOException {
		analyzer = new RegexAnalyzer();
		assertEquals(21, analyzer.calculateLOC(TEST_CLASS, TYPE_REGEX, fileObj));
	}
	
	@Test
	public void testCalculateStrCompLOC() throws IOException {
		analyzer = new StrcompAnalyzer();
		assertEquals(7, analyzer.calculateLOC(TEST_CLASS, TYPE_STRCOMP, fileObj));
	}
	
	@Test
	public void testCalculateRegexNOM() throws IOException {
		analyzer = new RegexAnalyzer();
		assertEquals(3, analyzer.calculateNOM(TEST_CLASS, TYPE_REGEX, fileObj));
	}
	
	@Test
	public void testCalculateStrCompNOM() throws IOException {
		analyzer = new StrcompAnalyzer();
		assertEquals(3, analyzer.calculateNOM(TEST_CLASS, TYPE_STRCOMP, fileObj));
	}
	
	@Test
	public void testCalculateRegexNOC() throws IOException {
		analyzer = new RegexAnalyzer();
		assertEquals(3, analyzer.calculateNOM(TEST_CLASS, TYPE_REGEX, fileObj));
	}
	
	@Test
	public void testCalculateStrCompNOC() throws IOException {
		analyzer = new StrcompAnalyzer();
		assertEquals(3, analyzer.calculateNOM(TEST_CLASS, TYPE_STRCOMP, fileObj));
	}
	
}
