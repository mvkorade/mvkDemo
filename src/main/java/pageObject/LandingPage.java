package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	
	private By signin = By.cssSelector("a[href*='sign_in']");
	private By title = By.xpath("//*[@id='content']/div/div/h2");
	private By navbar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	private By header = By.cssSelector("div[class*='video-banner'] h3");
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}

	public WebElement Login()
	{
		//driver.switchTo().alert().dismiss();
		 return driver.findElement(signin);
		
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}

	public WebElement getNav()
	{
		return driver.findElement(navbar);
	}
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}
	}
