package Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Demo12 {
	WebDriver driver;
	SoftAssert sa;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pritesh.ranjan\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("http://10.82.180.36/Common/Login.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sa=new SoftAssert();
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void f() {
		driver.findElement(By.id("body_txtUserID")).sendKeys("donhere");
		driver.findElement(By.id("body_txtPassword")).sendKeys("don@123");
		driver.findElement(By.id("body_btnLogin")).click();
		sa.assertEquals(driver.getCurrentUrl(), "http://10.82.180.36/Accounts/Customer/CustomerAccountHome.aspx");
		driver.findElement(By.linkText("View Transactions")).click();
		sa.assertEquals(driver.getCurrentUrl(),
				"http://10.82.180.36/Accounts/Customer/CustomerViewTransactions.aspx");
		driver.findElement(By.id("lbLoginOut")).click();
		sa.assertEquals(driver.getCurrentUrl(), "http://10.82.180.36/Common/Login.aspx");
		sa.assertAll();
		System.out.println("This is line 51");
	}
}
