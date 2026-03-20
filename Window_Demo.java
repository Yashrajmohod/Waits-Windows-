package Com.Switch;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Window_Demo {
	@Test
	public void testMultipleWindows() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com");
		//driver.get("https://www.amazon.in/");
		

		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		
		WebElement Link = driver.findElement(By.linkText("Myntra"));
		Link.click();
		WebElement Link1 = driver.findElement(By.linkText("Shopsy"));
		Link1.click();
		
		
		//System.out.println(driver.getTitle());
		
		//to get Title of the WebSite 
		//String Id = driver.getWindowHandle();
		//System.out.println(Id);
		
		///Code of Window id or WebSite of the Decalare webSite
		//9354ED6736F78588309721721FE70A58
		
		///Switch one tab to Another tab or Multiple Windows 
		///This method only of get multiple Window id 
		///Searching in NOT Possible in Set Method 
		Set<String> MultipleWindowIDs =  driver.getWindowHandles();
		
		///Searching in Possible in List Method
		///For Searching we Use In List, That is Get method on Index Value
		//List<String> SearchWindowID = new ArrayList<String>(MultipleWindowIDs);
		//String MytraID = SearchWindowID.get(1);
		//driver.switchTo().window(MytraID);
		//System.out.println(driver.getTitle());
		
		for(String id : MultipleWindowIDs) {
			driver.switchTo().window(id);
			String allTitle = driver.getTitle();
			if (allTitle.contains("Myntra")) {
				WebElement SearchBar = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
				SearchBar.sendKeys("Samsung S26 Ultra", Keys.ENTER);				
			}
		}
		
	}

}
