package com.selenium.facebook.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.base.BasePage;
import com.selenium.facebook.pom.util.ConstantsValue;

public class LaunchPage extends BasePage{
	//WebDriver driver; //global driver
	
	public LaunchPage(WebDriver driver, ExtentTest test){ //local driver
		//this.driver = driver; //global = local
		super(driver, test); //using extends and base class has the constructor for driver. so parent class driver become super 
	}
	
	public LoginPage gotoLoginPage(){
		//test.log(LogStatus.INFO,"Opening the url - " + ConstantsValue.getEnvDetails().get("url"));
		//driver.get(ConstantsValue.getEnvDetails().get("url"));
		//test.log(LogStatus.PASS,"url Opend "+ ConstantsValue.getEnvDetails().get("url"));
		
		test.log(LogStatus.INFO,"Opening the url - " + ConstantsValue.HOMEPAGE_URL);
		driver.get(ConstantsValue.HOMEPAGE_URL);	
		test.log(LogStatus.PASS,"url Opend ");
		
		//return PageFactory.initElements(driver, LoginPage.class);
		LoginPage loginPage = new LoginPage(driver, test);
		PageFactory.initElements(driver, loginPage);
		return loginPage;

	}


}
