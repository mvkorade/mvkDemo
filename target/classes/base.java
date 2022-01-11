package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver inititalizeBrowser() throws IOException      
	{
	    prop = new Properties();
	    
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
        prop.load(fis);
      // String BrowserName = System.getProperty("browser");
      String BrowserName = prop.getProperty("Browser");
       System.out.println(BrowserName);
       if(BrowserName.contains("chrome"))
       {
    	   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver.exe");
    	   ChromeOptions option = new ChromeOptions();
    	   if(BrowserName.contains("headless"))
    	   {
    	   option.addArguments("headless");
    	   }
    	   driver = new ChromeDriver(option);
    	   //Initializing chrome driver
       }
       else if(BrowserName.equalsIgnoreCase("Firefox"))
       {
    	   System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\geckodriver.exe");
    	   driver = new FirefoxDriver();
    	   
       }
       else if(BrowserName.equalsIgnoreCase("IE"))
       {
    	   System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\IEDriverServer.exe");
    	   driver = new InternetExplorerDriver();
       }
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       return driver;
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\resources\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		 
		return destinationFile;
	}
	
}
