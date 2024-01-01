package Day2;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post {
  @Test
  public void f() throws JSONException {
	  RestAssured.baseURI="http://10.82.180.36:8080/rest-session-demo/api";
	  RequestSpecification reqSpec =RestAssured.given();
	  
	  //create onject
//	  Map<String,Object> mp=new HashMap<>();
//	  JSONObject json_Object=new JSONObject(mp);
	  JSONObject json_Object=new JSONObject();
	  json_Object.put("name","ritesh");
	  json_Object.put("rollNo" ,102);
	  json_Object.put("std", "A");
	  
	  reqSpec.header("Content-Type","application/json");
	  //reqSpec.contentType(ContentType.JSON).accept(ContentType.JSON);
	  reqSpec.body(json_Object.toString());
	  
	  Response response=reqSpec.request(Method.POST,"/student");
	  
	  //response body
	  System.out.println(response.getBody().asString());
	  
	  //response code
	  System.out.println(response.getStatusCode());
	  System.out.println(response.sessionId());
	  System.out.println(response.getSessionId());
  
	  
	  //post with validate
	  //RestAssured.given().body(json_Object.toString()).when().post("/student");//then().statusCode(201);
	  
  }
}
