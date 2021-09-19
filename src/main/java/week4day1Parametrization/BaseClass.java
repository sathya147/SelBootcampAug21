package week4day1Parametrization;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver; 
	public JavascriptExecutor js;  
	public Actions actions; 
	
	public List<WebElement> listOfWebElements; 
	
	@BeforeClass()
	public void initiateDriver() {
	
		System.out.print("base class ");
		System.err.println("method is executed");
		WebDriverManager.chromedriver().setup(); 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications"); 
		driver = new ChromeDriver(options); 
		driver.manage().window().maximize();
		js  = (JavascriptExecutor) driver; 
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS); 
		
		//navigate to site
//		driver.get("https://login.salesforce.com/");
		
	}
	
	/*
	 * JavaScript executor - element click
	 */
	public void jsExecutorClick (WebElement element) {
		js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click()", element); 
	}
	
	/*
	 * JavaScript executor - scroll into view and click
	 */
	public void jsExecutorScrollIntoViewAndClick (WebElement element) {
		js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].scrollIntoView()", element); 
		element.click();
	}
	
	
	
	/*
	 * Actions object.  Move To Element action performed and clicked 
	 */
	public void actionsMoveToElementAndClick (WebElement element) {
		actions = new Actions(driver); 
		actions.moveToElement(element).click().build().perform(); 
	}
	
	
	/* *************************************************************
	 * FIND ELEMENT (single element locators to follow) 
	 *************************************************************** */
	
	
	
	/*
	 * This method is to find an element using ID.
	 */
	public void findByID (String id) {
		driver.findElement(By.id(id)); 
	}
	
	/*
	 * This method is to find an element using ID and pass text to the field.  
	 */
	public void findByIDandPassValue (String id, String strValue) {
		driver.findElement(By.id(id)).sendKeys(strValue);   
	}
	
	/*
	 * This method is to find an element using ID and pass keyboard action to the field.  
	 */
	public void findByIDandPassKeys (String id, Keys keyValue) {
		driver.findElement(By.id(id)).sendKeys(keyValue);   
	}
	
	/*
	 * This method is to find an element using ID and click.
	 */
	public void findByIDandClick (String id) {
		driver.findElement(By.id(id)).click(); 
	}
	
	/*
	 * This method is to find an element using ID and click.
	 */
	public void findByIDandClear (String id) {
		driver.findElement(By.id(id)).clear(); 
	}

	
	
	/*
	 * This method is to find an element using name.
	 */
	public void findByName (String name) {
		driver.findElement(By.name(name)); 
	}
	
	/*
	 * This method is to find an element using Name and pass text to the field.  
	 */
	public void findByNameandPassValue (String name, String strValue) {
		driver.findElement(By.name(name)).sendKeys(strValue);   
	}
	
	/*
	 * This method is to find an element using Name and pass Keyboard action to the field.  
	 */
	public void findByNameandPassKeys (String name, Keys keyValue) {
		driver.findElement(By.name(name)).sendKeys(keyValue);   
	}
	
	/*
	 * This method is to find an element using Name and click.
	 */
	public void findByNameandClick (String name) {
		driver.findElement(By.name(name)).click(); 
	}
	
	/*
	 * This method is to find an element using Name and click.
	 */
	public void findByNameandClear (String name) {
		driver.findElement(By.name(name)).clear(); 
	}
	
	
	
	/*
	 * This method is to find an element using xpath.
	 */
	public WebElement findByXpath (String xpath) {
		return driver.findElement(By.xpath(xpath)); 
	}
	
	/*
	 * This method is to find an element using xpath and pass text to the field.  
	 */
	public void findByXpathandPassValue (String xpath, String strValue) {
		driver.findElement(By.xpath(xpath)).sendKeys(strValue);   
	}
	
	/*
	 * This method is to find an element using xpath and pass Keyboard action to the field.  
	 */
	public void findByXpathandPassKeys (String xpath, Keys keyValue) {
		driver.findElement(By.xpath(xpath)).sendKeys(keyValue);   
	}
	
	/*
	 * This method is to find an element using xpath and click.
	 */
	public void findByXpathandClick (String xpath) {
		driver.findElement(By.xpath(xpath)).click(); 
	}
	
	/*
	 * This method is to find an element using xpath and click.
	 */
	public void findByXpathandClear (String xpath) {
		driver.findElement(By.xpath(xpath)).clear(); 
	}
	
	
	
	
	/*
	 * This method is to find an element using className.
	 */
	public void findByClassName (String className) {
		driver.findElement(By.className(className)); 
	}
	
	/*
	 * This method is to find an element using className and pass text to the field.  
	 */
	public void findByClassNameAndPassValue (String className, String strValue) {
		driver.findElement(By.className(className)).sendKeys(strValue);   
	}
	
	/*
	 * This method is to find an element using className and pass keyboard action to the field.  
	 */
	public void findByClassNameAndPassKeys (String className, Keys keyValue) {
		driver.findElement(By.className(className)).sendKeys(keyValue);   
	}
	
	/*
	 * This method is to find an element using className and click.
	 */
	public void findByClassNameAndClick (String className) {
		driver.findElement(By.className(className)).click(); 
	}
	
	/*
	 * This method is to find an element using className and click.
	 */
	public void findByClassNameAndClear (String className) {
		driver.findElement(By.className(className)).clear(); 
	}
	
	
	
	
	/* *************************************************************
	 * FIND ELEMENTS (multiple element locators to follow) 
	 *************************************************************** */

	/*
	 * This method is to find multiple elements using ID.
	 */
	public List<WebElement> findsByID (String id) {
		return driver.findElements(By.id(id)); 
	}
	
	/*
	 * This method is to find multiple elements using Name.
	 */
	public List<WebElement> findsByName (String name) {
		return driver.findElements(By.name(name)); 
	}
	
	/*
	 * This method is to find multiple elements using xpath.
	 */
	public List<WebElement> findsByXpath (String xpath) {
		return driver.findElements(By.xpath(xpath)); 
	}

	
	

	
	/* ****************************************************************************
	 * METHODS SPECIFIC TO APPLICATION 
	 * - LOGIN 
	 * - CLICKING COMMON PATHS
	 ****************************************************************************** */
	// strictly speaking, the below will be part of Base or Common Class, and the above methods will be part of wrapper classes 
	

	@Parameters({"sflogin", "sfpassword", "sfurl"})
	@BeforeMethod
	public void aloginSalesforce (String argLogin, String argPassword, String argURL) {
		System.out.println("sathya here");
		driver.get(argURL);
		findByIDandPassValue("username", argLogin); 
		findByIDandPassValue("password", argPassword); 
		findByIDandClick("Login"); 	
	}
	
	public void salesforcePathLauncherAndViewAll ( ) {
		findByClassNameAndClick("slds-icon-waffle");
		findByXpathandClick("//button[@class='slds-button']");
	}
	
	
	
	
}
