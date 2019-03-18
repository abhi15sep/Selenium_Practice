package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.LoginPageFactory;
import utilities.DriverFactory;

public class LoginFactory {
	
	String userName = "raviraj@yopmail.com";
	String password = "thbs123!";
	
	@Test
	public void loginTestPageFactory() {
		//1. Initialize driver
		WebDriver driver = DriverFactory.open("Firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		//Enter Login
		LoginPageFactory loginPage = new LoginPageFactory(driver);
		loginPage.login(userName, password );
	}
}
