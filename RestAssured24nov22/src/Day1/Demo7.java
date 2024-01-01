package Day1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo7 {    //assertion
  @Test
  public void f() {
	  RestAssured.baseURI="http://10.82.180.36:8080/AmigoWallet/RegistrationAPI";
	  RequestSpecification requestspec=RestAssured.given();
	  Response response=requestspec.request(Method.GET, "/getAllQuestions");
	  Assert.assertEquals(response.getStatusCode(), 200);
	  
  }
}
