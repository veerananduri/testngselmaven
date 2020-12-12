package com.tests;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageobjects.WordPressHomePageObjects;
import com.pageobjects.WordPressLoginPageObjects;
import com.utils.Commons;
import com.utils.PropertyReaderUtils;
import com.utils.Setup;

public class WordPressHomePageTest extends Setup {
	
	Commons commons;	
	
	public void initTest() {
		RemoteWebDriver driver = callDriver();
		super.driver=driver;
		commons = new Commons(driver);
		clickLogin();
	}
	
	WordPressLoginPageObjects wpPO = new WordPressLoginPageObjects();
	WordPressHomePageObjects wpHPPO = new WordPressHomePageObjects();
	
	@Test
	public void homePageTest() {
		initTest();
		
		//Validate left menu
		boolean value = commons.isDisplayed(wpHPPO.leftMenuBar());
		
		if(value) {
			Assert.assertTrue(value, "Left menu bar is displayed");
		} else {
			Assert.assertTrue(value, "Left menu bar is displayed");			
		}
	}
	
	//@Test
	public void homePageTest1() {
		initTest();
		
		//Homework - Write few test
		
	}
	
	//@Test
	public void homePageTest2() {
		initTest();
		
		//Homework - Write few test
	}
	
	//@Test
	public void homePageTest3() {
		initTest();
		
		//Homework - Write few test
	}
	
	private void clickLogin() {
		driver.get(PropertyReaderUtils.getProperty("url"));
		
		commons.typeValue(wpPO.loginField(), "opensourcecms");
		
		commons.typeValue(wpPO.pwdField(), "opensourcecms");

		commons.clickElement(wpPO.clickLogin());
	}
}
