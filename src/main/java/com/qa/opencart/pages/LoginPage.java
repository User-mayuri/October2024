package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class LoginPage {
	//pageclass,pagelibrary
	private WebDriver driver;
	private ElementUtil eleutil;
	
	//1.private By locator
	private By emailid=By.id("input-email");
	private By password=By.id("input-password");
	private By loginButton=By.xpath("//input[@value='Login']");
	//private By xpath=By.xpath("(//a[text()=\"Forgotten Password\"])[2]");
	
	//2.public page class constructor
public LoginPage(WebDriver driver) {
	this.driver=driver;
	eleutil= new ElementUtil(driver);
	
	
}

	
	//3.public methods
     public String getLoginPageTitle()
     {
    	 String title=driver.getTitle();
    	 System.out.println("tilie="+title);
    	 return title;
     }
     
     public String getLoginPageUrl()
     {
    	 String url=driver.getCurrentUrl();
    	 System.out.println("url="+url);
    	 return url;
     }
     
     public AccountPage doLogin(String username,String pwd)
     {
    	 System.out.println("user cred: "+username+ ":"+pwd);
    	 eleutil.waitForElementVisible(emailid, 10).sendKeys(username);
    	 eleutil.doSendKeys(emailid, pwd);
    	 eleutil.doClick(loginButton);
    	 //return eleutil.waitForTitleIs("My Account", 5);
//    	 driver.findElement(emailid).sendKeys(name);
//    	 driver.findElement(password).sendKeys(pwd);
//    	 driver.findElement(loginButton).click();
//    	 return driver.getTitle();
    	 return new AccountPage(driver);
     }
}


