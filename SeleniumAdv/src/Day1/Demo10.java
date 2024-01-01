package Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo10 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pritesh.ranjan\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://10.82.180.36/Common/Login.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void login() {
		driver.findElement(By.id("body_txtUserID")).sendKeys("donhere");
		driver.findElement(By.id("body_txtPassword")).sendKeys("don@123");
		driver.findElement(By.id("body_btnLogin")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://10.82.180.36/Accounts/Customer/CustomerAccountHome.aspx");
	}

	@Test(dependsOnMethods = "login")
	public void homePage() {
		driver.findElement(By.linkText("View Transactions")).click();
		Assert.assertEquals(driver.getCurrentUrl(),
				"http://10.82.180.36/Accounts/Customer/CustomerViewTransactions.aspx");
	}

	@Test(dependsOnMethods = "homePage")
	public void logout() {
		driver.findElement(By.id("lbLoginOut")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://10.82.180.36/Common/Login.aspx");
	}
}
