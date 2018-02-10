package com.selenium.facebook.pom.PageObjectModel_WithPageFactory.pages.session.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.base.BasePage;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.util.Constants;

public class GeneralSettingsPage extends BasePage {
	
	@FindBy(xpath=Constants.SECURITYANDLOGIN)
	public WebElement settingAndLogin;
	
	public GeneralSettingsPage(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
	}
	
	public SecurityAndLoginPage gotoSecurityAndLoginPage() {
		test.log(LogStatus.INFO,"Clicking on Security and Login- "+Constants.SECURITYANDLOGIN);
		settingAndLogin.click();
		test.log(LogStatus.PASS,"Security and Login opened");
		SecurityAndLoginPage securityAndLoginPage = new SecurityAndLoginPage(driver,test);
		PageFactory.initElements(driver,securityAndLoginPage);
		return securityAndLoginPage;
	}

}
