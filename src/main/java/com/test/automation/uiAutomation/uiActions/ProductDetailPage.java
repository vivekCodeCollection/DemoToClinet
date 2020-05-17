package com.test.automation.uiAutomation.uiActions;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testBase.TestBase;


/**
 * 
 * @author Vivek Kumar Jha
 *
 */
public class ProductDetailPage extends TestBase{
  
public String ToatlQty, ToatlPrice;
	
	WebDriver driver;
	
	public static final Logger log = Logger.getLogger(CreateAnAccountPage.class.getName());
    
	@FindBy(id="quantity_wanted")	
	private WebElement Quantity;
	
	@FindBy(xpath = "//button[@name='Submit']")
	private WebElement AddToCart_Btn;
	
	@FindBy(xpath = "//span[@class='ajax_cart_quantity']")
	private WebElement QuantityToAddedinCart;
	
	@FindBy(xpath = "//span[@class='ajax_block_cart_total']")
	private WebElement TotalCost;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	private WebElement ProceedTochkout_btn;
	
	@FindBy(xpath = "//iframe[@class='fancybox-iframe']")
	private WebElement FrameAtPopUp;
	
	public ProductDetailPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 
	
public void SetQuantity(String Qty) {
	
	System.out.println("Reached tO PopUp");
	waitForElement(driver, 30, FrameAtPopUp);
	driver.switchTo().frame(FrameAtPopUp);
	System.out.println("Switched To Frame");
	waitForElement(driver, 30, Quantity);
	Quantity.clear();
	Quantity.sendKeys(Qty);
}

public void ClickOnAddTocart() {
	AddToCart_Btn.click();
	
}

public String getQuantity() {
	
	ToatlQty=QuantityToAddedinCart.getText();
	
	return ToatlQty;
}

public String getTotalPrice() {
	
	ToatlPrice=TotalCost.getText();
	
	return ToatlPrice;
}

public MyOrderPage ClickOnProceedToChkout(WebDriver driver) {
	waitForElement(driver, 30, ProceedTochkout_btn);
	ProceedTochkout_btn.click();
	return new MyOrderPage(driver);
}

public void AddQnty_Procdtochkout(String Qty) {
	
	SetQuantity(Qty);
	ClickOnAddTocart();
	
}
}
