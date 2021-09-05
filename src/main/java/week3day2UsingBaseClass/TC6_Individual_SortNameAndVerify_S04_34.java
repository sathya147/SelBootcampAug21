package week3day2UsingBaseClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC6_Individual_SortNameAndVerify_S04_34 {

	@Test()
	public void individualSortByName() throws InterruptedException, StaleElementReferenceException  {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options); 
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		List<String> displayedList = new ArrayList<String>();  
		List<String> sortedList = new ArrayList<String>();  
		
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
		
		//Click on column 'Name' 
		List<WebElement> namesDisplayedList = driver.findElements(By.xpath("//tbody//a[contains(@href,'lightning')]"));
		//storing the displayed list in ArrayList
		for (WebElement each : namesDisplayedList) {
			//System.out.print(each.getText().toLowerCase()); 
			displayedList.add(each.getText().toLowerCase());
		}
		/*
		 * Karthik suggested to get the displayed list of name and sort it.  The click the table to sort, collect that sorted list 
		 * in a new List then compare to see if they are equal.  
		 */
		Collections.sort(displayedList);
		System.out.print("displaying after sort" +displayedList);
		System.out.println();
		
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[@class='slds-truncate' and text()='Name']")));
		Thread.sleep(7000);
		List<WebElement> namesSortedList = driver.findElements(By.xpath("//tbody//a[contains(@href,'lightning')]"));
		//storing the sorted list in ArrayList
		for (WebElement each : namesSortedList) {
			System.out.print(each.getText().toLowerCase()); 
			sortedList.add(each.getText().toLowerCase());
		}
		
		//verify if names are sorted 
		if (displayedList.equals(sortedList)) {
			System.out.println("Names are sorted");	
		}
		else {
			System.out.println("Names are not sorted");
		}
		
    	System.out.println("end of script");
		

		
	}

}
