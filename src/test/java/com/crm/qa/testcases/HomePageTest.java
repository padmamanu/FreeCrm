package com.crm.qa.testcases;

import junit.framework.Assert;

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
	
	@AfterMethod
	public void teardown(){
		driver.quit();
}
	
	
}