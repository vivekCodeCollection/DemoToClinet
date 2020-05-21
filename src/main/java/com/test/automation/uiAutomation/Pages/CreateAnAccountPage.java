package com.test.automation.uiAutomation.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.test.automation.uiAutomation.Generic.Base.TestBase;


/**
 * 
 * @author Vivek Kumar Jha
 *
 */
public class CreateAnAccountPage extends TestBase {
	
	static String SignupPageTitle="AUTHENTICATION";
	static String SignupCompletionTitle="MY ACCOUNT";
	
	WebDriver driver;

	public static final Logger log = Logger.getLogger(CreateAnAccountPage.class.getName());


	@FindBy(css ="h1.page-heading")	
	private WebElement CreateAnAccountHeader;
	
	@FindBy(xpath ="//label[@for='id_gender1']/div")
	private WebElement TitleofAccountHolder;
	
	@FindBy(id="customer_firstname")
	private WebElement FirstName_txt;
	
	@FindBy(id="customer_lastname")
	private WebElement Lastname_txt;
	
	@FindBy(id="email")
	private WebElement Email_txt;
	
	@FindBy(id="passwd")
	private WebElement Password_txt;
	
	@FindBy(id="days")
	private WebElement DayDOB_DDP;
	
	@FindBy(id="months")
	private WebElement Daymnt_DDP;
	
	@FindBy(id="years")
	private WebElement Dayyr_DDP;
	
	//Address Deatisl in Sign Up
	
	@FindBy(id="firstname")
	private WebElement AddFirstName_txt;
	
	@FindBy(id="lastname")
	private WebElement AddLastname_txt;
	
	@FindBy(id="address1")
	private WebElement Address_Customer_txt;
	
	@FindBy(id="city")
	private WebElement Address_city_Customer_txt;
	
	@FindBy(id="postcode")
	private WebElement Address_Zip_Customer_txt;
	
	@FindBy(id="id_state")
	private WebElement Address_id_state_Customer_txt;
	
	@FindBy(id="postcode")
	private WebElement Address_postcode_Customer_txt;
	
	@FindBy(id="id_country")
	private WebElement Address_id_country_Customer_DDp;
	
	@FindBy(id="phone_mobile")
	private WebElement phone_mobile_txt;
	
	@FindBy(id="submitAccount")
	private WebElement SubmitButton;
	
	public CreateAnAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	
public void EnterSignupAllDetails(String Fname,String Lname,String pwd,String day,String month,String year 
,String Addfname1,String AddLname,String Address,String City,String State,String mobileno,String EmailKey,String Emailid,String zip) {
	
	// Header of Craete Account page
	String actaul_Title=CreateAnAccountHeader.getText();
	
	// Assert Header
	Assert.assertEquals(actaul_Title, SignupPageTitle,"Create An account Page Title");

	// Mr Title Radio Button
	
	waitForElement(driver, 20, TitleofAccountHolder);
	TitleofAccountHolder.click();
	//JavascrptClick(TitleofAccountHolder);
	
	// Create Account Personal Details
	FirstName_txt.sendKeys(Fname);
	Lastname_txt.sendKeys(Lname);
	//Email_txt.sendKeys(Emailid);
	Password_txt.sendKeys(pwd);
	
	SelectDdpByValue(DayDOB_DDP, day);
	SelectDdpByValue(Daymnt_DDP, month);
	SelectDdpByValue(Dayyr_DDP, year);
	
	// Create Account Address Details
	
	//AddFirstName_txt.sendKeys(Addfname1);
	//AddLastname_txt.sendKeys(AddLname);
	Address_Customer_txt.sendKeys(Address);
	Address_city_Customer_txt.sendKeys(City);	
	SelectDdpByText(Address_id_state_Customer_txt, State);	
	
	Address_Zip_Customer_txt.sendKeys(zip);
	phone_mobile_txt.sendKeys(mobileno);
	
	
	
	
}
	
public MyAccountPage ClickSignUpButton(WebDriver driver) {
	SubmitButton.click();
	
	return new MyAccountPage(driver);
}

public void VerifyMyAccountPage() {
	
waitForElement(driver, 20, CreateAnAccountHeader);
	
	Assert.assertEquals(CreateAnAccountHeader.getText(), SignupCompletionTitle,"Create An account Page Title");
}
}
