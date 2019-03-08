package com.selenium.facebook.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.base.BasePage;
import com.selenium.facebook.pom.session.LandingPage;
import com.selenium.facebook.pom.util.ConstantsValue;

public class LoginPage extends BasePage {
		
	public LoginPage(WebDriver driver, ExtentTest test){ 
		super(driver, test);
	}
	
	@FindBy(xpath = ConstantsValue.LOGIN_USERNAME) 
	public WebElement userName;
	
	@FindBy(xpath = ConstantsValue.LOGIN_PASSWORD) 
	public WebElement passWord;
	
	@FindBy(how = How.ID, using ="Submit")
	public WebElement signIn;
	

	
	public Object doLogin(String username,String password){
		test.log(LogStatus.INFO, "Logging in -"+username+"/"+password);
		userName.sendKeys(username);
		passWord.sendKeys(password);
		signIn.click();
		
		
		boolean loginSuccess=isElementPresent(ConstantsValue.PROFILEPAGE_LINK);
		//return PageFactory.initElements(driver, LandingPage.class);
		
		if(loginSuccess){
			test.log(LogStatus.INFO, "Login Success");
			LandingPage landingPage = new LandingPage(driver,test);
			PageFactory.initElements(driver, LandingPage.class);
			return landingPage;
		}
		else{
			test.log(LogStatus.INFO, "Login Not Success");
			LoginPage loginPage = new LoginPage(driver,test);
			PageFactory.initElements(driver, LoginPage.class);
			return loginPage;
		}

	}

}
