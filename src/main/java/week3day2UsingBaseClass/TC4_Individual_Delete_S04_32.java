package week3day2UsingBaseClass;

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

public class TC4_Individual_Delete_S04_32 {

	@Test
	public void deleteIndividual() throws InterruptedException  {
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
		js.executeScript("arguments[0].scrollIntoView();", elementIndividual); //option 1 - to click by scrolling to element
		elementIndividual.click();
		
		driver.findElement(By.xpath("//input[@name='Individual-search-input']")).sendKeys("Muthumariappan ");
		driver.findElement(By.xpath("//input[@name='Individual-search-input']")).sendKeys(Keys.ENTER);
		Thread.sleep(7000);
		//click on down arrow of first record
		driver.findElement(By.xpath("//span[@class='slds-truncate' and @title='Name']/ancestor::table[@data-aura-class='uiVirtualDataTable']//tbody//tr[1]/td[6]")).click();
		//clicking Delete
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		//confirming Delete in pop up
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		
		String stringOf_individualDeleteResult = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText(); 
		
		if (stringOf_individualDeleteResult.contains("No items to display.")) {
			System.out.println("Individual was deleted successfully");
		}
		else {
			System.out.println("Individual was not deleted");
		}


		
	}

}
