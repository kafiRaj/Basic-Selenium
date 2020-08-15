package com.kafi.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageTest {

	public static void main(String[] args) throws InterruptedException {
		
		
		//getting driver from Config Class
		WebDriver driver = Config.getDriver();
		
		//opening account login page
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//finding email field
		WebElement email = driver.findElement(By.id("input-email"));
		
		//inserting in email field
		email.sendKeys("test@gmail.com");
		
		//finding password field
		WebElement password = driver.findElement(By.id("input-password"));
		
		//inserting in password field
		password.sendKeys("123456");

		
		//Finding Login Button
		WebElement login = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
		
		//click on Login Button
		login.click();
		
		
		/* 	checking test result.  As i am inserting wrong values so the login will be failed in it will show
		"Warning: No match for E-Mail Address and/or Password."  */
		
		//Finding xPath of Message Field
		WebElement message = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]"));
		
		String actualMessage = message.getText();
		
		System.out.println("Actual Message is: " + actualMessage);
		
		String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";
		
		if (expectedMessage.equalsIgnoreCase(actualMessage)) {
			
			System.out.println("Test Passed");
			
		} else {
			
			System.out.println("Opps! Test Failed!");

			
		}
		
		
		
		Thread.sleep(300);
		
		
		driver.close();
		
	}

}
