package com.spotify.utility;

import java.io.File;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class ConfigReader 
{

	public static String readConfig(String key) throws IOException
	{
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		
		Properties prop = new Properties();
		prop.load(fis);
		
		String value = prop.getProperty(key);
		System.out.println(value);
		
		return value;
		
	}
}
