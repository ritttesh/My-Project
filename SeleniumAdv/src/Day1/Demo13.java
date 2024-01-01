package Day1;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Demo13 {
	WebDriver driver;

	@Test
	public void f() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pritesh.ranjan\\Documents\\Selenium Jars\\drivers\\chormedriver\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(co);
		driver.get("http://10.82.180.36/Common/Login.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("body_txtUserID")).sendKeys("donhere");
		driver.findElement(By.id("body_txtPassword")).sendKeys("don@123");
		driver.findElement(By.id("body_btnLogin")).click();
		driver.quit();
	
	}

//	@Test
//	public void f1() {
//		System.setProperty("webdriver.gecko.driver",
//				"C:\\Users\\vittal.shenoy\\Downloads\\win64\\win64\\geckodriver.exe");
//		ProfilesIni profileIni = new ProfilesIni();
//		FirefoxProfile fp = profileIni.getProfile("Selenium");
//		fp.setAcceptUntrustedCertificates(true);
//		fp.setAssumeUntrustedCertificateIssuer(false);
//		FirefoxOptions fo=new FirefoxOptions();
//		fo.setProfile(fp);
//		FirefoxDriver driver=new FirefoxDriver(fo);
//		driver.get("http://10.82.180.36/Common/Login.aspx");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.id("body_txtUserID")).sendKeys("donhere");
//		driver.findElement(By.id("body_txtPassword")).sendKeys("don@123");
//		driver.findElement(By.id("body_btnLogin")).click();
//		driver.quit();
	}

