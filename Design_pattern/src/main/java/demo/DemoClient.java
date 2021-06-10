package demo;

import java.io.IOException;

import codeanalyzer.*;

/**
 * Reads the args from command line and create facade object to start the operations. 
 * @author DimitrisMazarakis
 *
 */

public class DemoClient {
	
	public static void main(String[] args) throws IOException {

		Facade operate =new Facade();
		operate.operations(args);
	}

}
  