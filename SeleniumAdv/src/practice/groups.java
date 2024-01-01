package practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class groups {
  @Test(groups="sanity")
  public void f1() {
	  System.out.println("sanity");
  }
  
  @Test(groups="regression")
  public void f2() {
	  System.out.println("regression");
  }
  @Test(groups="smoke")
  public void f3() {
	  System.out.println("smoke");
  }
  @Test(groups={"sanity","smoke"})
  public void f4() {
	  System.out.println("sanity and smoke");
  }
  

}
