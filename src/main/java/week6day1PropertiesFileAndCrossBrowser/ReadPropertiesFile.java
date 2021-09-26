package week6day1PropertiesFileAndCrossBrowser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadPropertiesFile {

	@Test
	public void properties() throws IOException {
		//set up the file path
		FileInputStream fis = new FileInputStream("./src/main/resources/TDAconfig.properties"); 

		//create object for Properties 
		Properties prop = new Properties(); 
		
		//load the .properties file
		prop.load(fis);

		//using the properties file to pass login information
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(); 
		driver.get(prop.getProperty("url"));
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
	
	}

}
