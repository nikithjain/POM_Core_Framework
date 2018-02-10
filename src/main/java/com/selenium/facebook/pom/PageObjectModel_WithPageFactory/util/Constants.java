package com.selenium.facebook.pom.PageObjectModel_WithPageFactory.util;

public class Constants {
	public static final String CHROME_DRIVER_EXE = "C:\\Selenium_Automation\\LibraryFiles\\chromedriver.exe";
	
	//Default username and Password
	public static final String DEFAULT_USERNAME = "nikithjain@gmail.com";
	public static final String DEFAULT_PASSWORD = "Shalinikith_5";
	
	//locators
	public static final String LOGIN_USERNAME ="//*[@id='email']";
	public static final String PASSWORD ="//*[@id='pass']";
	public static final String PROFILEPAGE_LINK = "//*[@id='u_0_a']/div[1]/div[1]/div/a/span/span";
	public static final String NAVIGATION_LABEL = "//*[@id='userNavigationLabel']";
	public static final String SETTINGS_LINK = "//span[text()='Settings']";
	public static final String SECURITYANDLOGIN = "//*[@id='navItem_security']//div[contains(text(),'Security and Login')]";
	public static final String PASSWORD_CHANGE = "//*[@id='SettingsPage_Content']/div/div/div/div[3]/div[2]//button[@type='submit']";
	public static final String OLD_PASSWORD = "//*[@id='password_old']";
	public static final String NEW_PASSWORD = "//*[@id='password_new']";
	public static final String CONFIRM_CHANGE = "//*[@id='password_confirm']";
	public static final String SAVE_CHANGES = "//*[@class='submit uiButton uiButtonConfirm']";
	
	
	//Friends Page locators
	public static final String INPUT_SEARCHFRIENDS = "//*[@id='pagelet_timeline_medley_friends']/div[1]//input[@class='inputtext']";
	public static final String SEARCHFRIENDS_BUTTON = "//*[@id='pagelet_timeline_medley_friends']/div[1]//button[@type='submit' and @title='Search for your friends']";
	
	//Profile Page locators
	public static final String PHOTOS_TAB = "//div[@id='fbTimelineHeadline']//a[@data-tab-key='photos']";
	public static final String FRIENDS_TAB ="//div[@id='fbTimelineHeadline']//a[@data-tab-key='friends']";
	
	
	//URLs
	public static final String HOMEPAGE_URL = "https://www.facebook.com/";
	
	//Paths
	public static final String REPORTS_PATH = "C:\\Users\\vasantkn\\workspace3\\PageObjectModel_WithPageFactory\\reports\\";
	public static final String DATA_XLS_PATH = System.getProperty("user.dir")+"\\data\\Data.xlsx";

	public static final String TESTDATA_SHEET = "TestData";

	public static final Object RUNMODE_COL = "Runmode";

	public static final String KILL_SESSION = "//input[@value='kill_sessions']";

	public static final String CONTINUE_PASSWORD_CHANGE_BUTTON = "//button[text()='Continue']";

	public static final String TESTCASES_SHEET = "TestCases";


	
	
	
	

	

	
	

	

	

	

	

	

	

	
	
	
	
}
