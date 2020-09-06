package com.kafi.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookSignIn {

	public static void main(String[] args) {

		WebDriver driver = Config.getChromeDriver();
		
		String baseUrl = "https://www.facebook.com/r.php";
		
		driver.get(baseUrl);
		
		//Finding Location of Drop Down Element.
		WebElement date = driver.findElement(By.xpath("//*[@id=\"day\"]"));
		WebElement month = driver.findElement(By.xpath("//*[@id=\"month\"]"));
		WebElement year = driver.findElement(By.xpath("//*[@id=\"year\"]"));

		
		//Select Drop Down Element
		Select dDdate = new Select(date);
		Select dDmonth = new Select(month);
		Select dDyear = new Select(year);
		
		
		//sending value to Drop Down Element.		
		dDdate.selectByValue("10");
		dDmonth.selectByVisibleText("Jan");
		dDyear.selectByVisibleText("1995");
		
		
		
		try {
			Thread.sleep(500);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		driver.close();
		
	}

}
