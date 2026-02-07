package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		//open the FileInputStream to read contents
		FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");
		
		//create an object for Properties class
		Properties properties = new Properties();
		
		//load the properties file
		properties.load(fin);	
		
		//Reading data from the properties file
		String url = properties.getProperty("appurl");
		String username = properties.getProperty("username");
		System.out.println(url);
		System.out.println(username);
		
		//reading all keys from properties file
		//Set<String> keys = properties.stringPropertyNames();
		Set<Object> keys = properties.keySet();
		System.out.println(keys);
		
		//reading all values
		Collection<Object> values = properties.values();
		System.out.println(values);
		
		fin.close();
	}

}
