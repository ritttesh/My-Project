package POM;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportDemo {
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\pritesh.ranjan\\Documents\\TestNG\\MSEdgedriver\\msedgedriver.exe");
	}

	@BeforeMethod
	public void beforeMethod() {
		reports = new ExtentReports("extentreports.html");
		test = reports.startTest("login test");
		driver = new EdgeDriver();
		test.log(LogStatus.INFO, "Launching edge browser");
		driver.get("http://10.82.180.36/Common/Login.aspx");
		test.log(LogStatus.INFO, "Navigating to url");
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Maximizing edge browser");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Setting implicit wait");
	}

	@Test
	public void f() throws IOException {
		driver.findElement(By.id("body_txtUserID")).sendKeys("donhere");
		test.log(LogStatus.INFO, "sending username to username textbox");
		driver.findElement(By.id("body_txtPassword")).sendKeys("don@123");
		test.log(LogStatus.INFO, "sending password to password textbox");
		driver.findElement(By.id("body_btnLogin")).click();
		test.log(LogStatus.INFO, "Clicking on login button");
		if (driver.getCurrentUrl().equals("http://10.82.180.36/Accounts/Customer/CustomerAccountHome.aspx1")) {
			test.log(LogStatus.PASS, "Testcase passed: LOGIN SUCCESSFUL");
		} else {
			test.log(LogStatus.FAIL, test.addScreenCapture(captureScreenshot(driver)) +"Testcase failed: Login UNSUCCESSFUL");
		}
	}
	
	public String captureScreenshot(WebDriver driver) throws IOException {
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dst=new File(".\\"+System.currentTimeMillis()+".png");
		//FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
		test.log(LogStatus.INFO, "Closing all the opened edge browser windows and closing edgedriver.exe");
		reports.endTest(test);
		reports.flush();
	}
}
