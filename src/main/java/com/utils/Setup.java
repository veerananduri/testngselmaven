package com.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Setup {

	protected RemoteWebDriver driver;
	
	public RemoteWebDriver callDriver() {
		
		String browser = PropertyReaderUtils.getProperty("browser");
		System.out.println("Browser returned : "+browser);
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\ganga\\eclipse-workspace\\SeleniumTrainingSept2020\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", 
					"C:\\Users\\ganga\\eclipse-workspace\\SeleniumTrainingSept2020\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			
		} else if(browser.equals("IE")) {
			//Assignment - Setup the Driver for IE & Launch
		} else if(browser.equals("Edge")) {
			//Assignment - Setup the Driver for Edge & Launch
		}
		return driver;
	}
	
	@AfterMethod (alwaysRun=true)
	public void afterMethod(ITestResult itestResult) {
		if(itestResult.getStatus() == 1) {
			System.out.println("Testcase is passed");
		} else if(itestResult.getStatus() == 2) {
			System.out.println("Testcase is Failed");
		} else {
			System.out.println("Testcase is Skipped");
		}
		if(driver!=null) {
			driver.close();
			driver.quit();
		}
	}
}
