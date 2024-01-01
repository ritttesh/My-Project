package Day1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HeaderProp {
	@Test
	public void f() {

		//another way to getting header information

		Response response=RestAssured.get("http://10.82.180.36:8080/AmigoWallet/RegistrationAPI");
		System.out.println(response.getBody().asString());

		//content type
		String content_type=response.header("Content-Type");
		System.out.println("content type :"+content_type);

		String transfer_encoding = response.header("Transfer-Encoding");
		System.out.println(transfer_encoding);

		String date = response.header("date");
		System.out.println(date);
		
		String asp_version = response.header("X-Aspnet-Version");
		System.out.println(asp_version);
		
		System.out.println(response.header("X-Powered-On"));
	}
}
