package Day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseProp {
  @Test
  public void f() {
	  RestAssured.baseURI="http://10.82.180.36:8080/AmigoWallet/RegistrationAPI";
	  RequestSpecification requestspec=RestAssured.given();
	  Response response=requestspec.request(Method.GET, "/getAllQuestions");
	  //Response response=requestspec.get("/getAllQuestions");
	  System.out.println(response.getBody().asString());
	  
	  //content type(xml/json)
	  String content_type=response.getContentType();
	  
	  //status of response==>return a int valu(e.g: 404 not found,200 found)
	  int statuscode=response.getStatusCode();
	  System.out.println("ststus code :"+statuscode);
	  
	  //status line
	  String status_line=response.getStatusLine();
	  System.out.println("ststus line :"+status_line);
	  
	  
	  //session id
	  String session_id=response.getSessionId();
	  System.out.println("ststus id :"+session_id);
	  
	  //get headers
	  Headers headers=response.getHeaders();
	  //System.out.println(headers);
	  for(Header header:headers) {
		  System.out.println(header.getName()+" : "+header.getValue());
	  }
	  
  }
  
}
