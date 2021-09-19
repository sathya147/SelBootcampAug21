package week4day1DataProvider;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC1_Individual_Create_S04_30 extends BaseClass {

	@Test(groups= {"salesforce", "needDriver"}, dataProvider="names", dataProviderClass = DataProviders.class)
	public void createIndividual(String individualName)  {

		
//		logging into sf application is done in baseclass using @BeforeMethod
//		loginSalesforce ("matschie@testleaf.com", "SelBootcamp$123", "https://login.salesforce.com/"); 
		
		salesforcePathLauncherAndViewAll();

		//need to scroll page for visibility
		WebElement elementIndividual = findByXpath("//p[@class='slds-truncate' and text()='Individuals']"); 
		actionsMoveToElementAndClick(elementIndividual);

		findByXpathandClick("//div[@title='New']");
		findByXpathandPassValue("//input[@placeholder='Last Name']", individualName);
		findByXpathandClick("//div[@data-aura-class='forceRecordEditActions']//span[text()='Save']");
		WebElement individualCreated_Success = findByXpath("//span[text()='We found no potential duplicates of this Individual.']");  
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
