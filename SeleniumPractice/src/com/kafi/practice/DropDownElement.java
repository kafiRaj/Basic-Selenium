package com.kafi.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownElement {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = Config.getChromeDriver();
		
		String BaseUrl="https://the-internet.herokuapp.com/dropdown";

		driver.get(BaseUrl);
		
		WebElement ddElement=driver.findElement(By.xpath("//*[@id=\"dropdown\"]"));
		
		//Create object for select 
		Select dropdown=new Select(ddElement);
		//dropdown.selectByVisibleText("Option 2");
		
		//dropdown.selectByValue("1");
		
		dropdown.selectByIndex(2);
		
		Thread.sleep(5000);
		
		driver.close();
		
		

	}

}
