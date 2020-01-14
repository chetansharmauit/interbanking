package com.actitime.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class loginpage 
{
	
	@FindBy(name="email")
	private @Getter WebElement untxtbx;
	
	
	
	 @FindBy(name="pass")
	 private @Getter WebElement PwdtxtBox;
	 
	 @FindBy(id ="loginbutton") 
	 private @Getter WebElement loginBtn;

	 public loginpage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}

	


	
}
