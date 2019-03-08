package com.selenium.facebook.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.facebook.pom.common.TopMenu;
import com.selenium.facebook.pom.util.ConstantsValue;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

public class BasePage {

	public WebDriver driver;
	public TopMenu menu;
	public ExtentTest test;
	
	public BasePage(){}
	
	public BasePage(WebDriver driver,  ExtentTest test){
		this.driver=driver;
		this.test = test;
		//menu = PageFactory.initElements(driver, TopMenu.class);
		menu = new TopMenu(driver, test);
		PageFactory.initElements(driver, menu);
	}
	
	public String verifyTitle(String expTitle){
		test.log(LogStatus.INFO, "Verifying the title " + expTitle);
		// webdriver code
		return "";
	}
	
	
	public String verifyText(String locator,String expText){
		return "";
	}
	
	public boolean isElementPresent(String locator){
		test.log(LogStatus.INFO, "Trying to find element -> "+locator);
		int s = driver.findElements(By.xpath(locator)).size();
		if(s==0){
			test.log(LogStatus.INFO, "Element not found");
			return false;
		}
		else{
			test.log(LogStatus.INFO, "Element found");
			return true;
		}
			
	}
	
	public TopMenu getMenu() {
		return menu;
	}
	
	public void reportFailure(String failureMessage){
		test.log(LogStatus.FAIL, failureMessage);
		takeScreenShot();
		Assert.fail(failureMessage);
	}
	
	
	
	public void takeScreenShot(){
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		String filePath=ConstantsValue.REPORTS_PATH+"screenshots//"+screenshotFile;
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO,test.addScreenCapture(filePath));
	}
	
	

}
