package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomePage {
	WebDriver driver;
	
	By SearchBox = By.name("query");
	
	public PortalHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
	}
	public WebElement searchBox()
	{
		return driver.findElement(SearchBox);
	}
	
}

