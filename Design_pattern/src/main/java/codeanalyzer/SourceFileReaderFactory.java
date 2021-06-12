package codeanalyzer;

import java.io.IOException;
import java.util.List;

/**
 * Creates SourceFileReader objects and calling their functions to read a file. 
 * @author DimitrisMazarakis
 *
 */
public class SourceFileReaderFactory {
	
	public SourceFileReader createReader(String type) {
		SourceFileReader reader;
		if( type.equals("local")){
			reader = new ReadLocalFile();
		}else if (type.equals("web")) {
			reader = new ReadWebFile();
		}else {
			reader = new ReadNullFile();
			System.err.println("Operation aborted due to unknown source location type");
			//throw new IllegalArgumentException("Unknown type :" + type );
		}
		return reader;
	}
}
	
