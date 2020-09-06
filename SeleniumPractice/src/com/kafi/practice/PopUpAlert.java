package com.kafi.practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopUpAlert {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = Config.getChromeDriver();


		driver.get("https://the-internet.herokuapp.com/javascript_alerts");


		WebElement jsAlert = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
		jsAlert.click();
		Thread.sleep(4000);
		PopUpAlert.jsAlertAccept();

		Thread.sleep(4000);


		WebElement jsAlert2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
		jsAlert2.click();
		Thread.sleep(4000);
		PopUpAlert.jsAlertCancel();
		
		
		WebElement jsAlert3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
		jsAlert3.click();
		Thread.sleep(4000);
		PopUpAlert.jsAlertTypeIn();
		
		
		


	}



	public static void jsAlertAccept() {

		try{
			Alert jsAlert = driver.switchTo().alert();

			System.out.println(jsAlert.getText());

			jsAlert.accept();

			System.out.println("Alert Accepted !!!");

		}catch(Exception e) {

			System.out.println("Ops! Something went wrong: " + e.getMessage());

		}

	}



	public static void jsAlertCancel() {

		try{
			Alert jsAlert = driver.switchTo().alert();

			System.out.println(jsAlert.getText());

			jsAlert.dismiss();

			System.out.println("Alert Canceled !!!");

		}catch(Exception e) {

			System.out.println("Ops! Something went wrong: " + e.getMessage());

		}		

	}



	public static void jsAlertTypeIn() {

		try{
			Alert jsAlert = driver.switchTo().alert();

			System.out.println(jsAlert.getText());
			
			String text = "Hello World";

			jsAlert.sendKeys(text);
			
			Thread.sleep(5000);
			
			jsAlert.accept();

			System.out.println("Alert Accepteed!!!");
			
			

		}catch(Exception e) {

			System.out.println("Ops! Something went wrong: " + e.getMessage());

		}		

	}

}
