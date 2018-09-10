package com.crm.qa.testcases;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	
	public HomePageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setup(){
		initilization();
		 testUtil=new TestUtil();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test
	public void verifyHomePageTitle(){
		
		testUtil.switchToFrame();
		String title=homePage.verifyHomePageTitle();
		Assert.assertEquals("Home page title not matched",title, "CRMPRO");
	}
	
	@Test
	public void verifyHomePageUserLableText(){
		testUtil.switchToFrame();
		String text=homePage.verifyUserLabelText();
		System.out.println(text+ "=============");
		Assert.assertEquals("Home page user name label is not matching",text,"User: padma p" );
	}
	
	@Test
	public void findListinContactBox(){
		
	}
	
	@AfterMethod
	public void takeScreenshotAndteardown(ITestResult result){
		//ITestResult interface provides the test case execution status and test case name
		if(ITestResult.FAILURE==result. getStatus()){
			
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			try {
				FileUtils.copyFile(src,new File("/home/bhavya/Documents/Freecrm.png"));
			} catch (IOException e) {
				System.out.println("exception while taking screenshot"+ e.getMessage());
				e.printStackTrace();
			}
		}
		
		
		driver.quit();
}
	
}