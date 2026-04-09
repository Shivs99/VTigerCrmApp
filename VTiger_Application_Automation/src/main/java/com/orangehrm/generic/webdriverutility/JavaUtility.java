package com.orangehrm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	//Generating Random Number
	public int getRandomNumber() {
		Random r = new Random();
		return r.nextInt(1000);
	}

	//Generating Date in Format
	public String getDate() {
		Date date = new Date();
		SimpleDateFormat sib = new SimpleDateFormat("YYYY-MM-dd");
		String dateformate = sib.format(date);
		return dateformate;
	}
}
