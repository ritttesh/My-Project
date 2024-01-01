package Day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Get {
  @Test
  public void f() {
	  //Response response=RestAssured.get("http://10.82.180.36:8080/AmigoWallet/RegistrationAPI/getAllQuestions");
	  Response response=RestAssured.get("https://reqres.in/api/data?name=cerulean");
	  ResponseBody responsebody=response.getBody();
	  String responseString=responsebody.asString();
	  System.out.println(responseString);
  }
}
