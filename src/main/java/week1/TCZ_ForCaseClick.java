package week1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/*public class TCZ_ForCaseClick {

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
//		System.out.println(driver.findElement(By.xpath("//span[text()='Cases']")).isDisplayed());
//		System.out.println(driver.findElement(By.xpath("//span[text()='Cases']")).isEnabled());
		WebElement cases = driver.findElement(By.xpath("//span[text()='Cases']")); 
		js.executeScript("arguments[0].click()", cases);

		
		
		 //need to scroll page for visibility
		WebElement elementIndividual = driver.findElement(By.xpath("//p[@class='slds-truncate' and text()='Individuals']")); 
//		js.executeScript("arguments[0].scrollIntoView();", elementIndividual); //option 1 - to click by scrolling to element
//		elementIndividual.click();
//		js.executeScript("arguments[0].click()", elementIndividual);  //option 2 - to use jsExecutor and click alone
		//option 3 - clicking the element using Action Class
		Actions actions = new Actions(driver); 
		actions.moveToElement(elementIndividual).click().perform(); 
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Muthumariappan");
		driver.findElement(By.xpath("//div[@data-aura-class='forceRecordEditActions']//span[text()='Save']")).click();
		WebElement individualCreated_Success = driver.findElement(By.xpath("//span[text()='We found no potential duplicates of this Individual.']")); 
		String stringOf_individualCreatedResult = individualCreated_Success.getText();  
		System.out.println(stringOf_individualCreatedResult);
		String stringOf_individualSuccessfullyCreated = "We found no potential duplicates of this Individual."; 
		
		if (stringOf_individualCreatedResult.equalsIgnoreCase(stringOf_individualSuccessfullyCreated)) {
			System.out.println("New Individual is successfully created");
		}
		else {
			System.out.println("New Individual was not created");
		}
		
		

		
	}

}
*/

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
//		Select dropdown = new Select(driver.findElement(By.xpath("//*[text()='Show more actions']")));  
//		dropdown.selectByVisibleText("Edit");  
		WebElement moreactions=driver.findElement(By.xpath("//tbody/tr/td[7]"));
		moreactions.click();
//		System.out.println("More actions clicked successfully");
//		Thread.sleep(2000);
//		WebElement edit=driver.findElement(By.xpath("//div[text()='Edit']"));
//		edit.click();
//		System.out.println("Edit button clicked successfully");
		

	}

}