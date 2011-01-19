package org.abrantix.rockon.rockonnggl;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

public class RockOnFileUtils{
	
	/**
	 * Constructor
	 */
	RockOnFileUtils(){
		
	}
	
	/**
	 * sanitize the filename
	 * @param fileName
	 * @return
	 */
	static String validateFileName(String fileName){
		if(fileName == null)
			return null;
		
		/*
		fileName = fileName.replace('/', '_');
		fileName = fileName.replace('<', '_');
		fileName = fileName.replace('>', '_');
		fileName = fileName.replace(':', '_');
		fileName = fileName.replace('\'', '_');
		fileName = fileName.replace('?', '_');
		fileName = fileName.replace('"', '_');
		fileName = fileName.replace('|', '_');
		fileName = fileName.replace('(', '_');
		fileName = fileName.replace(')', '_');
		fileName = fileName.replace('[', '_');
		fileName = fileName.replace(']', '_');
		fileName = fileName.replaceAll("%", "");
		return fileName;
		*/
		
		try 
		{
			fileName = java.net.URLEncoder.encode(fileName, "ascii");
		}
		catch (Exception ex)
		{
			//do nothing - it's definitely not going to be an unsupported encoding.
		}
		return fileName;
	}
	
}