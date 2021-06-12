package codeanalyzer;

import java.util.HashMap;
import java.util.Map;

/**
 * Creates SourceCodeAnalyzer objects and calling their functions. And then maps the loc, nom, noc variables to the correct metrics.
 * @author DimitrisMazarakis
 *
 */
public class SourceCodeAnalyzerFactory {

	public SourceCodeAnalyzer createAnalyzer( String filepath, String sourceCodeAnalyzerType, String sourceFileLocation) {
		SourceCodeAnalyzer analyzer;

			if( sourceCodeAnalyzerType.equals("regex") ) {
				analyzer = new RegexAnalyzer();
			}else if( sourceCodeAnalyzerType.equals("strcomp") ){
				analyzer = new StrcompAnalyzer();
			} else {
				analyzer = new NullAnalyzer();
				System.err.println("Operation aborted due to unknown Source type");
				//throw new IllegalArgumentException("Unknown type :" + sourceCodeAnalyzerType );
			}
			return analyzer;
	}
}
