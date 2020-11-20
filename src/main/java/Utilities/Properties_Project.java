package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Properties_Project{
	
	public static Properties prop = new Properties();	
	
	public static Properties returnPropsObject()
	{
	  InputStream input = null;  
	  	try {
	        input = new FileInputStream("config.properties");

	        // load a properties file
	        prop.load(input);
	        
	        // get the property value and print it out
	        //System.out.println(prop.getProperty("username"));
	  	} catch (IOException ex) {
               ex.printStackTrace();
	  	}
		return prop;
	  	
	} 	
	  	
	  	
}