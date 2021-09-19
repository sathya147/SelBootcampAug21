package week4day1DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviders extends BaseClass {

	@DataProvider(name="openMultipleURLs")
	public String[][] provideTestURL() {
		String[][] urls = new String[3][1]; 
		
		urls[0][0] = "https://mcwebtest.iscorp.com/tda"; 
		urls[1][0] = "https://mcwebtest.iscorp.com/prudential";
		urls[2][0] = "https://mcwebtest.iscorp.com/newyorklife"; 
		
		return urls;
	}
	
	@DataProvider(name="names")
	public String[] provideCaseData() {
		
		String[] names = new String[3]; 
		
		names[0] = "Muthumariappan"; 
		names[1] = "Manoharan"; 
		names[2] = "Muthukumaran"; 
		
		return names;
				
	}

	

}
