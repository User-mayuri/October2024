package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.Basetest;

public class LoginPageTest extends Basetest {
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String actTitle=loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, "Account Login");
	}
	
	@Test(priority=2)
	public void loginPageUrl()
	{
		String actURL=loginPage.getLoginPageUrl();
		Assert.assertTrue(actURL.contains("/login"));
	}
	
	@Test(priority=3)
	public void login()
	{
		accPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	//String actTitle1=loginPage.doLogin("test.xyz@gmail.com", "12345");
	Assert.assertEquals(accPage.getAccPageTitle(), "Account Login");
	}
	}

