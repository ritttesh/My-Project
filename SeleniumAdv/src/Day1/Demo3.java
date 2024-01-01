package Day1;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo3 {

	@BeforeTest
	public void beforeTest() {
		System.out.println("This is before test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("This is after test");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("This is before class Demo3");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("This is after class Demo3");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is before method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("This is after method");
	}

	@Test
	public void f() {
		System.out.println("This is test");
//		Assert.assertEquals(5, 4);
	}

	@Test
	public void f1() {
		System.out.println("This is test 1");
		Assert.assertEquals(5, 4);
	}

	@Test
	public void f2() {
		System.out.println("This is test 2");
	}
}
