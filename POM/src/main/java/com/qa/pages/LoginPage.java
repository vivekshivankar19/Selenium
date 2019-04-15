package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class LoginPage extends TestBase{

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"loginForm\"]/div/div/input")  
	WebElement loginBtn;
		
	@FindBy(xpath="/html/body/div[2]/div/div[1]/a/img")
	WebElement crmLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateTheLoginPageTitle() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String UN, String Pass) {
		System.out.println("inside login function");
		username.sendKeys(UN);
		password.sendKeys(Pass);
		//loginBtn.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", loginBtn);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		username.sendKeys(UN);
		password.sendKeys(Pass);
		//loginBtn.click();
	    js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", loginBtn);

		
		return new HomePage();
	}
	
	public HomePage login1(String UN, String Pass) {
		System.out.println("inside login function");
		username.sendKeys(UN);
		password.sendKeys(Pass);
		//loginBtn.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", loginBtn);
			
		return new HomePage();
	}
}
