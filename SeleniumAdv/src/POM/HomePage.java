package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By welcomeMessage = By.id("divWelcome");

	public boolean verifyLogin(String expected) {
		String actual = driver.findElement(welcomeMessage).getText();
		if(actual.equals(expected)) {
			return true;
		}
		return false;
	}

}
