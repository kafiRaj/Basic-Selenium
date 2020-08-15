package com.kafi.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Config {
	
	public static WebDriver getDriver() {
		
		
		System.setProperty("webdriver.gecko.driver", "E:\\Testing\\Tools\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		
		
		WebDriver driver = new FirefoxDriver();
		
		
		return driver;
	}

}
