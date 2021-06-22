package codeanalyzer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Exports (writes) the metrics to a given output. 
 * @author DimitrisMazarakis
 *
 */
public interface MetricsExporter {
	public void write(Map<String, Integer> metrics, String filepath);
}

/**
 * Exports (writes) the metrics to csv output. 
 * @author DimitrisMazarakis
 *
 */
class CsvWriter implements MetricsExporter {
	
	public void write(Map<String, Integer> metrics, String filepath) {
		File outputFile = new File(filepath + ".csv");
		StringBuilder metricsNames = new StringBuilder();
		StringBuilder metricsValues = new StringBuilder();
		
		for (Map.Entry<String, Integer> entry : metrics.entrySet()) {
			metricsNames.append(entry.getKey() + ",");
			metricsValues.append(entry.getValue()+",");
		}
		
		try {
			FileWriter writer = new FileWriter(outputFile);
			writer.append(metricsNames + "\n");
			writer.append(metricsValues + "\n");
			writer.close();
			System.out.println("Metrics saved in " + outputFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

/**
 * Exports (writes) the metrics to json output. 
 * @author DimitrisMazarakis
 *
 */
class JsonWriter implements MetricsExporter {
	
	public void write(Map<String, Integer> metrics, String filepath) {
		// Functionality not implemented yet
	}	
}

/**
 * Does not export the metrics due to unknown output. 
 * @author DimitrisMazarakis
 *
 */
class NullWriter implements MetricsExporter {
	@Override
	public void write(Map<String, Integer> metrics, String filepath) {
		throw new IllegalArgumentException("Unknown type output type");
	}
}