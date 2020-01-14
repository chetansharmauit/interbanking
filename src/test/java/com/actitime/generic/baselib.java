package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class baselib 
{
	public static WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser","baseurl"})
	public void precondition(String browsername, String url)
	{
		driver = browserfactory.launch(browsername);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(url);
		Reporter.log("url is launched",true);
	}
	
	@AfterMethod
	public void Postcondition()
	{
		driver.quit();
		Reporter.log("Browser closed",true);
	}

}
