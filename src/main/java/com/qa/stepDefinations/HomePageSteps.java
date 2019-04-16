package com.qa.stepDefinations;

import com.qa.pages.LoginPage;
import com.qa.util.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps extends TestBase{

	private LoginPage loginpage  = new LoginPage();
	
	@Given("^user open the browser$")
	public void user_open_the_browser() throws Throwable {
		System.out.println("User launch the browser.");
		TestBase.init();
	}

	@When("^User on login page$")
	public void user_on_login_page() throws Throwable {
	   System.out.println("user on login page.");
	   loginpage  = new LoginPage();
	   System.out.println("Login page title : "+ loginpage.validateTheLoginPageTitle());
	}
	
	@Then("^user enter username and password$")
	public void user_enter_username_and_password() throws Throwable {
	   System.out.println("un : "+ prop.getProperty("username") );
	   loginpage  = new LoginPage();
	   loginpage.login(prop.getProperty("username") , prop.getProperty("password"));
	   loginpage.login(prop.getProperty("username1") , prop.getProperty("password"));
	}

}
