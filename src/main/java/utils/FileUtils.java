package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

/**
 * 
 * Holds all File related utility functions
 * 
 */

public class FileUtils {
	
	private FileUtils() {
	}
	
	/**
	 * Loads text file as string, seperating lines with '\n'
	 * @param file
	 * @return String
	 */
	public static String loadFileAsString(String filePath) {
		
		String result = "";
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String lineBuffer = "";
			
			while ((lineBuffer = reader.readLine()) != null) {
				result += lineBuffer + "\n";	
				
			}
			
			reader.close();
			
		} catch (IOException e){
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	

}
