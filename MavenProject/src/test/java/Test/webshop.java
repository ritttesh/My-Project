package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class webshop {
WebDriver driver;
	

	@BeforeClass
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pritesh.ranjan\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
		//edge driver
//		System.setProperty("webdriver.edge.driver","C:\\Users\\pritesh.ranjan\\Documents\\TestNG\\MSEdgeDriver\\msedgedriver.exe");
//		driver=new EdgeDriver();
		
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}



	@Test
	public void validateRegister() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class=\"header-links\"]/ul/li/a[contains(text(),\"Register\")]")).click();
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("P Ritesh");
		driver.findElement(By.id("LastName")).sendKeys("Ranjan");
		driver.findElement(By.id("Email")).sendKeys("priteshranjan8"+Math.round(Math.random()*10)+"@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Ritesh@123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Ritesh@123");
		driver.findElement(By.id("register-button")).click();
		Thread.sleep(2000);
		boolean rvalue=driver.findElement(By.xpath("//div[@class='page registration-result-page']/div[2]/div")).isDisplayed();
		Assert.assertTrue(rvalue,"Registration is not successfull");
		if(rvalue) {
			System.out.println("Message displayed successfully");
		}
		
		
	}
}
