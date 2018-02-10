package com.selenium.facebook.pom.PageObjectModel_WithPageFactory.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.pages.session.settings.GeneralSettingsPage;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.util.Constants;

public class TopMenu {
	
	@FindBy(xpath=Constants.NAVIGATION_LABEL)
	public WebElement navigationLabel;
	
	@FindBy(xpath=Constants.SETTINGS_LINK)
	public WebElement settings;
	
	ExtentTest test;
	
	
	WebDriver driver;
	public TopMenu(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void logout() {
		
	}
	
	public GeneralSettingsPage gotoSetting() {
		test.log(LogStatus.INFO,"Going to Settings");
		navigationLabel.click();
		settings.click();
		test.log(LogStatus.INFO,"Settings page opened");
		GeneralSettingsPage settings = new GeneralSettingsPage(driver,test);
		PageFactory.initElements(driver,settings);
		return settings;
		
	}
	
	public void search() {
		
	}

}
