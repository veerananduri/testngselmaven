package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Commons extends Setup {

	protected RemoteWebDriver driver;
	
	public Commons(RemoteWebDriver driver) {
		this.driver=driver;
	}	
	
	public void typeValue(By locator, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(value);
	}
	
	public void clickElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();
	}
	
	public boolean isDisplayed(By locator) {
		boolean availability;
		return availability = driver.findElement(locator).isDisplayed();		
	}
	
	public String getText(By locator) {
		String text = driver.findElement(locator).getText();
		return text;
	}
}
