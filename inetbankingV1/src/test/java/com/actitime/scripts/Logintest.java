package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.feacture.LoginFeacture;
import com.actitime.generic.baselib;
import com.actitime.generic.excellib;

public class Logintest extends baselib
{
	@Test
	public void validlogin() throws InterruptedException
	{
		excellib elib = new excellib("./testdata/testdata-1.xlsx");
		String username = elib.readData("Sheet1", 1, 1);
		String password = elib.readData("Sheet1", 1, 2);
		LoginFeacture lf = new LoginFeacture(driver);
		lf.login(username,password);
		Thread.sleep(15000);
		//lf.verifyHomePage();
	}
	
	/*
	 * @Test(priority = 2) public void invalidLogin() { excellib elib = new
	 * excellib("./testdata/testdata-1.xlsx"); String username =
	 * elib.readData("Sheet1", 2, 1); String password = elib.readData("Sheet1", 2,
	 * 2); LoginFeacture lf = new LoginFeacture(driver);
	 * lf.login(username,password); lf.verifyInvalidLogin(); }
	 */
}
