package Junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
	WebDriver driver=null;

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		
		
	}
	
	@BeforeClass
	public static void tearDownAfterClass1() throws Exception {
		System.out.println("before all");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("before each");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after each");
		
	}
	@Test
	public void ball() {
		System.out.println("ball");
	}
	@Test
	public void apple() {
		System.out.println("apple");
	}

	
	
	

}
