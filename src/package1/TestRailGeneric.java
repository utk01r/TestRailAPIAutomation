package package1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class TestRailGeneric {
	
	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() throws InterruptedException{
		
	System.setProperty("webdriver.chrome.driver", ".\\exefiles\\chromedriver.exe");
	driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("https://nandinisuruchi.testrail.io/index.php?/suites/view/2&group_by=cases:section_id&group_order=asc");

	driver.findElement(By.id("name")).sendKeys("nandinisuruchi101@gmail.com");// 
		 
	driver.findElement(By.id("password")).sendKeys("02iVLvqj60EuXr.mfitr");
	driver.findElement(By.id("button_primary")).click();
	Thread.sleep(3000);

	
	
		
	}

		
		
		
		@Test(dataProvider="getShipmentData", dataProviderClass=ExcelDataConfig.class)
		public void NewProjectExt_SimplifySR(String  tcid, String step, String exp, String title, String changExp, String run) throws Exception
		{	 
			
			System.out.println(tcid +" "+step+" "+exp+" "+title+ " "+changExp+ " "+run);
			
		

			
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()='Add Case']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("title")).sendKeys(title);
	
	driver.findElement(By.xpath("//label[text()='Test-caseId												']/..//input")).sendKeys(tcid);
	driver.findElement(By.id("custom_steps")).sendKeys(step);
	driver.findElement(By.id("custom_expected")).sendKeys(exp);
	driver.findElement(By.id("accept")).click();
	
    driver.findElement(By.xpath("//li[@class='header-menu-item header-menu-item-selected']//a[text()='Test Cases']")).click();
	
    
    
    
    
// if(run.equalsIgnoreCase("y")) {
//	 Thread.sleep(2000);
//	 
//	 
//	 String tcupate=tcid;
//		//td[text()='102']
//		driver.findElement(By.xpath("//td[text()='"+tcupate+"']/..//td[3]//a")).click();
//		//td[text()='100']/..//td[3]//a
//		driver.findElement(By.xpath("//span[text()='Edit']")).click();
//		WebElement wbele = driver.findElement(By.id("custom_expected"));
//		//WebElement ele = driver.findElement(By.xpath("//a[text()='title1']"));
//		((JavascriptExecutor) driver).executeScript( "arguments[0].scrollIntoView();", wbele);
//		
//		wbele.clear();
//		driver.findElement(By.id("custom_expected")).sendKeys(changExp);
//		driver.findElement(By.id("accept")).click();
//	 
// }
    
    
    
    
 

//	@AfterMethod
//	public void teardown(){
//	}


}
}
