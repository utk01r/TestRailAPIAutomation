package package1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testrailui {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\exefiles\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://akashtestrail.testrail.io/index.php?/suites/view/1&group_by=cases:section_id&group_order=asc");
		//WebElement wb1 =
		//ExcelUtilities excel1 = new ExcelUtilities()
				driver.findElement(By.id("name")).sendKeys("das113367@gmail.com");
				driver.findElement(By.id("password")).sendKeys("Suruchi@123");
				driver.findElement(By.id("button_primary")).click();
				
				driver.findElement(By.xpath("//span[text()='Add Case']")).click();
				//driver.findElement(By.id("addCase")).click();
				
//				String data =ExcelUtilities.readData("Sheet2",1,0);
//				System.out.println(data);
				driver.findElement(By.id("title")).sendKeys(ExcelUtilities.readData("Sheet2",1,3));
				
				driver.findElement(By.id("custom_abcd")).sendKeys(ExcelUtilities.readData("Sheet2",1,0));
				driver.findElement(By.id("custom_steps")).sendKeys(ExcelUtilities.readData("Sheet2",1,1));
				driver.findElement(By.id("custom_expected")).sendKeys(ExcelUtilities.readData("Sheet2",1,2));
				driver.findElement(By.id("accept")).click();
//				driver.findElement(By.xpath("//a[@id='navigation-user']/span[2]")).click();	
//				driver.findElement(By.xpath("//a[text()='Logout']")).click();
//				
				
//				driver.findElement(By.id("name")).sendKeys("das113367@gmail.com");
//				driver.findElement(By.id("password")).sendKeys("Suruchi@123");
//				driver.findElement(By.id("button_primary")).click();
				
				//Thread.sleep(5000);
//				driver.findElement(By.xpath("//a[text()='Test Cases']")).click();
//				
//				driver.findElement(By.id("addCase")).click();
//				
				driver.navigate().refresh();
				WebElement wb = driver.findElement(By.xpath("//a[text()='Test Cases']"));
				((JavascriptExecutor) driver).executeScript(
			            "arguments[0].scrollIntoView();", wb);
				driver.findElement(By.xpath("//a[text()='Test Cases']")).click();
//				WebDriverWait wait = new WebDriverWait(driver, 10); 
//				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Test Cases']")));
//				element.click();			
		
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[text()='Add Case']")).click();
				
				
				driver.findElement(By.id("title")).sendKeys(ExcelUtilities.readData("Sheet2",2,3));
				driver.findElement(By.id("custom_abcd")).sendKeys(ExcelUtilities.readData("Sheet2",2,0));
				driver.findElement(By.id("custom_steps")).sendKeys(ExcelUtilities.readData("Sheet2",2,1));
				driver.findElement(By.id("custom_expected")).sendKeys(ExcelUtilities.readData("Sheet2",2,2));
				driver.findElement(By.id("accept")).click();
				
				
				
				driver.navigate().refresh();
				WebElement wb2 = driver.findElement(By.xpath("//a[text()='Test Cases']"));
				((JavascriptExecutor) driver).executeScript(
			            "arguments[0].scrollIntoView();", wb2);
				driver.findElement(By.xpath("//a[text()='Test Cases']")).click();
//				WebDriverWait wait = new WebDriverWait(driver, 10); 
//				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Test Cases']")));
//				element.click();			
		
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[text()='Add Case']")).click();
				
				
				driver.findElement(By.id("title")).sendKeys(ExcelUtilities.readData("Sheet2",3,3));
				driver.findElement(By.id("custom_abcd")).sendKeys(ExcelUtilities.readData("Sheet2",3,0));
				driver.findElement(By.id("custom_steps")).sendKeys(ExcelUtilities.readData("Sheet2",3,1));
				driver.findElement(By.id("custom_expected")).sendKeys(ExcelUtilities.readData("Sheet2",3,2));
				driver.findElement(By.id("accept")).click();
				
//				WebElement ele = driver.findElement(By.xpath("//a[text()='title1']"));
//				((JavascriptExecutor) driver).executeScript(
//			            "arguments[0].scrollIntoView();", ele);
//				
		//	driver.findElement(By.xpath("//a[text()='title1']")).click();
			
	}

}
