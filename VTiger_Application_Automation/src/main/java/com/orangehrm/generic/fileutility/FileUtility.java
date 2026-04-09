package com.orangehrm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String getDataFromPropertiesFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./ConfiguarationData/CommonData.Properties");
		Properties pro=new Properties();
		pro.load(fis);
		String key1=pro.getProperty(key);
		return key1;
	}
}
