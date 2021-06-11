package codeanalyzer;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MetricsExporterFactoryTest {

	private final static String TYPE_CSV = "csv";
	private final static String TYPE_JSON = "json";
	private MetricsExporterFactory factory = new MetricsExporterFactory();
	private MetricsExporter exporter;
	
	@Test
	public void testCreateWriterCsv() throws IOException {
		exporter = new CsvWriter();
		assertTrue(exporter.getClass().equals(factory.createwriter(TYPE_CSV).getClass()));
	}
	
	@Test
	public void testCreateWriterJson() throws IOException {
		exporter = new JsonWriter();
		assertTrue(exporter.getClass().equals(factory.createwriter(TYPE_JSON).getClass()));
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@Test
	public void testCreateWriterNull() throws IOException {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Unknown type : dasf");
		exporter = new NullWriter();
		assertTrue(exporter.getClass().equals(factory.createwriter("dasf").getClass()));
	}
}
