package week4day1Parametrization;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ForAdditonalCases extends BaseClass {

	@Parameters({"tdaurl"})
	@Test
	public void enterCredentials(String url)  {
		
		driver.get(url);
			
//		findByIDandPassValue("username", "matschie@testleaf.com"); 
//		findByIDandPassValue("password", "SelBootcamp$123"); 
	}
	
	@Parameters({"prudurl"})
	@Test
	public void enterUsername(String url)  {

		driver.get(url);
		
//		findByIDandPassValue("username", "uses Same Browser"); 
	}

}
