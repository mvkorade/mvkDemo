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

public class validateNavigationBar extends base {
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void openURL() throws IOException {
		driver = inititalizeBrowser();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void basepageNAvBarStatus() throws IOException {
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNav().isDisplayed());
		log.info("Navigetion Bar is displayed");
		
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}