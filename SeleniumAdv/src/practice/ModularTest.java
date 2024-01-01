package practice;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class ModularTest {
	static WebDriver driver;
	static String browser;
	static String url;
	public static void main(String[] args) throws Exception {
		getProperties();
		setUpBrowser(browser);
		openAUT(url);
		
		
	}
	public static void getProperties() throws Exception {
		Properties prop=new Properties();
		InputStream input=new FileInputStream("C:\\Users\\pritesh.ranjan\\eclipse-workspace\\SeleniumAdv\\src\\practice\\modularconfig.properties");
		prop.load(input);
		browser=prop.getProperty("browser");
		url=prop.getProperty("url");
	}
	public static void setUpBrowser(String browser) {
		switch(browser) {
		case "chrome" :
			System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pritesh.ranjan\\Documents\\Selenium Jars\\drivers\\chormedriver\\chromedriver.exe");
			driver=new ChromeDriver();
			break;
		case "edge" :
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\pritesh.ranjan\\Documents\\Selenium Jars\\drivers\\MSEdgedriver\\chromedriver.exe");
			driver=new EdgeDriver();		
			break;
		}
		
	}
	public static void openAUT(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.id("nav-logo-sprites")).isDisplayed(), "url is not open");
		System.out.println("url is launched");
	}
}
