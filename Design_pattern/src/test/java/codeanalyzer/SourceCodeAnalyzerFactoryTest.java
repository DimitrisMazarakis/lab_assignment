package codeanalyzer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class SourceCodeAnalyzerFactoryTest {

	private final static String TYPE_REGEX = "regex";
	private final static String TYPE_STRCOMP = "strcomp";
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	private SourceCodeAnalyzerFactory analyzer = new SourceCodeAnalyzerFactory();
	private Map<String, Integer> metrics = new HashMap<>();
	
	@Test
	public void testCreateCalculationsRegex() throws IOException {
		metrics.put("loc",21);
		metrics.put("nom",3);
		metrics.put("noc",3);
		assertEquals(metrics,analyzer.createCalculations(TEST_CLASS, TYPE_REGEX, "local"));
	}
	
	@Test
	public void testCreateCalculationsStrComp() throws IOException {
		metrics.put("loc",7);
		metrics.put("nom",3);
		metrics.put("noc",3);
		assertEquals(metrics,analyzer.createCalculations(TEST_CLASS, TYPE_STRCOMP, "local"));
	}
}
