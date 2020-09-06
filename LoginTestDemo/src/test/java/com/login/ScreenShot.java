package com.login;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {

	public static void main(String[] args) throws IOException {
	
		WebDriver driver;
		String chromeDriverPath=".\\src\\test\\resources\\Drivers\\chromedriver.exe";
		String baseUrl="https://demo.opencart.com/index.php?route=account/login";

		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(baseUrl);
		
		
		
		
		//Take screenshot
				File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				String destination = System.getProperty("user.dir") + "/Screenshots/"+"facebook2.png";
				try {
					
					FileUtils.copyFile(srcFile, new File(destination),true);
				} 
				catch (IOException e) 
				{
			
					System.out.println("Error"+e);
					e.printStackTrace();
				}
				
		
		driver.close();
	}
	
	
	

}
