package stepDefination;



import org.testng.Assert;

import Resources.base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.PortalHomePage;

public class stepDefinition extends base {
	
	@Given("^Initialize the browser$")
	public void initialize_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = inititalizeBrowser();
		
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);    // get the website name from the arguments
		System.out.println(arg1);
	}

	@Given("^click on login link in home page to to land on secure sign in Page$")
	public void click_on_login_link_in_home_page_to_to_land_on_secure_sign_in_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage l = new LandingPage(driver);
		l.Login().click();       //On home page click on the login tab
		System.out.println("Mahesh");
	}

	
	 @When("^User enters (.+) and (.+) and logs in$")
	    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		 LoginPage lp = new LoginPage(driver);
			lp.email().sendKeys(username);  
			lp.passwd().sendKeys(password);   // Enter Username and Password coming from the table
			lp.loginButton().click();     //click on login button
			System.out.println("Korade");
	    }

	@Then("^verify that user has successfully logged in$")
	public void verify_that_user_has_successfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   PortalHomePage p = new PortalHomePage(driver);
	   Assert.assertTrue(p.searchBox().isDisplayed());   // asserting whether the login successful or not
	   
	}
	
	 @And("^close the broswer$")
	    public void close_the_broswer() throws Throwable {
	      driver.quit();   //browser will be closed
	   
	    }


}
