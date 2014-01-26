package com.conftrackmgmnt.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfTrackMgmntUtil.
 */
public class ConfTrackMgmntUtil {
	
	/**
	 * Read file.
	 *
	 * @param filePath the file path
	 * @return the list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static List<String> readFile(String filePath) throws IOException {
		List<String> result=new ArrayList<String>();
	    BufferedReader br = new BufferedReader(new FileReader(filePath));
	    try {
	        String line = br.readLine();

	        while (line != null) {
	        	if(line.trim().length()>0){//Load only those lines which are not empty
	        		 result.add(line);
	        	}
	            line = br.readLine();
	        }
	        return result;
	    } finally {
	        br.close();
	    }
	}
	
	/**
	 * Gets the integer from string.
	 *
	 * @param input the input
	 * @return the integer from string
	 */
	public static Integer getIntegerFromString(String input){
		Scanner in = new Scanner(input).useDelimiter("[^0-9]+");
		if(in.hasNextInt()){
			return in.nextInt();
		}
		return null;
	}

}
