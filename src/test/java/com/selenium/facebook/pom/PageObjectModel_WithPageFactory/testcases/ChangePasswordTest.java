package com.selenium.facebook.pom.PageObjectModel_WithPageFactory.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.pages.LaunchPage;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.pages.LoginPage;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.pages.session.LandingPage;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.pages.session.settings.GeneralSettingsPage;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.pages.session.settings.SecurityAndLoginPage;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.testcases.base.BaseTest;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.util.Constants;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.util.DataUtil;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.util.ExtentManager;

public class ChangePasswordTest extends BaseTest {
	
	String testCaseName = "ChangePasswordTest";
	@Test(dataProvider="getData")
	public void changePasswordTest(Hashtable<String,String> data) {
		
		test = extent.startTest(testCaseName);
		if(!DataUtil.isTestExecutable(xls,testCaseName) || data.get(Constants.RUNMODE_COL).equals("N")) {
			test.log(LogStatus.SKIP,"Skipping the test as Runmode is N");
			throw new SkipException("Skipping the test as Runmode is N");
		}
		
		
		test.log(LogStatus.INFO, "Starting Test");
		test.log(LogStatus.INFO, "Opening Browser");
		init(data.get("Browser"));
		LaunchPage launchPage = new LaunchPage(driver,test);
		PageFactory.initElements(driver,launchPage);
		
		LoginPage loginPage = launchPage.gotoLoginPage();
		test.log(LogStatus.INFO, "Logging in");
		Object page = loginPage.doLogin(data.get("Username"),data.get("OldPassword"));
		if(page instanceof LoginPage)
			reportFailure("Could not login");
		//Change Password
		LandingPage landingPage = (LandingPage)page;
		GeneralSettingsPage settings =landingPage.getMenu().gotoSetting();
		Object page2 = settings.gotoSecurityAndLoginPage();
		if(page2 instanceof GeneralSettingsPage)
			reportFailure("Could not go to Settings and login Page");
		SecurityAndLoginPage securityAndLoginPage = (SecurityAndLoginPage)page2;
		securityAndLoginPage.gotoPasswordChange();
		String actualResult = securityAndLoginPage.doPasswordChange(data.get("OldPassword"),data.get("NewPassword"));
		test.log(LogStatus.INFO,"Result of Changing Password -"+actualResult);
		//validation
		
		if(!actualResult.equals(data.get("ExpectedResult"))) {
			reportFailure("Got Password change Result as - "+actualResult);
		}
			
		test.log(LogStatus.PASS,"Test Passed");
		
		
	}
	
	@AfterMethod
	public void quit() {
		if(extent!=null) {
			extent.endTest(test);
			extent.flush();
		}
		
		if(driver!=null)
			driver.quit();
	}
	
	
	@DataProvider
	public Object[][] getData(){
		
		return DataUtil.getData(xls, testCaseName);
	}
}
