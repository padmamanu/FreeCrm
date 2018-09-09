package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{
	HomePage homePage;
	TestUtil testUtil;
	ContactPage contactPage;
	
	@FindBy(xpath="//td[contains(text(),'User: padma p')]")
			WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactBox;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')}")
	WebElement newContact;
			
			
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyHomePageTitle(){

		String title=driver.getTitle();
		System.out.println("Title is ===========>" + title);
		
		return title;
	}
	
	public String verifyUserLabelText(){
	
		String userLableText= userNameLabel.getText();
		return userLableText;
		
	}
	
	public ContactPage clickOnContactsBox(){
		contactBox.click();
		return new ContactPage();
	}
	
	public void clickonNewContact(){
		Actions action=new Actions(driver);
		action.moveToElement(contactBox).build().perform();
		WebDriverWait wd=new WebDriverWait(driver,10);
		wd.until(ExpectedConditions.elementToBeClickable(newContact));
		newContact.click();
		
	}

}
