package com.selenium.facebook.pom.PageObjectModel_WithPageFactory.pages.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.base.BasePage;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.util.Constants;

public class FriendsPage extends BasePage {
	
	@FindBy(xpath=Constants.INPUT_SEARCHFRIENDS)
	public WebElement searchFriends;
	
	@FindBy(xpath=Constants.SEARCHFRIENDS_BUTTON)
	public WebElement searchFriendsButton;
	
	
	public FriendsPage(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
	}
	
	public void searchFriends(String frndName) {
		test.log(LogStatus.INFO,"Searching the friend");
		searchFriends.sendKeys(frndName);
		searchFriendsButton.click();
		
		
		
	}
	
	
}
