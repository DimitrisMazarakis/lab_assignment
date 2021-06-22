package codeanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Retrieves (reads) the contents of a given file.
 * The file can be stored locally or exist on the web. 
 * @author DimitrisMazarakis
 *
 */
public interface SourceFileReader {
	
	public List<String> readFileIntoList(String filepath) throws IOException;
	public String readFileIntoString(String filepath) throws IOException;
	
}

/**
 * Retrieves (reads) the contents of a given file.
 * The file can be stored only locally.
 * @author DimitrisMazarakis
 *
 */
class ReadLocalFile implements SourceFileReader {
	
	/**
	 * Reads a file and returns its content in a List
	 * @param filepath the path of a file  
	 * @return a List that contains the contents of the file 
	 * or null
	 * @throws IOException
	 */
	@Override
	public List<String> readFileIntoList(String filepath) throws IOException {
		// read a locally stored file
		List<String> lines = new ArrayList<>();
		File file = new File(filepath);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}
		reader.close();
		return lines;
	}
	
	/**
	 * Reads a file and returns its content in a String
	 * @param filepath the path of a file  
	 * @return a String that contains the contents of the file 
	 * or null
	 * @throws IOException
	 */
	@Override
	public String readFileIntoString(String filepath) throws IOException {
		// read a locally stored file
		StringBuilder sb = new StringBuilder();
		File file = new File(filepath);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		reader.close();
		return sb.toString();
	}

}

/**
 * Retrieves (reads) the contents of a given file.
 * The file can be stored only on web.
 * @author DimitrisMazarakis
 *
 */
class ReadWebFile implements SourceFileReader {
	
	/**
	 * Reads a file and returns its content in a List
	 * @param filepath the url of the file
	 * @return a List that contains the contents of the file 
	 * or null
	 * @throws IOException
	 */
	@Override
	public List<String> readFileIntoList(String filepath) throws IOException {
		List<String> lines = new ArrayList<>();
        URL url = new URL(filepath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
        	lines.add(line);
        }
        reader.close();
		return lines;
	}
	
	/**
	 * Reads a file and returns its content in a String
	 * @param filepath the url of the file
	 * @return a String that contains the contents of the file 
	 * or null
	 * @throws IOException
	 */
	@Override
	public String readFileIntoString(String filepath) throws IOException {
		StringBuilder sb = new StringBuilder();
        URL url = new URL(filepath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
        	sb.append(line + "\n");
        }
        reader.close();
		return sb.toString();
	}

}

/**
 * Retrieves (reads) the contents of a given file.
 * The file is stored in unknown place.
 * @author DimitrisMazarakis
 *
 */
class ReadNullFile implements SourceFileReader {
	
	/**
	 * Reads a file and returns an empty List
	 * @param filepath the unknown path of a file  
	 * @return a null List
	 * @throws IOException
	 */
	@Override
	public List<String> readFileIntoList(String filepath) throws IOException {
		throw new IllegalArgumentException("Unknown type" );
	}
	
	/**
	 * Reads a file and returns an empty String
	 * @param filepath the unknown path of a file  
	 * @return a empty String
	 * @throws IOException
	 */
	@Override
	public String readFileIntoString(String filepath) throws IOException {
		throw new IllegalArgumentException("Unknown type" );
	}

}
