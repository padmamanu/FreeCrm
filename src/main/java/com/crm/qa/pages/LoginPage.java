package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase {
	
	HomePage homePage;

	//Pagefactor or Object repositiory
	
	@FindBy(name="username") 
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	//@FindBy(xpath="//input[type='submit']")
	@FindBy(xpath="//input[contains(@type,'submit')]")
	WebElement loginBtn;
	@FindBy(linkText="Sign Up")
	WebElement SignUpBtn;
	//@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	
	//Initializing the Page Objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	//Action in page
	public String validateLoginPageTitle(){
		
		return driver.getTitle();
	}
	
	
	public boolean validateCRMImage(){
		
		return crmLogo.isDisplayed();
	}
public boolean loginButtonVisible(){
		
		return loginBtn.isDisplayed();
	}
	
	public HomePage login(String uname, String pass){
		username.sendKeys(uname);
		password.sendKeys(pass);
		driver.manage().window().maximize();
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
		/*Actions actions = new Actions(driver);
		//Thread.sleep(1000);
		
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);
		actions.moveToElement(loginBtn).click().build().perform();*/
	
		
		return new HomePage();
		
	}


	
}
