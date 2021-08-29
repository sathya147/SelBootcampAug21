package week1and2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TCZ_ForCaseClick 
{

	public static void main(String[] args) throws Exception 
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
//		System.setProperty("webdriver.chrome.driver","./drivers/chromerdriver.exe");
//		WebDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("matschie@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		Thread.sleep(3000);
		WebElement login=driver.findElement(By.id("Login"));
		login.click();
		System.out.println("Salesforce page logged in successfully");
		Thread.sleep(8000);
		WebElement toggle=driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		toggle.click();
		System.out.println("Toggle all link clicked successfully");
		Thread.sleep(5000);
		WebElement all=driver.findElement(By.xpath("//button[text()='View All']"));
		all.click();
		System.out.println("View All link clicked successfully");
		Thread.sleep(5000);
		WebElement Sales=driver.findElement(By.xpath("//p[text()='Sales']"));
		Sales.click();
		System.out.println("Sales link clicked successfully");
		Thread.sleep(7000);
		WebElement more=driver.findElement(By.xpath("//*[text()='More']"));
		more.click();
		System.out.println("More tab clicked successfully");
		Thread.sleep(8000);
		WebElement cases=driver.findElement(By.xpath("//span[text()='Cases']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", cases);
		System.out.println("Cases link clicked successfully");
		Thread.sleep(8000);
		WebElement moreactions=driver.findElement(By.xpath("//tbody/tr/td[7]"));
		moreactions.click();
		System.out.println("More actions clicked successfully");
		Thread.sleep(2000);
		WebElement edit=driver.findElement(By.xpath("//div[text()='Edit']"));
		js.executeScript("arguments[0].click()", edit); 
		System.out.println("Edit button clicked successfully");
		

	}

}