package com.selenium.facebook.pom.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.base.BasePage;
import com.selenium.facebook.pom.util.ConstantsValue;


public class LandingPage extends BasePage{
	
	
	public LandingPage(WebDriver driver, ExtentTest test){ 
		super(driver,test);
	}
	
	@FindBy(xpath = ConstantsValue.PROFILEPAGE_LINK) 
	public WebElement profileLink;
	
	public ProfilePage gotoProfilePage(){
		test.log(LogStatus.INFO, "Going to profile page");
		profileLink.click();
		ProfilePage profilePage = new ProfilePage(driver,test);
		PageFactory.initElements(driver, profilePage);
		return profilePage;
		//return PageFactory.initElements(driver, ProfilePage.class);
		
	}
}
