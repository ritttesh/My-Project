package Day1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listners.class)
public class Listnertest {
  
  @Test
  public void f() {
	  System.out.println("test");
  }
}
