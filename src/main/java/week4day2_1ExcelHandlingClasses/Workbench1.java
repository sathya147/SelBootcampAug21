package week4day2_1ExcelHandlingClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Workbench1 {

	public static void main(String[] args) throws Exception {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(chromeOptions);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("Saleforce page launched successfully");
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("matschie@testleaf.com");
		System.out.println("Username was entered successfully");
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("SelBootcamp$123");
		System.out.println("Password was entered successfully");
		WebElement login=driver.findElement(By.id("Login"));
		login.click();
		System.out.println("Salesforce page was logged in successfully");
		Thread.sleep(8000);
		WebElement toggle=driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		toggle.click();
		System.out.println("Toggle All link was clicked successfully");
		Thread.sleep(5000);
		WebElement viewall=driver.findElement(By.xpath("//button[text()='View All']"));
		viewall.click();
		System.out.println("View All link was clicked successfully");
		Thread.sleep(7000);
		WebElement worktypes=driver.findElement(By.xpath("(//p[text()='Work Types'])"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", worktypes);
		System.out.println("Work Type link was clicked successfully");
		Thread.sleep(5000);
		WebElement newworktype=driver.findElement(By.xpath("//div[text()='New']"));
		newworktype.click();
		System.out.println("New link was clicked successfully");
		Thread.sleep(5000);
		WebElement WTname=driver.findElement(By.xpath("//div[@class='uiInput uiInputText uiInput--default uiInput--input']/input"));
		WTname.sendKeys("Salesforce Project");
		System.out.println("Worktype name was entered successfully");
		WebElement WTDes=driver.findElement(By.className("textarea"));
		WTDes.sendKeys("Specimen");
		System.out.println("Description was entered successfully");
		WebElement search=driver.findElement(By.xpath("//div[@class='autocompleteWrapper slds-grow']/input"));
		search.click();
		System.out.println("Search box was clicked successfully");
		Thread.sleep(1000);
		WebElement NewOHrs=driver.findElement(By.xpath("//span[text()='New Operating Hours']"));
		NewOHrs.click();
		System.out.println("New Op-Hours link was clicked successfully");
		Thread.sleep(3000);
		WebElement NewOH=driver.findElement(By.xpath("(//div[@class='uiInput uiInputText uiInput--default uiInput--input']/input)[2]"));
		NewOH.sendKeys("UK Shift");
		System.out.println("New OHours was entered successfully");
		WebElement t=driver.findElement(By.xpath(("(//div[@class='select-options'])[6]")));
		Select select=new Select(t);
		select.selectByVisibleText("(GMT+01:00) British Summer Time (Europe/London)");
		WebElement opt=select.getFirstSelectedOption();
		String selopt=opt.getText();
		System.out.println("Element:"+selopt+"was selected successfully");
		WebElement save=driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']/span"));
		save.click();
		System.out.println("Operation Hours created successfully");
		Thread.sleep(3000);
		WebElement duration=driver.findElement(By.xpath("(//div/div/div/div/div/input)[4]"));
		duration.sendKeys("7");
		System.out.println("Duration value entered successfully");
		WebElement WTsave=driver.findElement(By.xpath("(//div/button/span)[11]"));
		WTsave.click();
		System.out.println("Work Type was saved successfully");
		

		

	}


}
