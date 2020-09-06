package com.login;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;



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
		

	}

	
	@BeforeMethod
	public void beforeMethod() {
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}



	@Test(dataProvider = "ValidData")
	public void  validTest(String email, String password) throws InterruptedException {

		logger = report.createTest("Valid Test");

		driver.get(baseUrl);
		WebElement Email = driver.findElement(By.id("input-email"));
		WebElement Password = driver.findElement(By.id("input-password"));
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

		Email.clear();
		Email.sendKeys(email);

		Password.clear();
		Password.sendKeys(password);

		loginButton.click();
		
		WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]"));
		String myAccountText = myAccount.getText();
		
		Assert.assertEquals("My Account", myAccountText);
		


	}

	@Test(dataProvider="InvalidData")
	public void invalidTest(String email, String password) {

		logger = report.createTest("Invalid Test");

		driver.get(baseUrl);

		WebElement Email = driver.findElement(By.id("input-email"));
		WebElement Password = driver.findElement(By.id("input-password"));
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));

		Email.clear();
		Email.sendKeys(email);

		Password.clear();
		Password.sendKeys(password);

		loginButton.click();

		WebElement warning = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]"));
		String warningText = warning.getText();
		Assert.assertEquals("Warning: No match for E-Mail Address", warningText);

		
	}
	
	
	
	@AfterTest
	public void afterTest() {

		report.flush();		
		driver.quit();
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		
		if(result.getStatus()==ITestResult.FAILURE) {
			
			logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
			logger.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
								
		} 
		
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.log(Status.PASS, "Test Passed"+result.getName());
			
		}
		
		else if(result.getStatus()==ITestResult.SKIP) {
			
			logger.log(Status.SKIP, "Test is Skipped" +result.getName());			
		}
		
		
		
		driver.close();		
		
	}



	
	 

}