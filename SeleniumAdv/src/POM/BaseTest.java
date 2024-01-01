package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseTest {
	private WebDriver driver;

	@BeforeClass
	@Parameters({ "browser", "url" })
	public void beforeClass(String browser, String url) {
		initialize(browser, url);
	}

	public void initialize(String browser, String url) {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\pritesh.ranjan\\Documents\\TestNG\\MSEdgedriver\\msedgedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\vittal.shenoy\\Downloads\\win64\\win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public WebDriver getDriver() {
		
		return driver;
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
