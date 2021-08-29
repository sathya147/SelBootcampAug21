package week1and2;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_VerifyAppStoreLoaded_S04_62 {

	public static void main(String[] args)  throws InterruptedException {
		
		String urlToVerify = "https://apps.apple.com/us/app/salesforcea/id";
		
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
		
		//click on the sliding arrow. Clicking till Download Salesforce is visible
		WebElement salesforceLink = driver.findElement(By.xpath("//span[text()='Download SalesforceA']")); 
		while (salesforceLink.isDisplayed() == false) {
			js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[text()='Scroll Right']"))); 
			Thread.sleep(3000);
		}
		
		//clicking on App Store link
		driver.findElement(By.xpath("//span[text()='App Store']")).click();
		
		//Navigating to the new tab and clicking on 'Confirm'
		Set<String> windows = driver.getWindowHandles(); 
		
		for (String each : windows) {
			driver.switchTo().window(each); 
		}
		
		//verifying the loaded URL 
		driver.findElement(By.xpath("//button[text()='Confirm']")).click(); 
		System.out.println(driver.getCurrentUrl());
		String loadedURL = driver.getCurrentUrl().substring(0, 44); 
		
		if (urlToVerify.contains(loadedURL)) {
			System.out.println("Expected URL is loaded");
		}
		else {
			System.out.println("URL loaded is not as expected");
		}
			
	}

}
