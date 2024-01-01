package Day1;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Demo11 {
	SoftAssert sa;
	
	@BeforeMethod
	public void beforeMethod() {
		sa=new SoftAssert();
	}
	
	
  @Test
  public void f() {
	 // sa=new SoftAssert();
	  sa.assertEquals("sa", "sa1");
	  System.out.println("This is line 11");
	  sa.assertEquals("sa1", "sa1");
	  sa.assertAll();
	  System.out.println("This is line 14");
  }
  
  @Test
  public void f1() {
	 //sa=new SoftAssert();
	  sa.assertEquals("sa", "sa");
	  System.out.println("This is line 11");
	  sa.assertEquals("sa1", "sa1");
	  sa.assertAll();
	  System.out.println("This is line 14");
  }
}
