package POM;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = getDriver();
	}

	@Test
	public void f() {
		LoginPage lp = new LoginPage(driver);
		HomePage hp = lp.login("donhere", "don@123");
		Assert.assertEquals(hp.verifyLogin("Welcome donhere"),true);
	}
}
