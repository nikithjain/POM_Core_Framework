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
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.testcases.base.BaseTest;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.util.Constants;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.util.DataUtil;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.util.ExtentManager;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.util.Xls_Reader;

public class LoginTest extends BaseTest {
	
	String testCaseName = "LoginTest";
	
	@Test(dataProvider="getData")
	public void doLogin(Hashtable<String,String> data) {
		
		test = extent.startTest("LoginTest");
		if(!DataUtil.isTestExecutable(xls,testCaseName) || data.get(Constants.RUNMODE_COL).equals("N")) {
			test.log(LogStatus.SKIP,"Skipping the test as Runmode is N");
			throw new SkipException("Skipping the test as Runmode is  N");
			
		}
		test.log(LogStatus.INFO, "Starting Login Test");
		test.log(LogStatus.INFO, "Opening Browser");
		init(data.get("Browser"));
		LaunchPage launchPage = new LaunchPage(driver,test);
		PageFactory.initElements(driver,launchPage);
		
		LoginPage loginPage = launchPage.gotoLoginPage();
		loginPage.takeScreenShot();
		test.log(LogStatus.INFO, "Logging in");
		Object page = loginPage.doLogin(data.get("Username"),data.get("Password"));
		String actualResult ="";
		//if i am logged in
		if(page instanceof LandingPage)
			actualResult = "Success";
		else 
			actualResult = "Unsuccessful";
		
		if(!actualResult.equals(data.get("ExpectedResult")))
			reportFailure("Failure message");
		test.log(LogStatus.INFO, "Login Test Passed");
	
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
