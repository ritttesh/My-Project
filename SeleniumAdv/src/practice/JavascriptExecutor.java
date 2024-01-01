package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavascriptExecutor {
	WebDriver driver;
	
	 @BeforeClass
	  public void beforeClass() throws IOException {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\pritesh.ranjan\\Documents\\Selenium Jars\\drivers\\chormedriver\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("https://www.google.com");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		  
	  }
  @Test
  public void f() {
	  driver.findElement(By.id("xxx"));
	  WebElement email = driver.findElement(By.id("useremail"));
//	  JavascriptExecutor jse = (JavascriptExecutor)driver;        	
//	  jse.executeScript("document.getElementById('email').value='Avinash Mishra';");

	  
	  
	  
  }
}
