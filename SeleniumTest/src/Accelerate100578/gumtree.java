package Accelerate100578;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class gumtree{
	WebDriver driver;


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pritesh.ranjan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.gumtree.com/");
		//driver.get("https://www.gumtree.com/cars-vans-motorbikes/cars");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();


	}

	
	@Test
	public void module1() throws IOException, InterruptedException {
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		//Thread.sleep(5000);
		
		WebElement carsnvehicle=driver.findElement(By.xpath("//*[@id=\"content\"]/header/div/div[1]/div/div[1]/div/div/div/ul/li[1]/div"));//.click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/header/div/div[1]/div/div[1]/div/div/div/ul/li[1]/div/a/span")).click();
		WebElement car=driver.findElement(By.xpath("//*[@id=\"content\"]/header/div/div[2]/div[2]/div/div[1]/div/div[2]/ul/li[1]/a"));//.click();
//		
		Actions ac=new Actions(driver);
		ac.moveToElement(carsnvehicle).moveToElement(car).click().build().perform();
		
		//module1
		File file =new File("C:\\Users\\pritesh.ranjan\\Desktop\\Accelerate100578\\Accelerate100578.xlsx");
		FileInputStream fin=new FileInputStream(file);
		XSSFWorkbook book=new XSSFWorkbook(fin);
		XSSFSheet sheet=book.getSheet("Car Details");
		
		
		WebElement makes=driver.findElement(By.xpath("//*[@id=\"structured-search\"]/div/div/div/div[1]/div[1]/div/select"));
		List<WebElement> car_makes=makes.findElements(By.tagName("option"));
		for(int i=2;i<car_makes.size();i++) {
			String make=car_makes.get(i).getText();

			Row newRow=sheet.createRow(i-1);
			Cell newCell=newRow.createCell(0);
			newCell.setCellValue(make);
		}
		


		//module2
		sheet=book.getSheet("Audi Models");
		
		Select cars=new Select(makes);
		cars.selectByVisibleText("Audi");
		Thread.sleep(3000);

		WebElement models= driver.findElement(By.xpath("//*[@id=\"structured-search\"]/div/div/div/div[1]/div[2]/div/select"));
		List<WebElement> audi_models=models.findElements(By.tagName("option"));
		
		for(int i=2;i<audi_models.size();i++) {
			String model=audi_models.get(i).getText();

			Row newRow=sheet.createRow(i-1);
			Cell newCell=newRow.createCell(0);
			newCell.setCellValue(model);
		}

		//module3
		Select car_model=new Select(models);
		car_model.selectByVisibleText("A7");
		driver.findElement(By.xpath("//*[@id=\"structured-search\"]/div/div/div/div[2]/div[2]/button")).click();
		
		//sort
		WebElement sort=driver.findElement(By.xpath("//*[@id=\"srp-header-sort\"]/div/div/span/span/select"));
		Select sortBy=new Select(sort);
		sortBy.selectByIndex(1);
		
		//take screen shot
		TakesScreenshot takess=((TakesScreenshot)driver);
		File srcFile=takess.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("C:\\Users\\pritesh.ranjan\\Desktop\\Accelerate100578\\gumtree.jpg"));

		FileOutputStream fout=new FileOutputStream(file);
		book.write(fout);
		book.close();
	}


}
