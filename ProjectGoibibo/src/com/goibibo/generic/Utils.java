package com.goibibo.generic;

import java.text.SimpleDateFormat;
import java.util.Date;

import bsh.Parser;

public class Utils extends BaseTest
{
	
	public static String getCurrentDate() {
//		Date date=java.util.Calendar.getInstance().get
//		System.out.println(date);
		String sDate="";
		try {
			Date dNow = new Date();
			SimpleDateFormat sdt = new SimpleDateFormat("dd");
			sDate=sdt.format(dNow);
		}catch(Exception e) {
			
		}
		return sDate ;
	}
	
	public static String addDaystoTodaysDate(int days) {
		return String.valueOf(Integer.parseInt(getCurrentDate())+days);
		
	}

	

}
