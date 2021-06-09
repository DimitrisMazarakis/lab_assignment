package codeanalyzer;

import java.util.HashMap;
import java.util.Map;

public class SourceCodeAnalyzerFactory {
	
	private SourceCodeAnalyzer analyzer;

	public Map<String, Integer> createCalculations( String filepath, String sourceCodeAnalyzerType, String sourceFileLocation) {
		SourceFileReaderFactory fileObj = new SourceFileReaderFactory(sourceFileLocation);
		int loc;
		int nom;
		int noc;
		try {
			if( sourceCodeAnalyzerType.equals("regex") ) {
				analyzer = new RegexAnalyzer();
			}else if( sourceCodeAnalyzerType.equals("strcomp") ){
				analyzer = new StrcompAnalyzer();
			} else {
				analyzer = new NullAnalyzer();
				System.err.println("Operation aborted due to unknown Source type");
			}
			loc = analyzer.calculateLOC(filepath, sourceCodeAnalyzerType, fileObj);
			nom = analyzer.calculateNOM(filepath, sourceCodeAnalyzerType, fileObj);
			noc = analyzer.calculateNOC(filepath, sourceCodeAnalyzerType, fileObj);
			
			Map<String, Integer> metrics = new HashMap<>();
			metrics.put("loc",loc);
			metrics.put("nom",nom);
			metrics.put("noc",noc);
			return metrics;
		}catch(Exception e) {
			return null;
		}
	}
}
