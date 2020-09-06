package com.kafi.practice;

import org.openqa.selenium.WebDriver;

public class Navigate {

	public static void main(String[] args) throws InterruptedException {
		
		
		//getting driver from Config Class
				WebDriver driver = Config.getFirefoxDriver();
				
				//opening account login page
				driver.get("https://demo.opencart.com/index.php?route=account/login");
				
				//stop execution for 3 second
				Thread.sleep(3000);
				
				//opening google home page
				driver.navigate().to("https://www.google.com/");
				
				Thread.sleep(3000);

				
				//coming back to account login page
				driver.navigate().back();
				
				Thread.sleep(3000);

				
				//going agin to google home page
				driver.navigate().forward();
				
				
				Thread.sleep(3000);

				
				//refreshing google home page
				driver.navigate().refresh();
				
				Thread.sleep(3000);

				
				driver.close();

	}

}
