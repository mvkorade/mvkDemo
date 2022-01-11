package SandipFoundation.EndtoendPRoject;

import java.io.IOException;

import javax.annotation.concurrent.ThreadSafe;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReportNG;
import Resources.base;

public class Listeners extends base implements ITestListener {
	 ExtentTest test;
	WebDriver driver = null;    
	ExtentReports extent = ExtentReportNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
   
	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		
		


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
	 
		extentTest.get().fail(result.getThrowable());
		 
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
		} 
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver),testMethodName); 
			//getScreenShotPath(testMethodName,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		
	}


	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

}
