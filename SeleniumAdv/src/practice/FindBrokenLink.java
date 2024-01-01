package practice;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class FindBrokenLink {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pritesh.ranjan\\Documents\\Selenium Jars\\drivers\\chormedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void f() throws IOException {
		List<WebElement> linklist=driver.findElements(By.tagName("a"));
		Iterator<WebElement> it=linklist.iterator();

		while(it.hasNext()) {
			String link=it.next().getAttribute("href");
			System.out.println(link);
			if(link==null || link.isEmpty()) {
				System.out.println("there is no link with anchor tag");
			}
			else if(!validateLink(link)) {
				System.out.println("link is not valid");
			}
		}
	}

	public static boolean validateLink(String link) throws IOException {
		URL url=new URL(link);
		HttpURLConnection huc =(HttpURLConnection) url.openConnection();
		huc.setRequestMethod("HEAD");
		huc.connect();

		int rescode=huc.getResponseCode();
		if(rescode >= 400){
			return false;
		}
		else{
			return true;
		}
	}
}
