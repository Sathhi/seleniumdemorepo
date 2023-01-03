package resources;

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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	WebDriver driver;
	public Properties prop;
	@SuppressWarnings("deprecation")
	public WebDriver initializebrowser() throws Exception
	{   
		prop=new Properties();
		String proppath=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis=new FileInputStream(proppath);
		prop.load(fis);
		
	
		
		String browsername=prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			 driver=new InternetExplorerDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return driver;
		
			}
	public void takescreenshot(String testname,WebDriver driver) throws Exception
	{
		File Sourcefile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath=System.getProperty("user.dir")+"\\screenshots\\"+testname+".png";
		FileUtils.copyFile(Sourcefile,new File(destinationFilePath));
}
	
}
