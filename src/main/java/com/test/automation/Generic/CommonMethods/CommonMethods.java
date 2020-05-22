package com.test.automation.Generic.CommonMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods  {
	
	static Properties properties = new Properties();

public static String RandomeStringGenrateofEightDigit(int n) {
	String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789"
            + "abcdefghijklmnopqrstuvxyz"; 

// create StringBuffer size of AlphaNumericString 
StringBuilder sb = new StringBuilder(n); 

for (int i = 0; i < n; i++) { 

// generate a random number between 
// 0 to AlphaNumericString variable length 
int index 
= (int)(AlphaNumericString.length() 
* Math.random()); 

// add Character one by one in end of sb 
sb.append(AlphaNumericString 
  .charAt(index)); 
} 

return sb.toString();
}

public static void SaveInProperties(String key,String value) {
	Properties properties = new Properties();
	try {
		InputStream inputstream = new FileInputStream(System.getProperty("user.dir")+Constants.CommonProp_Filepath);
		properties.load(inputstream);
		 OutputStream outputStream = new FileOutputStream(System.getProperty("user.dir")+Constants.CommonProp_Filepath);  
		
		properties.setProperty(key, value);	  
	    properties.store(outputStream, null);
	} catch (IOException e) {
	    e.printStackTrace();
	} 
}

public static String GetProperties(String key) {
	
	String value=null;
	try {		  
		File file = new File(System.getProperty("user.dir") + "/resources/Configuration/common.properties");
		FileInputStream f = new FileInputStream(file);	
		properties.load(f);
		value=properties.getProperty(key);
		
	} catch (IOException e) {
	    e.printStackTrace();
	} 
	
	return value;
}

}
