package Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo5 {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pritesh.ranjan\\Documents\\Selenium Jars\\drivers\\chormedriver\\chromedriver.exe");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("http://10.82.180.36/Common/Login.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(dataProvider = "getData")
	public void f(String username, String password) {
		driver.findElement(By.id("body_txtUserID")).sendKeys(username);
		driver.findElement(By.id("body_txtPassword")).sendKeys(password);
		driver.findElement(By.id("body_btnLogin")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://10.82.180.36/Accounts/Customer/CustomerAccountHome.aspx");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {
		String object[][] = { { "donhere", "don@123" }, { "donhere1", "don@123" }, { "donhere2", "don@123" } };
		return object;
	}
}
