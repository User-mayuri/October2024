package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class AccountPage {
	private WebDriver driver;
	private ElementUtil eleutil;
	
	//1.private By locator
	private By logouLink=By.linkText("Logout");
	private By accountLink=By.linkText("My Account");
	private By headers=By.cssSelector("div#content h2");
	
	//2.public page class constructor
    public AccountPage(WebDriver driver) {
	this.driver=driver;
	eleutil= new ElementUtil(driver);
	}
  
    public String getAccPageTitle()
    {
   	 String title=driver.getTitle();
   	 System.out.println("tilie="+title);
   	 return title;
    }
    
    public String getAccPageUrl()
    {
   	 String url=eleutil.waitForURLContains("route=account/account", 5);
   	 System.out.println("url="+url);
   	 return url;
    }
    
    
}


