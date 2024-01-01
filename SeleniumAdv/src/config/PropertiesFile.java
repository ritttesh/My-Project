package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {
	static Properties prop=new Properties(); 
	public static void main(String[] args) throws Exception {
		readPropertiesFile();
		writePropertiesFile();
		readPropertiesFile();
	}
	public static void readPropertiesFile() throws Exception {
		//get data from properties file
		//Properties prop=new Properties();  //step 1
		//step 2 : properties file address
		InputStream fin=new FileInputStream("C:\\Users\\pritesh.ranjan\\eclipse-workspace\\SeleniumAdv\\src\\config\\config.properties");
		prop.load(fin);    //step 3
		System.out.println(prop.getProperty("browser"));   //step 4
		
		
	}
	public static void writePropertiesFile() throws Exception {
		//set data in properties file
		
		OutputStream output=new FileOutputStream("C:\\Users\\pritesh.ranjan\\eclipse-workspace\\SeleniumAdv\\src\\config\\config.properties");
		//prop.setProperty("url","https://www.amazon.in");
		prop.setProperty("browser","firefox");
		prop.store(output, null);
		
		
		
	}
}
