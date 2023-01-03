package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageobjects.Accountpage;
import pageobjects.landingpage;
import pageobjects.loginpage;
import resources.Base;

public class loginTest extends Base {
	
	WebDriver  driver;
	
	@Test
	public void login() throws Exception
	{
	
		driver=initializebrowser();
		driver.get(prop.getProperty("url"));
		
		landingpage landpage=new landingpage(driver);
		landpage.myAccountDropdown().click();
		landpage.loginoption().click();
		Thread.sleep(3000);
		
		loginpage login=new loginpage(driver);
		login.emailaddressfield().sendKeys(prop.getProperty("email"));
		login.passwordfield().sendKeys(prop.getProperty("password"));
		login.loginbutton().click();
		
		Accountpage apage=new Accountpage(driver);
		Assert.assertTrue(apage.editaccountinfo().isDisplayed());
		
				
}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}

