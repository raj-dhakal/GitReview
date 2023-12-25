package com.extentreports;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {
	ExtentReports extent;
	@BeforeTest
	public void config() {
		
		String path = System.getProperty("user.dir") +"//reports//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
	}
	
	@Test
	public void initialExtentReportDemo() {
		extent.createTest("Initial Extent Demo");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		extent.flush();
		
	}

}
