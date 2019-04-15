package com.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class HomePage extends TestBase{

	public HomePage() {
		System.out.println("Inside Homepage Constructor...");
		PageFactory.initElements(driver, this);
	}
}
