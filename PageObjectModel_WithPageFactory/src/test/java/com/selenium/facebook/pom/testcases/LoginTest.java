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
import com.selenium.facebook.pom.util.ConstantsValue;
import com.selenium.facebook.pom.util.DataUtil;

public class LoginTest extends BaseTest{
	String testCaseName="LoginTest";
	
	@Test(dataProvider="getData")
	public void doLogin(Hashtable<String,String> data){
		test = extent.startTest("Login Test");
		
		if(!DataUtil.isTestExecutable(xls, testCaseName) ||  data.get(ConstantsValue.RUNMODE_COL).equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as Rnumode is N");
			throw new SkipException("Skipping the test as Rnumode is N");
		}
		
		test.log(LogStatus.INFO, "Starting login test");
		test.log(LogStatus.INFO, "Opening browser");
		
		init(data.get("Browser"));
		//init("Chrome");
		LaunchPage launchPage = new LaunchPage(driver,test);
		PageFactory.initElements(driver, launchPage);
		
		LoginPage loginPage = launchPage.gotoLoginPage();
		loginPage.takeScreenShot();
		test.log(LogStatus.INFO, "Logging in");
		Object page=loginPage.doLogin(data.get("Username"), data.get("Password"));
		String actualResult="";
		// if i am logged in
		if(page instanceof LandingPage)
			actualResult="Success";
		else
			actualResult="Unsuccessful";
		
		if(!actualResult.equals(data.get("ExpectedResult"))){
			
			reportFailure("failure message");
		}
		
	
		
		test.log(LogStatus.PASS,"Login test passed");
	
	}
	
	@AfterMethod
	public void quit() {
		if(extent!= null) {
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
