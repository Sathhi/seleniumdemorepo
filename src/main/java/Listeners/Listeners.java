package Listeners;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.Extentreports;
import resources.Base;

public class Listeners extends Base implements ITestListener{
	WebDriver driver=null;
	ExtentReports extentreport=Extentreports.getExtentReport();
	ExtentTest extenttest;
	ThreadLocal<ExtentTest> extenttestthread=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult tr)
{
		String testname=tr.getName();
		extenttest=extentreport.createTest(testname+"executon stareted");
		extenttestthread.set(extenttest);
		System.out.println("started");
		
}
	@Override
	public void onTestSuccess(ITestResult tr)
{
	extenttest.log(Status.PASS,"test passed");
//	extenttestthread.get(extenttest.log(Status.PASS,"test passed");
	
}
@Override
public void onTestFailure(ITestResult tr)
{
	extenttest.fail(tr.getThrowable());
	String testName=tr.getName();
	try
	{
		driver=(WebDriver)tr.getTestClass().getRealClass().getDeclaredField("driver").get(tr.getInstance());
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	try
	{
		takescreenshot(testName,driver);
	}
    catch(Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
	
}
	@Override
public void onTestSkipped(ITestResult tr)
{
	
}
@Override
public void onFinish(ITestContext context)
{
extentreport.flush();
}
	
}

