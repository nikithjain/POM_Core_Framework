package com.selenium.facebook.pom.PageObjectModel_WithPageFactory.pages.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.base.BasePage;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.util.Constants;

public class ProfilePage extends BasePage {
	
	@FindBy(xpath=Constants.FRIENDS_TAB)
	public WebElement friendsLink;
	
	public ProfilePage(WebDriver driver,ExtentTest test) {
		super(driver,test);
	}

	public void verifyProfile() {
		test.log(LogStatus.INFO,"Verifying the Profile");
		
	}
	
	
	public FriendsPage gotoFriends() {
		test.log(LogStatus.INFO,"Going to Friends Page");
		friendsLink.click();
		FriendsPage friendsPage = new FriendsPage(driver,test);
		PageFactory.initElements(driver,friendsPage);
		return friendsPage;
	}

	
}
