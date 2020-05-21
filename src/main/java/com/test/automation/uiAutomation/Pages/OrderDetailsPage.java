package com.test.automation.uiAutomation.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.test.automation.uiAutomation.Generic.Base.TestBase;


public class OrderDetailsPage extends TestBase{
    public static String orderhistoryheader ="ORDER HISTORY";
	WebDriver driver;
    public static final Logger log = Logger.getLogger(CreateAnAccountPage.class.getName());
	
    @FindBy(xpath = "//span[@class='price']")
    private WebElement OrderPrice;
    
    @FindBy(xpath = "//h1[@class='page-heading bottom-indent']")
    private WebElement OrderHistoryPageHeader;
    
	public OrderDetailsPage(WebDriver driver) {
		
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String GetOrderPrice() {
	waitForElement(driver, 30, OrderPrice);
	return	OrderPrice.getText();
		
	}
	
	public void VerifyOrderPriceFromePaymentPage() {
		Assert.assertEquals(OrderHistoryPageHeader.getText(), orderhistoryheader,"Order History page Title page should be matched");
		Assert.assertEquals(GetOrderPrice(), MyOrderPage.ToatlpriceAtConfirmationPage,"Order price should be matched");
	}
}
