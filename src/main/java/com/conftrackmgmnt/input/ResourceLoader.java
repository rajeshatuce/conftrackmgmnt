package com.conftrackmgmnt.input;

// TODO: Auto-generated Javadoc
/**
 * The Class ResourceLoader.
 */
public class ResourceLoader {
	
	/**
	 * Retrieve file path.
	 *
	 * @param fileName the file name
	 * @return the string
	 */
	public String retrieveFilePath(String fileName){
		return this.getClass().getResource(fileName).getPath();
	}

}
