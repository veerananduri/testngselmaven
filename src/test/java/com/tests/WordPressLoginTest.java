package com.tests;

import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.pageobjects.WordPressHomePageObjects;
import com.pageobjects.WordPressLoginPageObjects;
import com.utils.Commons;
import com.utils.Setup;

public class WordPressLoginTest extends Setup {
	
	Commons commons;	
	
	public void initTest() {
		RemoteWebDriver driver = callDriver();
		super.driver=driver;
		commons = new Commons(driver);
	}
	
	WordPressLoginPageObjects wpPO = new WordPressLoginPageObjects();
	WordPressHomePageObjects wpHPPO = new WordPressHomePageObjects();
	
	@Test
	public void loginTest() {		
		
		//Initialize the driver
		initTest();
		
		driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");
		
		commons.typeValue(wpPO.loginField(), "opensourcecms");
		
		commons.typeValue(wpPO.pwdField(), "opensourcecms");
		
		commons.clickElement(wpPO.clickLogin());
		
		//Validate the display name is present
		//TestNG Assertions
		boolean value = commons.isDisplayed(wpHPPO.displayName());
		Assert.assertTrue(value);
		
		String text = commons.getText(wpHPPO.displayName());
		
		Assert.assertEquals("Checking the text of the display name", "opensourcecms", text);
	}

}
