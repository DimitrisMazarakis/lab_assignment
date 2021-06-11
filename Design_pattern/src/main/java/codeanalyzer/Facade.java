package codeanalyzer;

import java.util.HashMap;
import java.util.Map;

/**
 * Starts the operations by creating SourceCodeAnalyzerFactory 
 * and MetricsExporterFactory objects to call their functions. 
 * @author DimitrisMazarakis
 *
 */

public class Facade {

	public void operations(String filepath, String sourceCodeAnalyzerType, String sourceFileLocation, String outputFilePath, String outputFileType) {
		
		SourceCodeAnalyzerFactory factoryAnalyzer =new SourceCodeAnalyzerFactory();
		SourceCodeAnalyzer analyzer;
		SourceFileReaderFactory fileObj = new SourceFileReaderFactory();
		SourceFileReader reader = fileObj.createReader(sourceFileLocation);
		
		analyzer = factoryAnalyzer.createAnalyzer(filepath, sourceCodeAnalyzerType, sourceFileLocation);
		
		try {
			int loc = analyzer.calculateLOC(filepath, sourceCodeAnalyzerType, reader);
			int nom = analyzer.calculateNOM(filepath, sourceCodeAnalyzerType, reader);
			int noc = analyzer.calculateNOC(filepath, sourceCodeAnalyzerType, reader);
			
			Map<String, Integer> metrics = new HashMap<>();
			metrics.put("loc",loc);
			metrics.put("nom",nom);
			metrics.put("noc",noc);
			
			MetricsExporterFactory exporter = new MetricsExporterFactory();
			MetricsExporter writer = exporter.createwriter(outputFileType);
			writer.write(metrics, outputFilePath);
		}catch(Exception e) {
			
		}
	}
}
