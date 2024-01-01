package POM;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogDemo {
	Logger log = Logger.getLogger("LogDemo.class");

	@Test
	public void f() {
		// BasicConfigurator.configure();
		// PropertyConfigurator.configure("log4j.properties");
		DOMConfigurator.configure("log4j.xml");
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\pritesh.ranjan\\Documents\\TestNG\\MSEdgedriver\\msedgedriver.exe");
		log.info("Setting system property of edge browser");
		WebDriver driver = new EdgeDriver();
		log.info("Launching edge browser");
		driver.get("http://10.82.180.36/Common/Login.aspx");
		log.info("Navigating to url");
		driver.manage().window().maximize();
		log.info("Maximizing the browser");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Setting implicit wait");
		driver.findElement(By.id("body_txtUserID")).sendKeys("donhere");
		log.info("Passing username to username textbox");
		driver.findElement(By.id("body_txtPassword")).sendKeys("don@123");
		log.info("Passing password to password textbox");
		driver.findElement(By.id("body_btnLogin")).click();
		log.info("clicking on login button");
		if (driver.getCurrentUrl().equals("http://10.82.180.36/Accounts/Customer/CustomerAccountHome.aspx")) {
			log.info("test passed: login successful");
		} else {
			log.error("test failed: login credentials not valid");
		}
		Assert.assertEquals(driver.getCurrentUrl(), "http://10.82.180.36/Accounts/Customer/CustomerAccountHome.aspx");
		driver.quit();
	}
}
