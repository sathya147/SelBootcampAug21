package week3day1ConverPlainVanillaScriptsToTestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC2_Individual_Edit_S04_31 {

	@Test
	public void editIndividual() throws InterruptedException  {
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
//		js.executeScript("arguments[0].scrollIntoView();", elementIndividual); //option 1 - to click by scrolling to element
//		elementIndividual.click();
//		js.executeScript("arguments[0].click()", elementIndividual);  //option 2 - to use jsExecutor and click alone
		//option 3 - clicking the element using Action Class
		Actions actions = new Actions(driver); 
		actions.moveToElement(elementIndividual).click().perform(); 
		
		driver.findElement(By.xpath("//input[@name='Individual-search-input']")).sendKeys("Jeyaraj");
		driver.findElement(By.xpath("//input[@name='Individual-search-input']")).sendKeys(Keys.ENTER);
		Thread.sleep(7000);
		//click on down arrow of first record
		driver.findElement(By.xpath("//span[@class='slds-truncate' and @title='Name']/ancestor::table[@data-aura-class='uiVirtualDataTable']//tbody//tr[1]/td[6]")).click();
		//clicking Edit
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		
		//selecting "Mr" in Salutation
		driver.findElement(By.xpath("//span[text()='Salutation']/following::a[@class='select']")).click();
		List<WebElement> list_Salutation = driver.findElements(By.xpath("//div[@class='select-options']//li"));
		list_Salutation.get(1).click();
		
		
		//Enter First Name and save
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Sathya");
		driver.findElement(By.xpath("//div[@data-aura-class='forceRecordEditActions']//span[text()='Save']")).click();
		
		String stringOf_individualEditedResult = driver.findElement(By.partialLinkText("Sathya")).getText(); 
		
		if (stringOf_individualEditedResult.contains("Sathya")) {
			System.out.println("Individual is edited successfully");
		}
		else {
			System.out.println("Individual was not edited as expected");
		}


		
	}

}
