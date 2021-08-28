package week1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01_WorkTypeGroups_Create_S04_36 {

	public static void main(String[] args)  {
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
		//need to scrill page for visibility
		WebElement elementWorkTypeGroups = driver.findElement(By.xpath("//p[@class='slds-truncate' and text()='Work Type Groups']")); 
		js.executeScript("arguments[0].scrollIntoView();", elementWorkTypeGroups); //option 1 - to click by scrolling to element
		elementWorkTypeGroups.click(); 

		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//label/span[text()='Work Type Group Name']/../following-sibling::input")).sendKeys("Sathya WTG name");
		driver.findElement(By.xpath("//button[@data-aura-class='uiButton forceActionButton']/span[text()='Save']")).click();
		WebElement success_WTGcreated = driver.findElement(By.xpath("//div[@data-aura-class='forceToastMessage']")); 
		String stringOf_WTGcreatedResult = success_WTGcreated.getText(); 
		String stringOf_WTGsuccessfullyCreated = "Work Type Group \"Sathya WTG name\" was created."; 
		
		System.out.println(stringOf_WTGcreatedResult);
		
		//if (stringOf_WTGcreatedResult.contains(stringOf_WTGsuccessfullyCreated)) {
		if (stringOf_WTGcreatedResult.contains("Work Type Group") && stringOf_WTGcreatedResult.contains("was created")) {
			System.out.println("Work Type Group is successfully created");
		}
		else {
			System.out.println("Work Type Group was not created");
		}
		
/*		WebElement individualCreated_Success = driver.findElement(By.xpath("//span[text()='We found no potential duplicates of this Individual.']")); 
		String stringOf_individualCreatedResult = individualCreated_Success.getText();  
		System.out.println(stringOf_individualCreatedResult);
		String stringOf_individualSuccessfullyCreated = "We found no potential duplicates of this Individual."; 
		
		if (stringOf_individualCreatedResult.equalsIgnoreCase(stringOf_individualSuccessfullyCreated)) {
			System.out.println("New Individual is successfully created");
		}
		else {
			System.out.println("New Individual was not created");
		}
*/		
		

		
	}

}
