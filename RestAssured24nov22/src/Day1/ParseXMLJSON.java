package Day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParseXMLJSON {  // parse through json and xml

	//parse thru json
	@Test
	public void f() { 

		Response response=RestAssured.get("http://10.82.180.36:8080/rest-session-demo/api/student?rollNo=101");
		System.out.println(response.getBody().asString());
		JsonPath json_path=response.jsonPath();
		System.out.println(json_path.getString("name"));
		System.out.println(json_path.getInt("rollNo"));
		System.out.println(json_path.getString("std"));  
	}

	//@Test
	public void f1() {
		Response response=RestAssured.get("http://10.82.180.36:8080/rest-session-demo/api/student?rollNo=101");
		System.out.println(response.getBody().asString());
		JsonPath json=new JsonPath(response.asString());
		System.out.println(json.getString("name"));
		System.out.println(json.getInt("rollNo"));
		System.out.println(json.getString("std"));
		
		//for multiple data use indexing
		//System.out.println(json.getString("name[1]"))
		
	}

	//xml parsing 
	//@Test
	public void f2() {
		Response response = RestAssured.get("http://10.82.181.42/WebService/Bank/Bank.asmx/ReadUser?username=infosys");
		System.out.println("Content-Type: " + response.getContentType());
		System.out.println("Response Body is : " + response.getBody().asString());
		XmlPath xml_res = response.xmlPath();
		System.out.println("Password : " + xml_res.getString("user.password"));
		System.out.println("status : " + xml_res.getString("user.status"));
		System.out.println("balance : " + xml_res.getString("user.balance"));
	}

	//@Test
	public void f3() {
		Response response = RestAssured.get("http://10.82.181.42/WebService/Bank/Bank.asmx/ReadUser?username=infosys");
		XmlPath xml_path = new XmlPath(response.getBody().asString());
		System.out.println("Password : " + xml_path.getString("user.password"));
		System.out.println("status : " + xml_path.getString("user.status"));
		System.out.println("balance : " + xml_path.getString("user.balance"));
	}


}
