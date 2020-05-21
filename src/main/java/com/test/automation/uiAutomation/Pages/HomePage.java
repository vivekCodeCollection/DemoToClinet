package com.test.automation.uiAutomation.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.test.automation.uiAutomation.Generic.Base.TestBase;
/**
 * 
 * @author Vivek Kumar Jha
 *
 */
public class HomePage extends TestBase{
	
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	
	
	WebDriver driver;
	
	@FindBy(css = "a.login")
	WebElement signIn;
	
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		//testBase = new TestBase();
		PageFactory.initElements(driver, this);
	}
	
	
	public LoginandRegistrationPage NavigateToRegistrationPage() {
				signIn.click();
		return new LoginandRegistrationPage(driver);	
	}
	
	
		
}
