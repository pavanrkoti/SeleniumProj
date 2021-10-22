package com.goibibo.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.goibibo.generic.BaseTest;
import com.goibibo.generic.Utils;

public class GobiboHomePage extends BaseTest{
	
	@FindBy(xpath="//a[text()='Flights']")
	private WebElement LBL_Flights;
	@FindBy(xpath="//a[text()='Hotels']")
	private WebElement LBL_Hotels;

	public GobiboHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void clickLink(String strLnk) 
	{
		try {
			switch (strLnk) {
			case "Hotels": {
				veryElementPresent(LBL_Hotels);
				LBL_Hotels.click();
				break;
			}
			case "Flights": {
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + strLnk);
			}

		}catch (Exception e) {

		}
	}

}
