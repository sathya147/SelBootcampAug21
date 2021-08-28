package week1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_ServiceTerritories_Create_S04_74 {

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
		
		//need to scroll page for visibility then click on 'Service Territories'
		WebElement elementIndividual = driver.findElement(By.xpath("//p[@class='slds-truncate' and text()='Service Territories']")); 
		Actions actions = new Actions(driver); 
		actions.moveToElement(elementIndividual).click().perform(); 
		
		//Click on new
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		//Enter Name 
		driver.findElement(By.xpath("//label[@data-aura-class='uiLabel']/following-sibling::input")).sendKeys("Muthumariappan");
		
		//Choosing Operating Hours drop down's first option
		driver.findElement(By.xpath("//input[@title='Search Operating Hours']")).click(); 
		Thread.sleep(3000); 
		driver.findElements(By.xpath("//span[text()='Operating Hours']/following-sibling::span[text()='*']/../following-sibling::div//li")).get(0).click();
		
		//Check Active checkbox
		driver.findElement(By.xpath("//span[text()='Active']/parent::label/following-sibling::input")).click(); 
		
		//Enter City 
		driver.findElement(By.xpath("//input[@placeholder='City']")).sendKeys("Sartell");
		
		//Enter  State
		driver.findElement(By.xpath("//input[@placeholder='State/Province']")).sendKeys("Minnesota");
		
		//Enter Country 
		driver.findElement(By.xpath("//input[@placeholder='Country']")).sendKeys("USA");
		
		//Enter Postal Code 
		driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']")).sendKeys("56337");
		
		//Click Save
		driver.findElement(By.xpath("//div[@data-aura-class='forceRecordEditActions']//span[text()='Save']")).click();
		
		String stringOf_STcreated = driver.findElement(By.xpath("//span[contains(text(), 'Service Territory')]")).getText(); 
		System.out.println(stringOf_STcreated);
		if (stringOf_STcreated.equals("New Service Territory")) {
			System.out.println("Service Territory is successfully created");
		}
		else {
			System.out.println("Service Territory was not created");
		}
	}

}
