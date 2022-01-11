package SandipFoundation.EndtoendPRoject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import junit.framework.Assert;
import pageObject.LandingPage;
import pageObject.LoginPage;

public class validateTitle extends base{

	public WebDriver driver;
	private static Logger log = LogManager.getLogger(base.class.getName());
	LandingPage l;
	@BeforeTest
	public void openURL() throws IOException {
		driver = inititalizeBrowser();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void validateTitleonpage() throws IOException
	{
		l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES");
		log.info("Varified title successfully");
	}
	
	@Test
	public void validateHeader() 
	{
		l = new LandingPage(driver);
		Assert.assertEquals(l.getHeader().getText(),"AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Varified header successfully");
	}
	
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}