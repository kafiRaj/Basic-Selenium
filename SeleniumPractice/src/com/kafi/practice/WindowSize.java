package com.kafi.practice;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class WindowSize {
	
	public static void main(String[] args) {		
		
			
		//getting driver from Config Class
		WebDriver driver = Config.getFirefoxDriver();
		
		
		//Open opencart website
		driver.get("https://demo.opencart.com/");
		
		
		//getting current window size
		Dimension size = driver.manage().window().getSize();
		
		System.out.println("Actual Window size is: " + size);
		
		
		//setting window size as 1000*600
		driver.manage().window().setSize(new Dimension(1000, 600));
		
		//checking that the window size is correct
		Dimension newSize = driver.manage().window().getSize();
		int width = newSize.getWidth();
		int height = newSize.getHeight();
		System.out.println("New window size is: Width, Height = " + width +" , "+ height );
		
				
		
	}


}
