package week1and2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_VerifyLegalEntitiesSortedBylastmodifieddate_S04_16 {

	public static void main(String[] args)  throws InterruptedException {
		
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
		
		//clicking on 'Legal Entities'  
		WebElement elementIndividual = driver.findElement(By.xpath("//p[@class='slds-truncate' and text()='Legal Entities']")); 
		js.executeScript("arguments[0].click()", elementIndividual); 
		
		//collecting displayed list of dates into 'displayedList' object 
		List<WebElement> datesDisplayedList  = driver.findElements(By.xpath("//tbody//span[@class='slds-truncate uiOutputDateTime']")); 
		
		for (WebElement each : datesDisplayedList) {
			displayedList.add(each.getText()); 
		}
//		System.out.println("before sort: " +displayedList);
		Collections.sort(displayedList);
//		System.out.println("after sort: " +displayedList);
		
		//click on column 'Last Modified Date' to sort it
		WebElement columnLMDate = driver.findElement(By.xpath("//span[text()='Last Modified Date']"));
		/*
		 * For the test case, we are clicking the column 'LastModifiedDate' twice. 
		 * Since on the first click it does not sort.  Only on the second click it sorts. 
		 */
		js.executeScript("arguments[0].click()", columnLMDate); 
		Thread.sleep(3000); 
		js.executeScript("arguments[0].click()", columnLMDate); 
		Thread.sleep(3000); 
		//collect sorted list of dates into 'sortedList' object 
		List<WebElement> datesSortedList  = driver.findElements(By.xpath("//tbody//span[@class='slds-truncate uiOutputDateTime']")); 
		
		for (WebElement each : datesSortedList) {
			sortedList.add(each.getText()); 
//			System.out.println("after site sort: " +each.getText());
		}
		System.out.println(sortedList);
		
		//verify if the dates are sorted
		if (displayedList.equals(sortedList)) {
			System.out.println("Last Modified Dates are sorted");
		}
		else {
			System.out.println("Last Modified Dates are not sorted");
		}
		
		
		
	}

}
