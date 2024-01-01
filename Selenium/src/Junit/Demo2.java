package Junit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2 {
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//System.out.println("after all");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pritesh.ranjan\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://10.82.180.36/Common/Login.aspx");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		
	}

}
