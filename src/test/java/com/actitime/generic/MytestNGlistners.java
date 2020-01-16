package com.actitime.generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class MytestNGlistners implements ITestListener
{
	public static int executioncount, passcount,failcount,skipcount =0;

	public void onTestStart(ITestResult result) 
	{
		executioncount++;
		Reporter.log(result.getName()+" script execution start "+ new Date(),true);
	}

	public void onTestSuccess(ITestResult result)
	{
		passcount++;
		Reporter.log(result.getName()+" script passed",true);
		
	}

	public void onTestFailure(ITestResult result) {
		failcount++;
		Reporter.log(result.getName()+" script failed",true);
		TakesScreenshot ts = (TakesScreenshot) baselib.driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		File desfile = new File("./screenshot/"+result.getName()+".png");
		try {
			Files.copy(srcfile,desfile);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		Reporter.log("screenshot taken");
	}

	public void onTestSkipped(ITestResult result)
	{
		skipcount++;
		Reporter.log(result.getName()+" script skipped",true);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
		
	}

	public void onStart(ITestContext context) 
	{	
		Reporter.log("suite execution start"+ new Date(),true);
	}

	public void onFinish(ITestContext context) 
	{
		Reporter.log("suite execution end"+ new Date(),true);
		Reporter.log("total script executed " + executioncount,true);
		Reporter.log("total script passed " + passcount,true);
		Reporter.log("total script failed " + failcount,true);
		Reporter.log("total script skipped " + skipcount,true);
		
	}
	
	
	
}
