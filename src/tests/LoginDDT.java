package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.DriverFactory;
import utilities.Excel;

public class LoginDDT {
	
	WebDriver driver;
	
	@Test(dataProvider="getData")
	public void loginTest(String name, String email, String password) {

		driver.findElement(By.id("MainContent_txtUserName")).sendKeys(email);

		driver.findElement(By.id("MainContent_txtPassword")).sendKeys(password);

		driver.findElement(By.id("MainContent_btnLogin")).click();

		String message = driver.findElement(By.id("conf_message")).getText();
		System.out.println("CONFIRMATION: " + message);

	}
	
	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.open("firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider
	public String[][] getData() {
		return Excel.get("/Users/abhay/Documents/selenium/selenium_workspace/SeleniumTraining/src/utilities/UserLogin.xls");
	}
}
