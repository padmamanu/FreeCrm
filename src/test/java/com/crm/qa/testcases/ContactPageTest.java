package com.crm.qa.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import org.apache.commons.io.FileUtils;
public class ContactPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	TestUtil testUtil;
	ContactPage contactPage;
	String sheetName="Contact";
	
	public ContactPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initilization();
		 testUtil=new TestUtil();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactPage=homePage.clickOnContactsBox();
	}
	
	/*@Test
	public void addNewContactPageI(){
		
	}
	
	@Test
	public void verifyContactboxtext(String text){
		Assert.assertEquals(text, "Contacts", "both are not matching");
	}
	
	@Test
	public void verifyContactboxisChecked(){
		Assert.assertTrue(contactPage.clickOnCheckBox(),"it is checked");
	}*/
	
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] =testUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getTestData")
	public void fillTheForm(String tt,String ft,String lt){
		homePage.clickonNewContact();
		contactPage.enterForm(tt, ft, lt);
	}
	
	@AfterMethod
	public void takeScreenshotAndteardown(ITestResult result){
		
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
