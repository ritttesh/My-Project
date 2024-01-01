package Day1;

import java.awt.Desktop.Action;

import org.testng.annotations.Test;

public class Demo8 {
	@Test(priority = -1000, enabled = true)
	public void login() {
		System.out.println("This is login");
	}

	@Test(priority=-1001)
	public void homePage() {
		System.out.println("This is homepage");
	}

	@Test(priority = -1002)
	public void logout() {
		System.out.println("This is logout");
		
	}
}
