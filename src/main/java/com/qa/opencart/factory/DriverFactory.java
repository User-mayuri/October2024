package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.opencart.execption.BrowserException;

public class DriverFactory {
	
	WebDriver driver;
	Properties prop;
	public WebDriver initDriver(Properties prop)
	{
		String browserName=prop.getProperty("browser");
		
		System.out.println("our browser name is : "+browserName);
		switch (browserName.trim().toLowerCase()) {
		case "chrome":
			driver=new ChromeDriver();
			break;
			
			case "firefox":
				driver=new FirefoxDriver();
				break;
				
				case "edge":
					driver=new EdgeDriver();
					break;

		default:
			System.out.println("please pass right broswer");
			throw new BrowserException("No browser found"+browserName);
			
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	public Properties initProp() {
		prop= new Properties();
		try {
			FileInputStream ip=new FileInputStream("./src/test/resources/config/config.properties");
		    try {
				prop.load(ip);
			} catch (IOException e) {
			e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
		   e.printStackTrace();
		}
		
		return prop;
	}
	

}
