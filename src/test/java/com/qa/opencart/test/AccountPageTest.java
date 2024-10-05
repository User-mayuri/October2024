package com.qa.opencart.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.Basetest;

public class AccountPageTest extends Basetest {
	@BeforeClass
	public void AccSetUp()
	{
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password")); 
	}
	
	@Test
	public void getAccPageTitleTest()
	{
		String actTitle=accPage.getAccPageTitle();
		Assert.assertEquals(actTitle, "Account Login");
	}

	@Test
	public void accPageURL()
	{
		String accUrl=accPage.getAccPageUrl();
		Assert.assertTrue(accUrl.contains("route=account/account"));
	}
}
