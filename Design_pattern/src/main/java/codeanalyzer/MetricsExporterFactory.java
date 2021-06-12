package codeanalyzer;

import java.util.Map;

/**
 * Creates MetricsExporter objects and calling their functions to write the file. 
 * @author DimitrisMazarakis
 *
 */
public class MetricsExporterFactory {
	
	public MetricsExporter createwriter(String outputType) {
		MetricsExporter writer;
		if (outputType.equals("csv")) {
			writer = new CsvWriter();
		} else if (outputType.equals("json")) {
			writer = new JsonWriter();
		} else {
		    writer = new NullWriter();
			System.err.println("Operation aborted due to unknown output format");
			//throw new IllegalArgumentException("Unknown type : " + outputType);
		}
		return writer;
	}
}
