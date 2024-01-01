package Day2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.dev.XSSFSave;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostExcel {
  @Test
  public void f() throws IOException, JSONException {
	  FileInputStream fis=new FileInputStream("C:\\Users\\pritesh.ranjan\\Documents\\REST Assured\\postbook.xlsx");
	  XSSFWorkbook book=new XSSFWorkbook(fis);
	  XSSFSheet sheet=book.getSheet("Sheet1");
	  
	  RestAssured.baseURI="http://10.82.180.36:8080/rest-session-demo/api";
	  RequestSpecification reqSpec=RestAssured.given();
	  
	  for(int i=1;i<=sheet.getLastRowNum();i++) {
		  String name=sheet.getRow(i).getCell(0).getStringCellValue();
		  String std=sheet.getRow(i).getCell(1).getStringCellValue();
		  double rollno=sheet.getRow(i).getCell(2).getNumericCellValue();

		  //json onject
		  JSONObject jsobj=new JSONObject();
		  jsobj.put("name", name);
		  jsobj.put("rollNo", rollno);
		  jsobj.put("std", std);
		  
		  reqSpec.header("Content-Type","application/json");
		  reqSpec.body(jsobj.toString());
		  
		  Response response=reqSpec.post("/student");
		  System.out.println(response.getBody().asString());
		  System.out.println(response.getStatusCode());
		  System.out.println("a"+response.getSessionId());
		  System.out.println("b"+response.sessionId());
		  
	 	  sheet.getRow(i).createCell(3).setCellValue(response.getBody().asString());
		  
		  
	  }
	  FileOutputStream fos=new FileOutputStream("C:\\Users\\pritesh.ranjan\\Documents\\REST Assured\\postbook.xlsx");
	  book.write(fos);
	  book.close();
	  
  }
}
