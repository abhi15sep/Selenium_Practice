package tests;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.CSV;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {
	
	String name, email,  phone, gender, password, country;
	boolean weeklyEmail, monthlyEmail, occasionalEmail;
	WebElement nameElement, emailElement, phoneElement, passwordElement, verifyPasswordElement, countryElement, maleRadio, femaleRadio, weeklyCheckbox;
	WebDriver driver;
	
	// Test method here
	@Test
	public void newAccountTest() {
		System.out.println("NEW RECORD " + name + " "+ email + " " + phone + " " + gender + " " + password + " " + country + " " + weeklyEmail + " " + monthlyEmail + " " + occasionalEmail);
		
		//Define Web Elements
		defineWebElements();
		
		//3. Fill out the form
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phone);
		passwordElement.sendKeys(password);
		verifyPasswordElement.sendKeys(password);
		new Select(countryElement).selectByVisibleText(country);
		
		//Gender radio button
		if (gender.equalsIgnoreCase("Male")) { maleRadio.click(); } 
		else { femaleRadio.click(); }
		
		//Check box
		if (weeklyEmail) {
			if (!weeklyCheckbox.isSelected()) { weeklyCheckbox.click();}
		} else {
			if (weeklyCheckbox.isSelected()) {weeklyCheckbox.click();}
		}

		driver.findElement(By.id("MainContent_checkUpdates")).click();
		//driver.findElement(By.id("MainContent_btnSubmit")).click();
		
	}
	
	@Before
	public void setUp() {
		driver = utilities.DriverFactory.open("chrome");
		
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.linkText("CREATE ACCOUNT")).click();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	public void defineWebElements() {
		
		nameElement = driver.findElement(By.id("MainContent_txtFirstName"));
		emailElement = driver.findElement(By.name("ctl00$MainContent$txtEmail"));
		phoneElement = driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']"));
		passwordElement = driver.findElement(By.cssSelector("input[type='password'][id='MainContent_txtPassword']"));
		verifyPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
		countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		maleRadio = driver.findElement(By.id("MainContent_Male"));
		femaleRadio = driver.findElement(By.id("MainContent_Female"));
		weeklyCheckbox = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
	}
	
	// This annotated method is designed to pass parameters into the class
	@Parameters
	public static List<String[]> getTestData() {
		return CSV.get("/Users/abhay/Documents/selenium/selenium_workspace/SeleniumTraining/src/utilities/UserAccounts.csv");
	}
	
	// Constructor method
	// 1. Take parameters from the @Parameters method
	// 2. Parse each element into the arguments
	// 3. It will iterate this for each record
	public NewAccountDDT(String name, String email, String phone, String gender, String password, String country, String weeklyEmail, String monthlyEmail, String occasionalEmail) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
		this.country = country;
		if ("TRUE".equals(weeklyEmail)) { this.weeklyEmail = true; } 
		else { this.weeklyEmail = false; }
		if ("TRUE".equals(monthlyEmail)) { this.monthlyEmail = true; } 
		else { this.monthlyEmail = false; }
		if ("TRUE".equals(occasionalEmail)) { this.occasionalEmail = true; } 
		else { this.occasionalEmail = false; }
	}

}
