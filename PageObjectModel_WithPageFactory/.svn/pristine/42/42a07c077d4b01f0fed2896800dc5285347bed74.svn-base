package com.selenium.facebook.pom.session.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.base.BasePage;
import com.selenium.facebook.pom.util.ConstantsValue;

public class GeneralSettingsPage extends BasePage{

	@FindBy(xpath=ConstantsValue.PASSWORD_CHANGE)
	public WebElement editPassword;
	
	@FindBy(xpath=ConstantsValue.OLD_PASSWORD)
	public WebElement oldPassword;
	
	@FindBy(xpath=ConstantsValue.NEW_PASSWORD)
	public WebElement newPassword;
	
	@FindBy(xpath=ConstantsValue.CONFIRM_CHANGE)
	public WebElement confirmPassword;
	
	@FindBy(xpath=ConstantsValue.SAVE_CHANGES)
	public WebElement saveChanges;
	
	@FindBy(xpath=ConstantsValue.KILL_SESSION)
	public WebElement killSessionRadio;
	
	@FindBy(xpath=ConstantsValue.CONTINUE_PASSWORD_CHANGE_BUTTON)
	public WebElement continuePasswdChange;
	
	
	public GeneralSettingsPage(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
	}
	
	public void gotoPasswordChange(){
		test.log(LogStatus.INFO, "clicking on password change");
		if(!isElementPresent(ConstantsValue.PASSWORD_CHANGE)){	
			reportFailure("Element not found "+ ConstantsValue.PASSWORD_CHANGE);
		}
			
		editPassword.click();
		test.log(LogStatus.INFO, "On password change Page");
		

	}

	public String doPasswordChange(String oPassword,String nPassword) {
		test.log(LogStatus.INFO, "Changing password");
		oldPassword.sendKeys(oPassword);
		newPassword.sendKeys(nPassword);
		confirmPassword.sendKeys(nPassword);
		saveChanges.click();
		if(!isElementPresent(ConstantsValue.PASSWORD_CHANGE))
			return "Unsuccessful";
		
		killSessionRadio.click();
		continuePasswdChange.click();
		test.log(LogStatus.INFO, "Changed Password Successfully");
		return "Success";
	}
}
