package com.selenium.facebook.pom.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.base.BaseTest;
import com.selenium.facebook.pom.pages.LaunchPage;
import com.selenium.facebook.pom.pages.LoginPage;
import com.selenium.facebook.pom.session.LandingPage;
import com.selenium.facebook.pom.session.ProfilePage;
import com.selenium.facebook.pom.util.ConstantsValue;


public class ProfileTest extends BaseTest{
	
	@Test
	public void testProfile(){
		test = extent.startTest("Profile Test");
		
		test.log(LogStatus.INFO,"Starting Profile Test");
		test.log(LogStatus.INFO,"Opening Browser");
		
		
		init("Chrome");
		LaunchPage launchPage = new LaunchPage(driver,test);
		PageFactory.initElements(driver, launchPage);
		
		LoginPage loginPage = launchPage.gotoLoginPage();
		loginPage.verifyTitle("Facebook Login");
		
		Object page = loginPage.doLogin(ConstantsValue.getEnvDetails().get("username"), ConstantsValue.getEnvDetails().get("password"));
		
		if(page instanceof LoginPage)
			Assert.fail("Login failed ");
		else if(page instanceof LandingPage)
			System.out.println("Logged in successfully");
		
		LandingPage landingPage=(LandingPage)page;
		
		
		ProfilePage profilePage = landingPage.gotoProfilePage();
		profilePage.verifyProfile();
		//profilePage.getMenu().logout();
		
		test.log(LogStatus.PASS, "Test Passed");
	}
	
	@AfterMethod
	public void quit() {
		if(extent!= null) {
			extent.endTest(test);
			extent.flush();
		}
		
	}

}
