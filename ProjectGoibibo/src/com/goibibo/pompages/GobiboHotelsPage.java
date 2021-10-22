package com.goibibo.pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.goibibo.generic.BaseTest;
import com.goibibo.generic.Utils;

public class GobiboHotelsPage extends BaseTest{
	
	@FindBy(id="downshift-1-input")
	private WebElement LST_Locations;

	@FindBy(id="downshift-1-menu")
	private WebElement TXT_Destination;
	
	@FindBy(xpath="//span[normalize-space()='Ooty']")
	private WebElement OPT_Dest;
	
	@FindBy(xpath="//div[text()='Check-in']//following-sibling::h4")
	private WebElement OPT_CheckInDateFeild ;
	
	@FindBy(xpath="//div[@data-testid='CalendarBlockOuterWrapper']//following::li[@class='date_is_selectable_true']")
	private WebElement TXT_CheckinDate;
	
	public GobiboHotelsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickonLocation() {
		try {
			veryElementPresent(LST_Locations);
			LST_Locations.click();
			//log.info("Clicked on Location");
		}catch(Exception e) {
			e.getMessage();
			//log.info("unable to Click on Location");
		}
		
	}
	public void EnterLocationSelect(String strLocation) {
	
		try {
			
			veryElementPresent(LST_Locations);
			LST_Locations.sendKeys(strLocation);
			OPT_Dest.click();
			//log.info("Location entered");
		}catch(Exception e) {
			e.printStackTrace();
			//log.info("unable to Location entered");
		}
	}
	public void setCheckIndates() 
	{
		String strCheckIndatedate =Utils.getCurrentDate();
		String strCheckoutdatedate = Utils.addDaystoTodaysDate(2);
		veryElementPresent(OPT_CheckInDateFeild);
		OPT_CheckInDateFeild.click();
		wait.until(ExpectedConditions.visibilityOf(TXT_CheckinDate));
		WebElement checkInDate,checkOutDate;
		checkInDate= getDynamicElement("strCheckIndatedate");
		
		checkOutDate= getDynamicElement("strCheckoutdatedate");
		checkInDate.click();
		checkOutDate.click();
		
		
		//TXT_CheckinDate.findElement(By.xpath(String.format("//span[text()='%s']", strCheckIndatedate))).click();
		//TXT_CheckinDate.findElement(By.xpath(String.format("//span[text()='%s']", strCheckoutdatedate))).click();
	}
	public WebElement getDynamicElement(String SystemName){
		return TXT_CheckinDate.findElement(By.xpath(String.format("//span[text()='%s']", SystemName)));
		}
}
