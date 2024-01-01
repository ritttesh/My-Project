package practice;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class amazonorder {
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pritesh.ranjan\\Documents\\Selenium Jars\\drivers\\chormedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//extentreport
		//report=new ExtentReports("orderreport.html");	
	}

	
//	@Test
//	public void openAUT() {
//		test=report.startTest("open AUT");
//		driver.get("https://www.amazon.in");
//		test.log(LogStatus.INFO, "navigating to url");
//		Assert.assertTrue(driver.findElement(By.id("nav-logo-sprites")).isDisplayed(), "url is not open");
//		test.log(LogStatus.PASS, "sucessfully navigate to the url");
//		driver.manage().window().maximize();
//		test.log(LogStatus.INFO, "maximize browser");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		test.log(LogStatus.INFO, "settingup implicit time");
//	}
	@Test(priority=0)
	public void login() {
		
		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
		//signin
		driver.findElement(By.id("ap_email")).sendKeys("8249820334");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("RITESH021");
		driver.findElement(By.id("signInSubmit")).click();
		
	}

	@Test
	public void apparelshoping() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mens jeans");
		driver.findElement(By.xpath("//*[@id=\"p_90/6741118031\"]/span/a/div/label/i")).click();
		driver.findElement(By.xpath("//*[@id=\"p_89/Pepe Jeans\"]/span/a/div/label/i")).click();
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div[1]/div/span/a/div")).click();
		driver.findElement(By.id("size_name_1")).click();
		driver.findElement(By.id("buy-now-button")).click();
		
	}


	@AfterClass
	public void afterClass() {
	}

}
