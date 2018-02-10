package com.selenium.facebook.pom.PageObjectModel_WithPageFactory.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.pages.LaunchPage;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.pages.LoginPage;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.pages.session.LandingPage;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.pages.session.ProfilePage;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.testcases.base.BaseTest;
import com.selenium.facebook.pom.PageObjectModel_WithPageFactory.util.DataUtil;




public class ProfileTest extends BaseTest {
	
	String testCaseName = "ProfileTest";
	@Test
	public void testProfile(){
		
		test=extent.startTest("Profile Test");
		if(!DataUtil.isTestExecutable(xls,testCaseName)) {
			test.log(LogStatus.SKIP,"Skipping the test as Runmode is N");
			throw new SkipException("Skipping the test as Runmode is  N");
			
		}
		test.log(LogStatus.INFO, "Starting Profile Test");
		init("Mozilla");
		LaunchPage launchPage = new LaunchPage(driver,test);
		PageFactory.initElements(driver,launchPage);
		
		LoginPage loginpage = launchPage.gotoLoginPage();
		loginpage.verifyTitle("Facebook login");
		Object page = loginpage.doLogin("nikithjain@gmail.com","Shalinikith_5");
		if(page instanceof LoginPage)
			Assert.fail("Login Failed");
		else if(page instanceof LandingPage)
			System.out.println("Logged in Successfully");
		LandingPage landingPage = (LandingPage)page;
		landingPage.getMenu().search();
		landingPage.verifyTitle("XXXX");
		
		ProfilePage profPage = landingPage.gotoProfilePage();
		profPage.verifyProfile();
		test.log(LogStatus.INFO,"Test Passed");
		profPage.takeScreenShot();
		//profPage.getMenu();
		//profPage.getMenu().logout();
		
	
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
	
	
	
	

}
