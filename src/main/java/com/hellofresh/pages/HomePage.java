package com.hellofresh.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hellofresh.basemanager.BaseClass;
import com.hellofresh.commonutils.CommonUtils;

public class HomePage {

	@FindBy(className = "login")
	public WebElement signInButton;
//logout
	
	@FindBy(className = "logout")
	public WebElement logOutButton;
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public void clickSignIn() {
		
		 CommonUtils.logInfo("Click Sign In");


		BaseClass.wait.until(ExpectedConditions.visibilityOf(signInButton)).click();

	}
	
	public void clickLogout(){
		
		CommonUtils.logInfo("Click Logout");
		
		logOutButton.click();
	}

}
