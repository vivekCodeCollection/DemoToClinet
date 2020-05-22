package com.test.automation.uiAutomation.UiCommonMethods;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectDDP {
	
	public static void selectByVisibleText(WebElement element,String DDPvalue) {
		Select select=new Select(element);
		select.selectByVisibleText(DDPvalue);
	}

}
