package Accelerate;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Task100497 {
	WebDriver driver=null;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pritesh.ranjan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		driver=new ChromeDriver();
		
		//edge driver
//		System.setProperty("webdriver.edge.driver","C:\\Users\\pritesh.ranjan\\Documents\\TestNG\\MSEdgeDriver\\msedgedriver.exe");
//		driver=new EdgeDriver();
		
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void module1() {
		//List<WebElement> topdeals=driver.findElement(By.id("anonCarousel1")).findElements(By.tagName("li"));
		List<WebElement> topdeals=driver.findElements(By.className("a-link-normal"));
		topdeals.forEach((we)-> System.out.println(we.getText()));
	}
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) { 
  }//a-carousel-card

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @AfterClass
  public void afterClass() {
  }

}
