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
			reader = new readLocalFile();
		}else if (type.equals("web")) {
			reader = new readWebFile();
		}else {
			reader = new readNullFile();
			throw new IllegalArgumentException("Unknown type :" + type );
		}
		return reader;
	}
}
	
