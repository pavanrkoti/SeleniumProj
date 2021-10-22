package com.goibibo.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
public class BaseTest implements AutoConts {
	public static WebDriver driver =null;
	public static Logger log=null;
	public  WebDriverWait wait=null;

	@BeforeMethod
	public void LaunchChrome()
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);		
		driver = new ChromeDriver();

		wait =new WebDriverWait(driver, 10); 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(APP_URL);
		System.out.println("Selenium Webdriver Script in Chrome");

	}
	@AfterMethod
	public void closeApp() 
	{
		driver.quit();
		System.out.println("Close the app");


	}
	public void veryElementPresent(WebElement ele) {
		WebDriverWait wait  = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
		}catch(Exception e) {

		}
	}
}
