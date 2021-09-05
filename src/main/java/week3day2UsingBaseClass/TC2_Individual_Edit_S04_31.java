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

public class TC2_Individual_Edit_S04_31 extends BaseClass {

	@Test
	public void editIndividual() throws InterruptedException {
	
//		driver.get("https://login.salesforce.com/");
		findByIDandPassValue("username", "matschie@testleaf.com"); 
		findByIDandPassValue("password", "SelBootcamp$123"); 
		findByIDandClick("Login"); 
		
		findByClassNameAndClick("slds-icon-waffle");
		findByXpathandClick("//button[@class='slds-button']");
		//need to scroll page for visibility
		WebElement elementIndividual = findByXpath("//p[@class='slds-truncate' and text()='Individuals']"); 
		jsExecutorClick(elementIndividual);

		findByXpathandPassValue("//input[@name='Individual-search-input']", "Jeyaraj");
		findByXpathandPassKeys("//input[@name='Individual-search-input']", Keys.ENTER);
		Thread.sleep(7000);
		//click on down arrow of first record
		findByXpathandClick("//span[@class='slds-truncate' and @title='Name']/ancestor::table[@data-aura-class='uiVirtualDataTable']//tbody//tr[1]/td[6]");
		//clicking Edit
		findByXpathandClick("//a[@title='Edit']");
		
		//selecting "Mr" in Salutation
		findByXpathandClick("//span[text()='Salutation']/following::a[@class='select']");
//		List<WebElement> list_Salutation = findsByXpath("//div[@class='select-options']//li");
		listOfWebElements = findsByXpath("//div[@class='select-options']//li");
		listOfWebElements.get(1).click();
		
		
		//Enter First Name and save
		findByXpathandClear("//input[@placeholder='First Name']");
		findByXpathandPassValue("//input[@placeholder='First Name']", "Sathya");
		findByXpathandClick("//div[@data-aura-class='forceRecordEditActions']//span[text()='Save']");
		
		String stringOf_individualEditedResult = driver.findElement(By.partialLinkText("Sathya")).getText(); 
		
		if (stringOf_individualEditedResult.contains("Sathya")) {
			System.out.println("Individual is edited successfully");
		}
		else {
			System.out.println("Individual was not edited as expected");
		}


		
	}

}
