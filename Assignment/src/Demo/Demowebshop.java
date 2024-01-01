package Demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Demowebshop {
	WebDriver driver;
	

	@BeforeClass
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\pritesh.ranjan\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		driver=new ChromeDriver();
		
		//edge driver
//		System.setProperty("webdriver.edge.driver","C:\\Users\\pritesh.ranjan\\Documents\\TestNG\\MSEdgeDriver\\msedgedriver.exe");
//		driver=new EdgeDriver();
		
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}



	@Test
	public void validateRegister() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class=\"header-links\"]/ul/li/a[contains(text(),\"Register\")]")).click();
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("P Ritesh");
		driver.findElement(By.id("LastName")).sendKeys("Ranjan");
		driver.findElement(By.id("Email")).sendKeys("priteshranjan9"+Math.round(Math.random()*10)+"@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Ritesh@123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Ritesh@123");
		driver.findElement(By.id("register-button")).click();
		Thread.sleep(2000);
		boolean rvalue=driver.findElement(By.xpath("//div[@class='page registration-result-page']/div[2]/div")).isDisplayed();
		Assert.assertTrue(rvalue,"Registration is not successfull");
		if(rvalue) {
			System.out.println("Message displayed successfully");
		}
		
		
	}

	
	@Test(priority=1)
	public void addToCart() throws InterruptedException {
		//validate computer menu
		driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]/a")).click();
		List<WebElement> itemlist=driver.findElements(By.xpath("//div[@class='item-box']"));
		for(WebElement items:itemlist) {
			if(!items.isDisplayed()) {
				System.out.println("page is not loaded properly");
			}
		}
		System.out.println("all the submenues are displayed");
		
		
		//desktop
		driver.findElement(By.xpath("//div[@class='sub-category-grid']/div[1]")).click();
		driver.findElement(By.xpath("//div[@class='product-grid']/div[3]")).click();
		
		driver.findElement(By.id("product_attribute_74_5_26_82")).click();
		driver.findElement(By.id("product_attribute_74_6_27_85")).click();
		driver.findElement(By.id("product_attribute_74_8_29_88")).click();
		driver.findElement(By.id("product_attribute_74_8_29_90")).click();
		driver.findElement(By.id("addtocart_74_EnteredQuantity")).clear();
		driver.findElement(By.id("addtocart_74_EnteredQuantity")).sendKeys("2");
		driver.findElement(By.id("add-to-cart-button-74")).click();
		
		//add to cart
		WebDriverWait wait=new WebDriverWait(driver,10);
		By cartmsg=By.xpath("//*[@id=\"bar-notification\"]/p"); //*[@id="bar-notification"]/p
		WebElement addToCart=wait.until(ExpectedConditions.visibilityOfElementLocated(cartmsg));
		System.out.println(addToCart.getText());
		driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/p/a")).click();
		Thread.sleep(2000);
		
		//Apparel and Shoes 
		driver.findElement(By.xpath("//div[@class='common-buttons']/input[2]")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[4]")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[2]/div[3]/div[2]/input")).click();
		
		//add shirt to cart
		WebElement disp=driver.findElement(By.id("products-pagesize"));
		Select display=new Select(disp);
		display.selectByVisibleText("12");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='product-grid']/div[9]")).click();
		
		//size
		Select size=new Select(driver.findElement(By.id("product_attribute_10_7_36")));
		size.selectByValue("110");
		driver.findElement(By.id("add-to-cart-button-10")).click();  //addtocart btn
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartmsg));
		//driver.findElement(By.xpath("//*[@id=\\\"bar-notification\\\"]/p/a")).click(); //cartbtn
		driver.findElement(By.id("topcartlink")).click();
		
		//shipping
		Select country=new Select(driver.findElement(By.id("CountryId")));
		country.selectByValue("41");
		driver.findElement(By.xpath("//div[@class=\"shipping-options\"]/div[4]/input")).click(); //estimate shipping
		
		//validate toc
		driver.findElement(By.id("checkout")).click();   //checkout
		boolean tos=driver.findElement(By.id("terms-of-service-warning-box")).isDisplayed();
		Assert.assertTrue(tos,"tos message is not displated");
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/button")).click();
		
		driver.findElement(By.id("termsofservice")).click();   //toc
		System.out.println("Disclaimer selected");
		driver.findElement(By.id("checkout")).click();    //checkout
		
		
	}
	
	
	@Test(priority=2)
	public void billing() throws InterruptedException{
		Select country=new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
		country.selectByValue("41");
		driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Bhubaneswar");  //city
		String address1="113 ,k8, Kalinganagar ,bhubaneswar";
		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys(address1); 
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("751001");
		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("8249520333");
		driver.findElement(By.xpath("//*[@id='billing-buttons-container']/input")).click();
		
		//shipping address
		driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")).click();
		
		//shipping method
		driver.findElement(By.id("shippingoption_2")).click();
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")).click();
		
		//payment 
		driver.findElement(By.id("paymentmethod_2")).click();
		driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click();
		
		//payment info
		Select cardtyp=new Select(driver.findElement(By.id("CreditCardType")));
		cardtyp.selectByValue("MasterCard");
		driver.findElement(By.id("CardholderName")).sendKeys("P Ritesh Ranjan");
		driver.findElement(By.id("CardNumber")).sendKeys("5105105105105100");
		new Select(driver.findElement(By.id("ExpireMonth"))).selectByValue("4");
		new Select(driver.findElement(By.id("ExpireYear"))).selectByValue("2023");
		driver.findElement(By.id("CardCode")).sendKeys("000");
		driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")).click();
		
		//validate cart product
		WebElement table=driver.findElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div[2]/div/form/table"));
		WebElement tbody=table.findElement(By.tagName("tbody"));
		List<WebElement> tr=tbody.findElements(By.tagName("tr"));
		if(tr.size()==3) {
			System.out.println("all items are in the cart");
		}
		
		//price check
		String cartprice=driver.findElement(By.xpath("//table[@class='cart-total']/tbody/tr[4]/td[2]/span/span/strong")).getText();
		cartprice=cartprice.substring(0,cartprice.length()-3);
		if(Integer.valueOf(cartprice)==4035) {
			System.out.println("Cart price is validated");
		}
//		driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")).click();  //confirm order
//		Thread.sleep(2000);
//		
//		String ordersts=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong")).getText();
//		Assert.assertEquals(ordersts,"Your order has been successfully processed!","your order is not placed");
//		System.out.println("order placed successfully");
//		System.out.println(driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[1]")).getText());
//		
//		//oder details
//		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[2]/a")).click();
//		String odate=driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div[1]/div[2]/span[1]")).getText();
//		odate=odate.substring(20);
//		System.out.println("odate "+odate);
//		DateFormat dt=new SimpleDateFormat("MMMM dd, yyyy");
//		String tdate=dt.format(new Date());
//		System.out.println("tdate "+tdate);
//		if(odate.equals(tdate)) {
//			System.out.println("date is validated");
//		}
//		
//		//pdf invoice
//		driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[1]/a[2]")).click();
//		Thread.sleep(3000);
//		Assert.assertTrue(isFileDownloaded("C:\\Users\\pritesh.ranjan\\Downloads","^[a-z_]{6}[_0-9]{7}[.]{1}[a-z]{3}$"),"file is not downloaded");
	}
	
	public static boolean isFileDownloaded(String filepath,String filename) {
		File dir=new File(filepath);
		File[] dirFiles= dir.listFiles();

		  for (int i = 0; i < dirFiles.length; i++) {
			  String fname=dirFiles[i].getName();
		      if (Pattern.matches(filename,fname)){
		    	  System.out.println("file name is : "+ dirFiles[i].getName());
		          dirFiles[i].delete();
		          return true;
		      }
		  }
		  return false;
	}
	
	@AfterMethod
	public void afterMethod() {
		//driver.close();
		//driver.quit();
	}

}
