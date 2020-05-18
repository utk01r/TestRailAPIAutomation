package package1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SahibJenkins {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\exefiles\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("url of jenkins");
		//WebElement wb1 =
		//ExcelUtilities excel1 = new ExcelUtilities()
				driver.findElement(By.id("name")).sendKeys();
				driver.findElement(By.id("password")).sendKeys("Suruchi@123");
				driver.findElement(By.id("button_primary")).click();//click update button
				
				//Set<String> s1 = driver.getWindowHandles();
				//driver.switchTo()

}
}