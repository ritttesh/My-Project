package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReporterDemo {
	@Test
	public void f() {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\pritesh.ranjan\\Documents\\TestNG\\MSEdgedriver\\msedgedriver.exe");
		Reporter.log("Setting system properties of edge browser");
		WebDriver driver = new EdgeDriver();
		Reporter.log("launching edge browser");
		driver.get("http://10.82.180.36/Common/Login.aspx");
		Reporter.log("Navigating to url");
		driver.manage().window().maximize();
		Reporter.log("maximizing the edge browser");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.log("setting implicit wait");
		driver.findElement(By.id("body_txtUserID")).sendKeys("donhere");
		Reporter.log("sending username to username textbox");
		driver.findElement(By.id("body_txtPassword")).sendKeys("don@123");
		Reporter.log("sending password to password textbox");
		driver.findElement(By.id("body_btnLogin")).click();
		Reporter.log("clicking on login button");
		Assert.assertEquals(driver.getCurrentUrl(), "http://10.82.180.36/Accounts/Customer/CustomerAccountHome.aspx");
		Reporter.log("test case passed: login successful");
		driver.quit();
		Reporter.log("closing the browser and also edgedriver.exe");
	}
}
