package com.kafi.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MoveElement {

	public static void main(String[] args) {
		
		
		WebDriver driver = Config.getChromeDriver();
		
		String baseUrl = "https://newgen-bd.com/";
		
		driver.get(baseUrl);
		
		
		WebElement mouseHover=driver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[4]"));
		
		
		moveToElement(driver, mouseHover);
		
		
		driver.findElement(By.linkText("Blog")).click();
		
	
	
	}
	
	
	public static void moveToElement(WebDriver driver, WebElement element) {
		
		Actions obj = new Actions(driver);
		obj.moveToElement(element).build().perform();
		
	}
	

}
