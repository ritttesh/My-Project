package Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo6 {
	WebDriver driver;

	@BeforeMethod
	@Parameters({ "browser", "url" })
	public void beforeMethod(String browser, String url) {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\pritesh.ranjan\\Documents\\Selenium Jars\\drivers\\chormedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "edge":
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\pritesh.ranjan\\Documents\\Selenium Jars\\drivers\\MSEdgeDriver\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void f() {
		driver.findElement(By.id("body_txtUserID")).sendKeys("donhere");
		driver.findElement(By.id("body_txtPassword")).sendKeys("don@123");
		driver.findElement(By.id("body_btnLogin")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://10.82.180.36/Accounts/Customer/CustomerAccountHome.aspx");
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	
}
