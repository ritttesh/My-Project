package Day1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo4 {
	@Test(dataProvider = "dataProvider")
	public void f(String username, String password) {
		System.out.println(username + " " + password);
	}

	@DataProvider(name = "dataProvider")
	public Object[][] getData() {
		String object[][] = new String[3][2];
		object[0][0] = "donhere";
		object[0][1] = "don@123";

		object[1][0] = "donhere1";
		object[1][1] = "don@123";

		object[2][0] = "donhere2";
		object[2][1] = "don@123";
		return object;
	}
}
