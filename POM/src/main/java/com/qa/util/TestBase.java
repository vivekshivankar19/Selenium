package com.qa.util;


import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	//public static WebEventListner eventListner;
	
	public ExtentReports extend;
	public ExtentTest logger;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\lenovo\\eclipse-workspace\\POM\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fis);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void init() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.out.println("Browser for the test is Chrome");
			System.setProperty("webdriver.chrome.driver" , prop.getProperty("chromeDriverPath"));
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
			driver = new ChromeDriver(options);
			
		}else if(browserName.equalsIgnoreCase("FF")){
			System.out.println("Browser for the test is Chrome");
			System.setProperty("", "");
			System.setProperty("webdriver.chrome.driver" , prop.getProperty("chromeDriverPath"));
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	
	
}
