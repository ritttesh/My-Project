package Day1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Demo9 {
	@Test(groups = { "sanity", "regression" })
	public void f() {
		System.out.println("This is f(sanity and regression)");
	}

	@Test(groups = "regression")
	public void f1() {
		System.out.println("This is f1(only regression)");
	}

	@Test(groups = { "smoke", "regression" })
	public void f2() {
		System.out.println("This is f2 smoke and regression");
	}

	@Test
	public void f3() {
		System.out.println("This is f3 and belongs to no group");
//		WebDriver driver=null;
//		driver.findElement(null).sendKeys(Keys.ENTER);
	}
}
