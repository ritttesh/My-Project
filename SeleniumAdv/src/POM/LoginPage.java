package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By userIDTextBox = By.id("body_txtUserID");
	By passwordTextBox = By.id("body_txtPassword");
	By loginButton = By.id("body_btnLogin");

	public HomePage login(String username, String password) {
		driver.findElement(userIDTextBox).sendKeys(username);
		driver.findElement(passwordTextBox).sendKeys(password);
		driver.findElement(loginButton).click();
		return new HomePage(driver);
	}

}
