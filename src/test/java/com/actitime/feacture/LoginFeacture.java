package com.actitime.feacture;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

//import com.actitime.pageobject.enterTimeTrackPage;
import com.actitime.pageobject.loginpage;

public class LoginFeacture
{
	WebDriver driver;
	loginpage lp;
	//enterTimeTrackPage ettp;
	
	public LoginFeacture(WebDriver driver)
	{
		this.driver = driver;
		lp = new loginpage(driver);
		//ettp = new enterTimeTrackPage(driver);
	}
	
	public void login(String username,String password)
	{
		lp.getUntxtbx().sendKeys(username);
		lp.getPwdtxtBox().sendKeys(password);
		lp.getLoginBtn().click();
		
		Reporter.log("Home page is verified",true);
	}
	
	/*
	 * public void verifyHomePage() { String expText = "Enter Time-Track"; // String
	 * actualText = ettp.getPageTitleEle().getText(); //
	 * Assert.assertEquals(actualText, expText);
	 * 
	 * String expTitle = "actiTIME - Enter Time-Track"; String actualTitle =
	 * driver.getTitle(); Assert.assertEquals(actualTitle, expTitle);
	 * Reporter.log("Home page is verified",true);
	 * 
	 * }
	 */
	
	/*
	 * public void verifyInvalidLogin() { String expText =
	 * "Username or Password is invalid. Please try again."; String acttext =
	 * lp.getInvalidLogin().getText(); Assert.assertEquals(acttext, expText);
	 * 
	 * }
	 */
		
	
}
