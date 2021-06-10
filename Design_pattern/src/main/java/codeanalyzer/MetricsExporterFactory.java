package codeanalyzer;

import java.util.Map;

/**
 * Creates MetricsExporter objects and calling their functions to write the file. 
 * @author DimitrisMazarakis
 *
 */
public class MetricsExporterFactory {
	
	public void writeFile(String outputType, Map<String, Integer> metrics, String filepath) {
		if (outputType.equals("csv")) {
			MetricsExporter writer = new CsvWriter();
			writer.write(metrics, filepath);
		} else if (outputType.equals("json")) {
			MetricsExporter writer = new JsonWriter();
			writer.write(metrics, filepath);
		} else {
			MetricsExporter writer = new NullWriter();
			writer.write(metrics, filepath);
			//throw new IllegalArgumentException("Unknown type : " + outputType);
		}
	}
}
