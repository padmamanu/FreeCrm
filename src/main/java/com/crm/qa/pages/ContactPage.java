package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase{
	
	
	@FindBy(xpath="//td[containst(text(),'Contacts')]")
	WebElement contactsLabel;
	
	
	@FindBy(xpath="//input[name='contact_id' AND type='checkbox'])")
	WebElement checkBox;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement selectTitle;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	
	@FindBy(id="surname")
	WebElement lastName;
	
	
	@FindBy(xpath="//input[text='submit' and value='Save']")
	WebElement Savebtn;
	
	public ContactPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyContactsText(){
		String name=contactsLabel.getText();
		return name;
	}
	
	public boolean clickOnCheckBox(){
		checkBox.click();
		return checkBox.isSelected();
	}

	public void enterForm(String title,String ftname,String ltname){
		Select select=new Select(selectTitle);
		select.selectByVisibleText(title);
		firstName.sendKeys(ftname);
		lastName.sendKeys(ltname);
		
		Savebtn.click();
		
	}
}
