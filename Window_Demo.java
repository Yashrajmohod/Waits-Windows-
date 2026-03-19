package Com.Switch;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Window_Demo {
	@Test
	public void testMultipleWindows() {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com");
		//driver.get("https://www.amazon.in/");
		
		
		driver.manage().window().maximize();
		
		
		WebElement Link = driver.findElement(By.linkText("Myntra"));
		//WebElement Link = driver.findElement(By.linkText("Facebook"));
		Link.click();
		
		
		//System.out.println(driver.getTitle());
		
		//to get Title of the WebSite 
		//String Id = driver.getWindowHandle();
		//System.out.println(Id);
		
		//9354ED6736F78588309721721FE70A58
		
		//Switch one tab to Another tab or Multiple Windows 
		Set<String> MultipleWindowIDs =  driver.getWindowHandles();
		//List<String> SearchWindowID = new ArrayList<String>(MultipleWindowIDs);
		//String MytraID = SearchWindowID.get(1);
		//driver.switchTo().window(MytraID);
		//System.out.println(driver.getTitle());
		
		for (String id : MultipleWindowIDs) {
			driver.switchTo().window(id);
			String allTitle = driver.getTitle();
			if (allTitle.contains("Myntra"))
				;
			
		}
		
	}

}
