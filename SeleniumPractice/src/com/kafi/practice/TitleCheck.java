package com.kafi.practice;

import org.openqa.selenium.WebDriver;

public class TitleCheck {

	public static void main(String[] args) throws InterruptedException {
		
		//getting driver from Config Class
		WebDriver driver = Config.getDriver();
		
		//opening account login page
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		
		String expectedTitle = "Account Login";
		
		//getting actual title
		String actualTitle = driver.getTitle();
		System.out.println("Actual Title is: " + actualTitle);
		
		//checking that the actual title and expected title are same
		
		if	(expectedTitle.equals(actualTitle)) {
			
			System.out.println("Test passed");
			
		} else {
			
			System.out.println("Opps! Test Faild!");

		}
		
		
		Thread.sleep(1000);
		
		driver.close();
		

	}

}
