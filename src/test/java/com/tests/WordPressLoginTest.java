package com.tests;

import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageobjects.WordPressHomePageObjects;
import com.pageobjects.WordPressLoginPageObjects;
import com.utils.Commons;
import com.utils.ExcelUtils;
import com.utils.PropertyReaderUtils;
import com.utils.Setup;

public class WordPressLoginTest extends Setup {

	Commons commons;

	public void initTest() {
		RemoteWebDriver driver = callDriver();
		super.driver = driver;
		commons = new Commons(driver);
	}

	WordPressLoginPageObjects wpPO = new WordPressLoginPageObjects();
	WordPressHomePageObjects wpHPPO = new WordPressHomePageObjects();

	@Test(dataProvider = "Login")
	public void loginTest(String username, String password) {

		// Step1 : Initialize the driver
		initTest();

		driver.get(PropertyReaderUtils.getProperty("url"));

		commons.typeValue(wpPO.loginField(), username);

		commons.typeValue(wpPO.pwdField(), password);

		commons.clickElement(wpPO.clickLogin());

		// Validate the display name is present
		// TestNG Assertions
		boolean value = commons.isDisplayed(wpHPPO.displayName());
		Assert.assertTrue(value);

		/*
		 * String text = commons.getText(wpHPPO.displayName());
		 * 
		 * Assert.assertEquals("Checking the text of the display name", "opensourcecms",
		 * text);
		 */
	}

	/*
	 * Assignment : 10/4 Add a google search test using dataprovider
	 */

	@DataProvider(name = "Login")
	public static Object[][] Login() {

		Object[][] testObject = ExcelUtils
				.readExcel(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx", "Sheet1");
		return testObject;
	}

	@Test
	public void test() {
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("os.name"));
	}

}
