package com.hp.cmcc.bboss.autotesting.common;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


/**   
*    
* @author 
* @version    
*    
*/
public class ConfigReader 
{
	/**
	 * 
	 * @param configFilePath
	 * @param key
	 * @return
	 */
	public static String GetValue(String configFilePath,String key)
	{
		InputStream stream;
		String value="";
		try
		{
			stream = new FileInputStream(configFilePath);
			Properties logConifgProperties=new Properties();
			logConifgProperties.load(stream);
			value=logConifgProperties.getProperty(key);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return value;
	}

}
