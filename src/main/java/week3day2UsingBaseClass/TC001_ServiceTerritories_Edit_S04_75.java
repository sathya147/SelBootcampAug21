package week3day2UsingBaseClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_ServiceTerritories_Edit_S04_75 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options); 
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		
		driver.get("https://login.salesforce.com/");
			
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS); 
		
		driver.findElement(By.id("username")).sendKeys("matschie@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.className("slds-icon-waffle")).click();
//		driver.findElement(By.className("slds-button")).click();  //for some reason this did not work and neither did it show error, but using xpath in next line worked
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
//		driver.findElement(By.className("slds-truncate")).click(); //for some reason this did not work and neither did it show error, but using xpath in next line worked
		
		//need to scroll page for visibility then click on 'Service Territories'
		WebElement elementIndividual = driver.findElement(By.xpath("//p[@class='slds-truncate' and text()='Service Territories']")); 
		Actions actions = new Actions(driver); 
		actions.moveToElement(elementIndividual).click().perform(); 
		
		Thread.sleep(10000);
		
		/*
		 * creating a for loop to navigate through the table and choose required data/value. 
		 * This table had rows <tr> and within rows, has columns with two different tags <td> and <th> 
		 * <th> for one row, as it acts as a link to open the details 
		 */
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@role='grid' and @data-aura-class='uiVirtualDataTable']//tbody/tr"));
		List<WebElement> columnsTD = driver.findElements(By.xpath("//table[@role='grid' and @data-aura-class='uiVirtualDataTable']//tbody/tr[1]/td"));
		List<WebElement> columnsTH = driver.findElements(By.xpath("//table[@role='grid' and @data-aura-class='uiVirtualDataTable']//tbody/tr[1]/th")); 
		
		System.out.println("number of rows: " + rows.size()); 
		System.out.println("number of columnsTD: " + columnsTD.size()); 
		System.out.println("number of columnsTH: " + columnsTH.size()); 
		
		for (int r = 1; r <= rows.size(); r++) {
 			List<WebElement> td = driver.findElements(By.xpath("//table[@role='grid' and @data-aura-class='uiVirtualDataTable']//tbody/tr[" + r +"]/td"));
			for (int cTD = 1; cTD < td.size(); cTD++) { 
//				System.out.print(td.get(cTD).getText() + "  |  ");
				if (cTD != 2) {
					System.out.print(td.get(cTD).getText() + "  |  ");
				}
				else {
						List<WebElement> th = driver.findElements(By.xpath("//table[@role='grid' and @data-aura-class='uiVirtualDataTable']//tbody/tr[" + r +"]/th")); 
						if (th.size() != 0) {
							System.out.print(th.get(0).getText() + "  |  ");
						}
						else {
							System.out.print("empty here");
						}
				}
			}
			System.out.println();
		}

		
		
	}

}
