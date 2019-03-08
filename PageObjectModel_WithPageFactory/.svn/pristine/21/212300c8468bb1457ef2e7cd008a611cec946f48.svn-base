package com.selenium.facebook.pom.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.base.BaseTest;
import com.selenium.facebook.pom.pages.LaunchPage;
import com.selenium.facebook.pom.pages.LoginPage;
import com.selenium.facebook.pom.session.LandingPage;
import com.selenium.facebook.pom.session.settings.GeneralSettingsPage;
import com.selenium.facebook.pom.util.ConstantsValue;
import com.selenium.facebook.pom.util.DataUtil;

public class ChangePasswordTest extends BaseTest{
	String testCaseName="ChangePasswordTest";
	
	@Test(dataProvider="getData")
	public void changePasswordTest(Hashtable<String,String> data){
			
		test = extent.startTest(testCaseName);
		
		if(!DataUtil.isTestExecutable(xls, testCaseName) ||  data.get(ConstantsValue.RUNMODE_COL).equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as Rnumode is N");
			throw new SkipException("Skipping the test as Rnumode is N");
		}
		
		test.log(LogStatus.INFO,"Starting" +testCaseName);
		
		//init("Chrome");
		init(data.get("Browser"));
		
		//LaunchPage launchPage = PageFactory.initElements(driver, LaunchPage.class);
		LaunchPage launchPage =new LaunchPage(driver,test);
		PageFactory.initElements(driver, launchPage);
		
		LoginPage loginPage = launchPage.gotoLoginPage();
		test.log(LogStatus.INFO, "Logging in");
		Object page=loginPage.doLogin(data.get("Username"), data.get("OldPassword"));
		
		if(page instanceof LoginPage)
			reportFailure("Could not login");
		
		LandingPage landingPage = (LandingPage)page;
		//Change Password
		GeneralSettingsPage settings = landingPage.getMenu().gotoSettings();
		settings.gotoPasswordChange();
		String actualResult=settings.doPasswordChange(data.get("OldPassword"),data.get("NewPassword"));
		test.log(LogStatus.INFO, "Result of changing password - "+actualResult);

		//validation
		if(!actualResult.equals(data.get("ExpectedResult")))
			reportFailure("Got password change result as - "+actualResult);
		
		test.log(LogStatus.PASS, "Test Passed");
		
	}
	
	@AfterMethod
	public void quit(){
		if(extent!=null){
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
