package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class browserfactory 
{
	
	public static WebDriver launch(String BrowserName)
	{
		WebDriver driver = null;
		if(BrowserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./exefiles/chromedriver.exe");
			driver = new ChromeDriver();
			Reporter.log("chrome browser launched");		
		}
		if(BrowserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./exefiles/Firefox Setup 60.7.2esr.exe");
			driver = new FirefoxDriver();
			Reporter.log("Firefox browser launched");
		}
		return driver;
	}
	
	

}
