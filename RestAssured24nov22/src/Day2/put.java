package Day2;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class put {
  @Test
  public void f() throws JSONException {
	  RestAssured.baseURI="https://reqres.in";
	  JSONObject jsobj=new JSONObject();
	  jsobj.put("name", "morpheus");
	  jsobj.put ("job","zion resident");
	  
	  Response response=RestAssured.given().header("Content-Type","application/json")
			  	.body(jsobj.toString()).put("/api/users/2");
	  
	  
//	  RequestSpecification reqspe=RestAssured.given();
//	  reqspe.header("Content-Type","application/json");
//	  reqspe.body(jsobj.toString());
//	  Response response=reqspe.put("/api/users/2");
	  System.out.println(response.statusCode());
	  
	  
  }
}
