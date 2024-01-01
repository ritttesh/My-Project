package Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ParallelTest {
	WebDriver driver=null;
	@Test
	public void f() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pritesh.ranjan\\Downloads\\chromedriver_win32\\chromedriver.exe");




		driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@Test
	public void f1() {




		System.setProperty("webdriver.edge.driver","C:\\Users\\pritesh.ranjan\\Documents\\TestNG\\MSEdgeDriver\\msedgedriver.exe");

		driver = new EdgeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
}
