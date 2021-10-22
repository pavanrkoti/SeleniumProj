package com.goibibo.testscripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.goibibo.generic.BaseTest;
import com.goibibo.generic.Utils;
import com.goibibo.pompages.GobiboHomePage;
import com.goibibo.pompages.GobiboHotelsPage;

public class HotelSearch extends BaseTest{
	GobiboHomePage gHomePage=null;
	GobiboHotelsPage gHotelPage=null;
	
	@Test
	public void SearchHotel()  
	{
		
		String strSearchOption = "Hotels";
		String strLocation = "ooty";
		
		gHomePage = new GobiboHomePage(BaseTest.driver);
		gHotelPage = new GobiboHotelsPage(BaseTest.driver);
		
				
		gHomePage.clickLink(strSearchOption);
		gHotelPage.clickonLocation();
		gHotelPage.EnterLocationSelect(strLocation);
		gHotelPage.setCheckIndates();
		
		try {
			gHomePage.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
