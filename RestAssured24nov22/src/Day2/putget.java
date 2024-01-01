package Day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class putget {
  @Test
  public void f() {
	  RestAssured.basePath="http://10.82.180.36:8080/rest-session-demo/api";
	  Response response=RestAssured.given().get();
  }
}
