package Day1;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get2 {
  @Test
  public void f() {
//	  RestAssured.baseURI="http://10.82.180.36:8080/AmigoWallet/RegistrationAPI";
//	  RequestSpecification requestspec=RestAssured.given();
//	  Response response=requestspec.request(Method.GET, "/getAllQuestions");
//	  //Response response=requestspec.get("/getAllQuestions");
//	  System.out.println(response.getBody().asString());
//	  //System.out.println(response.jsonPath().getString("questionId"));
	  
	  //get with validate
	  RestAssured.baseURI="https://reqres.in/";
	  //RestAssured.given().get("/api/users/2").then().statusCode(200).body("data.first_name", Matchers.equalTo("Janet")).log().all();
	  Response res=RestAssured.given().get("/api/users/2").then().statusCode(200).body("data.first_name", Matchers.equalTo("Janet")).extract().response();
	  //Response res=RestAssured.given().get("/api/users/2");
	  System.out.println(res.getBody().asString());
	  
  }


}

