package com.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class LoginPageTest {


	//Extent Report

	ExtentSparkReporter htmlReport;
	ExtentReports report;
	ExtentTest logger;

	WebDriver driver;

	String chromeDriverPath=".\\src\\test\\resources\\Drivers\\chromedriver.exe";
	String baseUrl="https://demo.opencart.com/index.php?route=account/login";






	@DataProvider(name="ValidData")
	public Object[][] validData() {

		Object [][] validData = new Object[1][2];

		validData[0][0] = "kafiraj.27@gmail.com";
		validData[0][1] = "120862ks";


		return validData;
	}


	@DataProvider(name="InvalidData")
	public Object[][] invData() {

		Object[][] invData = new Object[1][2];

		invData[0][0] = "example@gmail.com";
		invData[0][1] = "123456";


		return invData;
	}



	@BeforeTest
	public void beforeTest() {


		htmlReport = new ExtentSparkReporter(System.getProperty("user.dir")+"\\ExtentReport\\MyLoginTestReport.html");
		htmlReport.config().setDocumentTitle("Functional Testing");
		htmlReport.config().setTheme(Theme.DARK);
		
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		
		report.setSystemInfo("Tester Name", "Abdullah Al Kafi");
		report.setSystemInfo("OS", "Windows-7");
		report.setSystemInfo("Browser", "Chrome");
		


		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
	}




	@Test(dataProvider = "ValidData")
	public void  validTest(String email, String password) throws InterruptedException {



		driver.get(baseUrl);
		WebElement Email = driver.findElement(By.id("input-email"));
		WebElement Password = driver.findElement(By.id("input-password"));
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

		Email.clear();
		Email.sendKeys(email);

		Password.clear();
		Password.sendKeys(password);

		loginButton.click();
		
		logger = report.createTest("Valid Test");
		logger.log(Status.PASS, "Test Passed");
		


	}

	@Test(dataProvider="InvalidData")
	public void invalidTest(String email, String password) {



		driver.get(baseUrl);

		WebElement Email = driver.findElement(By.id("input-email"));
		WebElement Password = driver.findElement(By.id("input-password"));
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

		Email.clear();
		Email.sendKeys(email);

		Password.clear();
		Password.sendKeys(password);

		loginButton.click();


		logger = report.createTest("Invalid Test");
		logger.log(Status.PASS, "Test Passed");



	}


	@AfterTest
	public void afterTest() {

		report.flush();
		driver.close();

	}




}
