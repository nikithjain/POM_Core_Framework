package com.selenium.facebook.pom.PageObjectModel_WithPageFactory.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.pages.LaunchPage;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.pages.LoginPage;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.pages.session.FriendsPage;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.pages.session.LandingPage;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.pages.session.ProfilePage;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.testcases.base.BaseTest;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.util.Constants;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.util.DataUtil;

public class FriendsTest extends BaseTest {
	String testCaseName = "FriendsTest";
	@Test(dataProvider="getData")
	public void doFriendsTest(Hashtable<String,String> data) {
		
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
		Object page = loginPage.doLogin(Constants.DEFAULT_USERNAME,Constants.DEFAULT_PASSWORD);
		if(page instanceof LoginPage)
			reportFailure("Could not login");
		//Change Password
		LandingPage landingPage = (LandingPage)page;
		ProfilePage profPage = landingPage.gotoProfilePage();
		FriendsPage friendsPage = profPage.gotoFriends();
		friendsPage.searchFriends(data.get("FriendName"));
		
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
