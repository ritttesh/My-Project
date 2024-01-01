package Day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete {
  @Test
  public void f() {
	  RestAssured.baseURI="http://10.82.180.36:8080/rest-session-demo/api";
	  RequestSpecification resSpec=RestAssured.given();
	  Response response=resSpec.request(Method.DELETE,"/student/delete?rollNo=103");
	  //Response response=RestAssured.delete("http://10.82.180.36:8080/rest-session-demo/api/student/delete?rollNo=103");
	  System.out.println(response.getBody().asString());
	  System.out.println(response.getStatusCode());
  }
}
