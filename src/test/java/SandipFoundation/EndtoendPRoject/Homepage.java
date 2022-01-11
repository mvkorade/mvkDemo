package SandipFoundation.EndtoendPRoject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import junit.framework.Assert;
import pageObject.ForgotPassword;
import pageObject.LandingPage;
import pageObject.LoginPage;

public class Homepage extends base {
	private static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void openURL() throws IOException {
		driver = inititalizeBrowser();
		log.info("Driver is initialized");
		

	}

	@Test(dataProvider = "getData")
	public void basepageNavigation(String username, String Password) {
		driver.get(prop.getProperty("url"));
		log.info("Navigated to URL");
		LandingPage l = new LandingPage(driver);
		l.Login().click();
		LoginPage lp = new LoginPage(driver);
		lp.email().sendKeys(username);
		lp.passwd().sendKeys(Password);
		lp.loginButton().click();
		ForgotPassword fp = lp.forgotpassword();
		fp.email().sendKeys("korademaheshv@gmail.com");
		fp.next().click();
		log.info("Login Page is successfully validated for restricted and Non Restricted User");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "nonrestircted@gmail.com";
		data[0][1] = "12345";
		
		data[1][0] = "restircted@gmail.com";
		data[1][1] = "1234534";

		return data;
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
