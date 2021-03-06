package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Analyzes the contents of a Java source code file 
 * and calculates the following metrics: loc = lines of code,
 * nom = number of methods, and noc=number of classes. 
 * @author DimitrisMazarakis
 *
 */
public interface SourceCodeAnalyzer {

	public int calculateLOC(String filepath, String analyzerType, SourceFileReader fileReader) throws IOException;
	public int calculateNOM(String filepath, String analyzerType, SourceFileReader fileReader) throws IOException;
	public int calculateNOC(String filepath, String analyzerType, SourceFileReader fileReader) throws IOException;
}

/**
* The current class supports a type of source code analysis,
* namely regex (with the use of regular expressions)
*/
class RegexAnalyzer implements SourceCodeAnalyzer {
	@Override
	public int calculateLOC(String filepath, String analyzerType, SourceFileReader fileReader) throws IOException {
		String sourceCode = fileReader.readFileIntoString(filepath);
		Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
        Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);

        int nonCodeLinesCounter = 0;
        while (nonCodeLinesMatcher.find()) {
        	nonCodeLinesCounter++;
        }
		
        int sourceFileLength = sourceCode.split("\n").length;
        int loc =  sourceFileLength - nonCodeLinesCounter;
        
		return loc;
	}
	
	@Override
	public int calculateNOM(String filepath, String analyzerType, SourceFileReader fileReader) throws IOException {
		String sourceCode = fileReader.readFileIntoString(filepath);
		Pattern pattern = Pattern.compile(".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*"); 
        Matcher methodSignatures = pattern.matcher(sourceCode);

        int methodCounter = 0;
        while (methodSignatures.find()) {
        	methodCounter++;
        }
		return methodCounter;
	}
	
	@Override
	public int calculateNOC(String filepath, String analyzerType, SourceFileReader fileReader) throws IOException {
		String sourceCode = fileReader.readFileIntoString(filepath);
		Pattern pattern = Pattern.compile(".*\\s*class\\s+.*"); 
        Matcher classSignatures = pattern.matcher(sourceCode);

        int classCounter = 0;
        while (classSignatures.find()) {
        	classCounter++;
        }
		return classCounter;
	}	
}

/**
* The current class supports a type of source code analysis,
* namely strcomp (with the use of string comparison)
*/
class StrcompAnalyzer implements SourceCodeAnalyzer {
	@Override
	public int calculateLOC(String filepath, String analyzerType, SourceFileReader fileReader) throws IOException {
		List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
		int nonCodeLinesCounter = 0;
		for (String line : sourceCodeList) {
			line = line.trim(); //clear all leading and trailing white spaces
			if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}") || line.equals(""))
				nonCodeLinesCounter++;
		}
		int loc = sourceCodeList.size() - nonCodeLinesCounter;
		return loc; 
	}
	
	@Override
	public int calculateNOM(String filepath, String analyzerType, SourceFileReader fileReader) throws IOException {
		List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
		int methodCounter = 0;
		for (String line : sourceCodeList) {
			line = line.trim(); //clear all leading and trailing white spaces
			if ( ((line.contains("public") || line.contains("private") || line.contains("protected"))
					|| line.contains("void") || line.contains("int") || line.contains("String"))
				&& line.contains("(") && line.contains(")") && line.contains("{") )
				methodCounter++;
		}
		return methodCounter; 
	}
	
	@Override
	public int calculateNOC(String filepath, String analyzerType, SourceFileReader fileReader) throws IOException {
		List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
		int classCounter = 0;
		for (String line : sourceCodeList) {
			line = line.trim(); //remove leading and trailing white spaces
			if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
				classCounter++;
			}
		}
		return classCounter; 
	}	
}

/**
* The current class supports an unknown type of source code analysis
*/
class NullAnalyzer implements SourceCodeAnalyzer {
	public int calculateLOC(String filepath, String analyzerType, SourceFileReader fileReader) throws IOException {
		throw new IllegalArgumentException("Unknown type" );
	}
	public int calculateNOM(String filepath, String analyzerType, SourceFileReader fileReader) throws IOException{
		throw new IllegalArgumentException("Unknown type" );
	}
	public int calculateNOC(String filepath, String analyzerType, SourceFileReader fileReader) throws IOException{
		throw new IllegalArgumentException("Unknown type" );
	}
}
