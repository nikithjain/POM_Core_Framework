package com.selenium.facebook.pom.PageObjectModel_WithPageFactory.pages.session.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.base.BasePage;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.util.Constants;

public class SecurityAndLoginPage extends BasePage {
	
	@FindBy(xpath=Constants.PASSWORD_CHANGE)
	public WebElement editPassword;
	
	@FindBy(xpath=Constants.OLD_PASSWORD)
	public WebElement oldPassword;
	
	@FindBy(xpath=Constants.NEW_PASSWORD)
	public WebElement newPassword;
	
	@FindBy(xpath=Constants.CONFIRM_CHANGE)
	public WebElement confirmPassword;
	
	@FindBy(xpath=Constants.SAVE_CHANGES)
	public WebElement saveChanges;
	
	@FindBy(xpath=Constants.KILL_SESSION)
	public WebElement killSessionRadio;
	
	@FindBy(xpath=Constants.CONTINUE_PASSWORD_CHANGE_BUTTON)
	public WebElement continuePasswordChange;
	
	
	
	
	
	public SecurityAndLoginPage(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
	}
	
	public void gotoPasswordChange() {
		test.log(LogStatus.INFO,"Clicking on Password Change");
		if(!isElementPresent(Constants.PASSWORD_CHANGE)) {
			test.log(LogStatus.FAIL,"Element not found - "+Constants.PASSWORD_CHANGE);
			takeScreenShot();
			Assert.fail("Element not found - "+Constants.PASSWORD_CHANGE);
		}
		editPassword.click();
		test.log(LogStatus.INFO,"On Password Change section");	
	}

	public String doPasswordChange(String oPassword,String nPassword) {
		test.log(LogStatus.INFO,"Changing Password");
		oldPassword.sendKeys(oPassword);
		newPassword.sendKeys(nPassword);
		confirmPassword.sendKeys(nPassword);
		saveChanges.click();
		if(!isElementPresent(Constants.PASSWORD_CHANGE)) 
			return "UnSuccessful";
		killSessionRadio.click();
		continuePasswordChange.click();
		test.log(LogStatus.INFO,"Changed Password Successfully");
		return "Success";
	}
	
	

}
