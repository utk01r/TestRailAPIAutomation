package package1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testRailChangeExpected {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", ".\\exefiles\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://pawanbel.testrail.io/index.php?/suites/view/1&group_by=cases:section_id&group_order=asc");
	
				driver.findElement(By.id("name")).sendKeys("pawanukok@googlemail.com");// 
			 
				driver.findElement(By.id("password")).sendKeys("5a2S2kBnPuFpDkz5OjtC");  

				driver.findElement(By.id("button_primary")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[text()='Add Case']")).click();
				//driver.findElement(By.id("addCase")).click();
				
//				String data =ExcelUtilities.readData("Sheet2",1,0);
//				System.out.println(data);
				driver.findElement(By.id("title")).sendKeys(ExcelUtilities.readData("Sheet2",1,3));
				
				driver.findElement(By.xpath("//label[text()='Test-caseId												']/..//input")).sendKeys(ExcelUtilities.readData("Sheet2",1,0));
				driver.findElement(By.id("custom_steps")).sendKeys(ExcelUtilities.readData("Sheet2",1,1));
				driver.findElement(By.id("custom_expected")).sendKeys(ExcelUtilities.readData("Sheet2",1,2));
				driver.findElement(By.id("accept")).click();
				
                driver.findElement(By.xpath("//li[@class='header-menu-item header-menu-item-selected']//a[text()='Test Cases']")).click();
				
				
            	Thread.sleep(3000);
                driver.findElement(By.xpath("//span[text()='Add Case']")).click();
				//driver.findElement(By.id("addCase")).click();
				
//				String data =ExcelUtilities.readData("Sheet2",1,0);
//				System.out.println(data);
				driver.findElement(By.id("title")).sendKeys(ExcelUtilities.readData("Sheet2",2,3));
				
				driver.findElement(By.xpath("//label[text()='Test-caseId												']/..//input")).sendKeys(ExcelUtilities.readData("Sheet2",1,0));
				driver.findElement(By.id("custom_steps")).sendKeys(ExcelUtilities.readData("Sheet2",2,1));
				driver.findElement(By.id("custom_expected")).sendKeys(ExcelUtilities.readData("Sheet2",2,2));
				driver.findElement(By.id("accept")).click();
				
                driver.findElement(By.xpath("//li[@class='header-menu-item header-menu-item-selected']//a[text()='Test Cases']")).click();
				
                
                String tcupate="100";
				//td[text()='102']
				driver.findElement(By.xpath("//td[text()='"+tcupate+"']/..//td[3]//a")).click();
				//td[text()='100']/..//td[3]//a
				driver.findElement(By.xpath("//span[text()='Edit']")).click();
				WebElement wbele = driver.findElement(By.id("custom_expected"));
				//WebElement ele = driver.findElement(By.xpath("//a[text()='title1']"));
				((JavascriptExecutor) driver).executeScript( "arguments[0].scrollIntoView();", wbele);
				
				wbele.clear();
				driver.findElement(By.id("custom_expected")).sendKeys(ExcelUtilities.readData("Sheet2",1,4));
				driver.findElement(By.id("accept")).click();
				
//				
//				
			
	}

}
