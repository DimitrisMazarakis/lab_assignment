package codeanalyzer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import codeanalyzer.MetricsExporter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doCallRealMethod;

public class MetricsExporterTest {
	
	@Test
	public void testWriteCsv() {
		// create the metrics content
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",30);
		metrics.put("nom",5);
		metrics.put("noc",2);
		
		MetricsExporter mex = new CsvWriter();
		// generate and write the output file
		String outputFilepath = "src/test/resources/output_metrics";
		mex.write(metrics, outputFilepath);
		
		// evaluate that the file exists
		File outputFile = new File(outputFilepath + ".csv");
		Assert.assertTrue(outputFile.exists());
		
		// delete the generated file
		outputFile.delete();
	}
	
	@Test
	public void testWriteJson() {
		MetricsExporter mockedExporter = mock(JsonWriter.class);
		// create an empty metrics content
		Map<String, Integer> metrics = new HashMap<>();
		String outputFilepath = "whatever-path";
		
		//this is a demo of how a mocked object can call a real method (partial mocking)
		doCallRealMethod().when(mockedExporter).write( metrics, outputFilepath);
		mockedExporter.write(metrics, outputFilepath);
		//just verify that the method was executed/called
		verify(mockedExporter).write(metrics, outputFilepath);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@Test
	public void testtWriteNull() throws IOException {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Unknown type output type");
		MetricsExporter mockedExporter = mock(NullWriter.class);
		// create an empty metrics content
		Map<String, Integer> metrics = new HashMap<>();
		String outputFilepath = "whatever-path";
		//this is a demo of how a mocked object can call a real method (partial mocking)
		doCallRealMethod().when(mockedExporter).write( metrics, outputFilepath);
		mockedExporter.write(metrics, outputFilepath);
	}
}
