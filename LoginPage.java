package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	By email = By.xpath("//input[@type='email']");
	By password = By.cssSelector("#user_password");
	By LoginButton = By.xpath("//input[@name='commit']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
	}
	public WebElement email()
	{
		return driver.findElement(email);
	}
	public WebElement passwd()
	{
		return driver.findElement(password);
	}
	public WebElement loginButton()
	{
		return driver.findElement(LoginButton);
	}
}