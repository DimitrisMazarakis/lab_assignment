package codeanalyzer;

import java.util.Map;

/**
 * Starts the operations by creating SourceCodeAnalyzerFactory 
 * and MetricsExporterFactory objects to call their functions. 
 * @author DimitrisMazarakis
 *
 */

public class Facade {

	public void operations(String[] args) {
		String filepath = "src/main/resources/TestClass.java";
		String sourceCodeAnalyzerType = "regex";
		String sourceFileLocation = "local";
		String outputFilePath = "output_metrics";
		String outputFileType = "csv";
		
		if(args.length == 5) {
			filepath = args[0];
			sourceCodeAnalyzerType = args[1];
			sourceFileLocation = args[2];
			outputFilePath = args[3];
			outputFileType = args[4];
		} else if (args.length != 0) {
			System.out.println("Incorrect number of arguments.");
			System.exit(1);
		}
		
		SourceCodeAnalyzerFactory analyzer =new SourceCodeAnalyzerFactory();

		Map<String, Integer> metrics = analyzer.createCalculations(filepath, sourceCodeAnalyzerType, sourceFileLocation);
		
		MetricsExporterFactory exporter = new MetricsExporterFactory();
		exporter.writeFile(outputFileType, metrics, outputFilePath);
	}
}
