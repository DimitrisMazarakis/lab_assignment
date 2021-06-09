package codeanalyzer;

import java.io.IOException;
import java.util.List;

public class SourceFileReaderFactory {
	
	private String type;
	private SourceFileReader reader;
		
	public SourceFileReaderFactory(String _type) {
		this.type = _type;
		if( type.equals("local")){
			this.reader = new readLocalFile();
		}else if (type.equals("web")) {
			this.reader = new readWebFile();
		}else {
			this.reader = new readNullFile();
		}
		
	}
	
	public String StringFileReader(String filepath) throws IOException{
		
		String result = reader.readFileIntoString(filepath);
		return result;
	}
	
	public List<String> StrFileReader(String filepath) throws IOException{
		
		List<String> result = reader.readFileIntoList(filepath);
		return result;
	}
}
