package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	static ExtentReports er;
	public static ExtentReports getReportObject()
	{
	
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter =  new ExtentSparkReporter(path);
		reporter.config().setReportName("Framework test automation");
		reporter.config().setDocumentTitle("framework result");
		
		er = new ExtentReports();
		er.attachReporter(reporter);
		er.setSystemInfo("Tester", "Mahesh Korade");
		return er;
				
}
}