package com.conftrackmgmnt.input;

public class ClasspathResourceLoader implements ResourceLoader{
	
	public String retrieveFilePath(String fileName){
		return this.getClass().getResource(fileName).getPath();
	}


}
