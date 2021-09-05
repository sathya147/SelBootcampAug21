package week3day2UsingBaseClass;

import org.testng.annotations.Test;

public class ForAdditonalCases extends BaseClass {

	@Test
	public void enterCredentials()  {
		
		driver.get("https://login.salesforce.com/");
			
		findByIDandPassValue("username", "matschie@testleaf.com"); 
		findByIDandPassValue("password", "SelBootcamp$123"); 
	}
	
	@Test
	public void enterUsername()  {

		driver.get("https://login.salesforce.com/");
		
		findByIDandPassValue("username", "uses Same Browser"); 
	}

}
