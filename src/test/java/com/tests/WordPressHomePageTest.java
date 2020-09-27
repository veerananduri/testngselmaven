package com.tests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.utils.Commons;
import com.utils.Setup;

public class WordPressHomePageTest extends Setup {
	
	Commons commons;	
	
	public void initTest() {
		RemoteWebDriver driver = callDriver();
		super.driver=driver;
		commons = new Commons(driver);
	}
	
	@Test
	public void homePageTest() {
		initTest();
		
		//Next Steps
	}
	
	
}
