package week1and2PlainVanillaScripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC5_Individual_CreateWithoutMandatoryField_S04_33 {

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
		WebElement elementIndividual = driver.findElement(By.xpath("//p[@class='slds-truncate' and text()='Individuals']")); 
		js.executeScript("arguments[0].click()", elementIndividual);  //option 2 - to use jsExecutor and click alone
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		//selecting "Mr" in Salutation
		driver.findElement(By.xpath("//span[text()='Salutation']/following::a[@class='select']")).click();
		List<WebElement> list_Salutation = driver.findElements(By.xpath("//div[@class='select-options']//li"));
		list_Salutation.get(1).click();
		
		//Entering First Name and clicking Save
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Sathya");
		driver.findElement(By.xpath("//div[@data-aura-class='forceRecordEditActions']//span[text()='Save']")).click();
		
		//verify the alert message under Last Name
		WebElement alertForMissingLastName = driver.findElement(By.xpath("//li[text()='Complete this field.']")); 
		String stringOf_alertForMissingLastNameResult = alertForMissingLastName.getText();  
		System.out.println(stringOf_alertForMissingLastNameResult);
		
		
		if (stringOf_alertForMissingLastNameResult.equalsIgnoreCase("Complete this field.")) {
			System.out.println("Alert for missing Last Name is displayed");
		}
		else {
			System.out.println("Alert for missing Last Name is not displayed");
		}
		
		

		
	}

}
