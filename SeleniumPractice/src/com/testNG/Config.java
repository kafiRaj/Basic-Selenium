package com.testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Config {
  @Test
  public void f() {
	  
  }
  
  
	public static WebDriver getFirefoxDriver() {
		
		
		System.setProperty("webdriver.gecko.driver", "E:\\Testing\\Tools\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		
		
		WebDriver driver = new FirefoxDriver();
		
		
		return driver;
	}
	
	public static WebDriver getChromeDriver() {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\Tools\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		return driver;
	}

}
