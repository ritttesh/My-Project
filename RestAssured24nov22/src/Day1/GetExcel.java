package Day1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.plaf.metal.MetalIconFactory.FileIcon16;

import org.apache.poi.xssf.binary.XSSFBCommentsTable;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetExcel {
	@Test
	public void f() throws Exception {
		File file=new File("C:\\Users\\pritesh.ranjan\\Documents\\REST Assured\\restbook.xlsx");
		FileInputStream filein=new FileInputStream(file);
		XSSFWorkbook book=new XSSFWorkbook(filein);
		XSSFSheet sheet=book.getSheet("Sheet1");
		for(int i=1;i<sheet.getLastRowNum();i++) {
			String rollNo=sheet.getRow(i).getCell(0).getRawValue();
			
			Response response=RestAssured.get("http://10.82.180.36:8080/rest-session-demo/api/student?rollNo="+rollNo);
			JsonPath jsonpath=response.jsonPath();
			String name=jsonpath.getString("name");
			String std=jsonpath.getString("std");
			sheet.getRow(i).createCell(1).setCellValue(name);
			sheet.getRow(i).createCell(2).setCellValue(std);
		}
		//FileOutputStream fileout = new FileOutputStream("C:\\Users\\pritesh.ranjan\\Documents\\REST Assured\\restbook.xlsx");
		FileOutputStream fileout = new FileOutputStream(file);
		book.write(fileout);
		book.close();
	}
}
