package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreports {
static ExtentReports extentreport;

public static ExtentReports getExtentReport()
{
	String extentreportspath=System.getProperty("user.dir")+"\\reports\\extentreport.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(extentreportspath);
	reporter.config().setReportName("tutorials ninja test results");
	reporter.config().setDocumentTitle("Test results");
	
	extentreport=new ExtentReports();
	extentreport.attachReporter(reporter);
	extentreport.setSystemInfo("operatingsystem", "windows10");
	extentreport.setSystemInfo("testedby", "jay");
	
	return extentreport;
	
	
	
}
}
