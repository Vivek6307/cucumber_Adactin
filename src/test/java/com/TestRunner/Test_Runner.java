package com.TestRunner;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
@RunWith(Cucumber.class)
@CucumberOptions(features ="src//test//java//com//Adactin//feature",
glue ="com.Adactin.StepDef",monochrome = true,dryRun = false,
plugin = {"html:Reports/HtmlReport","pretty",
		"json:Reports/JsonReport.json",
		"com.cucumber.listener.ExtentCucumberFormatter:Reports/ExtentReport.html"})
public class Test_Runner {
	
		public static WebDriver driver; // Null

		@BeforeClass
		public static void setUp() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}

		@AfterClass
		public static void tearDown() {
			driver.close();
		}

}
