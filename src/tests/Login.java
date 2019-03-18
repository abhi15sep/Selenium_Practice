package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.DashboardPage;
import pages.LoginPage;
import utilities.DriverFactory;

public class Login {
	
	@Test
	public void loginTestPOM() {
		//1. Initialize driver
		WebDriver driver = DriverFactory.open("Firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		//2. Enter login information (Login page)
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName("raviraj@yopmail.com");
		loginPage.setPassword("thbs123!");
		loginPage.clickSubmit();
		
		
		//3. Get confirmation page (Dashboard page)
		DashboardPage dashboardPage = new DashboardPage(driver);
		String conf = dashboardPage.confirmationMessage();
		Assert.assertTrue(conf.contains("Logged in"));
		
		
		//4. Close the driver
		driver.quit();
	}
	


}
