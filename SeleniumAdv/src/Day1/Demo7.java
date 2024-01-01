package Day1;

import org.testng.annotations.Test;

public class Demo7 {
	@Test
	public void login() {
		System.out.println("This is login");
	}

	@Test(dependsOnMethods = "login")
	public void homePage() {
		System.out.println("This is homepage");
	}

	@Test
	public void logout() {
		System.out.println("This is logout");
	}
}
