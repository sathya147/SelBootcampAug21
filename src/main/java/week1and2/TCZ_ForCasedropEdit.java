package week1and2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TCZ_ForCasedropEdit {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options); 
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		
		driver.get("https://login.salesforce.com/");
			
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS); 
		
		driver.findElement(By.id("username")).sendKeys("matschie@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.className("slds-icon-waffle")).click();
//		driver.findElement(By.className("slds-button")).click();  //for some reason this did not work and neither did it show error, but using xpath in next line worked
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
//		driver.findElement(By.className("slds-truncate")).click(); //for some reason this did not work and neither did it show error, but using xpath in next line worked

//		Click on "Sales"
		driver.findElement(By.xpath("//p[@class='slds-truncate' and text()='Sales']")).click();
		
		//Click on 'More' dropdown
		driver.findElement(By.xpath("//span[@class='slds-p-right_small' and text()='More']")).click(); 
	
//		Thread.sleep(10000); 
		
		//Click on 'Cases'
		WebElement cases = driver.findElement(By.xpath("//span[text()='Cases']")); 
		js.executeScript("arguments[0].click()", cases);
		
		//clicking "Cases"
//		driver.findElement(By.xpath("//p[text()='Cases']")).click(); 
		
		//clicking on down arrow of the first  case
		driver.findElement(By.xpath("//tbody/tr/td[7]")).click();  

	
	}

}