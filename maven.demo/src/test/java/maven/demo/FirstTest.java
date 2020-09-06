package maven.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirstTest {


	public static void main(String[] args) {


	}




	@Test
	public void testFirst() {

		System.setProperty("webdriver.gecko.driver", "E:\\Testing\\Tools\\geckodriver-v0.27.0-win64\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
		searchBox.sendKeys("Abdullah Al Kafi");
		searchBox.sendKeys(Keys.ENTER);



	}


}

