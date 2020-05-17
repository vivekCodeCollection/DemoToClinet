package com.test.automation.uiAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.test.automation.uiAutomation.testBase.TestBase;


/**
 * 
 * @author Vivek Kumar Jha
 *
 */
public class MyOrderPage extends TestBase {
	
	public static String TotalPriceAtMyorder, ToatlpriceAtConfirmationPage;
	
    WebDriver driver;
    public static final Logger log = Logger.getLogger(CreateAnAccountPage.class.getName());
    
    @FindBy(xpath = "//p[@class='cart_navigation clearfix']//span[contains(text(),'Proceed to checkout')]")
    private WebElement ProceedToCkout;
    
    @FindBy(id="total_price")
    private WebElement TotalPrice;
    
    @FindBy(xpath ="//div[@id='uniform-cgv']")
    private WebElement IAggreeShipping;
    
    @FindBy(xpath = "//a[@class='bankwire']")
    private WebElement BankWire_btn;
    
    @FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
    private WebElement IconfirmMyOrder_btn;
    
    @FindBy(xpath = "//strong[contains(text(),'Your order on My Store is complete.')]")
    private WebElement MyOrderConfirmation;
    
    @FindBy(xpath = "//span[@class='price']")
    private WebElement MyPriceAtConfirmationpage;
    
    @FindBy(xpath = "//a[@title='View my customer account']")
    private WebElement ReturnToAccountHome;
    
	public MyOrderPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickonProceedTockout() {
		
		waitForElement(driver, 130, ProceedToCkout);
		ProceedToCkout.click();
		
	}
	
	public String GetTotalPriceAtMyorder() {
		waitForElement(driver, 130, TotalPrice);
		TotalPriceAtMyorder=TotalPrice.getText();
		
		return TotalPriceAtMyorder;
	}
	
	public void clickonIAggree() {
		IAggreeShipping.click();
	}
	
	public void ClickOnPayBankWire() {
		
		waitForElement(driver, 30, BankWire_btn);
		BankWire_btn.click();
	}
	
	public void ClickIConfirmMyOrder() {
		
		waitForElement(driver, 20, IconfirmMyOrder_btn);
		IconfirmMyOrder_btn.click();
		
	}
	
	public void VerifyMyorderConfirmationPage() {
		MyOrderConfirmation.isDisplayed();
		
		Assert.assertTrue(MyOrderConfirmation.isDisplayed(), "My order has been confirmed ");
	}
	
	public void GetPriceMyConfirmationPage() {
		ToatlpriceAtConfirmationPage=MyPriceAtConfirmationpage.getText();
	}
	
	public void VerifyPrice() {		
		Assert.assertEquals(TotalPriceAtMyorder, ToatlpriceAtConfirmationPage,"Price has been matched");
	}
	
	public MyAccountPage ReturnToHome(WebDriver driver) {
		
		waitForElement(driver, 20, ReturnToAccountHome);
		ReturnToAccountHome.click();
		
		return new MyAccountPage(driver);
	}
	
	public void ProceedToCheckout() {
		GetTotalPriceAtMyorder();
		ClickonProceedTockout();
		ClickonProceedTockout();
		clickonIAggree();
		ClickonProceedTockout();
		ClickOnPayBankWire();
		ClickIConfirmMyOrder();
		VerifyMyorderConfirmationPage();
		GetPriceMyConfirmationPage();
		VerifyPrice();
				
	}
}
