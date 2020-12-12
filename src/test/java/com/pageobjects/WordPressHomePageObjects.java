package com.pageobjects;

import org.openqa.selenium.By;

public class WordPressHomePageObjects {

	public By displayName() {
		By name = By.xpath("//*[@id='wp-admin-bar-my-account']/a/span");
		return name;
	}
	
	public By leftMenuBar() {
		By menu = By.cssSelector("ul#adminmenu");
		return menu;
	}
}
