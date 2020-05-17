package com.test.automation.uiAutomation.uiActions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


/**
 * 
 * @author Vivek Kumar Jha
 *
 */
import com.test.automation.uiAutomation.testBase.TestBase;

public class MyAccountPage extends TestBase{
	WebDriver driver;
	static String SignupCompletionTitle="MY ACCOUNT";
	public static final Logger log = Logger.getLogger(CreateAnAccountPage.class.getName());
	
	@FindBy(xpath = "//a[@title='Women']")
	private WebElement WomenSectionTab;
	
	@FindBy(xpath = "//a[@class='product_img_link']/img")
	private List<WebElement> ProductsList;
	
	@FindBy(css ="h1.page-heading")	
	private WebElement CreateAnAccountHeader;
	
	@FindBy(xpath = "//a[@title='Orders']")
	private WebElement OrderHistory;
	
 public MyAccountPage(WebDriver driver) {
	 super();
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
 }
 
 public void VerifyMyAccountPage() {
		
	 waitForElement(driver, 20, CreateAnAccountHeader);
	 	
	 	Assert.assertEquals(CreateAnAccountHeader.getText(), SignupCompletionTitle,"Create An account Page Title");
	 }
 
 public void ClickWomenTab() {
	 WomenSectionTab.click();
	 
 }
 
 public ProductDetailPage ClickWomenSectionProduct(WebDriver driver) {
	 ProductsList.get(0).click();
	 
	 return new ProductDetailPage(driver);
 }
 
 public OrderDetailsPage GetOrderHistory(WebDriver driver) {
	 waitForElement(driver, 20, OrderHistory);
	 OrderHistory.click();
	 
	 return new OrderDetailsPage(driver);
 }
}
