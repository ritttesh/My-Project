package Day2;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class patch {
  @Test
  public void f() throws JSONException {
	  RestAssured.baseURI="https://reqres.in";
	  RequestSpecification reqspec=RestAssured.given();
	  
	  Response response1=reqspec.get("/api/users/2");
	  System.out.println(response1.jsonPath().getString("data.id"));
	  System.out.println(response1.getBody().asString());
	  
	  JSONObject jsobj=new JSONObject();
	  jsobj.put("id", "3");
	  reqspec.header("Content-Type","application/json");
	  reqspec.body(jsobj.toString());
	  
	  Response response2=reqspec.patch("/api/users/2/data");
	  System.out.println(response2.getBody().asString());

//	  Response response3=reqspec.get("/api/users/2");
//	  System.out.println(response3.jsonPath().getString("data.id"));
//	  System.out.println(response3.getBody().asString());

  }
}
