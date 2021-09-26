package forexcelreader;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TC1_Individual_Create_S04_30_ForEXCEL extends forexcelreader.BaseClass {

	@BeforeTest
	public void setExcelFileName() {
		System.out.println("Does the suite execute? ");
		excelFileName = "week4day2Create"; 
		System.out.println("does it assign: " +excelFileName);
	}
	
	@Test(groups= {"needDriver"}, dataProvider="testData", dataProviderClass=BaseClass.class)
	public void createIndividual(String lastName)  {

		System.out.println("#############   sathya here test case 1   " + driver);
		salesforcePathLauncherAndViewAll();

		//need to scroll page for visibility
		WebElement elementIndividual = findByXpath("//p[@class='slds-truncate' and text()='Individuals']"); 
		actionsMoveToElementAndClick(elementIndividual);

		findByXpathandClick("//div[@title='New']");
		findByXpathandPassValue("//input[@placeholder='Last Name']", lastName);
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
