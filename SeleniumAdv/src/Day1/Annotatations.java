package Day1;

import org.testng.annotations.Test;
public class Annotatations {
  
	//@Test(invocationCount=10)
  public void f() {
	  System.out.println("test1");
  }
	
	@Test(invocationCount=10,threadPoolSize=5)
	  public void f1() { 
		  System.out.println("test2");
	  }
}
