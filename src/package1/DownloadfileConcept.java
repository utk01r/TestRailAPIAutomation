package package1;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import org.hamcrest.MatcherAssert.assertThat;
//import org.hamcrest.CoreMatchers.*;
/**
 * 
 * String downloadDir = System.getProperty("user.dir") + "\\src\\test\\resources";

chromePrefs.put("download.default_directory", downloadDir);

 * @author Suruchi.Das
 *
 */

public class DownloadfileConcept {
	WebDriver driver;
	File folder;
	
	@BeforeMethod
	public void setUp() {
		
		folder=new File(UUID.randomUUID().toString());
		folder.mkdirs();
		System.setProperty("webdriver.chrome.driver", ".\\exefiles\\chromedriver.exe");
		String downloadDir = System.getProperty("user.dir") + ".\\exefiles";
		ChromeOptions option= new ChromeOptions();
		
		Map<String, Object> prefs=new HashMap<String, Object>();
		
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", downloadDir);
		option.setExperimentalOption("prefs", prefs);
		
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, option);
		
		driver=new ChromeDriver(cap);
//		
//		driver.manage().window().maximize();
//		
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		driver.get("https://akashtestrail.testrail.io/index.php?/suite
	
		
	}
	
@Test
public void downloadFileTest() throws InterruptedException {
	
	driver.get("http://the-internet.herokuapp.com/download");
	
	List<WebElement> wbele = driver.findElements(By.xpath("//div[@class='example']//a"));
	int filecount=wbele.size();
	for (int i = 1; i <filecount; i++) {
		driver.findElement(By.xpath("//div[@class='example']//a["+i+"]")).click();
		
	}
	
	//driver.findElement(By.xpath("//a[text()='webdriverIO.png']")).click();
	Thread.sleep(2000);
File listoffile[]=folder.listFiles();


Thread.sleep(2000);

File listOfFiles[]=folder.listFiles();

Assert.assertEquals(listOfFiles.length>0, false);

for(File file:listOfFiles){

	Assert.assertTrue(file.length()>0);

}
//Assert.assertEquals(listoffile.length, is(not(0)));
//for(File file:listoffile) {
//	Assert.assertEquals(file.length(), is(not((long)0)));
//}
}
	
	
//	@AfterMethod
//	public void tearDown() {
//		
//		driver.quit();
//		for(File file: folder.listFiles()) {
//			file.delete();
//			
//		}
//	}
	
	
	
	
	//public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver", ".\\exefiles\\chromedriver.exe");
//		
//		//=new ChromeDriver();
//		
//		driver.manage().window().maximize();
//		
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		driver.get("https://akashtestrail.testrail.io/index.php?/suite

	//}

}
