package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase () {
		
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("/home/bhavya/workspace/FreeCRMTest/src/main/java/com/crm/qa/env/config.properties");
			prop.load(ip);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initilization(){
		String browserName=prop.getProperty("browser");
		if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver","/home/bhavya/Downloads/geckodriver" );
			driver=new FirefoxDriver();
		}
		else if (browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","/home/bhavya/Downloads/geckodriver" );
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}
	
	

}
