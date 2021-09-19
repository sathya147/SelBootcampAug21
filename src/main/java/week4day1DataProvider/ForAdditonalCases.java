package week4day1DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ForAdditonalCases extends BaseClass {

	@Test(dataProvider= "openMultipleURLs", dataProviderClass = DataProviders.class, groups= {"needDriver"})
	public void enterCredentials(String url)  {
		
		driver.get(url);
	}
	
	@Parameters({"transurl"})
	@Test
	public void enterTsername(String url)  {

		driver.get(url);
	}
	
	
	@Test(dataProvider="names", dataProviderClass = DataProviders.class, groups= {"noDriver"})
	public void openURLs (String names)  {
		
//		driver.get(url);
		System.out.println(names);
	}
	

}
